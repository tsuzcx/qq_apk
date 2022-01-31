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
  
  protected Class a()
  {
    return QZoneNotifyObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QzoneService.GetNewAndUnread".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        a(1, false, null);
      }
    }
    else {
      return;
    }
    a(1, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QZoneNotifyHandler
 * JD-Core Version:    0.7.0.1
 */