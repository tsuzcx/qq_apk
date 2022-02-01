package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qav.log.AVLog;
import java.nio.IntBuffer;

class ShowAndGuessGameVideoRecordCtrl$3
  implements Runnable
{
  ShowAndGuessGameVideoRecordCtrl$3(ShowAndGuessGameVideoRecordCtrl paramShowAndGuessGameVideoRecordCtrl, int[] paramArrayOfInt) {}
  
  public void run()
  {
    if (this.a != null) {}
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(ShowAndGuessGameVideoRecordCtrl.a(this.this$0), ShowAndGuessGameVideoRecordCtrl.b(this.this$0), Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer(IntBuffer.wrap(this.a));
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(1.0F, -1.0F);
      boolean bool = FileUtil.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), localMatrix, true), ShowAndGuessGameVideoRecordCtrl.a(this.this$0));
      if (!bool) {
        ShowAndGuessGameVideoRecordCtrl.a(this.this$0, null);
      }
      AVLog.a(this.this$0.a, "save photo " + bool + " " + ShowAndGuessGameVideoRecordCtrl.a(this.this$0));
      if (!this.this$0.b()) {
        GameEngine.a().a().a(ShowAndGuessGameVideoRecordCtrl.b(this.this$0), ShowAndGuessGameVideoRecordCtrl.a(this.this$0), ShowAndGuessGameVideoRecordCtrl.a(this.this$0));
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
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */