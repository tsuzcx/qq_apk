package com.tencent.aelight.camera.ae;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.IGetOriginListener;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$AEGestureListener$1
  implements AEFilterProcessTex.IGetOriginListener
{
  AEPituCameraUnit$AEGestureListener$1(AEPituCameraUnit.AEGestureListener paramAEGestureListener) {}
  
  public Bitmap a(Bitmap paramBitmap)
  {
    AEQLog.a(this.a.a.a, "can get bitmap for aiscene");
    AEPituCameraUnit.a(this.a.a, paramBitmap);
    this.a.a.S.b(196614, new Object[0]);
    this.a.a.f(0);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.AEGestureListener.1
 * JD-Core Version:    0.7.0.1
 */