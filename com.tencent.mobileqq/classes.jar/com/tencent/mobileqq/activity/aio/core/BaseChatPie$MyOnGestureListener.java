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
    ((MultiWindowAIOHelper)this.a.q(26)).a();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((BaseChatPie.by() == 1) && (!BaseChatPie.d(this.a).booleanValue()))
    {
      if (this.a.U.getCount() == 0) {
        return false;
      }
      if ((this.a.U != null) && (this.a.U.getLastVisiblePosition() >= this.a.U.getCount() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.a.U.getChildAt(this.a.U.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.e(this.a) == i)
        {
          this.a.p(1);
          BaseChatPie.a(this.a, Boolean.valueOf(true));
          BaseChatPie.a(this.a, -1);
        }
        BaseChatPie.a(this.a, i);
      }
    }
    if (BaseChatPie.f(this.a))
    {
      paramMotionEvent1 = this.a;
      paramMotionEvent1.a(true, paramMotionEvent1.e, this.a.Y);
    }
    if (paramFloat2 < 0.0F) {
      this.a.aK = false;
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "onShowPress");
    }
    this.a.i(false);
    BaseChatPie localBaseChatPie = this.a;
    localBaseChatPie.a(true, localBaseChatPie.e, this.a.Y);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (LeftSwipeReplyHelper)this.a.q(50);
    if (paramMotionEvent != null) {
      paramMotionEvent.b(true);
    }
    this.a.i(false);
    BaseChatPie localBaseChatPie = this.a;
    localBaseChatPie.a(true, localBaseChatPie.e, this.a.Y);
    if (paramMotionEvent != null) {
      paramMotionEvent.b(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyOnGestureListener
 * JD-Core Version:    0.7.0.1
 */