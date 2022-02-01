package com.tencent.mobileqq.apollo.cmgame;

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
    long l = 0L;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      QLog.d("apollo_cmGame_CmGameServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess() + ", retCode=" + paramFromServiceMsg.getResultCode());
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("cmd", paramIntent.getStringExtra("cmd"));
      localBundle.putSerializable("serializable", paramIntent.getSerializableExtra("serializable"));
      localBundle.putString("key1", paramIntent.getStringExtra("key1"));
      localBundle.putString("key2", paramIntent.getStringExtra("key2"));
      localBundle.putString("key3", paramIntent.getStringExtra("key3"));
      localBundle.putString("key4", paramIntent.getStringExtra("key4"));
      localBundle.putByteArray("data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - l));
      }
      return;
      arrayOfByte = null;
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
      if (arrayOfByte == null) {
        break label117;
      }
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameServlet", 2, "onSend exit cmd=" + str);
      }
      return;
      label117:
      paramIntent = new byte[4];
      PkgTools.DWord2Byte(paramIntent, 0, 4L);
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameServlet
 * JD-Core Version:    0.7.0.1
 */