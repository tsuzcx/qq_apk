package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommodityListView$1
  implements View.OnClickListener
{
  CommodityListView$1(CommodityListView paramCommodityListView, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("auth_");
    localStringBuilder.append(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView.a()));
    VSReporter.a(str, localStringBuilder.toString(), "clk_shop", 0, 0, new String[0]);
    SubscribeLaucher.a(((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.youZhan.get(0)).schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView.1
 * JD-Core Version:    0.7.0.1
 */