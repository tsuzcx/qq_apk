package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.ScrollerRunnable;

class BaseChatPie$27
  implements Runnable
{
  BaseChatPie$27(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.listView.getHeaderViewsCount();
    this.this$0.listView.setSelectionFromTop(i + this.val$selection, this.this$0.mActivity.getTitleBarHeight());
    this.this$0.mScrollerRunnable.a(this.val$selection, 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.27
 * JD-Core Version:    0.7.0.1
 */