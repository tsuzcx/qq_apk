package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class QQSettingSettingActivity$15
  implements Runnable
{
  QQSettingSettingActivity$15(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.getSelfXManInfoScene2();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.15
 * JD-Core Version:    0.7.0.1
 */