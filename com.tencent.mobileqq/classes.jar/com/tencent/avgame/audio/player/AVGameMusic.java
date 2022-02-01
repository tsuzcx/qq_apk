package com.tencent.avgame.audio.player;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;

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
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      localMediaPlayer.setVolume(this.jdField_a_of_type_Float, this.b);
      return localMediaPlayer;
    }
    catch (Exception paramString)
    {
      QLog.e("AVGameMusic", 1, new Object[] { "[createMediaPlayerFromAssets]", " error: " + paramString.getMessage(), paramString });
    }
    return localMediaPlayer;
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
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = a(paramString);
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null)
    {
      QLog.e("AVGameMusic", 1, "[playBackgroundMusic] background media player is null");
      return;
      if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer = a(paramString);
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
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
      QLog.e("AVGameMusic", 1, "[playBackgroundMusic] error state");
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.player.AVGameMusic
 * JD-Core Version:    0.7.0.1
 */