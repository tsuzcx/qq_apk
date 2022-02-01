package com.tencent.hippy.qq.view.tkd.image;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.qphone.base.util.QLog;

class HippyTKDImageView$1
  implements Runnable
{
  HippyTKDImageView$1(HippyTKDImageView paramHippyTKDImageView) {}
  
  public void run()
  {
    Bitmap localBitmap2 = HippyTKDImageView.access$000(this.this$0).getBitmap();
    Bitmap localBitmap1;
    if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
    {
      localObject2 = localBitmap2;
      localBitmap1 = localBitmap2;
    }
    try
    {
      try
      {
        int i = localBitmap2.getWidth();
        localObject2 = localBitmap2;
        localBitmap1 = localBitmap2;
        int j = localBitmap2.getHeight();
        localObject2 = localBitmap2;
        localBitmap1 = localBitmap2;
        float f = HippyTKDImageView.access$100(this.this$0, i, j, this.this$0.mBlurRadius);
        localObject2 = localBitmap2;
        localBitmap1 = localBitmap2;
        localBitmap2 = Bitmap.createScaledBitmap(localBitmap2, (int)(i / f), (int)(j / f), true);
        localObject2 = localBitmap2;
        localBitmap1 = localBitmap2;
        StackBlur.a(localBitmap2, (int)(this.this$0.mBlurRadius / f));
        localObject2 = localBitmap2;
        localObject3 = localBitmap2;
        localBitmap1 = localBitmap2;
        if (!QLog.isColorLevel()) {
          break label227;
        }
        localObject2 = localBitmap2;
        localBitmap1 = localBitmap2;
        QLog.d("", 2, new Object[] { "mBlurRadius", Integer.valueOf(this.this$0.mBlurRadius), " blurRate:", Float.valueOf(f) });
        localObject3 = localBitmap2;
      }
      finally
      {
        break label238;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject3;
      label211:
      break label211;
    }
    Object localObject2 = localObject1;
    QLog.e("HippyImageView", 1, "shouldSetContent BlurBitmap oom");
    localObject3 = localObject1;
    label227:
    this.this$0.onGaussianBlurComplete((Bitmap)localObject3, null);
    return;
    label238:
    this.this$0.onGaussianBlurComplete((Bitmap)localObject2, null);
    throw localObject1;
    QLog.e("HippyImageView", 1, "shouldSetContent BlurBitmap tempBitmap == null || tempBitmap.isRecycled()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView.1
 * JD-Core Version:    0.7.0.1
 */