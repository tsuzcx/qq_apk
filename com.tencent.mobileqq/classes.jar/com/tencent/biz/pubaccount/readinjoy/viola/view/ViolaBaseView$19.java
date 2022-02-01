package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bmqa;
import com.tencent.viola.utils.ViolaUtils;
import pha;

class ViolaBaseView$19
  implements Runnable
{
  ViolaBaseView$19(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)bmqa.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + pha.a(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      bmqa.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + pha.a(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)bmqa.a(ViolaUtils.getPageName(this.this$0.a) + pha.a(), Long.valueOf(0L))).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      bmqa.a(ViolaUtils.getPageName(this.this$0.a) + pha.a(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.19
 * JD-Core Version:    0.7.0.1
 */