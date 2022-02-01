package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class ArNativeSoManager$4
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  ArNativeSoManager$4(ArNativeSoManager paramArNativeSoManager, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    ((StringBuilder)localObject).append(", filename = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.c);
    ((StringBuilder)localObject).append(", url = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.a);
    QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (!ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c, paramDownloadInfo.b))
      {
        ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager.a(paramDownloadInfo.d, paramDownloadInfo.c, paramDownloadInfo.b);
    }
    localObject = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localObject != null) {
      ((ARPreSoResourceDownload.ARResourceDownloadCallback)localObject).a(paramBoolean, paramDownloadInfo);
    }
  }
  
  public void b()
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoManager.4
 * JD-Core Version:    0.7.0.1
 */