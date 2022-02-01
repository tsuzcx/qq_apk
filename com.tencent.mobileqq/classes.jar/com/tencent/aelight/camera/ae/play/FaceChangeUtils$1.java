package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;

final class FaceChangeUtils$1
  implements Runnable
{
  FaceChangeUtils$1(FaceChangeUtils.ChangeFaceSingleCallback paramChangeFaceSingleCallback, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    this.val$callback.onResult(FaceChangeUtils.access$100(this.val$userFace, this.val$materialDir));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.FaceChangeUtils.1
 * JD-Core Version:    0.7.0.1
 */