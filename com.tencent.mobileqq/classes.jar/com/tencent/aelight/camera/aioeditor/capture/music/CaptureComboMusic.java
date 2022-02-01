package com.tencent.aelight.camera.aioeditor.capture.music;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class CaptureComboMusic
  extends CaptureComboBase
{
  public MusicItemInfo f;
  int g;
  MusicDownloadListener h = new CaptureComboMusic.1(this);
  
  public CaptureComboMusic(int paramInt)
  {
    super(null);
    this.g = paramInt;
    this.f = ((QIMMusicConfigManager)QIMManager.a(2)).b(paramInt);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyMusic");
      localStringBuilder.append(this.f);
      QLog.i("QCombo.Music", 2, localStringBuilder.toString());
    }
    if (this.f == null) {
      return 0;
    }
    ((MusicProviderView)paramActivity.findViewById(2131430313)).a(this.f);
    return 0;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    if (this.f == null) {
      return;
    }
    if ((paramInt != 1) && (paramInt != 3)) {
      ((QimMusicPlayer)QIMManager.a().d(8)).a(paramInt);
    }
  }
  
  public int c()
  {
    boolean bool;
    label67:
    try
    {
      MusicItemInfo localMusicItemInfo = this.f;
      if (localMusicItemInfo == null) {
        return 3;
      }
      if (this.f.mProgress > -1)
      {
        int i = this.f.mProgress;
        if (i == 100) {
          return 3;
        }
        return 1;
      }
    }
    finally {}
    try
    {
      bool = FileUtils.fileExists(this.f.getLocalPath());
      if (bool) {
        return 3;
      }
    }
    catch (Exception localException)
    {
      break label67;
    }
    return 2;
  }
  
  public int d()
  {
    try
    {
      StringBuilder localStringBuilder;
      if (this.f == null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download STATE_DOWNLOADED");
          localStringBuilder.append(this.f);
          QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
        }
        return 3;
      }
      if (this.f.mProgress > -1)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download mMusic.mProgress");
          localStringBuilder.append(this.f.mProgress);
          QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
        }
        return 1;
      }
      if (!FileUtils.fileExists(this.f.getLocalPath()))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download .");
          localStringBuilder.append(this.f.mProgress);
          QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
        }
        this.f.mProgress = 1;
        QimMusicDownloader.a(this.f.mUrl, this.f.getLocalPath(), this.h);
        a();
        return 2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("STATE_DOWNLOADED .");
        localStringBuilder.append(this.f.mProgress);
        QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
      }
      return 3;
    }
    finally {}
  }
  
  public float e()
  {
    try
    {
      int i = this.f.mProgress;
      float f1 = i * 1.0F / 100.0F;
      return f1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Music@");
    localStringBuilder.append(this.g);
    localStringBuilder.append("@");
    localStringBuilder.append(this.f);
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.CaptureComboMusic
 * JD-Core Version:    0.7.0.1
 */