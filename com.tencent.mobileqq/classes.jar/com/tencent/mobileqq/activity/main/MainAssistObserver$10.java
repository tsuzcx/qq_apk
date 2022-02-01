package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class MainAssistObserver$10
  implements Observer
{
  MainAssistObserver$10(MainAssistObserver paramMainAssistObserver) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof IGuildUnreadCntService.NotifyObj)) {
      return;
    }
    paramObservable = (IGuildUnreadCntService.NotifyObj)paramObject;
    if (MainAssistObserver.a(this.a, paramObservable))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainAssistObserver", 2, "updateGuildTabUI begin");
      }
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.10
 * JD-Core Version:    0.7.0.1
 */