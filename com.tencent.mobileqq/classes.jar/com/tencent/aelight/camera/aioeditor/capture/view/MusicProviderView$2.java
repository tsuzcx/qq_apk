package com.tencent.aelight.camera.aioeditor.capture.view;

import android.os.SystemClock;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class MusicProviderView$2
  extends MusicDownloadListener
{
  MusicProviderView$2(MusicProviderView paramMusicProviderView) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    if ((this.a.jdField_a_of_type_Long == 0L) || (l - this.a.jdField_a_of_type_Long > 16L))
    {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
      this.a.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "onFinish, succ:", Boolean.valueOf(paramBoolean), ", failcode:", Integer.valueOf(paramInt) });
    }
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath().equals(paramString))) {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
    if ((!paramBoolean) && (paramInt == -104)) {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView.2
 * JD-Core Version:    0.7.0.1
 */