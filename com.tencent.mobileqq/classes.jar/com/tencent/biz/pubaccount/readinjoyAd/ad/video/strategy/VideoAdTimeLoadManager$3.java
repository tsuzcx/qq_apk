package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import shl;
import ult;

public class VideoAdTimeLoadManager$3
  implements Runnable
{
  public VideoAdTimeLoadManager$3(ult paramult, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    ult.a(this.this$0).add(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    ult.a(this.this$0).notifyItemInserted(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager.3
 * JD-Core Version:    0.7.0.1
 */