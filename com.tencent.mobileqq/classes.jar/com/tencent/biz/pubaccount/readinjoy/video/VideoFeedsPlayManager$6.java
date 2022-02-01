package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import qwu;
import rlr;
import rrm;
import rro;
import rwf;

class VideoFeedsPlayManager$6
  implements Runnable
{
  VideoFeedsPlayManager$6(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && ((VideoFeedsPlayManager.a(this.this$0).b() == 5) || (VideoFeedsPlayManager.a(this.this$0).b() == 2)))
    {
      VideoFeedsPlayManager.a(this.this$0).e();
      if (VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_Rlr != null) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_Rlr.e(VideoFeedsPlayManager.a(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((rro)localIterator.next()).e(VideoFeedsPlayManager.a(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.c(this.this$0)) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_Qwu.f = qwu.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.6
 * JD-Core Version:    0.7.0.1
 */