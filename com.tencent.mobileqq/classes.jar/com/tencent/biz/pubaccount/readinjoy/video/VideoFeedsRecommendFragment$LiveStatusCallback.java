package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatus;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatusCallback;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.UserInfoItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoFeedsRecommendFragment$LiveStatusCallback
  implements RIJLiveStatusModule.LiveStatusCallback
{
  private VideoFeedsRecommendFragment$LiveStatusCallback(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(int paramInt, List<RIJLiveStatusModule.UserInfoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    label12:
    label146:
    label147:
    for (;;)
    {
      RIJLiveStatusModule.UserInfoItem localUserInfoItem;
      if (paramList.hasNext())
      {
        localUserInfoItem = (RIJLiveStatusModule.UserInfoItem)paramList.next();
        Iterator localIterator = VideoFeedsRecommendFragment.a(this.a).iterator();
        paramInt = 0;
        label45:
        if (localIterator.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
          if ((TextUtils.isEmpty(localVideoInfo.j)) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus != null) || (Long.parseLong(localVideoInfo.j) != localUserInfoItem.jdField_a_of_type_Long)) {
            break label146;
          }
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus = localUserInfoItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus;
          if (localUserInfoItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatus.a != 1) {
            break label146;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        break label45;
        if (paramInt == 0) {
          break label147;
        }
        VideoFeedsHelper.a(new VideoFeedsRecommendFragment.LiveStatusCallback.1(this, localUserInfoItem));
        break label12;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.LiveStatusCallback
 * JD-Core Version:    0.7.0.1
 */