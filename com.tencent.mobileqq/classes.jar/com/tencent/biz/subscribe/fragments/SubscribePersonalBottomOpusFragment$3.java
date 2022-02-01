package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribePersonalBottomOpusFragment$3
  implements View.OnClickListener
{
  SubscribePersonalBottomOpusFragment$3(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.a.poster.registerCertifiedAccountUrl.get()))
    {
      SubscribeLaucher.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.a.poster.registerCertifiedAccountUrl.get());
      VSReporter.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeBaseBottomPersonalFragment$BottomData.a.poster.id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment.3
 * JD-Core Version:    0.7.0.1
 */