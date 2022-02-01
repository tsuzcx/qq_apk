package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bnrf;
import com.tencent.viola.utils.ViolaUtils;
import ozs;

class ViolaBaseView$19
  implements Runnable
{
  ViolaBaseView$19(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)bnrf.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ozs.a(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      bnrf.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ozs.a(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)bnrf.a(ViolaUtils.getPageName(this.this$0.a) + ozs.a(), Long.valueOf(0L))).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      bnrf.a(ViolaUtils.getPageName(this.this$0.a) + ozs.a(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.19
 * JD-Core Version:    0.7.0.1
 */