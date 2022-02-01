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
    if ((BaseChatPie.f() == 1) && (!BaseChatPie.a(this.a).booleanValue()))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() == 0) {
        return false;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() >= this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.a(this.a) == i)
        {
          this.a.k(1);
          BaseChatPie.a(this.a, Boolean.valueOf(true));
          BaseChatPie.a(this.a, -1);
        }
        BaseChatPie.a(this.a, i);
      }
    }
    if (BaseChatPie.a(this.a))
    {
      paramMotionEvent1 = this.a;
      paramMotionEvent1.a(true, paramMotionEvent1.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
    if (paramFloat2 < 0.0F) {
      this.a.w = false;
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onShowPress");
    }
    this.a.f(false);
    BaseChatPie localBaseChatPie = this.a;
    localBaseChatPie.a(true, localBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (LeftSwipeReplyHelper)this.a.a(50);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(true);
    }
    this.a.f(false);
    BaseChatPie localBaseChatPie = this.a;
    localBaseChatPie.a(true, localBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyOnGestureListener
 * JD-Core Version:    0.7.0.1
 */