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
  MediaPlayer a = new MediaPlayer();
  private SoundPool b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private HashMap<String, Integer> i;
  private HashSet<Integer> j;
  private HashSet<Integer> k;
  private String l;
  private String m;
  
  public ARMusicController(int paramInt, String... paramVarArgs)
  {
    int n = 0;
    this.c = 0;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = false;
    try
    {
      this.h = true;
      this.i = new HashMap();
      this.j = new HashSet();
      this.k = new HashSet();
      this.b = new SoundPool(paramInt, 3, 0);
      this.b.setOnLoadCompleteListener(new ARMusicController.4(this));
      this.a = new MediaPlayer();
      this.a.setOnPreparedListener(new ARMusicController.5(this));
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int i1 = paramVarArgs.length;
        paramInt = n;
        while (paramInt < i1)
        {
          String str = paramVarArgs[paramInt];
          if (!TextUtils.isEmpty(str))
          {
            n = this.b.load(str, 1);
            this.i.put(str, Integer.valueOf(n));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("load file:");
              localStringBuilder.append(str);
              localStringBuilder.append(", id=");
              localStringBuilder.append(n);
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
    this.c = 0;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = false;
    try
    {
      this.l = paramString1;
      this.m = paramString2;
      this.b = new SoundPool(1, 3, 0);
      this.b.setOnLoadCompleteListener(new ARMusicController.1(this));
      this.a = new MediaPlayer();
      this.a.setOnPreparedListener(new ARMusicController.2(this));
      this.a.setOnErrorListener(new ARMusicController.3(this));
      this.c = this.b.load(paramString2, 1);
      try
      {
        this.a.setDataSource(paramString1);
        this.a.prepareAsync();
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
    int n;
    label168:
    do
    {
      for (;;)
      {
        try
        {
          if (!this.h) {
            return;
          }
          if (!this.i.containsKey(paramString)) {
            break label168;
          }
          n = ((Integer)this.i.get(paramString)).intValue();
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("playSound path=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", id=");
          localStringBuilder.append(n);
          QLog.d("ARMusicController", 2, localStringBuilder.toString());
        }
        catch (Exception paramString)
        {
          QLog.e("ARMusicController", 2, paramString, new Object[0]);
          return;
        }
        if (this.k.contains(Integer.valueOf(n)))
        {
          this.b.play(n, 1.0F, 1.0F, 1, 0, 1.0F);
          return;
        }
        if (paramBoolean)
        {
          this.j.add(Integer.valueOf(n));
          return;
        }
        this.j.remove(Integer.valueOf(n));
        return;
        n = -1;
      }
    } while (n != -1);
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
        if (this.a.isPlaying()) {
          this.a.stop();
        }
        this.l = paramString;
        this.a.reset();
        this.a.setDataSource(paramString);
        this.a.setLooping(paramBoolean1);
        this.a.prepareAsync();
        this.g = paramBoolean2;
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
      if (this.e) {
        this.a.start();
      } else {
        this.g = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playBgMusic : ");
        localStringBuilder.append(this.l);
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
      this.a.stop();
      this.e = false;
      this.a.prepareAsync();
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
      this.a.release();
      this.b.release();
      this.i = null;
      this.j = null;
      this.k = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController
 * JD-Core Version:    0.7.0.1
 */