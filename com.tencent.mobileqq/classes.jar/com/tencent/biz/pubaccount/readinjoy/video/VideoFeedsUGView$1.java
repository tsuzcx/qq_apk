package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoFeedsUGView$1
  implements View.OnClickListener
{
  VideoFeedsUGView$1(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    SharedPreUtils.a("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.a.setVisibility(8);
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.i, "101", this.a.jdField_a_of_type_JavaLangString));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.1
 * JD-Core Version:    0.7.0.1
 */