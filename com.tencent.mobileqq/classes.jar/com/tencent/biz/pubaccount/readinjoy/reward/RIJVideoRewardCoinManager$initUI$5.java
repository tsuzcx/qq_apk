package com.tencent.biz.pubaccount.readinjoy.reward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJVideoRewardCoinManager$initUI$5
  implements View.OnClickListener
{
  RIJVideoRewardCoinManager$initUI$5(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager) {}
  
  public final void onClick(View paramView)
  {
    if (RIJVideoRewardCoinManager.a(this.a))
    {
      localObject1 = RIJVideoRewardCoinManager.a(this.a);
      if (localObject1 != null) {
        ((RIJVideoRewardCoinManager.Callback)localObject1).a("投币中，请稍等～");
      }
    }
    int j = RIJVideoRewardCoinManager.a(this.a, RIJVideoRewardCoinManager.a(this.a));
    Object localObject1 = RIJVideoRewardCoinManager.a(this.a);
    int i;
    if (localObject1 != null)
    {
      Object localObject2 = ((VideoInfo)localObject1).j;
      if (localObject2 == null) {
        break label164;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label159;
      }
      i = 1;
      if (i != 1) {
        break label164;
      }
      RIJVideoRewardCoinManager.a(this.a, true);
      RIJVideoRewardCoinManager.b(this.a, RIJVideoRewardCoinManager.a(this.a));
      localObject2 = ReadInJoyLogicEngine.a();
      String str = ((VideoInfo)localObject1).j;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.accountUin");
      ((ReadInJoyLogicEngine)localObject2).a(Long.parseLong(str), j, ((VideoInfo)localObject1).g);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label159:
      i = 0;
      break;
      label164:
      localObject1 = RIJVideoRewardCoinManager.a(this.a);
      if (localObject1 != null) {
        ((RIJVideoRewardCoinManager.Callback)localObject1).a(false, "投币失败", RIJVideoRewardCoinManager.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.initUI.5
 * JD-Core Version:    0.7.0.1
 */