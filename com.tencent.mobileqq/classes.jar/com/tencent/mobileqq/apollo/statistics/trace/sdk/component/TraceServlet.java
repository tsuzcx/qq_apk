package com.tencent.mobileqq.apollo.statistics.trace.sdk.component;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TraceServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.d("[cmshow][TraceReport]", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
    localBundle.putString("cmd", paramIntent.getStringExtra("cmd"));
    localBundle.putInt("retryTime", paramIntent.getIntExtra("retryTime", 0));
    localBundle.putByteArray("request_data", paramIntent.getByteArrayExtra("data"));
    localBundle.putSerializable("serializable", paramIntent.getSerializableExtra("serializable"));
    localBundle.putBundle("extra_bundle_key", paramIntent.getBundleExtra("extra_bundle_key"));
    localBundle.putByteArray("data", (byte[])localObject);
    notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getIntExtra("timeout", 30000);
    if (!TextUtils.isEmpty(str))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      if (arrayOfByte != null)
      {
        paramIntent = new byte[arrayOfByte.length + 4];
        PkgTools.dWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
        PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
        paramPacket.putSendData(paramIntent);
      }
      else
      {
        paramIntent = new byte[4];
        PkgTools.dWord2Byte(paramIntent, 0, 4L);
        paramPacket.putSendData(paramIntent);
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("[cmshow][TraceReport]", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.component.TraceServlet
 * JD-Core Version:    0.7.0.1
 */