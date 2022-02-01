package com.tencent.mobileqq.activity.miniaio;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

class MiniEntryViewManager$1
  extends GestureDetector.SimpleOnGestureListener
{
  MiniEntryViewManager$1(MiniEntryViewManager paramMiniEntryViewManager) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (MiniEntryViewManager.a(this.a) != null)
    {
      MiniEntryViewManager.a(this.a).onClick(MiniEntryViewManager.a(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniEntryViewManager.1
 * JD-Core Version:    0.7.0.1
 */