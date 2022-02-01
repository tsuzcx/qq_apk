package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdBlurUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

class ReadInJoyBlurImageView$2
  implements Runnable
{
  ReadInJoyBlurImageView$2(ReadInJoyBlurImageView paramReadInJoyBlurImageView, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = AdBlurUtils.a.a(this.a);
    if (localBitmap == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInjoyBlurImageView", "urlBitmap is empty");
      return;
    }
    int i = ReadInJoyBlurImageView.a(this.this$0).getComMeasuredWidth();
    int j = ReadInJoyBlurImageView.a(this.this$0).getComMeasuredHeight();
    int k = AIOUtils.b(34.0F, ReadInJoyBlurImageView.a(this.this$0).getResources());
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (DeviceInfoUtil.a() >= 26) {
        localObject1 = AdBlurUtils.a.a(localBitmap, ReadInJoyBlurImageView.a(this.this$0), i - k, j, i, j);
      }
    }
    catch (Exception localException)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInjoyBlurImageView", localException.getMessage());
      localObject2 = localObject3;
    }
    if (localObject2 == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInjoyBlurImageView", "adBlurBitmap is empty");
      CommonImageCacheHelper.a(this.b, localBitmap);
      ReadInJoyBlurImageView.a(this.this$0).sendEmptyMessage(1);
      return;
    }
    CommonImageCacheHelper.a(this.b, localObject2);
    ReadInJoyBlurImageView.a(this.this$0).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */