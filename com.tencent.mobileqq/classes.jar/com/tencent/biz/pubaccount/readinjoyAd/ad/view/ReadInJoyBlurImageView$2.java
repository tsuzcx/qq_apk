package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import bhdb;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import uju;
import ukq;
import unr;

public class ReadInJoyBlurImageView$2
  implements Runnable
{
  public ReadInJoyBlurImageView$2(unr paramunr, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = uju.a.a(this.a);
    if (localBitmap == null)
    {
      ukq.a("ReadInjoyBlurImageView", "urlBitmap is empty");
      return;
    }
    int i = unr.a(this.this$0).getComMeasuredWidth();
    int j = unr.a(this.this$0).getComMeasuredHeight();
    int k = AIOUtils.dp2px(34.0F, unr.a(this.this$0).getResources());
    localBitmap = uju.a.a(localBitmap, unr.a(this.this$0), i - k, j, i, j);
    if (localBitmap == null)
    {
      ukq.a("ReadInjoyBlurImageView", "adBlurBitmap is empty");
      return;
    }
    bhdb.a(this.b, localBitmap);
    unr.a(this.this$0).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.2
 * JD-Core Version:    0.7.0.1
 */