package com.tencent.avgame.qav.audio.player;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

public class AVGameMusic
{
  private float jdField_a_of_type_Float;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
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
      localReportMediaPlayer.setVolume(this.jdField_a_of_type_Float, this.b);
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
    this.jdField_a_of_type_Float = 0.5F;
    this.b = 0.5F;
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = a(paramString);
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    else if (!((String)localObject).equals(paramString))
    {
      localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localObject != null) {
        ((MediaPlayer)localObject).release();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = a(paramString);
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    paramString = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (paramString == null)
    {
      QLog.e("AVGameMusic", 1, "[playBackgroundMusic] background media player is null");
      return;
    }
    paramString.stop();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_Boolean = false;
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
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (this.jdField_a_of_type_Boolean))
    {
      localMediaPlayer.start();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
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