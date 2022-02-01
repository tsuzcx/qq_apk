package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import atwl;
import bjcq;
import java.nio.IntBuffer;
import mxl;
import myc;
import ngv;

public class GuessSongGameRecordCtrl$2
  implements Runnable
{
  public GuessSongGameRecordCtrl$2(ngv paramngv, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(720, 720, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = atwl.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), ngv.a(this.this$0));
      if (!bool) {
        ngv.a(this.this$0, null);
      }
      bjcq.a(this.this$0.a, "save photo " + bool + " " + ngv.a(this.this$0));
      if (!this.this$0.b()) {
        mxl.a().a().a(ngv.b(this.this$0), ngv.a(this.this$0), ngv.a(this.this$0));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bjcq.a(this.this$0.a, "save photo " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.2
 * JD-Core Version:    0.7.0.1
 */