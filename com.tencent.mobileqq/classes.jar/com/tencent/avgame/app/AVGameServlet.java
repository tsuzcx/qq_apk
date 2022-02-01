package com.tencent.avgame.app;

import android.content.Intent;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class AVGameServlet
  extends MSFServlet
{
  private BaseAVGameAppInterface a = null;
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush" };
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof BaseAVGameAppInterface)) {
      this.a = ((BaseAVGameAppInterface)localAppRuntime);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    else
    {
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive, cmd[");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameServlet", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((BaseAVGameAppInterface)localObject).receiveToService(paramIntent, paramFromServiceMsg);
    }
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
        if (QLog.isDevelopLevel())
        {
          paramPacket = new StringBuilder();
          paramPacket.append("send, cmd[");
          paramPacket.append(paramIntent.getServiceCmd());
          paramPacket.append("]");
          QLog.i("AVGameServlet", 4, paramPacket.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameServlet
 * JD-Core Version:    0.7.0.1
 */