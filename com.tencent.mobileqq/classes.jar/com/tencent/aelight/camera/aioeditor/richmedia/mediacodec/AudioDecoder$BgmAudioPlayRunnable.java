package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

class AudioDecoder$BgmAudioPlayRunnable
  implements Runnable
{
  long jdField_a_of_type_Long;
  MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  Timer jdField_a_of_type_JavaUtilTimer;
  TimerTask jdField_a_of_type_JavaUtilTimerTask;
  
  public AudioDecoder$BgmAudioPlayRunnable(AudioDecoder paramAudioDecoder)
  {
    if (paramAudioDecoder.a != null) {
      this.jdField_a_of_type_Long = paramAudioDecoder.a.c;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new AudioDecoder.BgmAudioPlayRunnable.1(this));
      return;
    }
    catch (IOException paramString)
    {
      QLog.e("AudioDecoder", 1, paramString, new Object[0]);
      return;
    }
    catch (FileNotFoundException paramString)
    {
      QLog.e("AudioDecoder", 1, paramString, new Object[0]);
    }
  }
  
  public void a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.pause();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      e();
    }
  }
  
  public void c()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.seekTo(0);
      e();
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      localObject = this.jdField_a_of_type_JavaUtilTimer;
      if (localObject != null)
      {
        ((Timer)localObject).cancel();
        this.jdField_a_of_type_JavaUtilTimer.purge();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (this.jdField_a_of_type_JavaUtilTimer == null) {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      if (this.this$0.a != null)
      {
        TimerTask localTimerTask = this.jdField_a_of_type_JavaUtilTimerTask;
        if (localTimerTask != null) {
          localTimerTask.cancel();
        }
        this.jdField_a_of_type_JavaUtilTimerTask = new AudioDecoder.BgmAudioPlayRunnable.2(this);
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.this$0.a.b)) {
      a(this.this$0.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder.BgmAudioPlayRunnable
 * JD-Core Version:    0.7.0.1
 */