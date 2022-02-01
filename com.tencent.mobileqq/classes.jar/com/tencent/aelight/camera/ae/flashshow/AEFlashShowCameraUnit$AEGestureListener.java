package com.tencent.aelight.camera.ae.flashshow;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.Style;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowChangeModeViewModel;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.log.AEQLog;

public class AEFlashShowCameraUnit$AEGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  protected AEFlashShowCameraUnit$AEGestureListener(AEFlashShowCameraUnit paramAEFlashShowCameraUnit) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((AEFlashShowCameraUnit.s(this.a) != null) && (AEFlashShowCameraUnit.t(this.a).g()))
    {
      AEQLog.a(AEFlashShowCameraUnit.u(this.a), "can not switch tab when capturing ");
      return false;
    }
    if (AEFlashShowCameraUnit.e(this.a))
    {
      AEQLog.a(AEFlashShowCameraUnit.v(this.a), "can not switch tab when cutdown ");
      return false;
    }
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 110.0F)
    {
      AEFlashShowCameraUnit.w(this.a).b().postValue(AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE);
      return false;
    }
    if (paramMotionEvent2.getX() - paramMotionEvent1.getX() > 110.0F) {
      AEFlashShowCameraUnit.w(this.a).b().postValue(AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE);
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.AEGestureListener
 * JD-Core Version:    0.7.0.1
 */