package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class ReadInJoyAdIMAXBrowserFragment$1
  implements View.OnClickListener
{
  ReadInJoyAdIMAXBrowserFragment$1(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackEvent();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("stat_src", "5");
      NativeAdUtils.a(new AdReportData().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(20).b(27).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(NativeAdUtils.a(localHashMap)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */