package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.readinjoy.ReadInJoyHelper;

class ViolaBaseView$23
  implements Runnable
{
  ViolaBaseView$23(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)ReadInJoyHelper.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ReadInJoyUtils.a(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      ReadInJoyHelper.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ReadInJoyUtils.a(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)ReadInJoyHelper.a(ViolaUtils.getPageName(this.this$0.a) + ReadInJoyUtils.a(), Long.valueOf(0L))).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      ReadInJoyHelper.a(ViolaUtils.getPageName(this.this$0.a) + ReadInJoyUtils.a(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.23
 * JD-Core Version:    0.7.0.1
 */