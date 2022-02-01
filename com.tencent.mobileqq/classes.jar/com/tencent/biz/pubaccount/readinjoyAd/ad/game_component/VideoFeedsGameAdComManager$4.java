package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;

class VideoFeedsGameAdComManager$4
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (!VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager)) {}
    }
    while (!(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager) instanceof Activity))
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager.b();
      return;
    }
    ReadInJoyAdUtils.b(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager));
    FastWeqAdUtils.a(VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager), VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager).p, VideoFeedsGameAdComManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager).q, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.4
 * JD-Core Version:    0.7.0.1
 */