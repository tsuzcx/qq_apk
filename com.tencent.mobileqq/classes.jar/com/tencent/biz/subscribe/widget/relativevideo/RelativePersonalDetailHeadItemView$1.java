package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelativePersonalDetailHeadItemView$1
  implements View.OnClickListener
{
  RelativePersonalDetailHeadItemView$1(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, CertifiedAccountMeta.StYouZanShop paramStYouZanShop) {}
  
  public void onClick(View paramView)
  {
    SubscribeLaucher.a(this.a.schema.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.1
 * JD-Core Version:    0.7.0.1
 */