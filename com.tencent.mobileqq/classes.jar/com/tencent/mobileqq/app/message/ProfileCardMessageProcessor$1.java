package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import aofw;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ProfileCardMessageProcessor$1
  implements Runnable
{
  public ProfileCardMessageProcessor$1(aofw paramaofw) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(aofw.a(this.this$0).getAccount())) {
      ((FriendListHandler)aofw.b(this.this$0).a(1)).b(aofw.c(this.this$0).getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProfileCardMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */