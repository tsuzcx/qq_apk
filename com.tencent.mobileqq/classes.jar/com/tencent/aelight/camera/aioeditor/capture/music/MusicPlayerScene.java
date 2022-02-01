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
  protected int a;
  private long a;
  protected AudioPlayer a;
  protected MusicItemInfo a;
  protected List<MusicPlayerSceneListener> a;
  
  public MusicPlayerScene()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = new AudioPlayer(BaseApplicationImpl.getApplication(), this);
  }
  
  public int a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b();
    }
    return -1;
  }
  
  public void a()
  {
    int j = -1;
    try
    {
      this.jdField_a_of_type_Int = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      int i = j;
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
      {
        i = j;
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          a(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart + (int)this.jdField_a_of_type_Long);
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
    paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
      this.jdField_a_of_type_Int = paramMusicItemInfo.musicStart;
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
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(List<MusicPlayerSceneListener> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a();
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
  
  public void b()
  {
    String str2 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
      MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
      int j = -1;
      String str1 = str2;
      int i = j;
      if (localMusicItemInfo != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
        {
          str1 = str2;
          i = j;
          if (!this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a())
          {
            str1 = str2;
            i = j;
            if (this.jdField_a_of_type_Int != -1)
            {
              str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
              a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Int);
              i = this.jdField_a_of_type_Int;
            }
          }
        }
      }
      b(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
    paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).c(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void b(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void c()
  {
    int i = -1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a())
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b();
        i = this.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      c(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
    paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).d(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d()
  {
    int j = -1;
    try
    {
      this.jdField_a_of_type_Int = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      int i = j;
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
      {
        i = j;
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart < 0)
          {
            localStringBuilder.append(" musicStart=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
          }
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          d(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
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
    paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList;
    if (paramMusicItemInfo != null)
    {
      paramMusicItemInfo = paramMusicItemInfo.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).b(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
      this.jdField_a_of_type_Int = -1;
      String str = "";
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      }
      g();
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
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
      this.jdField_a_of_type_JavaUtilList = null;
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene destroy");
      }
      return;
    }
    finally {}
  }
  
  protected void g()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MusicPlayerSceneListener)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */