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
  private int jdField_a_of_type_Int;
  private MusicSoundFile.ProgressListener jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile$ProgressListener = new MusicWaveformManager.1(this);
  private MusicSoundFile jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MusicWaveformManager.2(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b = false;
  private boolean c = false;
  
  public static boolean a()
  {
    return ("Meizu".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT <= 22);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = new MusicSoundFile();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangRunnable, null, true);
  }
  
  public float a(int paramInt)
  {
    if ((this.b) && (this.c)) {
      return 0.5F;
    }
    if (this.b)
    {
      MusicSoundFile localMusicSoundFile = this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile;
      if ((localMusicSoundFile != null) && (localMusicSoundFile.jdField_a_of_type_Boolean))
      {
        int i = this.jdField_a_of_type_Int;
        if (paramInt >= i) {
          return this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile.a(paramInt - i);
        }
      }
    }
    return -1.0F;
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = null;
    }
    this.b = false;
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    if (paramMusicItemInfo == null)
    {
      a();
      return;
    }
    if (this.b)
    {
      if ((paramMusicItemInfo.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) && (this.jdField_a_of_type_Int <= paramInt) && (paramMusicItemInfo.musicStart == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart) && (paramMusicItemInfo.musicEnd == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)) {
        return;
      }
      a();
    }
    this.b = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo.copy();
    this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = null;
    this.jdField_a_of_type_Int = paramInt;
    if (a())
    {
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.e("MusicWaveformManager", 2, "musicSoundFile create give up, is rubbish Meizu");
      }
    }
    else
    {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.musicwavesupport.MusicWaveformManager
 * JD-Core Version:    0.7.0.1
 */