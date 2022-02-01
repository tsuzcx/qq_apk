package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import java.io.File;

public abstract interface VideoViewVideoHolder$VideoViewListener
{
  public abstract void a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView);
  
  public abstract void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean);
  
  public abstract boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView, int paramInt, Object paramObject);
  
  public abstract boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView, boolean paramBoolean);
  
  public abstract void b(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView);
  
  public abstract void c(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoViewListener
 * JD-Core Version:    0.7.0.1
 */