package com.tencent.biz.pubaccount.readinjoy.reward;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJVideoRewardCoinManager$initUI$1
  implements View.OnClickListener
{
  RIJVideoRewardCoinManager$initUI$1(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager) {}
  
  public final void onClick(View paramView)
  {
    ReadInJoyUtils.a((Context)RIJVideoRewardCoinManager.a(this.a), "https://viola.qq.com/js/moonCakeMoney.js?_rij_violaUrl=1&v_tid=6&v_bundleName=moonCakeMoney&_bid=3740&statusBarStyle=1&hideNav=1&v_nav_immer=1&entry=3");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.initUI.1
 * JD-Core Version:    0.7.0.1
 */