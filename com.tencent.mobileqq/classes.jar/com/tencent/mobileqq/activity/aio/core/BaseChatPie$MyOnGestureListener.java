package com.tencent.mobileqq.activity.aio.core;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$MyOnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  BaseChatPie$MyOnGestureListener(BaseChatPie paramBaseChatPie) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    ((MultiWindowAIOHelper)this.a.a(26)).a();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((BaseChatPie.j() == 1) && (!BaseChatPie.a(this.a).booleanValue())) {
      if (this.a.a.getCount() != 0) {}
    }
    do
    {
      return false;
      if ((this.a.a != null) && (this.a.a.getLastVisiblePosition() >= this.a.a.getCount() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.a.a.getChildAt(this.a.a.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.g(this.a) == i)
        {
          this.a.s(1);
          BaseChatPie.a(this.a, Boolean.valueOf(true));
          BaseChatPie.e(this.a, -1);
        }
        BaseChatPie.e(this.a, i);
      }
      if (BaseChatPie.a(this.a)) {
        this.a.g(true);
      }
    } while (paramFloat2 >= 0.0F);
    this.a.C = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onShowPress");
    }
    this.a.h(false);
    this.a.g(true);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (LeftSwipeReplyHelper)this.a.a(50);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(true);
    }
    this.a.h(false);
    this.a.g(true);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyOnGestureListener
 * JD-Core Version:    0.7.0.1
 */