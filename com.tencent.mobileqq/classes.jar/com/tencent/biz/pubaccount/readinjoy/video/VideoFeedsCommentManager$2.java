package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.IAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoFeedsCommentManager$2
  implements ReadInJoyCommentUtils.FirstCommentEvent
{
  VideoFeedsCommentManager$2(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
  public void a()
  {
    if (VideoFeedsCommentManager.a(this.a) != null) {
      VideoFeedsCommentManager.a(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    VideoFeedsCommentManager.a(this.a).e = paramInt;
    VideoFeedsCommentManager.a(this.a).a(VideoFeedsCommentManager.a(this.a));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VideoFeedsCommentManager.a(this.a, 0);
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager.2
 * JD-Core Version:    0.7.0.1
 */