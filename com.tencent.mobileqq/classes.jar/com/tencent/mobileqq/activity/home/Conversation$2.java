package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class Conversation$2
  implements Runnable
{
  Conversation$2(Conversation paramConversation, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = NetworkUtil.isNetSupportHw(BaseApplication.getContext());
    this.this$0.b(new Conversation.2.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.2
 * JD-Core Version:    0.7.0.1
 */