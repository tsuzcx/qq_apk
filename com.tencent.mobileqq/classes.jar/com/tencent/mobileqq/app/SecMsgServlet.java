package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class SecMsgServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd"));
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onSend cmd=" + paramIntent.getStringExtra("cmd"));
    }
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    paramPacket.setSSOCommand("secmsg." + str);
    paramPacket.setTimeout(l);
    if (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.a(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecMsgServlet
 * JD-Core Version:    0.7.0.1
 */