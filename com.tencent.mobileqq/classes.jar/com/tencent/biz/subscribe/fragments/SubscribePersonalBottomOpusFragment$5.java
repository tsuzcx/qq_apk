package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

class SubscribePersonalBottomOpusFragment$5
  implements View.OnClickListener
{
  SubscribePersonalBottomOpusFragment$5(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("postUin", this.a.e.poster.id.get());
    if (this.a.e.poster.youZhan.size() > 0)
    {
      int i = ((CertifiedAccountMeta.StYouZanShop)this.a.e.poster.youZhan.get(0)).type.get();
      boolean bool = true;
      if (i <= 1) {
        bool = false;
      }
      localIntent.putExtra("has_shop", bool);
    }
    QZoneHelper.forwardToQQPublicAccountPublishPage(this.b.getBaseActivity(), localIntent, 0);
    VSReporter.b(this.a.e.poster.id.get(), "auth_person", "blank_post", 0, 0, new String[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment.5
 * JD-Core Version:    0.7.0.1
 */