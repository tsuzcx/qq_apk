package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import java.util.HashMap;

class VideoFeedsShareController$RIJObserver
  extends ReadInJoyObserver
{
  private VideoFeedsShareController$RIJObserver(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void g(String paramString, int paramInt)
  {
    VideoFeedsShareController.a().put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.RIJObserver
 * JD-Core Version:    0.7.0.1
 */