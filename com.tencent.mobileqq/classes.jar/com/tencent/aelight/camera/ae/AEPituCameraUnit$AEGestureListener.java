package com.tencent.aelight.camera.ae;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

public class AEPituCameraUnit$AEGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  protected AEPituCameraUnit$AEGestureListener(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((!this.a.f()) && (System.currentTimeMillis() - AEPituCameraUnit.a(this.a) > 5000L))
    {
      this.a.a.a(196614, new Object[0]);
      AEPituCameraUnit.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.AEGestureListener
 * JD-Core Version:    0.7.0.1
 */