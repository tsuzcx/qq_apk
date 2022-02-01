package com.tencent.mobileqq.activity.aio.core.helper;

import android.view.MotionEvent;
import androidx.annotation.IntRange;

public abstract interface TopGestureTouchEventListener
{
  public abstract void a(MotionEvent paramMotionEvent);
  
  @IntRange(from=0L, to=2L)
  public abstract int b(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.helper.TopGestureTouchEventListener
 * JD-Core Version:    0.7.0.1
 */