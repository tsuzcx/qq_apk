package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import cooperation.readinjoy.ReadInJoyHelper;

public class VideoFeedsLikeAnimateManager$LikeAnimateObserver
  implements BusinessObserver
{
  public VideoFeedsLikeAnimateManager$LikeAnimateObserver(VideoFeedsLikeAnimateManager paramVideoFeedsLikeAnimateManager) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle))) {}
    while (!paramBoolean) {
      return;
    }
    paramObject = (Bundle)paramObject;
    VideoFeedsLikeAnimateManager.a(this.a, (LikeAnimationInfo)paramObject.getParcelable("key_like_animation_info"));
    ReadInJoyHelper.a();
    ReadInJoyHelper.a(VideoFeedsLikeAnimateManager.a(this.a));
    VideoFeedsLikeAnimateManager.a(this.a, VideoFeedsLikeAnimateManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimateManager.LikeAnimateObserver
 * JD-Core Version:    0.7.0.1
 */