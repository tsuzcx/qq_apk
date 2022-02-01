package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import bjuc;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.nio.IntBuffer;
import nfc;
import nfv;
import nrf;

public class GuessSongGameRecordCtrl$2
  implements Runnable
{
  public GuessSongGameRecordCtrl$2(nrf paramnrf, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(720, 720, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = FileUtil.writeBitmapToFile(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), nrf.a(this.this$0));
      if (!bool) {
        nrf.a(this.this$0, null);
      }
      bjuc.a(this.this$0.a, "save photo " + bool + " " + nrf.a(this.this$0));
      if (!this.this$0.b()) {
        nfc.a().a().a(nrf.b(this.this$0), nrf.a(this.this$0), nrf.a(this.this$0));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bjuc.a(this.this$0.a, "save photo " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.2
 * JD-Core Version:    0.7.0.1
 */