package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class VideoFeedsRecommendFragment$FollowStatusObserver
  implements FollowListInfoModule.FollowStatusObserver
{
  private List<VideoInfo> a;
  
  public VideoFeedsRecommendFragment$FollowStatusObserver(List<VideoInfo> paramList)
  {
    this.a = paramList;
  }
  
  public void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if (!TextUtils.isEmpty(localVideoInfo.j))
      {
        FollowingMember localFollowingMember = (FollowingMember)paramMap.get(Long.valueOf(Long.parseLong(localVideoInfo.j)));
        if (localFollowingMember != null) {
          localVideoInfo.q = localFollowingMember.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.FollowStatusObserver
 * JD-Core Version:    0.7.0.1
 */