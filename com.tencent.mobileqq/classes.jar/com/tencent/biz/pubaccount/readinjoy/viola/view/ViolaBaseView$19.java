package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bkbq;
import com.tencent.viola.utils.ViolaUtils;
import ors;

class ViolaBaseView$19
  implements Runnable
{
  ViolaBaseView$19(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)bkbq.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ors.a(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      bkbq.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ors.a(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)bkbq.a(ViolaUtils.getPageName(this.this$0.a) + ors.a(), Long.valueOf(0L))).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      bkbq.a(ViolaUtils.getPageName(this.this$0.a) + ors.a(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.19
 * JD-Core Version:    0.7.0.1
 */