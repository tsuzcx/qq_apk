package com.tencent.avgame.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.mobileqq.app.ThreadManager;

class AVGamePosterView$1
  implements Runnable
{
  AVGamePosterView$1(AVGamePosterView paramAVGamePosterView, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1334, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.this$0.draw(localCanvas);
    ThreadManager.executeOnFileThread(new AVGamePosterView.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView.1
 * JD-Core Version:    0.7.0.1
 */