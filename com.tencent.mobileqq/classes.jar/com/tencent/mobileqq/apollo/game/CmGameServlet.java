package com.tencent.mobileqq.apollo.game;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class CmGameServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.d("[cmshow]apollo_cmGame_CmGameServlet", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      l = 0L;
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
    localBundle.putSerializable("serializable", paramIntent.getSerializableExtra("serializable"));
    localBundle.putString("key1", paramIntent.getStringExtra("key1"));
    localBundle.putString("key2", paramIntent.getStringExtra("key2"));
    localBundle.putString("key3", paramIntent.getStringExtra("key3"));
    localBundle.putString("key4", paramIntent.getStringExtra("key4"));
    localBundle.putByteArray("data", (byte[])localObject);
    notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive exit|cost: ");
      paramIntent.append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]apollo_cmGame_CmGameServlet", 2, paramIntent.toString());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
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
      QLog.d("[cmshow]apollo_cmGame_CmGameServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameServlet
 * JD-Core Version:    0.7.0.1
 */