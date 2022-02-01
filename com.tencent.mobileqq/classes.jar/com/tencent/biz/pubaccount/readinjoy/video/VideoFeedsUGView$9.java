package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;

class VideoFeedsUGView$9
  implements Runnable
{
  VideoFeedsUGView$9(VideoFeedsUGView paramVideoFeedsUGView, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo == null) || (TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.j)) || (!this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.j.equals(this.a))) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.this$0.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.9
 * JD-Core Version:    0.7.0.1
 */