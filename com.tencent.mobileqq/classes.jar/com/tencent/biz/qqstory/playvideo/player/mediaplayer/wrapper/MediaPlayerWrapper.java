package com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import java.util.Map;

@TargetApi(14)
public class MediaPlayerWrapper
  implements IMediaPlayer
{
  MediaPlayer a = new MediaPlayer();
  
  public int a()
  {
    return this.a.getDuration();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.setVolume(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt)
  {
    this.a.seekTo(paramInt);
  }
  
  public void a(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void a(Surface paramSurface)
  {
    this.a.setSurface(paramSurface);
  }
  
  public void a(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnBufferingUpdateListener == null) {}
    for (paramOnBufferingUpdateListener = null;; paramOnBufferingUpdateListener = new MediaPlayerWrapper.3(this, paramOnBufferingUpdateListener))
    {
      localMediaPlayer.setOnBufferingUpdateListener(paramOnBufferingUpdateListener);
      return;
    }
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnCompletionListener == null) {}
    for (paramOnCompletionListener = null;; paramOnCompletionListener = new MediaPlayerWrapper.2(this, paramOnCompletionListener))
    {
      localMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
      return;
    }
  }
  
  public void a(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnErrorListener == null) {}
    for (paramOnErrorListener = null;; paramOnErrorListener = new MediaPlayerWrapper.6(this, paramOnErrorListener))
    {
      localMediaPlayer.setOnErrorListener(paramOnErrorListener);
      return;
    }
  }
  
  public void a(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnInfoListener == null) {}
    for (paramOnInfoListener = null;; paramOnInfoListener = new MediaPlayerWrapper.7(this, paramOnInfoListener))
    {
      localMediaPlayer.setOnInfoListener(paramOnInfoListener);
      return;
    }
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnPreparedListener == null) {}
    for (paramOnPreparedListener = null;; paramOnPreparedListener = new MediaPlayerWrapper.1(this, paramOnPreparedListener))
    {
      localMediaPlayer.setOnPreparedListener(paramOnPreparedListener);
      return;
    }
  }
  
  public void a(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnSeekCompleteListener == null) {}
    for (paramOnSeekCompleteListener = null;; paramOnSeekCompleteListener = new MediaPlayerWrapper.4(this, paramOnSeekCompleteListener))
    {
      localMediaPlayer.setOnSeekCompleteListener(paramOnSeekCompleteListener);
      return;
    }
  }
  
  public void a(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnVideoSizeChangedListener == null) {}
    for (paramOnVideoSizeChangedListener = null;; paramOnVideoSizeChangedListener = new MediaPlayerWrapper.5(this, paramOnVideoSizeChangedListener))
    {
      localMediaPlayer.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setLooping(paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.isPlaying();
  }
  
  public int b()
  {
    return this.a.getCurrentPosition();
  }
  
  public void b()
  {
    this.a.prepareAsync();
  }
  
  public void b(int paramInt)
  {
    this.a.setAudioSessionId(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public int c()
  {
    return this.a.getVideoWidth();
  }
  
  public void c()
  {
    this.a.start();
  }
  
  public void c(int paramInt)
  {
    this.a.setAudioStreamType(paramInt);
  }
  
  public int d()
  {
    return this.a.getVideoHeight();
  }
  
  public void d()
  {
    this.a.pause();
  }
  
  public int e()
  {
    return this.a.getAudioSessionId();
  }
  
  public void e()
  {
    this.a.stop();
  }
  
  public void f()
  {
    this.a.release();
  }
  
  public void g()
  {
    try
    {
      this.a.reset();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      CaughtExceptionReport.a(localIllegalStateException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.MediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */