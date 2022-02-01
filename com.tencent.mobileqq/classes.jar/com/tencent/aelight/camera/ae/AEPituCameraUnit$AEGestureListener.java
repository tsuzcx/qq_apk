package com.tencent.aelight.camera.ae;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

public class AEPituCameraUnit$AEGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((!this.a.Z()) && (System.currentTimeMillis() - AEPituCameraUnit.s(this.a) > 5000L))
    {
      paramMotionEvent = AEFilterManagerHolder.getAEFilterManager();
      AEPituCameraUnit.AEGestureListener.1 local1 = new AEPituCameraUnit.AEGestureListener.1(this);
      if (paramMotionEvent != null) {
        paramMotionEvent.a(local1);
      }
      AEPituCameraUnit.a(this.a, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.AEGestureListener
 * JD-Core Version:    0.7.0.1
 */