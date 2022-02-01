package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class ReadInJoyAdIMAXBrowserFragment$2
  implements View.OnClickListener
{
  ReadInJoyAdIMAXBrowserFragment$2(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (SwiftBrowserShareMenuHandler)this.a.mComponentsProvider.a(4);
    if ((localObject != null) && (((SwiftBrowserShareMenuHandler)localObject).a != null) && (((SwiftBrowserShareMenuHandler)localObject).a.isShowing())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a);
      localObject = new HashMap();
      ((HashMap)localObject).put("stat_src", "5");
      NativeAdUtils.a(new AdReportData().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(21).b(27).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(NativeAdUtils.a((HashMap)localObject)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */