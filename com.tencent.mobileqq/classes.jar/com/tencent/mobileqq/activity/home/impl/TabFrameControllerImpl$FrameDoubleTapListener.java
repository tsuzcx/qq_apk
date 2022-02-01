package com.tencent.mobileqq.activity.home.impl;

import android.os.SystemClock;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.qphone.base.util.QLog;

public class TabFrameControllerImpl$FrameDoubleTapListener
  implements GestureDetector.OnDoubleTapListener
{
  private FrameFragment a;
  
  public TabFrameControllerImpl$FrameDoubleTapListener(FrameFragment paramFrameFragment)
  {
    this.a = paramFrameFragment;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDoubleTap() called with: e = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("]");
      QLog.d("TabFrameControllerImpl", 2, localStringBuilder.toString());
    }
    this.a.b = SystemClock.uptimeMillis();
    TabFrameControllerImpl.dispatchOnDoubleTap(this.a);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.FrameDoubleTapListener
 * JD-Core Version:    0.7.0.1
 */