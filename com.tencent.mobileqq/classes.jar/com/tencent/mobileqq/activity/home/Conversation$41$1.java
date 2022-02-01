package com.tencent.mobileqq.activity.home;

import android.os.SystemClock;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.StartupTracker;

class Conversation$41$1
  implements Runnable
{
  Conversation$41$1(Conversation.41 param41, boolean paramBoolean) {}
  
  public void run()
  {
    this.b.a.e(true);
    if (this.b.a.D)
    {
      SimpleModeHelper.a(this.b.a, this.a);
      if (this.b.a.w != null)
      {
        MsgTabStoryNodeListManager localMsgTabStoryNodeListManager = this.b.a.w;
        int i;
        if (this.a) {
          i = 0;
        } else {
          i = 2;
        }
        localMsgTabStoryNodeListManager.a(i);
      }
    }
    if (this.b.a.E > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.b.a.E);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.41.1
 * JD-Core Version:    0.7.0.1
 */