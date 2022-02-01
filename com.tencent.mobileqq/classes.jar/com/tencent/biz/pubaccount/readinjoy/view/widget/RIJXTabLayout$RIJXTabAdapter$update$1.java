package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJXTabLayout$RIJXTabAdapter$update$1
  implements View.OnClickListener
{
  RIJXTabLayout$RIJXTabAdapter$update$1(RIJXTabLayout.RIJXTabAdapter paramRIJXTabAdapter, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    RIJXTabLayout.RIJXTabAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabLayout$RIJXTabAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabLayout.RIJXTabAdapter.update.1
 * JD-Core Version:    0.7.0.1
 */