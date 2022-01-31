package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import qeq;
import qhw;

class VideoFeedsPlayManager$2
  implements Runnable
{
  VideoFeedsPlayManager$2(VideoFeedsPlayManager paramVideoFeedsPlayManager, qeq paramqeq, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw = VideoFeedsPlayManager.b(this.this$0, this.jdField_a_of_type_Qeq);
    if ((this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw != null) && (VideoFeedsPlayManager.a(this.this$0) != null))
    {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.a(this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      VideoFeedsPlayManager.a(this.this$0).put(this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw, VideoFeedsPlayManager.a(this.this$0));
      VideoFeedsPlayManager.a(this.this$0).post(new VideoFeedsPlayManager.2.1(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw + ", mUIHandler = " + VideoFeedsPlayManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.2
 * JD-Core Version:    0.7.0.1
 */