package com.tencent.aelight.camera.aioeditor;

import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;

class EditVideoSmartMusicPart$9
  implements Runnable
{
  EditVideoSmartMusicPart$9(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT > 25)
    {
      VibrationEffect localVibrationEffect = VibrationEffect.createOneShot(50, -1);
      this.this$0.a().vibrate(localVibrationEffect);
      return;
    }
    this.this$0.a().vibrate(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.9
 * JD-Core Version:    0.7.0.1
 */