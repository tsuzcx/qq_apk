package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.config.TroopNotificationEntryConfig;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$10
  implements TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener
{
  MainAssistObserver$10(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 1, "onUnreadCountChanged, count = " + paramInt);
    }
    this.a.f();
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if (QLog.isColorLevel())
    {
      if (paramTroopNotificationEntryConfig == null) {
        break label46;
      }
      QLog.d("MainAssistObserver", 1, "onTroopNotificationConfigUpdate, newConf = " + paramTroopNotificationEntryConfig.toString());
    }
    for (;;)
    {
      this.a.f();
      return;
      label46:
      QLog.d("MainAssistObserver", 1, "onTroopNotificationConfigUpdate, newConf is null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.10
 * JD-Core Version:    0.7.0.1
 */