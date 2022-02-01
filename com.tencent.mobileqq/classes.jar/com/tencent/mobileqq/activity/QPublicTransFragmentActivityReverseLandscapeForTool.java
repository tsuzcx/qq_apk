package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QPublicTransFragmentActivityReverseLandscapeForTool
  extends QPublicTransFragmentActivityForTool
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QPublicTransFragmentActivityReverseLandscapeForTool
 * JD-Core Version:    0.7.0.1
 */