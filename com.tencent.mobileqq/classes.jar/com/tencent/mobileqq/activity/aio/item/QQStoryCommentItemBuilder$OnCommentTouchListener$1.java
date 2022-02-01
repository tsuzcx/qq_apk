package com.tencent.mobileqq.activity.aio.item;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.app.BaseActivity;

class QQStoryCommentItemBuilder$OnCommentTouchListener$1
  extends GestureDetector.SimpleOnGestureListener
{
  QQStoryCommentItemBuilder$OnCommentTouchListener$1(QQStoryCommentItemBuilder.OnCommentTouchListener paramOnCommentTouchListener) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.a()) {
      return false;
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, (BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onLongClick(this.a.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder.OnCommentTouchListener.1
 * JD-Core Version:    0.7.0.1
 */