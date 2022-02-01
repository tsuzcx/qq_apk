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
    VideoAdTimeLoadManager.a(this.this$0).add(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    VideoAdTimeLoadManager.a(this.this$0).notifyItemInserted(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.3
 * JD-Core Version:    0.7.0.1
 */