package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoStateCallback;", "", "onVideoComplete", "", "url", "", "onVideoError", "onVideoPause", "onVideoStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface VideoStateCallback
{
  public abstract void a(@Nullable String paramString);
  
  public abstract void b(@Nullable String paramString);
  
  public abstract void c(@Nullable String paramString);
  
  public abstract void d(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.VideoStateCallback
 * JD-Core Version:    0.7.0.1
 */