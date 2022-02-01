package com.tencent.mobileqq.ark.api.silk;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class SilkAudioPlayer
{
  private VoicePlayer a;
  private final AudioManager b;
  private final SilkAudioPlayer.SilkAudioPlayerListener c;
  private final Object d = new Object();
  private volatile boolean e = false;
  private final AudioManager.OnAudioFocusChangeListener f = new SilkAudioPlayer.1(this);
  
  public SilkAudioPlayer(@NonNull SilkAudioPlayer.SilkAudioPlayerListener paramSilkAudioPlayerListener)
  {
    if (paramSilkAudioPlayerListener != null)
    {
      this.c = paramSilkAudioPlayerListener;
      this.b = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      return;
    }
    throw new NullPointerException("SilkAudioPlayer's listener is null");
  }
  
  private int b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return -1;
    }
    if (this.e)
    {
      this.c.f();
      return 0;
    }
    return d(paramString);
  }
  
  private String c(String paramString)
  {
    String str;
    try
    {
      if (!FileUtil.d(paramString))
      {
        str = TransFileUtil.getTransferFilePath(BaseApplicationImpl.sApplication.getRuntime().getCurrentAccountUin(), MD5.toMD5(paramString), 23, null);
        File localFile = new File(str);
        if (localFile.exists()) {
          if (localFile.length() > 0L) {
            return str;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("SilkAudioPlayer", 2, String.format("playLocal file not exist : %s", new Object[] { paramString }));
        }
        return null;
      }
      else
      {
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("SilkAudioPlayer", 1, "playLocal check resource file error ", paramString);
      return null;
    }
    return str;
  }
  
  private int d(String paramString)
  {
    try
    {
      synchronized (this.d)
      {
        if (this.a != null)
        {
          this.a.f();
          this.a = null;
        }
        this.a = new VoicePlayer(paramString, new Handler(ThreadManager.getSubThreadLooper()), 1);
        this.a.a(this.c);
        this.a.c();
        if (this.b != null) {
          this.b.requestAudioFocus(this.f, 3, 2);
        }
        this.c.e();
        return 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      this.c.f();
      QLog.e("SilkAudioPlayer", 1, "playLocal play audio error ", paramString);
    }
  }
  
  public void a()
  {
    try
    {
      this.e = true;
      synchronized (this.d)
      {
        if (this.a != null)
        {
          this.a.f();
          this.a = null;
        }
        if (this.b != null) {
          this.b.abandonAudioFocus(this.f);
        }
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop e=");
      localStringBuilder.append(localException);
      QLog.e("SilkAudioPlayer", 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.e = false;
    this.c.c();
    if (b(paramString) != -1) {
      return;
    }
    ThreadManager.excute(new SilkAudioPlayer.2(this, paramString), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer
 * JD-Core Version:    0.7.0.1
 */