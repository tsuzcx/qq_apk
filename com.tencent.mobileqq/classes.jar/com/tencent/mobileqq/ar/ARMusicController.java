package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class ARMusicController
{
  private int jdField_a_of_type_Int;
  MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<Integer> jdField_b_of_type_JavaUtilHashSet;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public ARMusicController(int paramInt, String... paramVarArgs)
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    try
    {
      this.e = true;
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(paramInt, 3, 0);
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new ARMusicController.4(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new ARMusicController.5(this));
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
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("load file:");
              localStringBuilder.append(str);
              localStringBuilder.append(", id=");
              localStringBuilder.append(i);
              QLog.d("ARMusicController", 2, localStringBuilder.toString());
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
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, 3, 0);
      this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new ARMusicController.1(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new ARMusicController.2(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new ARMusicController.3(this));
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
    label168:
    do
    {
      for (;;)
      {
        try
        {
          if (!this.e) {
            return;
          }
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
            break label168;
          }
          i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("playSound path=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", id=");
          localStringBuilder.append(i);
          QLog.d("ARMusicController", 2, localStringBuilder.toString());
        }
        catch (Exception paramString)
        {
          QLog.e("ARMusicController", 2, paramString, new Object[0]);
          return;
        }
        if (this.jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(i)))
        {
          this.jdField_a_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 1, 0, 1.0F);
          return;
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(i));
          return;
        }
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(i));
        return;
        i = -1;
      }
    } while (i != -1);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (!new File(paramString).exists())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("playBgMusic file not exist");
          localStringBuilder.append(paramString);
          QLog.d("ARMusicController", 2, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playBgMusic exception");
      localStringBuilder.append(paramString.getMessage());
      QLog.d("ARMusicController", 1, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      } else {
        this.d = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playBgMusic : ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("ARMusicController", 2, localStringBuilder.toString());
        return;
      }
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
      if (QLog.isColorLevel())
      {
        QLog.d("ARMusicController", 2, "stopAllMusic");
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController
 * JD-Core Version:    0.7.0.1
 */