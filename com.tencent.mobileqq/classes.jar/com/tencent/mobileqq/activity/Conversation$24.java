package com.tencent.mobileqq.activity;

import bdin;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;

class Conversation$24
  implements Runnable
{
  Conversation$24(Conversation paramConversation) {}
  
  public void run()
  {
    PullRefreshHeader localPullRefreshHeader;
    if (this.this$0.g)
    {
      Conversation.a(this.this$0, 800L);
      boolean bool = bdin.d(BaseApplication.getContext());
      if (this.this$0.a != null)
      {
        localPullRefreshHeader = this.this$0.a;
        if (!bool) {
          break label57;
        }
      }
    }
    label57:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.24
 * JD-Core Version:    0.7.0.1
 */