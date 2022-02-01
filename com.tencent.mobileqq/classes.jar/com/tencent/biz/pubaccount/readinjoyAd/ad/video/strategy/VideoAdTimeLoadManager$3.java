package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.util.ArrayList;

class VideoAdTimeLoadManager$3
  implements Runnable
{
  VideoAdTimeLoadManager$3(VideoAdTimeLoadManager paramVideoAdTimeLoadManager, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    VideoAdTimeLoadManager.b(this.this$0).add(this.a, this.b);
    VideoAdTimeLoadManager.c(this.this$0).notifyItemInserted(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.3
 * JD-Core Version:    0.7.0.1
 */