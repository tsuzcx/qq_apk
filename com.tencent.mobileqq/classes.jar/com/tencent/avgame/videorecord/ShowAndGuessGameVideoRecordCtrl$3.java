package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import bija;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.nio.IntBuffer;
import mzl;
import naf;
import nkk;

public class ShowAndGuessGameVideoRecordCtrl$3
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$3(nkk paramnkk, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(nkk.a(this.this$0), nkk.b(this.this$0), Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = FileUtil.writeBitmapToFile(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), nkk.a(this.this$0));
      if (!bool) {
        nkk.a(this.this$0, null);
      }
      bija.a(this.this$0.a, "save photo " + bool + " " + nkk.a(this.this$0));
      if (!this.this$0.b()) {
        mzl.a().a().a(nkk.b(this.this$0), nkk.a(this.this$0), nkk.a(this.this$0));
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
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */