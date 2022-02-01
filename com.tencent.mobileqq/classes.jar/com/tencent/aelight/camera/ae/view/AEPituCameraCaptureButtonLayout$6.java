package com.tencent.aelight.camera.ae.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;

class AEPituCameraCaptureButtonLayout$6
  implements View.OnTouchListener
{
  AEPituCameraCaptureButtonLayout$6(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 0) {
      AECameraDaTongHelper.a.a(this.a.y, null);
    }
    if (!AEPituCameraCaptureButtonLayout.a(this.a)) {
      return this.a.a(paramView, paramMotionEvent);
    }
    return AEPituCameraCaptureButtonLayout.a(this.a, paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.6
 * JD-Core Version:    0.7.0.1
 */