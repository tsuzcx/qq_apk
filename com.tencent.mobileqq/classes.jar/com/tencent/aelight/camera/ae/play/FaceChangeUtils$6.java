package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;

final class FaceChangeUtils$6
  implements Runnable
{
  FaceChangeUtils$6(Bitmap paramBitmap, FaceChangeUtils.CropFaceCallback paramCropFaceCallback) {}
  
  public void run()
  {
    try
    {
      FaceChangeUtils.access$300(this.val$photo, this.val$callback);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.val$callback.onFail(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.FaceChangeUtils.6
 * JD-Core Version:    0.7.0.1
 */