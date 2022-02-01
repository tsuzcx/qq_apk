package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class VideoFeedsPlayActivity$4
  implements OnColorNoteAnimFinishListener
{
  VideoFeedsPlayActivity$4(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    this.a.e();
    if ((VideoFeedsPlayActivity.a(this.a) != null) && (VideoFeedsPlayActivity.a(this.a).c())) {
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.4
 * JD-Core Version:    0.7.0.1
 */