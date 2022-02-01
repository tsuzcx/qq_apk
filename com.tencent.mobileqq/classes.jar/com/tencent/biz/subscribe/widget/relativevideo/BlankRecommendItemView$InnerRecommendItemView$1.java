package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BlankRecommendItemView$InnerRecommendItemView$1
  implements View.OnClickListener
{
  BlankRecommendItemView$InnerRecommendItemView$1(BlankRecommendItemView.InnerRecommendItemView paramInnerRecommendItemView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    SubscribeLaucher.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoBlankRecommendItemView$InnerRecommendItemView.a.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 0, TransitionAnimHelper.a(BlankRecommendItemView.InnerRecommendItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoBlankRecommendItemView$InnerRecommendItemView), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.width.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.height.get()));
    VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "blank_content_clk", 0, 0, new String[] { "", BlankRecommendItemView.InnerRecommendItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoBlankRecommendItemView$InnerRecommendItemView) + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.InnerRecommendItemView.1
 * JD-Core Version:    0.7.0.1
 */