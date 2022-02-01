package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class QQSettingSettingActivity$17
  implements Runnable
{
  QQSettingSettingActivity$17(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.getSelfXManInfoScene2();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */