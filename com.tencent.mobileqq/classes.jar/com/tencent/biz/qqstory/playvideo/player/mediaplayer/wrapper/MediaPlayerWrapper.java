package com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.Map;

@TargetApi(14)
public class MediaPlayerWrapper
  implements IMediaPlayer
{
  MediaPlayer a = new MediaPlayer();
  
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
    if (paramOnBufferingUpdateListener == null) {
      paramOnBufferingUpdateListener = null;
    } else {
      paramOnBufferingUpdateListener = new MediaPlayerWrapper.3(this, paramOnBufferingUpdateListener);
    }
    localMediaPlayer.setOnBufferingUpdateListener(paramOnBufferingUpdateListener);
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnCompletionListener == null) {
      paramOnCompletionListener = null;
    } else {
      paramOnCompletionListener = new MediaPlayerWrapper.2(this, paramOnCompletionListener);
    }
    localMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void a(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnErrorListener == null) {
      paramOnErrorListener = null;
    } else {
      paramOnErrorListener = new MediaPlayerWrapper.6(this, paramOnErrorListener);
    }
    localMediaPlayer.setOnErrorListener(paramOnErrorListener);
  }
  
  public void a(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnInfoListener == null) {
      paramOnInfoListener = null;
    } else {
      paramOnInfoListener = new MediaPlayerWrapper.7(this, paramOnInfoListener);
    }
    localMediaPlayer.setOnInfoListener(paramOnInfoListener);
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnPreparedListener == null) {
      paramOnPreparedListener = null;
    } else {
      paramOnPreparedListener = new MediaPlayerWrapper.1(this, paramOnPreparedListener);
    }
    localMediaPlayer.setOnPreparedListener(paramOnPreparedListener);
  }
  
  public void a(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnSeekCompleteListener == null) {
      paramOnSeekCompleteListener = null;
    } else {
      paramOnSeekCompleteListener = new MediaPlayerWrapper.4(this, paramOnSeekCompleteListener);
    }
    localMediaPlayer.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void a(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (paramOnVideoSizeChangedListener == null) {
      paramOnVideoSizeChangedListener = null;
    } else {
      paramOnVideoSizeChangedListener = new MediaPlayerWrapper.5(this, paramOnVideoSizeChangedListener);
    }
    localMediaPlayer.setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setLooping(paramBoolean);
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
  
  public void c()
  {
    this.a.start();
  }
  
  public void c(int paramInt)
  {
    this.a.setAudioStreamType(paramInt);
  }
  
  public void d()
  {
    this.a.pause();
  }
  
  public boolean e()
  {
    return this.a.isPlaying();
  }
  
  public void f()
  {
    this.a.stop();
  }
  
  public void g()
  {
    this.a.release();
  }
  
  public void h()
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
  
  public int j()
  {
    return this.a.getDuration();
  }
  
  public int k()
  {
    return this.a.getCurrentPosition();
  }
  
  public int l()
  {
    return this.a.getVideoWidth();
  }
  
  public int m()
  {
    return this.a.getVideoHeight();
  }
  
  public int o()
  {
    return this.a.getAudioSessionId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.MediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */