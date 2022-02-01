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
    if (this.a.a != null) {
      this.a.a.b(paramMotionEvent);
    }
  }
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.InterceptTouchEventListener
 * JD-Core Version:    0.7.0.1
 */