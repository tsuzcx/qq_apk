package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$6
  implements Runnable
{
  VideoFeedsPlayManager$6(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && ((VideoFeedsPlayManager.a(this.this$0).b() == 5) || (VideoFeedsPlayManager.a(this.this$0).b() == 2)))
    {
      VideoFeedsPlayManager.a(this.this$0).e();
      if (VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.e(VideoFeedsPlayManager.a(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).a(VideoFeedsPlayManager.a(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.c(this.this$0)) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.6
 * JD-Core Version:    0.7.0.1
 */