package com.tencent.mobileqq.apollo.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloMusicPlayer
{
  protected AudioManager a;
  protected MediaPlayer a;
  protected final Object a;
  protected List<MediaPlayer> a;
  protected AtomicBoolean a;
  
  public ApolloMusicPlayer()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMusicPlayer", 2, "[stopMusic]");
    }
    a(false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        while (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)this.jdField_a_of_type_JavaUtilList.get(0);
          try
          {
            localMediaPlayer.stop();
          }
          catch (IllegalStateException localIllegalStateException)
          {
            QLog.e("[cmshow]ApolloMusicPlayer", 1, "[stopMusic] failed, ", localIllegalStateException);
          }
          localMediaPlayer.release();
          this.jdField_a_of_type_JavaUtilList.remove(localMediaPlayer);
        }
      }
      ??? = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (??? != null)
      {
        ((MediaPlayer)???).stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, float paramFloat)
  {
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 2147483647;
    }
    if (!URLUtil.isNetworkUrl(paramString))
    {
      paramString = CMGetResPathUtil.a(paramString, "mp3");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          paramString = paramString.getPath();
          break label61;
        }
      }
      paramString = null;
    }
    label61:
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("[cmshow]ApolloMusicPlayer", 1, "[playMusic] music file not exist");
      return;
    }
    if (paramInt1 == 0)
    {
      b(paramString, i, paramInt3, paramFloat);
      return;
    }
    a(paramString, i, paramInt3, paramFloat);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    for (;;)
    {
      try
      {
        MediaPlayer localMediaPlayer = new MediaPlayer();
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.add(localMediaPlayer);
          a(true);
          localMediaPlayer.setDataSource(paramString);
          if (paramInt1 == 2147483647)
          {
            bool = true;
            localMediaPlayer.setLooping(bool);
            if (paramInt1 != 2147483647)
            {
              localMediaPlayer.setOnCompletionListener(new ApolloMusicPlayer.1(this, paramInt1));
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("[playSpecialEffectMusic] create player, audio_sessionID: ");
                paramString.append(localMediaPlayer.getAudioSessionId());
                QLog.d("[cmshow]ApolloMusicPlayer", 2, paramString.toString());
              }
            }
            localMediaPlayer.prepare();
            localMediaPlayer.start();
            if (-1 != paramInt2) {
              localMediaPlayer.seekTo(paramInt2);
            }
            if (-1.0F != paramFloat) {
              localMediaPlayer.setVolume(paramFloat, paramFloat);
            }
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloMusicPlayer", 1, "[playSpecialEffectMusic] error, ", paramString);
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
    } else {
      i = this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMusicPlayer", 2, new Object[] { "[execAudioFocus] requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        a(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        paramString = this.jdField_a_of_type_AndroidMediaMediaPlayer;
        if (paramInt1 != 2147483647) {
          break label126;
        }
        bool = true;
        paramString.setLooping(bool);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        if (-1 != paramInt2) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt2);
        }
        if (-1.0F != paramFloat)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(paramFloat, paramFloat);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloMusicPlayer", 1, "[playBackgroundMusic] error, ", paramString);
      }
      return;
      label126:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.audio.ApolloMusicPlayer
 * JD-Core Version:    0.7.0.1
 */