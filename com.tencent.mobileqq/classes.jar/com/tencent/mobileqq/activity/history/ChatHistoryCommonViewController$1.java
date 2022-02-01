package com.tencent.mobileqq.activity.history;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class ChatHistoryCommonViewController$1
  extends ViewPager.SimpleOnPageChangeListener
{
  ChatHistoryCommonViewController$1(ChatHistoryCommonViewController paramChatHistoryCommonViewController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.a.b = this.a.a.getCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ChatHistoryCommonViewController.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryCommonViewController.1
 * JD-Core Version:    0.7.0.1
 */