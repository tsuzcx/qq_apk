package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Bitmap;

public abstract class MediaPlayListenerAdapter
  implements VideoPlayerWrapper.MediaPlayListener
{
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, String paramString) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return false;
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper) {}
  
  public void c(VideoPlayerWrapper paramVideoPlayerWrapper) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter
 * JD-Core Version:    0.7.0.1
 */