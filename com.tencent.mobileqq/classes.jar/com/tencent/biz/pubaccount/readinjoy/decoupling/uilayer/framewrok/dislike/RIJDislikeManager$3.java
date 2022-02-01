package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.widget.KandianNegativeWindowForAd;

class RIJDislikeManager$3
  implements PopupWindow.OnDismissListener
{
  RIJDislikeManager$3(RIJDislikeManager paramRIJDislikeManager, RIJDataManager paramRIJDataManager) {}
  
  public void onDismiss()
  {
    RIJDislikeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager).a(1.0F);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().f(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager.3
 * JD-Core Version:    0.7.0.1
 */