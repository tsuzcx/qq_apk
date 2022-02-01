package com.tencent.biz.qqstory.playvideo.player;

import android.view.View;

public class ProgressVideoViewWrapper
  implements IVideoView
{
  private IVideoView a;
  private ProgressVideoViewWrapper.ProgressListener b;
  private ProgressVideoViewWrapper.OnErrorListenerWrapper c = new ProgressVideoViewWrapper.OnErrorListenerWrapper(this, null);
  private ProgressVideoViewWrapper.OnInfoListenerWrapper d = new ProgressVideoViewWrapper.OnInfoListenerWrapper(this, null);
  private ProgressVideoViewWrapper.OnPreparedListenerWrapper e = new ProgressVideoViewWrapper.OnPreparedListenerWrapper(this, null);
  
  public ProgressVideoViewWrapper(IVideoView paramIVideoView)
  {
    this.a = paramIVideoView;
  }
  
  public View a()
  {
    return this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.a.a(paramOnCompletionListener);
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener)
  {
    this.a.a(paramOnDownloadListener);
  }
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    ProgressVideoViewWrapper.OnErrorListenerWrapper localOnErrorListenerWrapper = this.c;
    localOnErrorListenerWrapper.a = paramOnErrorListener;
    this.a.a(localOnErrorListenerWrapper);
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    ProgressVideoViewWrapper.OnInfoListenerWrapper localOnInfoListenerWrapper = this.d;
    localOnInfoListenerWrapper.a = paramOnInfoListener;
    this.a.a(localOnInfoListenerWrapper);
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    ProgressVideoViewWrapper.OnPreparedListenerWrapper localOnPreparedListenerWrapper = this.e;
    localOnPreparedListenerWrapper.a = paramOnPreparedListener;
    this.a.a(localOnPreparedListenerWrapper);
  }
  
  public void a(ProgressVideoViewWrapper.ProgressListener paramProgressListener)
  {
    this.b = paramProgressListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.a.a(paramString1, paramString2, paramString3, paramLong, paramInt1, paramInt2);
  }
  
  public StoryPlayerTVKWrapper.ReportData b()
  {
    return this.a.b();
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public void d()
  {
    ProgressVideoViewWrapper.ProgressListener localProgressListener = this.b;
    if (localProgressListener != null) {
      localProgressListener.b(this.a);
    }
    this.a.d();
  }
  
  public long e()
  {
    return this.a.e();
  }
  
  public void f()
  {
    ProgressVideoViewWrapper.ProgressListener localProgressListener = this.b;
    if (localProgressListener != null) {
      localProgressListener.c(this.a);
    }
    this.a.f();
  }
  
  public void g()
  {
    ProgressVideoViewWrapper.ProgressListener localProgressListener = this.b;
    if (localProgressListener != null)
    {
      localProgressListener.a(0L, this.a.h(), this.a);
      this.b.b(this.a);
    }
    this.a.g();
  }
  
  public long h()
  {
    return this.a.h();
  }
  
  public boolean i()
  {
    return this.a.i();
  }
  
  public int j()
  {
    return this.a.j();
  }
  
  public int k()
  {
    return this.a.k();
  }
  
  public void l()
  {
    this.a.l();
  }
  
  public IVideoView m()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper
 * JD-Core Version:    0.7.0.1
 */