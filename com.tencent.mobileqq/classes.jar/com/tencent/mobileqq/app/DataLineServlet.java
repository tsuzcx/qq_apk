package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class DataLineServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineServlet", 2, "onReceive called");
    }
    if (paramIntent == null)
    {
      QLog.e("DataLineServlet", 1, "onReceive : req is null");
      return;
    }
    paramIntent.getExtras().putParcelable("response", paramFromServiceMsg);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    ((DataLineHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineServlet", 2, "onSend called");
    }
    if (paramIntent == null)
    {
      QLog.e("DataLineServlet", 1, "onSend : req is null");
      return;
    }
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    if (paramIntent != null)
    {
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(paramIntent.getWupBuffer());
      paramPacket.setTimeout(paramIntent.getTimeout());
      if (!paramIntent.isNeedCallback()) {
        paramPacket.setNoResponse();
      }
    }
    else
    {
      QLog.e("DataLineServlet", 1, "onSend : toMsg is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineServlet
 * JD-Core Version:    0.7.0.1
 */