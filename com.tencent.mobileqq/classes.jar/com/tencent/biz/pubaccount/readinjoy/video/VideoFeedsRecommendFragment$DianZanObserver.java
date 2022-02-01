package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanObserver;

class VideoFeedsRecommendFragment$DianZanObserver
  extends VideoPlayDianZanObserver
{
  private VideoFeedsRecommendFragment$DianZanObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    VideoFeedsPlayActivity.a("onGetDianZanState isSuccess: " + paramBoolean);
    if ((!paramBoolean) || (paramBundle == null)) {}
    int i;
    do
    {
      String str;
      do
      {
        return;
        str = paramBundle.getString("VALUE_VIDEO_ARTICLE_ID");
        i = paramBundle.getInt("VALUE_VIDEO_FAVORITE_STATE");
      } while (str == null);
      paramBundle = VideoFeedsRecommendFragment.a(this.a).a(str);
    } while (paramBundle == null);
    if (i == 1) {
      paramBundle.r = true;
    }
    for (;;)
    {
      VideoFeedsRecommendFragment.a(this.a).a(paramBundle);
      return;
      if (i == 0) {
        paramBundle.r = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.DianZanObserver
 * JD-Core Version:    0.7.0.1
 */