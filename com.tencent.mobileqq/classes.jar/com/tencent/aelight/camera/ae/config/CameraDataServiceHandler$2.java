package com.tencent.aelight.camera.ae.config;

import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPath.GIF.FILES;
import com.tencent.aelight.camera.ae.AEPath.Watermark.FILES;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class CameraDataServiceHandler$2
  implements Runnable
{
  CameraDataServiceHandler$2(CameraDataServiceHandler paramCameraDataServiceHandler) {}
  
  public void run()
  {
    QLog.d(CameraDataServiceHandler.f(), 4, "[deleteOldMaterialFile]");
    if (FileUtils.fileExists(AEPath.CAMERA.FILES.d))
    {
      QLog.d(CameraDataServiceHandler.f(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_ZIP_DOWNLOAD_OLD");
      FileUtils.deleteDirectory(AEPath.CAMERA.FILES.d);
    }
    if (FileUtils.fileExists(AEPath.CAMERA.FILES.e))
    {
      QLog.d(CameraDataServiceHandler.f(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_FINAL_USABLE_OLD");
      FileUtils.deleteDirectory(AEPath.CAMERA.FILES.e);
    }
    if (FileUtils.fileExists(AEPath.CAMERA.FILES.f))
    {
      QLog.d(CameraDataServiceHandler.f(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_OLD");
      FileUtils.deleteDirectory(AEPath.CAMERA.FILES.f);
    }
    if (FileUtils.fileExists(AEPath.Watermark.FILES.b))
    {
      QLog.d(CameraDataServiceHandler.f(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_JSON_OLD");
      FileUtils.deleteDirectory(AEPath.CAMERA.FILES.f);
    }
    if (FileUtils.fileExists(AEPath.GIF.FILES.f))
    {
      QLog.d(CameraDataServiceHandler.f(), 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_JSON_OLD");
      FileUtils.deleteDirectory(AEPath.CAMERA.FILES.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraDataServiceHandler.2
 * JD-Core Version:    0.7.0.1
 */