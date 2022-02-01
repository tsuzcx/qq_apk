package com.tencent.mobileqq.activity.home;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class Conversation$64
  extends GestureDetector.SimpleOnGestureListener
{
  Conversation$64(Conversation paramConversation) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, " gestureDetector onDoubleTap");
    }
    Conversation.l(this.a);
    return super.onDoubleTap(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.64
 * JD-Core Version:    0.7.0.1
 */