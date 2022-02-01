package com.tencent.mobileqq.ar;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.qphone.base.util.QLog;

class RemoteArConfigManager$1
  implements ServiceConnection
{
  RemoteArConfigManager$1(RemoteArConfigManager paramRemoteArConfigManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.f = IArConfigManager.Stub.a(paramIBinder);
    if (QLog.isColorLevel())
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append("onServiceConnected configManager=");
      paramComponentName.append(this.a.f);
      QLog.d("ArConfig_RemoteArConfigManager", 2, paramComponentName.toString());
    }
    if (this.a.f != null)
    {
      try
      {
        this.a.f.a(this.a.k);
        this.a.f.a(this.a.l);
        this.a.f.a(RemoteArConfigManager.a(this.a));
        if (RemoteArConfigManager.b(this.a) != -1) {
          this.a.f.b(RemoteArConfigManager.b(this.a));
        }
      }
      catch (RemoteException paramComponentName)
      {
        if (QLog.isColorLevel())
        {
          paramIBinder = new StringBuilder();
          paramIBinder.append("registerArCallback: ");
          paramIBinder.append(paramComponentName.getMessage());
          QLog.d("ArConfig_RemoteArConfigManager", 2, paramIBinder.toString());
        }
      }
      if (RemoteArConfigManager.c(this.a) != null) {
        RemoteArConfigManager.c(this.a).sendEmptyMessage(0);
      }
      if (this.a.i)
      {
        paramComponentName = this.a;
        paramComponentName.a = paramComponentName.b();
        if ((this.a.a != null) && (RemoteArConfigManager.c(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.a;
          RemoteArConfigManager.c(this.a).sendMessage(paramComponentName);
        }
      }
      paramComponentName = this.a;
      paramComponentName.b = paramComponentName.c();
      if (this.a.b == null) {
        this.a.b = new ArEffectConfig();
      }
      if ((this.a.b != null) && (RemoteArConfigManager.c(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.b;
        RemoteArConfigManager.c(this.a).sendMessage(paramComponentName);
      }
      paramComponentName = this.a;
      paramComponentName.c = paramComponentName.d();
      if ((this.a.c != null) && (RemoteArConfigManager.c(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.c;
        RemoteArConfigManager.c(this.a).sendMessage(paramComponentName);
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.a.f != null)
    {
      try
      {
        this.a.f.b(this.a.k);
        this.a.f.b(this.a.l);
        this.a.f.b(RemoteArConfigManager.a(this.a));
      }
      catch (RemoteException paramComponentName)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unregisterCallback: ");
          localStringBuilder.append(paramComponentName.getMessage());
          QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder.toString());
        }
      }
      this.a.f = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager.1
 * JD-Core Version:    0.7.0.1
 */