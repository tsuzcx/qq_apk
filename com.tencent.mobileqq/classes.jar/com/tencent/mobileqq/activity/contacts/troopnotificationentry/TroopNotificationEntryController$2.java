package com.tencent.mobileqq.activity.contacts.troopnotificationentry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.qphone.base.util.QLog;

class TroopNotificationEntryController$2
  implements ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener
{
  TroopNotificationEntryController$2(TroopNotificationEntryController paramTroopNotificationEntryController) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUnreadCountChanged bShowEntry");
      ((StringBuilder)localObject).append(TroopNotificationEntryController.a(this.a));
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" count");
      localStringBuilder.append(paramInt);
      QLog.d("TroopNotificationEntryController", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    this.a.d();
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if ((paramTroopNotificationEntryConfig != null) && (paramTroopNotificationEntryConfig.a(TroopNotificationEntryController.a(this.a).getCurrentAccountUin()))) {
      TroopNotificationEntryController.a(this.a, true);
    } else {
      TroopNotificationEntryController.a(this.a, false);
    }
    if ((QLog.isColorLevel()) && (paramTroopNotificationEntryConfig != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTroopNotificationConfigUpdate bShowEntry");
      localStringBuilder.append(TroopNotificationEntryController.a(this.a));
      localStringBuilder.append(" newConf");
      localStringBuilder.append(paramTroopNotificationEntryConfig.toString());
      QLog.d("TroopNotificationEntryController", 2, localStringBuilder.toString());
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController.2
 * JD-Core Version:    0.7.0.1
 */