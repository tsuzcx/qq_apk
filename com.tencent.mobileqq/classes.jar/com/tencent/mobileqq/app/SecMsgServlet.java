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
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive cmd=");
      paramFromServiceMsg.append(paramIntent.getStringExtra("cmd"));
      QLog.d("SecMsgServlet", 2, paramFromServiceMsg.toString());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSend cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      QLog.d("SecMsgServlet", 2, ((StringBuilder)localObject).toString());
    }
    String str = paramIntent.getStringExtra("cmd");
    Object localObject = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    paramIntent = new StringBuilder();
    paramIntent.append("secmsg.");
    paramIntent.append(str);
    paramPacket.setSSOCommand(paramIntent.toString());
    paramPacket.setTimeout(l);
    if (localObject != null)
    {
      paramIntent = new byte[localObject.length + 4];
      PkgTools.dWord2Byte(paramIntent, 0, localObject.length + 4);
      PkgTools.copyData(paramIntent, 4, (byte[])localObject, localObject.length);
      paramPacket.putSendData(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecMsgServlet
 * JD-Core Version:    0.7.0.1
 */