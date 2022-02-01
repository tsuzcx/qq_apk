package com.tencent.avgame.qav.audio.player;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

public class AVGameMusic
{
  private float a;
  private float b;
  private MediaPlayer c;
  private boolean d;
  private String e;
  
  public AVGameMusic()
  {
    e();
  }
  
  private MediaPlayer a(String paramString)
  {
    ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
    try
    {
      localReportMediaPlayer.setDataSource(paramString);
      localReportMediaPlayer.prepare();
      localReportMediaPlayer.setVolume(this.a, this.b);
      return localReportMediaPlayer;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" error: ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("AVGameMusic", 1, new Object[] { "[createMediaPlayerFromAssets]", localStringBuilder.toString(), paramString });
    }
    return localReportMediaPlayer;
  }
  
  private void e()
  {
    this.a = 0.5F;
    this.b = 0.5F;
    this.c = null;
    this.d = false;
    this.e = null;
  }
  
  public void a()
  {
    MediaPlayer localMediaPlayer = this.c;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.d = false;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      this.c = a(paramString);
      this.e = paramString;
    }
    else if (!((String)localObject).equals(paramString))
    {
      localObject = this.c;
      if (localObject != null) {
        ((MediaPlayer)localObject).release();
      }
      this.c = a(paramString);
      this.e = paramString;
    }
    paramString = this.c;
    if (paramString == null)
    {
      QLog.e("AVGameMusic", 1, "[playBackgroundMusic] background media player is null");
      return;
    }
    paramString.stop();
    this.c.setLooping(paramBoolean);
    try
    {
      this.c.prepare();
      this.c.seekTo(0);
      this.c.start();
      this.d = false;
      return;
    }
    catch (Exception paramString)
    {
      label119:
      break label119;
    }
    QLog.e("AVGameMusic", 1, "[playBackgroundMusic] error state");
  }
  
  public void b()
  {
    MediaPlayer localMediaPlayer = this.c;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying()))
    {
      this.c.pause();
      this.d = true;
    }
  }
  
  public void c()
  {
    MediaPlayer localMediaPlayer = this.c;
    if ((localMediaPlayer != null) && (this.d))
    {
      localMediaPlayer.start();
      this.d = false;
    }
  }
  
  public void d()
  {
    MediaPlayer localMediaPlayer = this.c;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVGameMusic
 * JD-Core Version:    0.7.0.1
 */