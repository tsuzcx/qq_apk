package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;

class ProfileCardMessageProcessor$1
  implements Runnable
{
  ProfileCardMessageProcessor$1(ProfileCardMessageProcessor paramProfileCardMessageProcessor) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(ProfileCardMessageProcessor.a(this.this$0).getAccount())) {
      ((FriendListHandler)ProfileCardMessageProcessor.b(this.this$0).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(ProfileCardMessageProcessor.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */