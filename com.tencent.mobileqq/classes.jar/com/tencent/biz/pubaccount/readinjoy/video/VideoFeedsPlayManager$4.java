package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import qyz;
import rfs;
import rfu;

class VideoFeedsPlayManager$4
  implements Runnable
{
  VideoFeedsPlayManager$4(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && (VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_AndroidViewView != null))
    {
      if (VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Qyz != null) {
        VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Qyz.a(VideoFeedsPlayManager.b(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((rfu)localIterator.next()).b(VideoFeedsPlayManager.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.4
 * JD-Core Version:    0.7.0.1
 */