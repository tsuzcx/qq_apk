package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import com.tencent.avgame.gameroom.stage.IStagePresenter;

class ShowAndGuessGameVideoRecordCtrl$6
  implements Runnable
{
  ShowAndGuessGameVideoRecordCtrl$6(ShowAndGuessGameVideoRecordCtrl paramShowAndGuessGameVideoRecordCtrl, int paramInt, View paramView) {}
  
  public void run()
  {
    if (this.this$0.k())
    {
      int i = this.a;
      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      float f4 = (i >> 24 & 0xFF) / 255.0F;
      if (f4 > 0.0F) {
        this.this$0.a(true, f1, f2, f3, f4);
      } else {
        this.this$0.a(false, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      this.b.destroyDrawingCache();
      Bitmap localBitmap = this.b.getDrawingCache();
      if (localBitmap != null)
      {
        int k = this.b.getLeft();
        int m = this.b.getTop();
        int j = k;
        i = m;
        if (ShowAndGuessGameVideoRecordCtrl.i(this.this$0) != null)
        {
          RectF localRectF = ShowAndGuessGameVideoRecordCtrl.i(this.this$0).b();
          j = k;
          i = m;
          if (localRectF != null)
          {
            f1 = localRectF.right;
            f2 = localRectF.left;
            f3 = localRectF.bottom;
            f4 = localRectF.top;
            j = (int)((f1 - f2 - this.b.getWidth()) / 2.0F);
            i = (int)((f3 - f4 - this.b.getHeight()) / 2.0F);
          }
        }
        this.this$0.b(localBitmap, this.b.getWidth(), this.b.getHeight(), j, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.6
 * JD-Core Version:    0.7.0.1
 */