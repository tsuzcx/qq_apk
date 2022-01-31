package com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import java.util.Map;
import nqt;
import nqu;
import nqv;
import nqw;
import nqx;
import nqy;
import nqz;

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
  
  public void a(Context paramContext, Uri paramUri, Map paramMap)
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public void a(Surface paramSurface)
  {
    this.a.setSurface(paramSurface);
  }
  
  public void a(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.a.setOnBufferingUpdateListener(new nqv(this, paramOnBufferingUpdateListener));
  }
  
  public void a(IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new nqu(this, paramOnCompletionListener));
  }
  
  public void a(IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.a.setOnErrorListener(new nqy(this, paramOnErrorListener));
  }
  
  public void a(IMediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.a.setOnInfoListener(new nqz(this, paramOnInfoListener));
  }
  
  public void a(IMediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.a.setOnPreparedListener(new nqt(this, paramOnPreparedListener));
  }
  
  public void a(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.a.setOnSeekCompleteListener(new nqw(this, paramOnSeekCompleteListener));
  }
  
  public void a(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.a.setOnVideoSizeChangedListener(new nqx(this, paramOnVideoSizeChangedListener));
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
    this.a.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.MediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */