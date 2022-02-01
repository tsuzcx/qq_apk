package com.tencent.mobileqq.activity.photo;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPlayControllerForFile
  extends VideoPlayControllerForAIO
  implements FileVideoMediaPlayHelper.OnCaptureVideoFrameImageListener
{
  private VideoPlayControllerForFile.OnCaptureVideoFrameListener jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForFile$OnCaptureVideoFrameListener;
  private Map<Long, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private VideoPlayControllerForAIO.OnDownloadListener b = null;
  
  public VideoPlayControllerForFile()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper = new FileVideoMediaPlayHelper();
    ((FileVideoMediaPlayHelper)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(VideoPlayControllerForAIO.OnDownloadListener paramOnDownloadListener)
  {
    this.b = paramOnDownloadListener;
    ((FileVideoMediaPlayHelper)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper).a(new VideoPlayControllerForFile.1(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForFile$OnCaptureVideoFrameListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForFile$OnCaptureVideoFrameListener.a(paramString);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean));
    String str = HardCodeUtil.a(2131716164) + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_c_of_type_Long) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_c_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long, 11, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_AndroidOsBundle);
    return false;
  }
  
  public long c()
  {
    if (FileVideoMediaPlayHelper.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper)) {
      return ((FileVideoMediaPlayHelper)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long, 12, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString[0])) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a == null));
    b();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayControllerForFile
 * JD-Core Version:    0.7.0.1
 */