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
  MediaPlayer a;
  Timer b;
  long c;
  TimerTask d;
  
  public AudioDecoder$BgmAudioPlayRunnable(AudioDecoder paramAudioDecoder)
  {
    if (paramAudioDecoder.a != null) {
      this.c = paramAudioDecoder.a.h;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.a = new MediaPlayer();
      this.a.setDataSource(paramString);
      this.a.setAudioStreamType(3);
      this.a.prepareAsync();
      this.a.setOnPreparedListener(new AudioDecoder.BgmAudioPlayRunnable.1(this));
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
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null) {
      localMediaPlayer.pause();
    }
  }
  
  public void b()
  {
    if (this.a != null) {
      e();
    }
  }
  
  public void c()
  {
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.seekTo(0);
      e();
    }
  }
  
  public void d()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).stop();
      this.a.release();
      this.a = null;
      localObject = this.b;
      if (localObject != null)
      {
        ((Timer)localObject).cancel();
        this.b.purge();
        this.b = null;
      }
    }
  }
  
  public void e()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        this.b = new Timer();
      }
      this.a.start();
      if (this.this$0.a != null)
      {
        TimerTask localTimerTask = this.d;
        if (localTimerTask != null) {
          localTimerTask.cancel();
        }
        this.d = new AudioDecoder.BgmAudioPlayRunnable.2(this);
        this.b.schedule(this.d, this.c);
      }
    }
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.this$0.a.i)) {
      a(this.this$0.a.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder.BgmAudioPlayRunnable
 * JD-Core Version:    0.7.0.1
 */