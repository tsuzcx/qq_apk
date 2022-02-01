package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.utils.ViewUtils;

class AdLiveExpandCardProteusItem$3
  implements Runnable
{
  AdLiveExpandCardProteusItem$3(AdLiveExpandCardProteusItem paramAdLiveExpandCardProteusItem, ViewBase paramViewBase, boolean paramBoolean, Container paramContainer) {}
  
  public void run()
  {
    int i = this.a.findViewBaseByName("id_ad_expand_back").getNativeView().getHeight();
    int j = this.a.findViewBaseByName("id_ad_zhibo_small_container").getNativeView().getHeight();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdLiveExpandCardProteusItem.changeViewbigCardHeight");
    localStringBuilder.append(i);
    localStringBuilder.append("smallCardHeight");
    localStringBuilder.append(j);
    ReadInJoyAdLog.a("AdLiveExpandCardProteusItem", localStringBuilder.toString());
    if ((i != 0) && (AdLiveExpandCardProteusItem.b(this.this$0) == 0)) {
      AdLiveExpandCardProteusItem.a(this.this$0, i);
    } else if (i == 0) {
      AdLiveExpandCardProteusItem.a(this.this$0, ViewUtils.dip2px(275.0F));
    }
    i = j;
    if (j == 0) {
      i = ViewUtils.dip2px(90.0F);
    }
    j = ViewUtils.dip2px(15.0F);
    if (this.b)
    {
      ReadInJoyAdUtils.a(this.c, i + j);
      return;
    }
    ReadInJoyAdUtils.a(this.c, AdLiveExpandCardProteusItem.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem.3
 * JD-Core Version:    0.7.0.1
 */