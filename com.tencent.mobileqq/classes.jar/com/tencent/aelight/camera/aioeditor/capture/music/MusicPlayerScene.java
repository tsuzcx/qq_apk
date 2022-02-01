package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.biz.videostory.widget.easylyric.VideoPlayStatusDispatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MusicPlayerScene
  implements AudioPlayerBase.AudioPlayerListener
{
  protected AudioPlayer a = new AudioPlayer(BaseApplicationImpl.getApplication(), this);
  protected MusicItemInfo b;
  protected int c = -1;
  protected List<MusicPlayerSceneListener> d;
  private long e = 0L;
  
  public void a()
  {
    int j = -1;
    try
    {
      this.c = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      int i = j;
      String str1 = str2;
      if (this.a != null)
      {
        i = j;
        str1 = str2;
        if (this.b != null)
        {
          str1 = this.b.mMusicName;
          this.a.c(3);
          if (this.b.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=");
            localStringBuilder.append(this.b.musicStart);
            this.b.musicStart = 0;
          }
          i = this.b.musicStart;
          a(i, this.b);
          a(this.b.getLocalPath(), this.b.musicStart + (int)this.e);
        }
      }
      localStringBuilder.append(" musicName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" position=");
      localStringBuilder.append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = this.d;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).a(paramInt, this.b);
      }
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    b(this.b);
    d();
    if (QLog.isColorLevel()) {
      QLog.d("MusicPlayerScene", 2, "MusicPlayerScene onCompletion");
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    try
    {
      this.b = paramMusicItemInfo;
      this.c = paramMusicItemInfo.musicStart;
      return;
    }
    finally
    {
      paramMusicItemInfo = finally;
      throw paramMusicItemInfo;
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    ThreadManager.postImmediately(new MusicPlayerScene.1(this, paramString, paramInt), null, true);
    this.e = 0L;
  }
  
  public void a(List<MusicPlayerSceneListener> paramList)
  {
    this.d = paramList;
  }
  
  public void b()
  {
    String str2 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
      MusicItemInfo localMusicItemInfo = this.b;
      int j = -1;
      String str1 = str2;
      int i = j;
      if (localMusicItemInfo != null)
      {
        str1 = str2;
        i = j;
        if (this.a != null)
        {
          str1 = str2;
          i = j;
          if (!this.a.m())
          {
            str1 = str2;
            i = j;
            if (this.c != -1)
            {
              str1 = this.b.mMusicName;
              a(this.b.getLocalPath(), this.c);
              i = this.c;
            }
          }
        }
      }
      b(i, this.b);
      localStringBuilder.append(" musicName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" position=");
      localStringBuilder.append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = this.d;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).c(paramInt, this.b);
      }
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void b(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = this.d;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).b(this.b);
      }
    }
  }
  
  public void c()
  {
    int i = -1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.a.m())
      {
        this.c = this.a.h();
        i = this.c;
      }
      this.a.d();
      c(i, this.b);
      localStringBuilder.append(" musicName=");
      localStringBuilder.append("");
      localStringBuilder.append(" position=");
      localStringBuilder.append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void c(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = this.d;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).d(paramInt, this.b);
      }
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d()
  {
    int j = -1;
    try
    {
      this.c = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      int i = j;
      String str1 = str2;
      if (this.a != null)
      {
        i = j;
        str1 = str2;
        if (this.b != null)
        {
          str1 = this.b.mMusicName;
          this.a.c(3);
          if (this.b.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=");
            localStringBuilder.append(this.b.musicStart);
            this.b.musicStart = 0;
          }
          if (g()) {
            this.a.d();
          }
          i = this.b.musicStart;
          d(i, this.b);
          a(this.b.getLocalPath(), this.b.musicStart);
        }
      }
      localStringBuilder.append(" musicName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" position=");
      localStringBuilder.append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void d(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = this.d;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).b(paramInt, this.b);
      }
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    VideoPlayStatusDispatcher.a().a(paramInt);
  }
  
  public void e()
  {
    try
    {
      this.c = -1;
      String str = "";
      if (this.a != null) {
        this.a.d();
      }
      if (this.b != null)
      {
        str = this.b.mMusicName;
        this.b = null;
      }
      i();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MusicPlayerScene stopMusic musicName=");
        localStringBuilder.append(str);
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      this.c = -1;
      this.b = null;
      if (this.a != null) {
        this.a.d();
      }
      this.a = null;
      this.d = null;
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene destroy");
      }
      return;
    }
    finally {}
  }
  
  public boolean g()
  {
    try
    {
      if (this.a != null)
      {
        boolean bool = this.a.m();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public int h()
  {
    if (g()) {
      return this.a.h();
    }
    return -1;
  }
  
  protected void i()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MusicPlayerSceneListener)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */