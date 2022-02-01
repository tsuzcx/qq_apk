package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ssm;

class VideoFollowManager$CheckAccountFollowedRunnable$1
  implements Runnable
{
  VideoFollowManager$CheckAccountFollowedRunnable$1(VideoFollowManager.CheckAccountFollowedRunnable paramCheckAccountFollowedRunnable, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = VideoFollowManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager$CheckAccountFollowedRunnable.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      boolean bool = i | VideoFollowManager.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager$CheckAccountFollowedRunnable, (VideoInfo)localObject, this.jdField_a_of_type_Boolean);
      i = bool;
      if (((VideoInfo)localObject).c != null)
      {
        localObject = ((VideoInfo)localObject).c.iterator();
        for (;;)
        {
          i = bool;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
          bool = VideoFollowManager.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager$CheckAccountFollowedRunnable, localVideoInfo, this.jdField_a_of_type_Boolean) | bool;
        }
      }
    }
    if ((i != 0) && (VideoFollowManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager$CheckAccountFollowedRunnable.this$0) != null)) {
      VideoFollowManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager$CheckAccountFollowedRunnable.this$0).b(VideoFollowManager.CheckAccountFollowedRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFollowManager$CheckAccountFollowedRunnable).j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager.CheckAccountFollowedRunnable.1
 * JD-Core Version:    0.7.0.1
 */