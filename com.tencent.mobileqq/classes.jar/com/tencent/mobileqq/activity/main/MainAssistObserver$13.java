package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$13
  implements ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener
{
  MainAssistObserver$13(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUnreadCountChanged, count = ");
      localStringBuilder.append(paramInt);
      QLog.d("MainAssistObserver", 1, localStringBuilder.toString());
    }
    this.a.g();
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if (QLog.isColorLevel()) {
      if (paramTroopNotificationEntryConfig != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTroopNotificationConfigUpdate, newConf = ");
        localStringBuilder.append(paramTroopNotificationEntryConfig.toString());
        QLog.d("MainAssistObserver", 1, localStringBuilder.toString());
      }
      else
      {
        QLog.d("MainAssistObserver", 1, "onTroopNotificationConfigUpdate, newConf is null ");
      }
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.13
 * JD-Core Version:    0.7.0.1
 */