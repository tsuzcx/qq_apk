package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qav.log.AVLog;
import java.nio.IntBuffer;

class GuessSongGameRecordCtrl$2
  implements Runnable
{
  GuessSongGameRecordCtrl$2(GuessSongGameRecordCtrl paramGuessSongGameRecordCtrl, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(720, 720, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = FileUtil.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), GuessSongGameRecordCtrl.a(this.this$0));
      if (!bool) {
        GuessSongGameRecordCtrl.a(this.this$0, null);
      }
      AVLog.a(this.this$0.a, "save photo " + bool + " " + GuessSongGameRecordCtrl.a(this.this$0));
      if (!this.this$0.b()) {
        GameEngine.a().a().a(GuessSongGameRecordCtrl.b(this.this$0), GuessSongGameRecordCtrl.a(this.this$0), GuessSongGameRecordCtrl.a(this.this$0));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.a(this.this$0.a, "save photo " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.2
 * JD-Core Version:    0.7.0.1
 */