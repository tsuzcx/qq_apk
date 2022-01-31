package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import zuh;
import zui;
import zuj;
import zuk;
import zul;

public class ARMusicController
{
  private int jdField_a_of_type_Int;
  public MediaPlayer a;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private HashSet jdField_b_of_type_JavaUtilHashSet;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public ARMusicController(int paramInt, String... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.e = true;
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(paramInt, 3, 0);
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new zuk(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new zul(this));
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        paramInt = i;
        while (paramInt < j)
        {
          String str = paramVarArgs[paramInt];
          if (!TextUtils.isEmpty(str))
          {
            i = this.jdField_a_of_type_AndroidMediaSoundPool.load(str, 1);
            this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(i));
            if (QLog.isColorLevel()) {
              QLog.d("ARMusicController", 2, "load file:" + str + ", id=" + i);
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  public ARMusicController(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, 3, 0);
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new zuh(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new zui(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new zuj(this));
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.load(paramString2, 1);
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString1);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i;
    for (;;)
    {
      try
      {
        if (!this.e) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("ARMusicController", 2, "playSound path=" + paramString + ", id=" + i);
          }
          if (i == -1) {
            return;
          }
          if (!this.jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(i))) {
            break;
          }
          this.jdField_a_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 1, 0, 1.0F);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ARMusicController", 2, paramString, new Object[0]);
        return;
      }
      i = -1;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(i));
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (!new File(paramString).exists())
        {
          QLog.d("ARMusicController", 2, "playBgMusic file not exist" + paramString);
          return;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean1);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        this.d = paramBoolean2;
        return;
      }
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("ARMusicController", 2, "playBgMusic exception", paramString);
        return;
      }
      QLog.d("ARMusicController", 1, "playBgMusic exception" + paramString.getMessage());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ARMusicController", 2, "playBgMusic : " + this.jdField_a_of_type_JavaLangString);
        return;
        this.d = true;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "stopAllMusic");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_JavaUtilHashMap = null;
      this.jdField_a_of_type_JavaUtilHashSet = null;
      this.jdField_b_of_type_JavaUtilHashSet = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController
 * JD-Core Version:    0.7.0.1
 */