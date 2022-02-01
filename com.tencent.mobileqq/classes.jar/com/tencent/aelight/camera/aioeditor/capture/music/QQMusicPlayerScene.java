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
  WeakReferenceHandler e = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Timer f = null;
  private TimerTask g = null;
  private boolean h = true;
  
  public void a()
  {
    String str = "";
    for (;;)
    {
      try
      {
        this.h = true;
        int i = -1;
        this.c = -1;
        StringBuilder localStringBuilder = new StringBuilder("startMusic");
        if ((this.a != null) && (this.b != null))
        {
          this.a.c(3);
          str = this.b.mMusicName;
          if (this.b.musicDuration < this.b.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=");
            localStringBuilder.append(str);
            localStringBuilder.append(" musicDuration=");
            localStringBuilder.append(this.b.musicDuration);
            localStringBuilder.append(" musicEnd=");
            localStringBuilder.append(this.b.musicEnd);
            this.b.musicStart = 0;
            this.b.musicEnd = this.b.musicDuration;
          }
          if (this.b.musicEnd <= this.b.musicStart)
          {
            localStringBuilder.append(" musicEnd <= musicStart don't play music musicName=");
            localStringBuilder.append(str);
            localStringBuilder.append(" musicEnd=");
            localStringBuilder.append(this.b.musicEnd);
            localStringBuilder.append(" musicStart=");
            localStringBuilder.append(this.b.musicStart);
            localStringBuilder.append("\n");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            a(-1, this.b);
            return;
          }
          i = this.b.musicStart;
          a(i, this.b);
          j = this.b.musicEnd - this.b.musicStart;
          a(this.b.getLocalPath(), this.b.musicStart, j);
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
    j();
    this.f = new Timer();
    this.g = new QQMusicPlayerScene.MyMusicTimerTask(this, null);
    this.f.schedule(this.g, paramInt);
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
        this.h = true;
        MusicItemInfo localMusicItemInfo = this.b;
        int j = -1;
        if ((localMusicItemInfo != null) && (this.a != null) && (!this.a.m()) && (this.c != -1))
        {
          str = this.b.mMusicName;
          if (this.c >= this.b.musicEnd)
          {
            localStringBuilder.append(" mCurrentPosition>=musicEnd reset musicName");
            localStringBuilder.append(str);
            localStringBuilder.append(" mCurrentPosition=");
            localStringBuilder.append(this.c);
            localStringBuilder.append(" musicEnd");
            localStringBuilder.append(this.b.musicEnd);
            this.c = this.b.musicStart;
          }
          i = this.b.musicEnd - this.c;
          if (i <= 0)
          {
            a(-1, this.b);
            localStringBuilder.append("resumeMusic music info musicEnd <= musicStart don't play music");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            return;
          }
          a(this.b.getLocalPath(), this.c, i);
          j = this.c;
          b(j, this.b);
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
      this.h = false;
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.a.m())
      {
        this.c = this.a.h();
        i = this.c;
      }
      if (this.b != null) {
        str = this.b.mMusicName;
      }
      this.a.d();
      j();
      c(i, this.b);
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
        this.c = -1;
        String str = "";
        this.h = true;
        StringBuilder localStringBuilder = new StringBuilder("replayMusic");
        if ((this.a != null) && (this.b != null))
        {
          str = this.b.mMusicName;
          this.a.c(3);
          if (this.b.musicDuration < this.b.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=");
            localStringBuilder.append(str);
            localStringBuilder.append(" musicDuration=");
            localStringBuilder.append(this.b.musicDuration);
            localStringBuilder.append(" musicEnd=");
            localStringBuilder.append(this.b.musicEnd);
            this.b.musicStart = 0;
            this.b.musicEnd = this.b.musicDuration;
          }
          if (this.b.musicEnd <= this.b.musicStart)
          {
            a(-1, this.b);
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, "replayMusic music info musicEnd <= musicStart don't play music");
            }
            return;
          }
          i = this.b.musicStart;
          j = this.b.musicEnd - this.b.musicStart;
          if (g()) {
            this.a.d();
          }
          d(i, this.b);
          a(this.b.getLocalPath(), this.b.musicStart, j);
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
      this.h = false;
      String str = "";
      j();
      if (this.b != null)
      {
        str = this.b.mMusicName;
        this.b = null;
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
      this.h = false;
      j();
      this.b = null;
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
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage MSG_MUSIC_REPLAY isNeedPlay=");
        paramMessage.append(this.h);
        QLog.d("QQMusicPlayerScene", 2, paramMessage.toString());
      }
      if (this.h) {
        d();
      } else {
        e();
      }
    }
    return false;
  }
  
  public void j()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.g = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "cancelMyMusicTimer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QQMusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */