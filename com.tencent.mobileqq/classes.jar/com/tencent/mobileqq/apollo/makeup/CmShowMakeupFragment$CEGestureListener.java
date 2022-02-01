package com.tencent.mobileqq.apollo.makeup;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.utils.ViewUtils;

class CmShowMakeupFragment$CEGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private int b = ViewUtils.getScreenWidth();
  
  public CmShowMakeupFragment$CEGestureListener(CmShowMakeupFragment paramCmShowMakeupFragment) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 /= this.b;
    paramMotionEvent1 = Float.valueOf(0.0F);
    paramMotionEvent1 = String.format("ce.Level.CMShow.rotateCharacterByEuler(%f, %f, %f);", new Object[] { paramMotionEvent1, Float.valueOf(paramFloat1 * 2.0F), paramMotionEvent1 });
    CmShowMakeupFragment.d(this.a).evaluateJs(paramMotionEvent1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.CEGestureListener
 * JD-Core Version:    0.7.0.1
 */