package com.tencent.mobileqq.activity.history;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;

class ChatHistoryCommonViewController$1
  extends ViewPager.SimpleOnPageChangeListener
{
  ChatHistoryCommonViewController$1(ChatHistoryCommonViewController paramChatHistoryCommonViewController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      ChatHistoryCommonViewController localChatHistoryCommonViewController = this.a;
      localChatHistoryCommonViewController.i = localChatHistoryCommonViewController.l.getCurrentItem();
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