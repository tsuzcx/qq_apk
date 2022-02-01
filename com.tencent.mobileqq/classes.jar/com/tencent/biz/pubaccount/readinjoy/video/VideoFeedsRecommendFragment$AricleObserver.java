package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.PublicAccountArticleObserver;

class VideoFeedsRecommendFragment$AricleObserver
  extends PublicAccountArticleObserver
{
  private VideoFeedsRecommendFragment$AricleObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    VideoFeedsPlayActivity.a("onSendArticleLikeReq isSuccess=" + paramBoolean + ", articleID=" + paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.AricleObserver
 * JD-Core Version:    0.7.0.1
 */