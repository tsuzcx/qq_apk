package com.tencent.biz.pubaccount.readinjoy.reward;

import android.widget.PopupWindow.OnDismissListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onDismiss"}, k=3, mv={1, 1, 16})
final class RIJVideoRewardCoinManager$initPopupwindow$1
  implements PopupWindow.OnDismissListener
{
  RIJVideoRewardCoinManager$initPopupwindow$1(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager) {}
  
  public final void onDismiss()
  {
    RIJVideoRewardCoinManager.Callback localCallback = RIJVideoRewardCoinManager.a(this.a);
    if (localCallback != null) {
      localCallback.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.initPopupwindow.1
 * JD-Core Version:    0.7.0.1
 */