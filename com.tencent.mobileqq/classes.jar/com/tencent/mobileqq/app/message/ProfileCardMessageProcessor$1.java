package com.tencent.mobileqq.app.message;

import amgt;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(amgt paramamgt) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(amgt.a(this.this$0).getAccount())) {
      ((FriendListHandler)amgt.b(this.this$0).a(1)).b(amgt.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */