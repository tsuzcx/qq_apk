package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;

class VideoFeedsRecommendFragment$CommentEventListenerImpl
  implements VideoFeedsCommentManager.CommentEventListener
{
  private VideoFeedsRecommendFragment$CommentEventListenerImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a()
  {
    this.a.c(true);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).a.f(paramBoolean);
    }
    Object localObject;
    if (paramBoolean)
    {
      VideoFeedsRecommendFragment.a(this.a).setNeedDetectOrientation(this.a.getActivity(), false);
      if (!VideoFeedsRecommendFragment.a(this.a))
      {
        localObject = VideoFeedsRecommendFragment.a(this.a);
        if (paramBoolean) {
          break label174;
        }
        bool1 = true;
        label75:
        ((VideoFeedsRecyclerView)localObject).setScrollable(bool1);
        if ((!paramBoolean) && (VideoFeedsRecommendFragment.b(this.a)))
        {
          VideoFeedsRecommendFragment.a(this.a).a();
          VideoFeedsRecommendFragment.a(this.a, false);
        }
      }
      localObject = this.a;
      if (paramBoolean) {
        break label179;
      }
    }
    label174:
    label179:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((VideoFeedsRecommendFragment)localObject).b(bool1);
      if (VideoFeedsRecommendFragment.a(this.a) != null) {
        VideoFeedsRecommendFragment.a(this.a).a(paramBoolean);
      }
      return;
      VideoFeedsRecommendFragment.a(this.a, VideoFeedsRecommendFragment.a(this.a));
      break;
      bool1 = false;
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.CommentEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */