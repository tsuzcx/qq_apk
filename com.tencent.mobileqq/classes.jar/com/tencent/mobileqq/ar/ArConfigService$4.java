package com.tencent.mobileqq.ar;

import android.os.Handler;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class ArConfigService$4
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  ArConfigService$4(ArConfigService paramArConfigService) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "mARSDK2ResourceDownloadCallback");
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    ArConfigService.c(this.a, (int)(paramLong1 * 100L / paramLong2));
    int i = (ArConfigService.r(this.a) + ArConfigService.s(this.a) + ArConfigService.t(this.a) + ArConfigService.u(this.a) + ArConfigService.v(this.a)) / 5;
    if (!ArConfigService.q(this.a)) {
      ArConfigService.w(this.a).post(new ArConfigService.4.1(this, i));
    }
  }
  
  public void a(boolean paramBoolean, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadComplete mARSDK2ResourceDownloadCallback result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      ArConfigService.c(this.a, true);
      if ((ArConfigService.A(this.a)) && (ArConfigService.B(this.a)) && (ArConfigService.C(this.a)) && (ArConfigService.D(this.a)) && (ArConfigService.E(this.a))) {
        ArConfigService.w(this.a).post(new ArConfigService.4.2(this));
      }
    }
    else if (!ArConfigService.q(this.a))
    {
      ArConfigService.w(this.a).post(new ArConfigService.4.3(this));
      ArConfigService.a(this.a, true);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.4
 * JD-Core Version:    0.7.0.1
 */