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
    if (this.a.d.c()) {
      return false;
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    ChatActivityUtils.a(this.a.d.d, this.a.b, (BaseActivity)this.a.d.e);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.onLongClick(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder.OnCommentTouchListener.1
 * JD-Core Version:    0.7.0.1
 */