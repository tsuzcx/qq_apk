package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeFollowInfoView$1
  implements View.OnClickListener
{
  SubscribeFollowInfoView$1(SubscribeFollowInfoView paramSubscribeFollowInfoView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a() != null) || (!this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a()))
    {
      String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a()));
      VSReporter.a(str, localStringBuilder.toString(), "clk_name", 0, 0, new String[0]);
      SubscribeLaucher.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a(), ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.a()).poster);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeFollowInfoView.1
 * JD-Core Version:    0.7.0.1
 */