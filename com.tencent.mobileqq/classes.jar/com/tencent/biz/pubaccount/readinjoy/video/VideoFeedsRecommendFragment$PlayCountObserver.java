package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoPlayCountObserver;

class VideoFeedsRecommendFragment$PlayCountObserver
  extends VideoPlayCountObserver
{
  private VideoFeedsRecommendFragment$PlayCountObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    VideoFeedsPlayActivity.a("onGetVideoPlayCount isSuccess: " + paramBoolean);
    if ((!paramBoolean) || (paramBundle == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramBundle.getString("VALUE_VIDEO_VID");
      } while (localObject == null);
      localObject = VideoFeedsRecommendFragment.a(this.a).b((String)localObject);
    } while (localObject == null);
    ((VideoInfo)localObject).t = paramBundle.getInt("VALUE_VIDEO_PLAY_COUNT");
    VideoFeedsRecommendFragment.a(this.a).a((VideoInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.PlayCountObserver
 * JD-Core Version:    0.7.0.1
 */