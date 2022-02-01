package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdBlurUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class ReadInJoyAdCommonBlurImageView$2
  implements Runnable
{
  ReadInJoyAdCommonBlurImageView$2(ReadInJoyAdCommonBlurImageView paramReadInJoyAdCommonBlurImageView, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap3 = AdBlurUtils.a.a(this.a);
    if (localBitmap3 == null)
    {
      ReadInJoyAdLog.a("ReadInJoyAdCommonBlurImageView", "urlBitmap is empty");
      return;
    }
    int k = ReadInJoyAdCommonBlurImageView.a(this.this$0).getComMeasuredWidth();
    int m = ReadInJoyAdCommonBlurImageView.a(this.this$0).getComMeasuredHeight();
    int i = localBitmap3.getWidth();
    int j = localBitmap3.getHeight();
    float f;
    if (i * 1.0F / j < k * 1.0F / m)
    {
      f = m;
      i = (int)(i * 1.0F / j * f);
      j = m;
    }
    for (;;)
    {
      f = Math.max(k / (j * 1.0F), m / (j * 1.0F));
      try
      {
        if (DeviceInfoUtil.a() >= 26)
        {
          Bitmap localBitmap1 = AdBlurUtils.a.a(localBitmap3, ReadInJoyAdCommonBlurImageView.a(this.this$0), i, j, k, m, f);
          if (localBitmap1 != null) {
            break label224;
          }
          ReadInJoyAdLog.a("ReadInJoyAdCommonBlurImageView", "adBlurBitmap is empty");
          CommonImageCacheHelper.a(this.b, localBitmap3);
          ReadInJoyAdCommonBlurImageView.a(this.this$0).sendEmptyMessage(1);
          return;
          f = k;
          j = (int)(j * 1.0F * f / i);
          i = k;
        }
      }
      catch (Exception localException)
      {
        Bitmap localBitmap2;
        for (;;)
        {
          ReadInJoyAdLog.a("ReadInJoyAdCommonBlurImageView", localException.getMessage());
          localBitmap2 = null;
        }
        label224:
        CommonImageCacheHelper.a(this.b, localBitmap2);
        ReadInJoyAdCommonBlurImageView.a(this.this$0).sendEmptyMessage(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */