package com.tencent.biz.qqstory.playvideo.player;

import android.view.View;

public abstract interface IVideoView
{
  public abstract View a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(IVideoView.OnCompletionListener paramOnCompletionListener);
  
  public abstract void a(IVideoView.OnDownloadListener paramOnDownloadListener);
  
  public abstract void a(IVideoView.OnErrorListener paramOnErrorListener);
  
  public abstract void a(IVideoView.OnInfoListener paramOnInfoListener);
  
  public abstract void a(IVideoView.OnPreparedListener paramOnPreparedListener);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2);
  
  public abstract StoryPlayerTVKWrapper.ReportData b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract long e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract long h();
  
  public abstract boolean i();
  
  public abstract int j();
  
  public abstract int k();
  
  public abstract void l();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.IVideoView
 * JD-Core Version:    0.7.0.1
 */