package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;

class RecommendADVideoFeedsManager$2
  implements Runnable
{
  RecommendADVideoFeedsManager$2(RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager, ViewBase paramViewBase, boolean paramBoolean, View paramView) {}
  
  public void run()
  {
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    if ((localViewBase != null) && (localViewBase.getNativeView() != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
    }
    localViewBase = ((IProteusItemView)this.jdField_a_of_type_AndroidViewView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((localViewBase != null) && (localViewBase.getNativeView() != null)) {
      localViewBase.getNativeView().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager.2
 * JD-Core Version:    0.7.0.1
 */