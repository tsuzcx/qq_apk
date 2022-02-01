package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import aotb;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(aotb paramaotb) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(aotb.a(this.this$0).getAccount())) {
      ((FriendListHandler)aotb.b(this.this$0).a(1)).b(aotb.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */