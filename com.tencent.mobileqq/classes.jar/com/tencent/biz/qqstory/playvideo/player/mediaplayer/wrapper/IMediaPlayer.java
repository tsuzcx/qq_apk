package com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;

public abstract interface IMediaPlayer
{
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(int paramInt);
  
  public abstract void a(Context paramContext, Uri paramUri, Map<String, String> paramMap);
  
  public abstract void a(Surface paramSurface);
  
  public abstract void a(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  public abstract void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract void a(IMediaPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void a(IMediaPlayer.OnInfoListener paramOnInfoListener);
  
  public abstract void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener);
  
  public abstract void a(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void a(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void c(int paramInt);
  
  public abstract void d();
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract int j();
  
  public abstract int k();
  
  public abstract int l();
  
  public abstract int m();
  
  public abstract int o();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer
 * JD-Core Version:    0.7.0.1
 */