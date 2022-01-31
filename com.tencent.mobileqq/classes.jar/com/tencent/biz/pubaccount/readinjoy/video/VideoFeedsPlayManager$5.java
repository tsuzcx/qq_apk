package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import qbw;
import qjv;
import qqo;
import qqq;
import qub;

class VideoFeedsPlayManager$5
  implements Runnable
{
  VideoFeedsPlayManager$5(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && ((VideoFeedsPlayManager.a(this.this$0).e() == 5) || (VideoFeedsPlayManager.a(this.this$0).e() == 2)))
    {
      VideoFeedsPlayManager.a(this.this$0).g();
      if (VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Qjv != null) {
        VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Qjv.b(VideoFeedsPlayManager.b(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((qqq)localIterator.next()).e(VideoFeedsPlayManager.b(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.d(this.this$0)) {
        VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Qbw.f = qbw.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.5
 * JD-Core Version:    0.7.0.1
 */