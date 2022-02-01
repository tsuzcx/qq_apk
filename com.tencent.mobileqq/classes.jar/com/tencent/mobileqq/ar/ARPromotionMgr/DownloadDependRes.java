package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DownloadDependRes
{
  AppInterface a;
  ServiceConnection b = null;
  IArConfigManager c = null;
  private IArSoCallback d = null;
  
  void a()
  {
    try
    {
      if (this.c != null)
      {
        if (this.d != null)
        {
          this.c.b(this.d);
          this.d = null;
        }
        if (this.b != null)
        {
          this.a.getApp().unbindService(this.b);
          this.b = null;
        }
        this.c = null;
      }
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(PromotionUtil.a, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    if (!ArConfigService.e(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(PromotionUtil.a, 1, "tryDownload, so未准备");
      }
      b();
    }
  }
  
  void b()
  {
    IArConfigManager localIArConfigManager = this.c;
    if (localIArConfigManager != null) {
      try
      {
        localIArConfigManager.h();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PromotionUtil.a, 2, "downloadArSo Exception", localException);
        }
        return;
      }
    }
    this.d = new DownloadDependRes.1(this);
    this.b = new DownloadDependRes.2(this);
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = new Intent(((AppInterface)localObject).getApp(), ArConfigService.class);
    boolean bool = this.a.getApp().bindService((Intent)localObject, this.b, 1);
    localObject = PromotionUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindServer, ret[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.DownloadDependRes
 * JD-Core Version:    0.7.0.1
 */