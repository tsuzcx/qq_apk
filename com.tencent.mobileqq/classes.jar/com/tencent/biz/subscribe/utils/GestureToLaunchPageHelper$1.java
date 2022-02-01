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
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    int j;
    do
    {
      while (!paramMotionEvent.hasNext())
      {
        do
        {
          return true;
          i = (int)(paramMotionEvent.getX() + 0.5F);
          j = (int)(paramMotionEvent.getY() + 0.5F);
        } while (GestureToLaunchPageHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper) == null);
        paramMotionEvent = GestureToLaunchPageHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper).iterator();
      }
      ((View)paramMotionEvent.next()).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    } while (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper.1
 * JD-Core Version:    0.7.0.1
 */