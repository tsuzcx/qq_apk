package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommodityItemView$2
  implements View.OnClickListener
{
  CommodityItemView$2(CommodityItemView paramCommodityItemView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (!CommodityItemView.a(this.a))) {
      if (!(this.a.a() instanceof CommodityBean)) {
        break label127;
      }
    }
    label127:
    for (String str = ((CommodityBean)this.a.a()).mUrl;; str = ((CertifiedAccountMeta.StYouZanGood)this.a.a()).url.get())
    {
      if (CommodityItemView.a(this.a) != null) {
        VSReporter.a(CommodityItemView.a(this.a).poster.id.get(), "auth_" + SubscribeShareHelper.a(this.a.a()), "clk_goods", 0, 0, new String[0]);
      }
      SubscribeLaucher.a(str, 8002);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView.2
 * JD-Core Version:    0.7.0.1
 */