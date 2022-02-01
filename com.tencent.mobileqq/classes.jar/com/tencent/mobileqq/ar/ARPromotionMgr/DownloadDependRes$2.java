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
    QLog.w(PromotionUtil.a, 1, "onServiceConnected, name[" + paramComponentName + "]");
    try
    {
      this.a.a = IArConfigManager.Stub.a(paramIBinder);
      this.a.a.a(DownloadDependRes.a(this.a));
      this.a.a.c();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(PromotionUtil.a, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.w(PromotionUtil.a, 1, "onServiceDisconnected, name[" + paramComponentName + "]");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.DownloadDependRes.2
 * JD-Core Version:    0.7.0.1
 */