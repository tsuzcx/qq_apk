package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;

public class VsMediaPlayer
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener
{
  private volatile MediaPlayer a;
  private VsMediaPlayer.VsMediaPlayerListener b;
  private Timer c;
  private VsMusicItemInfo d;
  private int e = -1;
  private int f;
  private long g;
  private long h;
  private long i;
  private long j;
  private float k = 1.0F;
  
  public VsMediaPlayer()
  {
    f();
  }
  
  private void f()
  {
    this.a = new ReportMediaPlayer();
    this.a.setAudioStreamType(3);
    MediaPlayer localMediaPlayer = this.a;
    float f1 = this.k;
    localMediaPlayer.setVolume(f1, f1);
    this.a.setOnPreparedListener(this);
    this.a.setOnSeekCompleteListener(this);
    this.a.setOnErrorListener(this);
  }
  
  private void g()
  {
    if (this.d != null)
    {
      this.a.seekTo(this.d.musicStart);
      h();
    }
  }
  
  private void h()
  {
    i();
    this.c = new Timer();
    this.c.schedule(new VsMediaPlayer.1(this), 0L, 1000L);
  }
  
  private void i()
  {
    this.f = 0;
    Timer localTimer = this.c;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      if (this.a.isPlaying())
      {
        if (this.e == -1) {
          g();
        }
      }
      else
      {
        this.a.start();
        h();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(VsMediaPlayer.VsMediaPlayerListener paramVsMediaPlayerListener)
  {
    this.b = paramVsMediaPlayerListener;
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo)
  {
    Object localObject;
    if (this.d != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("ret_code", Integer.valueOf(0));
      ((HashMap)localObject).put("time_cost", Long.valueOf(this.i));
      ((HashMap)localObject).put("total_play_time", Long.valueOf(System.currentTimeMillis() - this.h));
      ((HashMap)localObject).put("video_duration", Long.valueOf(this.j));
      ((HashMap)localObject).put("music_source", Integer.valueOf(this.d.c));
      ((HashMap)localObject).put("file_size", Long.valueOf(this.d.fileSize));
      ((HashMap)localObject).put("element_id", this.d.mSongMid);
      VSReporter.a("edit_smart_music_play", VSReporter.a((HashMap)localObject));
    }
    if (paramVsMusicItemInfo == null) {
      return;
    }
    if ((paramVsMusicItemInfo.mUrl != null) && (paramVsMusicItemInfo.mUrl.trim().length() != 0))
    {
      localObject = Uri.parse(paramVsMusicItemInfo.mUrl);
      if (localObject == null)
      {
        paramVsMusicItemInfo = this.b;
        if (paramVsMusicItemInfo != null) {
          paramVsMusicItemInfo.a(this.a, -1, -1);
        }
        return;
      }
      this.g = System.currentTimeMillis();
      this.d = paramVsMusicItemInfo;
      b();
      try
      {
        f();
        this.a.setDataSource(BaseApplicationImpl.getContext(), (Uri)localObject);
        this.a.prepareAsync();
        return;
      }
      catch (IOException paramVsMusicItemInfo)
      {
        paramVsMusicItemInfo.printStackTrace();
        return;
      }
    }
    paramVsMusicItemInfo = this.b;
    if (paramVsMusicItemInfo != null) {
      paramVsMusicItemInfo.a(this.a, -2, -1);
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      c();
      this.a.release();
      this.a = null;
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.stop();
    }
    i();
  }
  
  public VsMusicItemInfo d()
  {
    return this.d;
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.pause();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VsMediaPlayer.VsMediaPlayerListener localVsMediaPlayerListener = this.b;
    if ((localVsMediaPlayerListener != null) && (paramInt1 != -38)) {
      localVsMediaPlayerListener.a(paramMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null)
    {
      VsMusicItemInfo localVsMusicItemInfo = this.d;
      if (localVsMusicItemInfo != null) {
        paramMediaPlayer.seekTo(localVsMusicItemInfo.musicStart);
      }
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (this.b != null) && (!paramMediaPlayer.isPlaying()))
    {
      this.i = (System.currentTimeMillis() - this.g);
      this.h = System.currentTimeMillis();
      this.b.a(paramMediaPlayer, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */