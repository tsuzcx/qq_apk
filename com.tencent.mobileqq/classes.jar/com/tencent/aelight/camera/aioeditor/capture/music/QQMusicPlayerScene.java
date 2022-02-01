package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Timer;
import java.util.TimerTask;

public class QQMusicPlayerScene
  extends MusicPlayerScene
  implements Handler.Callback
{
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  private boolean jdField_a_of_type_Boolean = true;
  
  public void a()
  {
    String str = "";
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        int i = -1;
        this.jdField_a_of_type_Int = -1;
        StringBuilder localStringBuilder = new StringBuilder("startMusic");
        if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c(3);
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=");
            localStringBuilder.append(str);
            localStringBuilder.append(" musicDuration=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
            localStringBuilder.append(" musicEnd=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd <= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart)
          {
            localStringBuilder.append(" musicEnd <= musicStart don't play music musicName=");
            localStringBuilder.append(str);
            localStringBuilder.append(" musicEnd=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            localStringBuilder.append(" musicStart=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
            localStringBuilder.append("\n");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            return;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          a(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, j);
          localStringBuilder.append(" musicName=");
          localStringBuilder.append(str);
          localStringBuilder.append(" position=");
          localStringBuilder.append(i);
          localStringBuilder.append(" timer=");
          localStringBuilder.append(j);
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          }
          return;
        }
      }
      finally {}
      int j = -1;
    }
  }
  
  public void a(int paramInt)
  {
    h();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new QQMusicPlayerScene.MyMusicTimerTask(this, null);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "setMyMusicTimer");
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.postImmediately(new QQMusicPlayerScene.1(this, paramString, paramInt1, paramInt2), null, true);
  }
  
  public void b()
  {
    String str = "";
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
        this.jdField_a_of_type_Boolean = true;
        MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        int j = -1;
        if ((localMusicItemInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) && (!this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a()) && (this.jdField_a_of_type_Int != -1))
        {
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
          {
            localStringBuilder.append(" mCurrentPosition>=musicEnd reset musicName");
            localStringBuilder.append(str);
            localStringBuilder.append(" mCurrentPosition=");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            localStringBuilder.append(" musicEnd");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd - this.jdField_a_of_type_Int;
          if (i <= 0)
          {
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            localStringBuilder.append("resumeMusic music info musicEnd <= musicStart don't play music");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            return;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Int, i);
          j = this.jdField_a_of_type_Int;
          b(j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          localStringBuilder.append(" musicName=");
          localStringBuilder.append(str);
          localStringBuilder.append(" position=");
          localStringBuilder.append(j);
          localStringBuilder.append(" timer=");
          localStringBuilder.append(i);
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          }
          return;
        }
      }
      finally {}
      int i = -1;
    }
  }
  
  public void c()
  {
    int i = -1;
    String str = "";
    try
    {
      this.jdField_a_of_type_Boolean = false;
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a())
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b();
        i = this.jdField_a_of_type_Int;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      h();
      c(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      localStringBuilder.append(" musicName=");
      localStringBuilder.append(str);
      localStringBuilder.append(" position=");
      localStringBuilder.append(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    int i = -1;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = -1;
        String str = "";
        this.jdField_a_of_type_Boolean = true;
        StringBuilder localStringBuilder = new StringBuilder("replayMusic");
        if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null))
        {
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=");
            localStringBuilder.append(str);
            localStringBuilder.append(" musicDuration=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
            localStringBuilder.append(" musicEnd=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd <= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart)
          {
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, "replayMusic music info musicEnd <= musicStart don't play music");
            }
            return;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
          }
          d(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, j);
          localStringBuilder.append(" musicName=");
          localStringBuilder.append(str);
          localStringBuilder.append(" position=");
          localStringBuilder.append(i);
          localStringBuilder.append(" timer=");
          localStringBuilder.append(j);
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          }
          return;
        }
      }
      finally {}
      int j = -1;
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      String str = "";
      h();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      }
      super.e();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQMusicPlayerScene stopMusic musicName=");
        localStringBuilder.append(str);
        QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      h();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      super.f();
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene destroy");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilTimerTask;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimerTask = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "cancelMyMusicTimer");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage MSG_MUSIC_REPLAY isNeedPlay=");
        paramMessage.append(this.jdField_a_of_type_Boolean);
        QLog.d("QQMusicPlayerScene", 2, paramMessage.toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        d();
      } else {
        e();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QQMusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */