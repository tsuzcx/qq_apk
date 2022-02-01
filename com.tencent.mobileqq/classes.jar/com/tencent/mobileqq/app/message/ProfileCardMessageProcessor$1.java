package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import aoop;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(aoop paramaoop) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(aoop.a(this.this$0).getAccount())) {
      ((FriendListHandler)aoop.b(this.this$0).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(aoop.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */