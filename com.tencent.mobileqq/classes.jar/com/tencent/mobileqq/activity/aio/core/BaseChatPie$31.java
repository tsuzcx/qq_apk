package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.bubble.ChatXListView;

class BaseChatPie$31
  implements Runnable
{
  BaseChatPie$31(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.listView.getHeaderViewsCount();
    this.this$0.listView.setSelectionFromTop(i + this.val$aioIndex, this.this$0.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.31
 * JD-Core Version:    0.7.0.1
 */