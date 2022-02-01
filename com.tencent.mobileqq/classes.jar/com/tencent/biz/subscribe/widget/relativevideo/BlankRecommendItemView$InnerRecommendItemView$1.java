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
    SubscribeLaucher.a(this.b.a.getContext(), this.a, 0, TransitionAnimHelper.a(BlankRecommendItemView.InnerRecommendItemView.a(this.b), this.a.cover.width.get(), this.a.cover.height.get()));
    String str = this.a.poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BlankRecommendItemView.InnerRecommendItemView.b(this.b));
    localStringBuilder.append("");
    VSReporter.b(str, "auth_follow", "blank_content_clk", 0, 0, new String[] { "", localStringBuilder.toString(), this.a.poster.nick.get(), this.a.title.get() });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.InnerRecommendItemView.1
 * JD-Core Version:    0.7.0.1
 */