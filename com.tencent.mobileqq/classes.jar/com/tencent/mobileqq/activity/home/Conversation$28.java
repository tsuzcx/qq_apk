package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.qphone.base.util.BaseApplication;

class Conversation$28
  implements Runnable
{
  Conversation$28(Conversation paramConversation) {}
  
  public void run()
  {
    if (this.this$0.D)
    {
      this.this$0.b(800L);
      boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
      if (this.this$0.x != null)
      {
        IPullRefreshHeaderControl localIPullRefreshHeaderControl = this.this$0.x;
        int i;
        if (bool) {
          i = 0;
        } else {
          i = 2;
        }
        localIPullRefreshHeaderControl.a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.28
 * JD-Core Version:    0.7.0.1
 */