package com.tencent.biz.pubaccount.readinjoy.reward;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJVideoRewardCoinManager$initUI$2
  implements View.OnClickListener
{
  RIJVideoRewardCoinManager$initUI$2(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager) {}
  
  public final void onClick(View paramView)
  {
    PopupWindow localPopupWindow = RIJVideoRewardCoinManager.a(this.a);
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.initUI.2
 * JD-Core Version:    0.7.0.1
 */