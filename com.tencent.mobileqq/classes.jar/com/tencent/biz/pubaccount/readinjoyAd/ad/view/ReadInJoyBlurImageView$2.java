package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import bfuj;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import tvt;
import twp;
import tzp;

public class ReadInJoyBlurImageView$2
  implements Runnable
{
  public ReadInJoyBlurImageView$2(tzp paramtzp, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = tvt.a.a(this.a);
    if (localBitmap == null)
    {
      twp.a("ReadInjoyBlurImageView", "urlBitmap is empty");
      return;
    }
    int i = tzp.a(this.this$0).getComMeasuredWidth();
    int j = tzp.a(this.this$0).getComMeasuredHeight();
    int k = AIOUtils.dp2px(34.0F, tzp.a(this.this$0).getResources());
    localBitmap = tvt.a.a(localBitmap, tzp.a(this.this$0), i - k, j, i, j);
    if (localBitmap == null)
    {
      twp.a("ReadInjoyBlurImageView", "adBlurBitmap is empty");
      return;
    }
    bfuj.a(this.b, localBitmap);
    tzp.a(this.this$0).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */