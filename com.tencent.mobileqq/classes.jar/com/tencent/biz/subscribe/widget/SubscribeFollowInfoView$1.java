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
    if ((this.b.getData() != null) || (!this.b.a()))
    {
      String str = this.a.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(this.b.getExtraTypeInfo()));
      VSReporter.a(str, localStringBuilder.toString(), "clk_name", 0, 0, new String[0]);
      SubscribeLaucher.a(this.b.getHostActivity(), ((CertifiedAccountMeta.StFeed)this.b.getData()).poster);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeFollowInfoView.1
 * JD-Core Version:    0.7.0.1
 */