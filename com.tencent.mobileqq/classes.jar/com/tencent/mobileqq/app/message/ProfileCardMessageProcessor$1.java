package com.tencent.mobileqq.app.message;

import amli;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(amli paramamli) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(amli.a(this.this$0).getAccount())) {
      ((FriendListHandler)amli.b(this.this$0).a(1)).b(amli.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */