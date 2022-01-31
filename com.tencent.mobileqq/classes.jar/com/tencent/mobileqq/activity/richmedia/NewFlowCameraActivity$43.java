package com.tencent.mobileqq.activity.richmedia;

import actj;
import android.graphics.Bitmap;
import android.os.Handler;
import axlk;
import uxv;
import ved;
import vxv;

class NewFlowCameraActivity$43
  implements Runnable
{
  NewFlowCameraActivity$43(NewFlowCameraActivity paramNewFlowCameraActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    int i = actj.a(47.0F, this.this$0.getResources());
    int j = actj.a(75.0F, this.this$0.getResources());
    Bitmap localBitmap1 = vxv.a(this.a, i, j, false);
    if (localBitmap1 == null) {
      ved.e("PTV.NewFlowCameraActivity", "resizeThumb = null.");
    }
    Bitmap localBitmap2;
    do
    {
      return;
      localBitmap2 = new uxv(actj.a(3.0F, this.this$0.getResources()), 0, j * 1.0F / i, null, null).a(localBitmap1);
      if (localBitmap2 == null)
      {
        ved.e("PTV.NewFlowCameraActivity", "roundThumb = null.");
        return;
      }
      i = this.a.getWidth();
      j = this.a.getHeight();
      float f1 = axlk.a;
      float f2 = axlk.a(this.this$0.getApplicationContext());
      if (i / j > f1 / f2) {}
      for (localBitmap1 = vxv.a(this.a, (int)(f1 / f2 * j), j, true); localBitmap1 == null; localBitmap1 = vxv.a(this.a, i, (int)(f2 / f1 * i), true))
      {
        ved.e("PTV.NewFlowCameraActivity", "animBitmap = null.");
        return;
      }
    } while (this.this$0.a == null);
    this.this$0.a.post(new NewFlowCameraActivity.RunnableUpdateThumb(this.this$0, localBitmap1, localBitmap2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.43
 * JD-Core Version:    0.7.0.1
 */