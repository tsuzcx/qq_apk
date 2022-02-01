package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bmhv;
import com.tencent.viola.utils.ViolaUtils;
import pkh;

class ViolaBaseView$20
  implements Runnable
{
  ViolaBaseView$20(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)bmhv.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + pkh.a(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      bmhv.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + pkh.a(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)bmhv.a(ViolaUtils.getPageName(this.this$0.a) + pkh.a(), Long.valueOf(0L))).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      bmhv.a(ViolaUtils.getPageName(this.this$0.a) + pkh.a(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.20
 * JD-Core Version:    0.7.0.1
 */