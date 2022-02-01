package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import agej;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import bhld;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import toz;
import tpx;
import tsz;

public class ReadInJoyBlurImageView$2
  implements Runnable
{
  public ReadInJoyBlurImageView$2(tsz paramtsz, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = toz.a.a(this.a);
    if (localBitmap == null)
    {
      tpx.a("ReadInjoyBlurImageView", "urlBitmap is empty");
      return;
    }
    int i = tsz.a(this.this$0).getComMeasuredWidth();
    int j = tsz.a(this.this$0).getComMeasuredHeight();
    int k = agej.a(34.0F, tsz.a(this.this$0).getResources());
    localBitmap = toz.a.a(localBitmap, tsz.a(this.this$0), i - k, j, i, j);
    if (localBitmap == null)
    {
      tpx.a("ReadInjoyBlurImageView", "adBlurBitmap is empty");
      return;
    }
    bhld.a(this.b, localBitmap);
    tsz.a(this.this$0).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */