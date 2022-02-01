package com.tencent.mobileqq.app;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class QZoneNotifyHandler
  extends BusinessHandler
{
  QZoneNotifyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QZoneNotifyObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QzoneService.GetNewAndUnread".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramObject == null)
      {
        notifyUI(1, false, null);
        return;
      }
      notifyUI(1, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QZoneNotifyHandler
 * JD-Core Version:    0.7.0.1
 */