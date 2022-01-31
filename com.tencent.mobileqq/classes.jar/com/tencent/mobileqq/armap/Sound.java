package com.tencent.mobileqq.armap;

import abeq;
import aber;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sound
  implements MediaPlayer.OnPreparedListener, SoundPool.OnLoadCompleteListener
{
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public Sound()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
    this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
  }
  
  private void d()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aber localaber = (aber)((Map.Entry)localIterator.next()).getValue();
        if ((localaber != null) && (localaber.c()))
        {
          this.jdField_a_of_type_AndroidMediaSoundPool.pause(localaber.a);
          localaber.c = 2;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "stopSound exception", localException);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    try
    {
      if ((this.b) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aber localaber = (aber)((Map.Entry)localIterator.next()).getValue();
        if ((localaber != null) && (localaber.d()))
        {
          this.jdField_a_of_type_AndroidMediaSoundPool.resume(localaber.a);
          localaber.c = 3;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "resumeSound exception", localException);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 1);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, new aber(this, i, 1));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Sound", 2, "playSound resPath: " + paramString + ", isBackgroundMusic: " + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "playSound resPath is empty!");
      }
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.e("Sound", 2, "playSound exception", paramString);
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break;
      }
      d();
      paramString = (aber)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("Sound", 2, "playSound contains resPath, state: " + paramString.c);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (paramString.b()) {
        paramString.a = this.jdField_a_of_type_AndroidMediaSoundPool.play(paramString.b, 1.0F, 1.0F, 0, 0, 1.0F);
      }
      for (;;)
      {
        paramString.c = 3;
        return;
        if (paramString.c()) {
          paramString.a = this.jdField_a_of_type_AndroidMediaSoundPool.play(paramString.b, 1.0F, 1.0F, 0, 0, 1.0F);
        }
      }
    }
    paramString.c = 4;
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Sound", 2, "playSound not contains resPath, load");
    }
    int i = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString, 1);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, new aber(this, i, 3));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aber localaber = (aber)((Map.Entry)localIterator.next()).getValue();
        if ((localaber != null) && (localaber.c()))
        {
          this.jdField_a_of_type_AndroidMediaSoundPool.pause(localaber.a);
          localaber.c = 4;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "pauseSound exception", localException);
      }
    }
  }
  
  public void c()
  {
    ThreadManager.post(new abeq(this), 8, null, true);
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Sound", 2, "onLoadComplete sampleId:" + paramInt1 + ", status:" + paramInt2);
    }
    if (paramInt2 == 0) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localaber = (aber)((Map.Entry)localIterator.next()).getValue();
            if ((localaber != null) && (localaber.b == paramInt1))
            {
              if (localaber.a())
              {
                localaber.c = 2;
                return;
              }
              if (localaber.c()) {
                if (!this.jdField_a_of_type_Boolean)
                {
                  localaber.a = paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramSoundPool)
      {
        aber localaber;
        paramSoundPool.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("Sound", 2, "onLoadComplete exception", paramSoundPool);
          return;
          localaber.c = 4;
        }
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if ((!this.jdField_a_of_type_Boolean) && (paramMediaPlayer != null)) {
        paramMediaPlayer.start();
      }
      this.b = true;
      return;
    }
    catch (IllegalStateException paramMediaPlayer)
    {
      do
      {
        paramMediaPlayer.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("Sound", 2, "onPrepared exception", paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.Sound
 * JD-Core Version:    0.7.0.1
 */