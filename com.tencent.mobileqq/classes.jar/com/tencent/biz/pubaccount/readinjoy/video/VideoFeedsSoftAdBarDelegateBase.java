package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

public abstract interface VideoFeedsSoftAdBarDelegateBase
{
  public abstract void a(double paramDouble);
  
  public abstract void a(VideoInfo paramVideoInfo);
  
  public abstract void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder);
  
  public abstract boolean a();
  
  public abstract boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong);
  
  public abstract String b();
  
  public abstract boolean b(VideoInfo paramVideoInfo);
  
  public abstract String c();
  
  public abstract CharSequence d();
  
  public abstract String e();
  
  public abstract int f();
  
  public abstract void g();
  
  public abstract void onClick(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateBase
 * JD-Core Version:    0.7.0.1
 */