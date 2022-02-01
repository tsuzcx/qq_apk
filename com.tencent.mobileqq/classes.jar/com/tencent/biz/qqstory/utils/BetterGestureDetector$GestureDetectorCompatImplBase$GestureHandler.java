package com.tencent.biz.qqstory.utils;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

class BetterGestureDetector$GestureDetectorCompatImplBase$GestureHandler
  extends Handler
{
  BetterGestureDetector$GestureDetectorCompatImplBase$GestureHandler(BetterGestureDetector.GestureDetectorCompatImplBase paramGestureDetectorCompatImplBase) {}
  
  BetterGestureDetector$GestureDetectorCompatImplBase$GestureHandler(BetterGestureDetector.GestureDetectorCompatImplBase paramGestureDetectorCompatImplBase, Handler paramHandler)
  {
    super(paramHandler.getLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          if (this.a.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener != null)
          {
            if (!this.a.jdField_a_of_type_Boolean)
            {
              this.a.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onSingleTapConfirmed(this.a.jdField_a_of_type_AndroidViewMotionEvent);
              return;
            }
            this.a.b = true;
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown message ");
          localStringBuilder.append(paramMessage);
          throw new RuntimeException(localStringBuilder.toString());
        }
      }
      else {
        this.a.a();
      }
    }
    else {
      this.a.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onShowPress(this.a.jdField_a_of_type_AndroidViewMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.BetterGestureDetector.GestureDetectorCompatImplBase.GestureHandler
 * JD-Core Version:    0.7.0.1
 */