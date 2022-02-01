package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import bija;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.nio.IntBuffer;
import mzl;
import naf;
import nkh;

public class GuessVideoGameRecordCtrl$2
  implements Runnable
{
  public GuessVideoGameRecordCtrl$2(nkh paramnkh, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(nkh.a(this.this$0), nkh.b(this.this$0), Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = FileUtil.writeBitmapToFile(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), nkh.a(this.this$0));
      if (!bool) {
        nkh.a(this.this$0, null);
      }
      bija.a(this.this$0.a, "save photo " + bool + " " + nkh.a(this.this$0));
      if (!this.this$0.b()) {
        mzl.a().a().a(nkh.b(this.this$0), nkh.a(this.this$0), nkh.a(this.this$0));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bija.a(this.this$0.a, "save photo " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.2
 * JD-Core Version:    0.7.0.1
 */