package com.tencent.mobileqq.armap;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ArMapServlet
  extends MSFServlet
{
  public String[] getPreferSSOCommands()
  {
    return new String[] { "cmd_connOpened", "cmd_connClosed" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    String str;
    ArMapInterface localArMapInterface;
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ArMapServlet", 4, "onReceive: " + paramFromServiceMsg.getServiceCmd());
      }
      str = paramFromServiceMsg.getServiceCmd();
      localArMapInterface = (ArMapInterface)getAppRuntime();
      if (!"cmd_connOpened".equals(str)) {
        break;
      }
      localArMapInterface.a();
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    if ("cmd_connClosed".equals(str))
    {
      localArMapInterface.b();
      return;
    }
    localArMapInterface.a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent != null)
      {
        paramPacket.setSSOCommand(paramIntent.getServiceCmd());
        paramPacket.putSendData(paramIntent.getWupBuffer());
        paramPacket.setTimeout(paramIntent.getTimeout());
        paramPacket.setAttributes(paramIntent.getAttributes());
        if (!paramIntent.isNeedCallback()) {
          paramPacket.setNoResponse();
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ArMapServlet", 4, "send: " + paramIntent.getServiceCmd());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapServlet
 * JD-Core Version:    0.7.0.1
 */