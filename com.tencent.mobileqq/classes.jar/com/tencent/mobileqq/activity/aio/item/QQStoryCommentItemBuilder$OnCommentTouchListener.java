package com.tencent.mobileqq.activity.aio.item;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;

class QQStoryCommentItemBuilder$OnCommentTouchListener
  implements View.OnTouchListener
{
  final OnLongClickAndTouchListener a;
  View b = null;
  GestureDetector c = new GestureDetector(new QQStoryCommentItemBuilder.OnCommentTouchListener.1(this));
  
  public QQStoryCommentItemBuilder$OnCommentTouchListener(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.a = paramOnLongClickAndTouchListener;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((OnLongClickAndTouchListener)localObject).onTouch(paramView, paramMotionEvent);
    }
    localObject = this.c;
    if (localObject != null)
    {
      this.b = paramView;
      ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
      return true;
    }
    this.b = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder.OnCommentTouchListener
 * JD-Core Version:    0.7.0.1
 */