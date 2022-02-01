package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import rds;
import rsr;
import ryo;
import ryq;
import sdj;

class VideoFeedsPlayManager$6
  implements Runnable
{
  VideoFeedsPlayManager$6(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && ((VideoFeedsPlayManager.a(this.this$0).b() == 5) || (VideoFeedsPlayManager.a(this.this$0).b() == 2)))
    {
      VideoFeedsPlayManager.a(this.this$0).e();
      if (VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_Rsr != null) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_Rsr.e(VideoFeedsPlayManager.a(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((ryq)localIterator.next()).a(VideoFeedsPlayManager.a(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.c(this.this$0)) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_Rds.f = rds.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.6
 * JD-Core Version:    0.7.0.1
 */