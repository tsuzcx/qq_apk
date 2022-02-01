package com.tencent.mobileqq.activity.aio.item;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;

class QQStoryCommentItemBuilder$OnCommentTouchListener
  implements View.OnTouchListener
{
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new QQStoryCommentItemBuilder.OnCommentTouchListener.1(this));
  View jdField_a_of_type_AndroidViewView = null;
  final OnLongClickAndTouchListener jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener;
  
  public QQStoryCommentItemBuilder$OnCommentTouchListener(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener;
    if (localObject != null) {
      ((OnLongClickAndTouchListener)localObject).onTouch(paramView, paramMotionEvent);
    }
    localObject = this.jdField_a_of_type_AndroidViewGestureDetector;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
      return true;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder.OnCommentTouchListener
 * JD-Core Version:    0.7.0.1
 */