package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class ArNativeSoManager$2
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  ArNativeSoManager$2(ArNativeSoManager paramArNativeSoManager, String paramString, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback) {}
  
  public void a()
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback;
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback;
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadSoRes onARResourceDownloadComplete. result = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", name = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.d);
    ((StringBuilder)localObject).append(", filename = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.c);
    ((StringBuilder)localObject).append(", url = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.jdField_a_of_type_JavaLangString);
    QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (!ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c, paramDownloadInfo.b))
      {
        ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
        return;
      }
      if (paramDownloadInfo.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager.a(paramDownloadInfo.d, paramDownloadInfo.c, paramDownloadInfo.b);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback;
    if (localObject != null) {
      ((ARPreSoResourceDownload.ARResourceDownloadCallback)localObject).a(paramBoolean, paramDownloadInfo);
    }
  }
  
  public void b()
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback;
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoManager.2
 * JD-Core Version:    0.7.0.1
 */