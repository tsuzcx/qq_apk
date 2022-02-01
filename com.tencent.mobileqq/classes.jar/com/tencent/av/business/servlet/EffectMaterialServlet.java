package com.tencent.av.business.servlet;

import android.content.Intent;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class EffectMaterialServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    if (paramIntent != null)
    {
      localToServiceMsg = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), localToServiceMsg);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive toMsg cmd: ");
      paramIntent.append(localToServiceMsg.getServiceCmd());
      QLog.i("EffectMaterialServlet", 2, paramIntent.toString());
    }
    ((EffectMaterialHandler)((AppInterface)getAppRuntime()).getBusinessHandler(EffectMaterialHandler.class.getName())).b().a(localToServiceMsg, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    if (paramIntent == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend msg cmd: ");
      localStringBuilder.append(paramIntent.getServiceCmd());
      QLog.i("EffectMaterialServlet", 2, localStringBuilder.toString());
    }
    if (paramPacket != null)
    {
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
      paramPacket.setAttributes(paramIntent.getAttributes());
      if (!paramIntent.isNeedCallback()) {
        paramPacket.setNoResponse();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.servlet.EffectMaterialServlet
 * JD-Core Version:    0.7.0.1
 */