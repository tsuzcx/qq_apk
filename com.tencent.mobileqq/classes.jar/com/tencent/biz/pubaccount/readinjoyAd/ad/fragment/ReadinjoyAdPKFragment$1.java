package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyAdPKFragment$1
  implements Runnable
{
  ReadinjoyAdPKFragment$1(ReadinjoyAdPKFragment paramReadinjoyAdPKFragment) {}
  
  public void run()
  {
    if (ReadinjoyAdPKFragment.a(this.this$0) != null) {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(ReadinjoyAdPKFragment.a(this.this$0), (int)(ReadinjoyAdPKFragment.a(this.this$0).getWidth() * 0.0625F), (int)(ReadinjoyAdPKFragment.a(this.this$0).getHeight() * 0.0625F), false);
        if (localBitmap == null)
        {
          if (!QLog.isColorLevel()) {
            break label202;
          }
          QLog.e("ReadinjoyAdPKFragment", 1, "run: scaledBitmap == null");
          return;
        }
        localObject = new StackBlurManager(localBitmap).process(4);
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("ReadinjoyAdPKFragment", 1, "run: blured bitmap is null");
          return;
        }
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(0);
        localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
        localCanvas.drawColor(Color.parseColor("#7F03081A"));
        localCanvas.setBitmap(null);
        ReadinjoyAdPKFragment.c(this.this$0).post(new ReadinjoyAdPKFragment.1.1(this, localBitmap));
        return;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mDecodeRunnable error message = ");
          ((StringBuilder)localObject).append(localThrowable.getMessage());
          QLog.e("ReadinjoyAdPKFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
    } else {
      return;
    }
    label202:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment.1
 * JD-Core Version:    0.7.0.1
 */