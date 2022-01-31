package com.tencent.mobileqq.app.message;

import akqm;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(akqm paramakqm) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.this$0.a.getAccount())) {
      ((FriendListHandler)this.this$0.a.a(1)).b(this.this$0.a.getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */