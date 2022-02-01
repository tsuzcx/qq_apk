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
  MusicDownloadListener a;
  public MusicItemInfo a;
  int c;
  
  public CaptureComboMusic(int paramInt)
  {
    super(null);
    this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = new CaptureComboMusic.1(this);
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)QIMManager.a(2)).b(paramInt);
  }
  
  public float a()
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress;
      float f = i * 1.0F / 100.0F;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    boolean bool;
    label67:
    try
    {
      MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
      if (localMusicItemInfo == null) {
        return 3;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress > -1)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress;
        if (i == 100) {
          return 3;
        }
        return 1;
      }
    }
    finally {}
    try
    {
      bool = FileUtils.fileExists(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath());
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
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyMusic");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      QLog.i("QCombo.Music", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
      return 0;
    }
    ((MusicProviderView)paramActivity.findViewById(2131364293)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
      return;
    }
    if ((paramInt != 1) && (paramInt != 3)) {
      ((QimMusicPlayer)QIMManager.a().c(8)).a(paramInt);
    }
  }
  
  public int b()
  {
    try
    {
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download STATE_DOWNLOADED");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
        }
        return 3;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress > -1)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download mMusic.mProgress");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
          QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
        }
        return 1;
      }
      if (!FileUtils.fileExists(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download .");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
          QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress = 1;
        QimMusicDownloader.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
        a();
        return 2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("STATE_DOWNLOADED .");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
        QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
      }
      return 3;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Music@");
    localStringBuilder.append(this.c);
    localStringBuilder.append("@");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.CaptureComboMusic
 * JD-Core Version:    0.7.0.1
 */