package com.tencent.aelight.camera.aioeditor.musicwavesupport;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filter.music.MusicSoundFile;
import com.tencent.mobileqq.filter.music.MusicSoundFile.ProgressListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"NewApi"})
public class MusicWaveformManager
{
  private boolean a;
  private MusicSoundFile b;
  private MusicItemInfo c;
  private int d;
  private boolean e = false;
  private boolean f = false;
  private MusicSoundFile.ProgressListener g = new MusicWaveformManager.1(this);
  private Runnable h = new MusicWaveformManager.2(this);
  
  public static boolean a()
  {
    return ("Meizu".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT <= 22);
  }
  
  private void c()
  {
    this.b = new MusicSoundFile();
    this.a = true;
    ThreadManager.postImmediately(this.h, null, true);
  }
  
  public float a(int paramInt)
  {
    if ((this.e) && (this.f)) {
      return 0.5F;
    }
    if (this.e)
    {
      MusicSoundFile localMusicSoundFile = this.b;
      if ((localMusicSoundFile != null) && (localMusicSoundFile.a))
      {
        int i = this.d;
        if (paramInt >= i) {
          return this.b.a(paramInt - i);
        }
      }
    }
    return -1.0F;
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    if (paramMusicItemInfo == null)
    {
      b();
      return;
    }
    if (this.e)
    {
      if ((paramMusicItemInfo.equals(this.c)) && (this.d <= paramInt) && (paramMusicItemInfo.musicStart == this.c.musicStart) && (paramMusicItemInfo.musicEnd == this.c.musicEnd)) {
        return;
      }
      b();
    }
    this.e = true;
    this.c = paramMusicItemInfo.copy();
    this.b = null;
    this.d = paramInt;
    if (a())
    {
      this.f = true;
      if (QLog.isColorLevel()) {
        QLog.e("MusicWaveformManager", 2, "musicSoundFile create give up, is rubbish Meizu");
      }
    }
    else
    {
      c();
    }
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    this.a = false;
    if (this.b != null) {
      this.b = null;
    }
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.musicwavesupport.MusicWaveformManager
 * JD-Core Version:    0.7.0.1
 */