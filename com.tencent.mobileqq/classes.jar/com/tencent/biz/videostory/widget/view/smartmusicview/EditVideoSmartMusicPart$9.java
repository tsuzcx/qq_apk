package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import zzf;

public class EditVideoSmartMusicPart$9
  implements Runnable
{
  public EditVideoSmartMusicPart$9(zzf paramzzf) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.9
 * JD-Core Version:    0.7.0.1
 */