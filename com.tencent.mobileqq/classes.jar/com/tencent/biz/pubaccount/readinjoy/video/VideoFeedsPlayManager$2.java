package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import qqo;
import qub;

class VideoFeedsPlayManager$2
  implements Runnable
{
  VideoFeedsPlayManager$2(VideoFeedsPlayManager paramVideoFeedsPlayManager, qqo paramqqo, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub = VideoFeedsPlayManager.b(this.this$0, this.jdField_a_of_type_Qqo);
    if ((this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub != null) && (VideoFeedsPlayManager.a(this.this$0) != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.a(this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g != null)
      {
        VideoFeedsPlayManager.a(this.this$0).put(this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub);
        VideoFeedsPlayManager.a(this.this$0).post(new VideoFeedsPlayManager.2.1(this));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        VideoFeedsPlayManager.a(this.this$0).put(String.valueOf(VideoFeedsPlayManager.a(this.this$0)), this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub);
        VideoFeedsPlayManager.b(this.this$0);
      }
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub + ", mUIHandler = " + VideoFeedsPlayManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.2
 * JD-Core Version:    0.7.0.1
 */