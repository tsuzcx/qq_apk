package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.UGDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;

class VideoFeedsUGView$5
  implements Runnable
{
  VideoFeedsUGView$5(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f)) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$UGDownloadInfo.f.equals(this.a.d)))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.this$0.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView.5
 * JD-Core Version:    0.7.0.1
 */