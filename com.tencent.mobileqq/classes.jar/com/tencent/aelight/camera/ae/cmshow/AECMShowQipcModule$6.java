package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import eipc.EIPCResult;
import java.io.File;

class AECMShowQipcModule$6
  extends DownloadListener
{
  AECMShowQipcModule$6(AECMShowQipcModule paramAECMShowQipcModule, File paramFile, int paramInt) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (3 == paramDownloadTask.a())
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        try
        {
          paramDownloadTask = this.jdField_a_of_type_JavaIoFile;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getParent());
          localStringBuilder.append(File.separator);
          ZipUtils.unZipFile(paramDownloadTask, localStringBuilder.toString());
          AECMShowQipcModule.b(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowQipcModule);
          this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowQipcModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(null));
        }
        catch (OutOfMemoryError paramDownloadTask)
        {
          AEQLog.a("AECMShowQipcModule", "[doDownloadCrossEngineAssets] unzip failed:", paramDownloadTask);
        }
        catch (Exception paramDownloadTask)
        {
          AEQLog.a("AECMShowQipcModule", "[doDownloadCrossEngineAssets] unzip failed:", paramDownloadTask);
        }
      }
    }
    else {
      AEQLog.d("AECMShowQipcModule", "[doDownloadCrossEngineAssets] download failed");
    }
    this.jdField_a_of_type_JavaIoFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule.6
 * JD-Core Version:    0.7.0.1
 */