package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdBlurUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class ReadInJoyAdCommonBlurImageView$2
  implements Runnable
{
  ReadInJoyAdCommonBlurImageView$2(ReadInJoyAdCommonBlurImageView paramReadInJoyAdCommonBlurImageView, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = AdBlurUtils.a.a(this.a);
    if (localBitmap == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdCommonBlurImageView", "urlBitmap is empty");
      return;
    }
    int m = ReadInJoyAdCommonBlurImageView.b(this.this$0).getComMeasuredWidth();
    int n = ReadInJoyAdCommonBlurImageView.b(this.this$0).getComMeasuredHeight();
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    float f3 = i;
    float f4 = j;
    float f5 = f3 * 1.0F / f4;
    float f1 = m;
    float f2 = n;
    int k;
    if (f5 < f1 * 1.0F / f2)
    {
      j = (int)(f5 * f2);
      i = n;
      k = i;
    }
    else
    {
      k = (int)(f4 * 1.0F * f1 / f3);
      i = m;
      j = i;
    }
    f3 = k * 1.0F;
    f1 = Math.max(f1 / f3, f2 / f3);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (DeviceInfoUtil.d() >= 26) {
        localObject1 = AdBlurUtils.a.a(localBitmap, ReadInJoyAdCommonBlurImageView.c(this.this$0), j, k, m, n, f1);
      }
    }
    catch (Exception localException)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdCommonBlurImageView", localException.getMessage());
      localObject2 = localObject3;
    }
    if (localObject2 == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoyAdCommonBlurImageView", "adBlurBitmap is empty");
      CommonImageCacheHelper.a(this.b, localBitmap);
      ReadInJoyAdCommonBlurImageView.d(this.this$0).sendEmptyMessage(1);
      return;
    }
    CommonImageCacheHelper.a(this.b, localObject2);
    ReadInJoyAdCommonBlurImageView.d(this.this$0).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */