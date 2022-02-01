package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import atwl;
import bjcq;
import java.nio.IntBuffer;
import mxl;
import myc;
import nha;

public class ShowAndGuessGameVideoRecordCtrl$3
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$3(nha paramnha, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(nha.a(this.this$0), nha.b(this.this$0), Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = atwl.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), nha.a(this.this$0));
      if (!bool) {
        nha.a(this.this$0, null);
      }
      bjcq.a(this.this$0.a, "save photo " + bool + " " + nha.a(this.this$0));
      if (!this.this$0.b()) {
        mxl.a().a().a(nha.b(this.this$0), nha.a(this.this$0), nha.a(this.this$0));
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
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */