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
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.b(this.b, this.a.a);
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.b(this.b, this.a.a);
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
    ((StringBuilder)localObject).append(this.a.a);
    ((StringBuilder)localObject).append(", filename = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.d);
    ((StringBuilder)localObject).append(", url = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.b);
    QLog.i("AREngine_ArNativeSoManager", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      if (!ArNativeSoManager.a(this.b, paramDownloadInfo.d, paramDownloadInfo.c))
      {
        ArNativeSoManager.a(this.b, paramDownloadInfo.d);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
        return;
      }
      this.b.a(paramDownloadInfo.e, paramDownloadInfo.d, paramDownloadInfo.c);
    }
    localObject = ArNativeSoManager.b(this.b, this.a.a);
    if (localObject != null) {
      ((ARPreSoResourceDownload.ARResourceDownloadCallback)localObject).a(paramBoolean, paramDownloadInfo);
    }
  }
  
  public void b()
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.b(this.b, this.a.a);
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoManager.4
 * JD-Core Version:    0.7.0.1
 */