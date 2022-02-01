package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BarrageController$onBarragePlaceInLine$1
  implements View.OnClickListener
{
  BarrageController$onBarragePlaceInLine$1(BarrageController paramBarrageController, BarrageInfo paramBarrageInfo) {}
  
  public final void onClick(View paramView)
  {
    BarrageCallback localBarrageCallback = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageController.a();
    if (localBarrageCallback != null)
    {
      String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(str, "barrageInfo.id");
      localBarrageCallback.onEventBarrageOnClick(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageController.onBarragePlaceInLine.1
 * JD-Core Version:    0.7.0.1
 */