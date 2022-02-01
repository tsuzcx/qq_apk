package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;

class Conversation$27
  implements Runnable
{
  Conversation$27(Conversation paramConversation) {}
  
  public void run()
  {
    if (this.this$0.f)
    {
      Conversation.a(this.this$0, 800L);
      boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
      if (this.this$0.a != null)
      {
        PullRefreshHeader localPullRefreshHeader = this.this$0.a;
        int i;
        if (bool) {
          i = 0;
        } else {
          i = 2;
        }
        localPullRefreshHeader.a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.27
 * JD-Core Version:    0.7.0.1
 */