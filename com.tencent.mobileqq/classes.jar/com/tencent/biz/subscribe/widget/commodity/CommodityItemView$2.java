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
    if ((this.a.getData() != null) && (!CommodityItemView.b(this.a)))
    {
      String str1;
      if ((this.a.getData() instanceof CommodityBean)) {
        str1 = ((CommodityBean)this.a.getData()).mUrl;
      } else {
        str1 = ((CertifiedAccountMeta.StYouZanGood)this.a.getData()).url.get();
      }
      if (CommodityItemView.c(this.a) != null)
      {
        String str2 = CommodityItemView.c(this.a).poster.id.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("auth_");
        localStringBuilder.append(SubscribeShareHelper.a(this.a.getExtraTypeInfo()));
        VSReporter.a(str2, localStringBuilder.toString(), "clk_goods", 0, 0, new String[0]);
      }
      SubscribeLaucher.a(str1, 8002);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityItemView.2
 * JD-Core Version:    0.7.0.1
 */