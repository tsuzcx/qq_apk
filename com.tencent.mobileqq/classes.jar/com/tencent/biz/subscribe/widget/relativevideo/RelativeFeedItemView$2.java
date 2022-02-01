package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelativeFeedItemView$2
  implements View.OnClickListener
{
  RelativeFeedItemView$2(RelativeFeedItemView paramRelativeFeedItemView) {}
  
  public void onClick(View paramView)
  {
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)this.a.getData();
    if (localStFeed != null)
    {
      SubscribeLaucher.a(this.a.getContext(), localStFeed, 0, TransitionAnimHelper.a(this.a.c, localStFeed.cover.width.get(), localStFeed.cover.height.get()));
      ExtraTypeInfo localExtraTypeInfo = this.a.getExtraTypeInfo();
      if ((localExtraTypeInfo != null) && (localStFeed != null)) {
        if (localExtraTypeInfo.pageType == 7003) {
          VSReporter.a(localStFeed.poster.id.get(), "auth_follow", "new_c_clk", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
        } else if (localExtraTypeInfo.pageType == 7004) {
          VSReporter.a(localStFeed.poster.id.get(), "auth_discover", "clk_content", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView.2
 * JD-Core Version:    0.7.0.1
 */