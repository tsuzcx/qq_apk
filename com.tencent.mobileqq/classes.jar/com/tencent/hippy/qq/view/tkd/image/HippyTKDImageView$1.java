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
    Bitmap localBitmap4 = HippyTKDImageView.access$000(this.this$0).getBitmap();
    if ((localBitmap4 == null) || (localBitmap4.isRecycled()))
    {
      QLog.e("HippyImageView", 1, "shouldSetContent BlurBitmap tempBitmap == null || tempBitmap.isRecycled()");
      return;
    }
    Bitmap localBitmap1 = localBitmap4;
    Bitmap localBitmap2 = localBitmap4;
    try
    {
      int i = localBitmap4.getWidth();
      localBitmap1 = localBitmap4;
      localBitmap2 = localBitmap4;
      int j = localBitmap4.getHeight();
      localBitmap1 = localBitmap4;
      localBitmap2 = localBitmap4;
      float f = HippyTKDImageView.access$100(this.this$0, i, j, this.this$0.mBlurRadius);
      localBitmap1 = localBitmap4;
      localBitmap2 = localBitmap4;
      localBitmap4 = Bitmap.createScaledBitmap(localBitmap4, (int)(i / f), (int)(j / f), true);
      localBitmap1 = localBitmap4;
      localBitmap2 = localBitmap4;
      StackBlur.a(localBitmap4, (int)(this.this$0.mBlurRadius / f));
      localBitmap1 = localBitmap4;
      localBitmap2 = localBitmap4;
      if (QLog.isColorLevel())
      {
        localBitmap1 = localBitmap4;
        localBitmap2 = localBitmap4;
        QLog.d("", 2, new Object[] { "mBlurRadius", Integer.valueOf(this.this$0.mBlurRadius), " blurRate:", Float.valueOf(f) });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localBitmap3 = localBitmap1;
      QLog.e("HippyImageView", 1, "shouldSetContent BlurBitmap oom");
      return;
    }
    finally
    {
      Bitmap localBitmap3;
      this.this$0.onGaussianBlurComplete(localBitmap3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView.1
 * JD-Core Version:    0.7.0.1
 */