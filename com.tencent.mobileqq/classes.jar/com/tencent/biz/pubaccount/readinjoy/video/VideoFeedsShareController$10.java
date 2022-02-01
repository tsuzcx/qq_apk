package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnComplainListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class VideoFeedsShareController$10
  implements ReadInJoyDisLikeDialogView.OnComplainListener
{
  VideoFeedsShareController$10(VideoFeedsShareController paramVideoFeedsShareController, VideoInfo paramVideoInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, "onDislikeDialogViewForAdComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      localIntent.putExtra("key_ad_info", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    }
    PublicFragmentActivity.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.10
 * JD-Core Version:    0.7.0.1
 */