package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

public class ChatFragment$InterceptTouchEventListener
  implements TopGestureLayout.InterceptTouchEventListener
{
  public ChatFragment$InterceptTouchEventListener(ChatFragment paramChatFragment) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.c != null) {
      this.a.c.b(paramMotionEvent);
    }
  }
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.c != null) {
      return this.a.c.c(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.InterceptTouchEventListener
 * JD-Core Version:    0.7.0.1
 */