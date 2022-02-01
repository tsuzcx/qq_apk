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
    if (this.a != null) {
      try
      {
        Object localObject1 = Bitmap.createBitmap(ShowAndGuessGameVideoRecordCtrl.c(this.this$0), ShowAndGuessGameVideoRecordCtrl.d(this.this$0), Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject1).copyPixelsFromBuffer(IntBuffer.wrap(this.a));
        localObject2 = new Matrix();
        ((Matrix)localObject2).setScale(1.0F, -1.0F);
        boolean bool = FileUtil.a(Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, true), ShowAndGuessGameVideoRecordCtrl.e(this.this$0));
        if (!bool) {
          ShowAndGuessGameVideoRecordCtrl.a(this.this$0, null);
        }
        localObject1 = this.this$0.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("save photo ");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(ShowAndGuessGameVideoRecordCtrl.e(this.this$0));
        AVLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
        if (!this.this$0.i())
        {
          GameEngine.a().s().a(ShowAndGuessGameVideoRecordCtrl.f(this.this$0), ShowAndGuessGameVideoRecordCtrl.e(this.this$0), ShowAndGuessGameVideoRecordCtrl.g(this.this$0));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = this.this$0.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("save photo ");
        localStringBuilder.append(localThrowable);
        AVLog.a((String)localObject2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.3
 * JD-Core Version:    0.7.0.1
 */