package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import raw;

class VideoFeedsRecommendFragment$CheckAccountFollowedRunnable$1
  implements Runnable
{
  VideoFeedsRecommendFragment$CheckAccountFollowedRunnable$1(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable paramCheckAccountFollowedRunnable, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$CheckAccountFollowedRunnable.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      boolean bool = i | VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$CheckAccountFollowedRunnable, (VideoInfo)localObject, this.jdField_a_of_type_Boolean);
      i = bool;
      if (((VideoInfo)localObject).d != null)
      {
        localObject = ((VideoInfo)localObject).d.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
          bool = VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$CheckAccountFollowedRunnable, localVideoInfo, this.jdField_a_of_type_Boolean) | bool;
        }
      }
    }
    if ((i != 0) && (VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$CheckAccountFollowedRunnable.this$0) != null)) {
      VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$CheckAccountFollowedRunnable.this$0).a(VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$CheckAccountFollowedRunnable).j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1
 * JD-Core Version:    0.7.0.1
 */