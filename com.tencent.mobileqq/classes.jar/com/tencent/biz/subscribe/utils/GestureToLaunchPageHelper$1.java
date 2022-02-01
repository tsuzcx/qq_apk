package com.tencent.biz.subscribe.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import java.util.ArrayList;
import java.util.Iterator;

class GestureToLaunchPageHelper$1
  implements TopGestureLayout.InterceptTouchEventListener
{
  GestureToLaunchPageHelper$1(GestureToLaunchPageHelper paramGestureToLaunchPageHelper, Rect paramRect) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      if (GestureToLaunchPageHelper.a(this.b) != null)
      {
        paramMotionEvent = GestureToLaunchPageHelper.a(this.b).iterator();
        while (paramMotionEvent.hasNext())
        {
          ((View)paramMotionEvent.next()).getGlobalVisibleRect(this.a);
          if (this.a.contains(i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper.1
 * JD-Core Version:    0.7.0.1
 */