package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import rvk;

public class RecommendADVideoFeedsManager$2
  implements Runnable
{
  public RecommendADVideoFeedsManager$2(rvk paramrvk, ViewBase paramViewBase, boolean paramBoolean, View paramView) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView() != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
    }
    ViewBase localViewBase = ((ProteusItemView)this.jdField_a_of_type_AndroidViewView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
    if ((localViewBase != null) && (localViewBase.getNativeView() != null)) {
      localViewBase.getNativeView().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager.2
 * JD-Core Version:    0.7.0.1
 */