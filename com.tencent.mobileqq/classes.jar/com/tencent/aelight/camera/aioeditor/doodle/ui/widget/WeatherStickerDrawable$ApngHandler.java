package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class WeatherStickerDrawable$ApngHandler
  extends Handler
{
  private WeakReference<WeatherStickerDrawable> a;
  
  public WeatherStickerDrawable$ApngHandler(WeakReference<WeatherStickerDrawable> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      WeatherStickerDrawable.a((WeatherStickerDrawable)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.WeatherStickerDrawable.ApngHandler
 * JD-Core Version:    0.7.0.1
 */