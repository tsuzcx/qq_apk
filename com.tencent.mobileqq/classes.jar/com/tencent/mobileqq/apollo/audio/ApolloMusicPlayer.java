package com.tencent.mobileqq.apollo.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloMusicPlayer
{
  protected final Object a = new Object();
  protected List<MediaPlayer> b = Collections.synchronizedList(new ArrayList());
  protected MediaPlayer c;
  protected AudioManager d = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
  protected AtomicBoolean e = new AtomicBoolean(false);
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMusicPlayer", 2, "[stopMusic]");
    }
    a(false);
    synchronized (this.a)
    {
      if (this.b != null) {
        while (this.b.size() > 0)
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)this.b.get(0);
          try
          {
            localMediaPlayer.stop();
          }
          catch (IllegalStateException localIllegalStateException)
          {
            QLog.e("[cmshow]ApolloMusicPlayer", 1, "[stopMusic] failed, ", localIllegalStateException);
          }
          localMediaPlayer.release();
          this.b.remove(localMediaPlayer);
        }
      }
      ??? = this.c;
      if (??? != null)
      {
        ((MediaPlayer)???).stop();
        this.c.release();
        this.c = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, float paramFloat, IApolloResManager paramIApolloResManager)
  {
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 2147483647;
    }
    if (!URLUtil.isNetworkUrl(paramString))
    {
      paramString = paramIApolloResManager.a(paramString, "mp3");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          paramString = paramString.getPath();
          break label65;
        }
      }
      paramString = null;
    }
    label65:
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
        synchronized (this.a)
        {
          this.b.add(localMediaPlayer);
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
      i = this.d.requestAudioFocus(null, 3, 2);
    } else {
      i = this.d.abandonAudioFocus(null);
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
        if (this.c == null) {
          this.c = new MediaPlayer();
        }
        this.c.stop();
        this.c.reset();
        a(true);
        this.c.setDataSource(paramString);
        paramString = this.c;
        if (paramInt1 != 2147483647) {
          break label126;
        }
        bool = true;
        paramString.setLooping(bool);
        this.c.prepare();
        this.c.start();
        if (-1 != paramInt2) {
          this.c.seekTo(paramInt2);
        }
        if (-1.0F != paramFloat)
        {
          this.c.setVolume(paramFloat, paramFloat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.audio.ApolloMusicPlayer
 * JD-Core Version:    0.7.0.1
 */