package com.tencent.mobileqq.ar.arengine;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ARPreSoResourceDownload$3
  extends HttpEngineTask
{
  ARPreSoResourceDownload$3(ARPreSoResourceDownload paramARPreSoResourceDownload, BaseQQAppInterface paramBaseQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    super(paramBaseQQAppInterface, paramString, paramIHttpEngineTask, paramHttpNetReq);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload))
    {
      ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).get(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.b);
      if (localARResourceDownloadCallback != null) {
        localARResourceDownloadCallback.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload))
    {
      ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).get(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.b);
      if (localARResourceDownloadCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.3
 * JD-Core Version:    0.7.0.1
 */