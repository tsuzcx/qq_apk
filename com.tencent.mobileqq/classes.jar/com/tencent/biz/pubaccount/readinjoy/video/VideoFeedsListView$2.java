package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.OrientationEventListener;

class VideoFeedsListView$2
  extends OrientationEventListener
{
  VideoFeedsListView$2(VideoFeedsListView paramVideoFeedsListView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (VideoFeedsListView.a(this.a)) {}
    while ((!VideoFeedsListView.b(this.a)) || (!VideoFeedsListView.c(this.a)) || (VideoFeedsListView.a(this.a) == 1) || (VideoFeedsListView.d(this.a)) || (!VideoFeedsListView.a(this.a, paramInt)) || ((!VideoFeedsListView.e(this.a)) && (VideoFeedsListView.f(this.a)))) {
      return;
    }
    VideoFeedsListView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView.2
 * JD-Core Version:    0.7.0.1
 */