package com.tencent.mobileqq.activity.contacts.troopnotificationentry;

import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.TroopNotificationEntryConfig;
import com.tencent.qphone.base.util.QLog;

class TroopNotificationEntryController$2
  implements TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener
{
  TroopNotificationEntryController$2(TroopNotificationEntryController paramTroopNotificationEntryController) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, new Object[] { "onUnreadCountChanged bShowEntry" + TroopNotificationEntryController.a(this.a), " count" + paramInt });
    }
    this.a.d();
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if ((paramTroopNotificationEntryConfig == null) || (!paramTroopNotificationEntryConfig.a(TroopNotificationEntryController.a(this.a).getCurrentAccountUin()))) {
      TroopNotificationEntryController.a(this.a, false);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (paramTroopNotificationEntryConfig != null)) {
        QLog.d("TroopNotificationEntryController", 2, "onTroopNotificationConfigUpdate bShowEntry" + TroopNotificationEntryController.a(this.a) + " newConf" + paramTroopNotificationEntryConfig.toString());
      }
      this.a.d();
      return;
      TroopNotificationEntryController.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController.2
 * JD-Core Version:    0.7.0.1
 */