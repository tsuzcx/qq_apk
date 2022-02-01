package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdBlurUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class ReadInJoyBlurImageView$2
  implements Runnable
{
  ReadInJoyBlurImageView$2(ReadInJoyBlurImageView paramReadInJoyBlurImageView, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap3 = AdBlurUtils.a.a(this.a);
    if (localBitmap3 == null)
    {
      ReadInJoyAdLog.a("ReadInjoyBlurImageView", "urlBitmap is empty");
      return;
    }
    int i = ReadInJoyBlurImageView.a(this.this$0).getComMeasuredWidth();
    int j = ReadInJoyBlurImageView.a(this.this$0).getComMeasuredHeight();
    int k = AIOUtils.a(34.0F, ReadInJoyBlurImageView.a(this.this$0).getResources());
    try
    {
      if (DeviceInfoUtil.a() >= 26)
      {
        Bitmap localBitmap1 = AdBlurUtils.a.a(localBitmap3, ReadInJoyBlurImageView.a(this.this$0), i - k, j, i, j);
        if (localBitmap1 != null) {
          break label146;
        }
        ReadInJoyAdLog.a("ReadInjoyBlurImageView", "adBlurBitmap is empty");
        CommonImageCacheHelper.a(this.b, localBitmap3);
        ReadInJoyBlurImageView.a(this.this$0).sendEmptyMessage(1);
      }
    }
    catch (Exception localException)
    {
      Bitmap localBitmap2;
      for (;;)
      {
        ReadInJoyAdLog.a("ReadInjoyBlurImageView", localException.getMessage());
        localBitmap2 = null;
      }
      label146:
      CommonImageCacheHelper.a(this.b, localBitmap2);
      ReadInJoyBlurImageView.a(this.this$0).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */