package com.tencent.mobileqq.ar;

import android.os.Handler;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class ArConfigService$8
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  ArConfigService$8(ArConfigService paramArConfigService) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "mARFeatureDownloadCallBack");
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("mARFeatureDownloadCallBack onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    ArConfigService.e(this.a, (int)(100L * paramLong1 / paramLong2));
    int i = (ArConfigService.a(this.a) + ArConfigService.b(this.a) + ArConfigService.c(this.a) + ArConfigService.d(this.a) + ArConfigService.e(this.a)) / 5;
    if (!ArConfigService.e(this.a)) {
      ArConfigService.a(this.a).post(new ArConfigService.8.1(this, i));
    }
  }
  
  public void a(boolean paramBoolean, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("mARFeatureDownloadCallBack  result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      ArConfigService.f(this.a, true);
      if ((ArConfigService.f(this.a)) && (ArConfigService.g(this.a)) && (ArConfigService.h(this.a)) && (ArConfigService.i(this.a)) && (ArConfigService.j(this.a))) {
        ArConfigService.a(this.a).post(new ArConfigService.8.2(this));
      }
    }
    while (ArConfigService.e(this.a)) {
      return;
    }
    ArConfigService.a(this.a).post(new ArConfigService.8.3(this));
    ArConfigService.a(this.a, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.8
 * JD-Core Version:    0.7.0.1
 */