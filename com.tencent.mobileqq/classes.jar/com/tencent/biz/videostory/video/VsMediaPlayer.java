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
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private volatile MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private VsMediaPlayer.VsMediaPlayerListener jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private long c;
  private long d;
  
  public VsMediaPlayer()
  {
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    float f = this.jdField_a_of_type_Float;
    localMediaPlayer.setVolume(f, f);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.musicStart);
      g();
    }
  }
  
  private void g()
  {
    h();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VsMediaPlayer.1(this), 0L, 1000L);
  }
  
  private void h()
  {
    this.jdField_b_of_type_Int = 0;
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  public VsMusicItemInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
      {
        if (this.jdField_a_of_type_Int == -1) {
          f();
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        g();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(VsMediaPlayer.VsMediaPlayerListener paramVsMediaPlayerListener)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener = paramVsMediaPlayerListener;
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("ret_code", Integer.valueOf(0));
      ((HashMap)localObject).put("time_cost", Long.valueOf(this.c));
      ((HashMap)localObject).put("total_play_time", Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long));
      ((HashMap)localObject).put("video_duration", Long.valueOf(this.d));
      ((HashMap)localObject).put("music_source", Integer.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.jdField_a_of_type_Int));
      ((HashMap)localObject).put("file_size", Long.valueOf(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.fileSize));
      ((HashMap)localObject).put("element_id", this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid);
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
        paramVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener;
        if (paramVsMusicItemInfo != null) {
          paramVsMusicItemInfo.a(this.jdField_a_of_type_AndroidMediaMediaPlayer, -1, -1);
        }
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
      b();
      try
      {
        e();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(BaseApplicationImpl.getContext(), (Uri)localObject);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        return;
      }
      catch (IOException paramVsMusicItemInfo)
      {
        paramVsMusicItemInfo.printStackTrace();
        return;
      }
    }
    paramVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener;
    if (paramVsMusicItemInfo != null) {
      paramVsMusicItemInfo.a(this.jdField_a_of_type_AndroidMediaMediaPlayer, -2, -1);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      c();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    h();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VsMediaPlayer.VsMediaPlayerListener localVsMediaPlayerListener = this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener;
    if ((localVsMediaPlayerListener != null) && (paramInt1 != -38)) {
      localVsMediaPlayerListener.a(paramMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null)
    {
      VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
      if (localVsMusicItemInfo != null) {
        paramMediaPlayer.seekTo(localVsMusicItemInfo.musicStart);
      }
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener != null) && (!paramMediaPlayer.isPlaying()))
    {
      this.c = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizVideostoryVideoVsMediaPlayer$VsMediaPlayerListener.a(paramMediaPlayer, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */