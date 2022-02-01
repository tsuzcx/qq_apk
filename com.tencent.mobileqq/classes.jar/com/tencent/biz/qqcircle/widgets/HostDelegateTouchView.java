package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;

public class HostDelegateTouchView
  extends FrameLayout
{
  public HostDelegateTouchView(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      HostUIHelper.getInstance().transTouchEventToTargetViewGroup(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), paramMotionEvent.getAction(), paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), 0));
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.HostDelegateTouchView
 * JD-Core Version:    0.7.0.1
 */