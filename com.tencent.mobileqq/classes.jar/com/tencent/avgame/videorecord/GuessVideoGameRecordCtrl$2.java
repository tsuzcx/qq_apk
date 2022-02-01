package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import auog;
import bkdp;
import java.nio.IntBuffer;
import myk;
import mze;
import nis;

public class GuessVideoGameRecordCtrl$2
  implements Runnable
{
  public GuessVideoGameRecordCtrl$2(nis paramnis, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(nis.a(this.this$0), nis.b(this.this$0), Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = auog.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), nis.a(this.this$0));
      if (!bool) {
        nis.a(this.this$0, null);
      }
      bkdp.a(this.this$0.a, "save photo " + bool + " " + nis.a(this.this$0));
      if (!this.this$0.b()) {
        myk.a().a().a(nis.b(this.this$0), nis.a(this.this$0), nis.a(this.this$0));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bkdp.a(this.this$0.a, "save photo " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.2
 * JD-Core Version:    0.7.0.1
 */