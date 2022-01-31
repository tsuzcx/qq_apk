package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bgmq;
import com.tencent.viola.utils.ViolaUtils;
import obz;

class ViolaBaseView$18
  implements Runnable
{
  ViolaBaseView$18(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)bgmq.a("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/Viola.min.0.3.10.js?v_bid=3547" + obz.a(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      bgmq.a("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/Viola.min.0.3.10.js?v_bid=3547" + obz.a(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)bgmq.a(ViolaUtils.getPageName(this.this$0.a) + obz.a(), Long.valueOf(0L))).longValue() > 7200000L) && (ViolaBaseView.a(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      bgmq.a(ViolaUtils.getPageName(this.this$0.a) + obz.a(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.18
 * JD-Core Version:    0.7.0.1
 */