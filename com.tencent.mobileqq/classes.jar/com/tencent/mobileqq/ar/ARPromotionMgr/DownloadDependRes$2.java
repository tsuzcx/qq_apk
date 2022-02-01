package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.qphone.base.util.QLog;

class DownloadDependRes$2
  implements ServiceConnection
{
  DownloadDependRes$2(DownloadDependRes paramDownloadDependRes) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    String str = PromotionUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceConnected, name[");
    localStringBuilder.append(paramComponentName);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    try
    {
      this.a.c = IArConfigManager.Stub.a(paramIBinder);
      this.a.c.a(DownloadDependRes.a(this.a));
      this.a.c.h();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(PromotionUtil.a, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    String str = PromotionUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceDisconnected, name[");
    localStringBuilder.append(paramComponentName);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.DownloadDependRes.2
 * JD-Core Version:    0.7.0.1
 */