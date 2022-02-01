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
    this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = IArConfigManager.Stub.a(paramIBinder);
    if (QLog.isColorLevel())
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append("onServiceConnected configManager=");
      paramComponentName.append(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager);
      QLog.d("ArConfig_RemoteArConfigManager", 2, paramComponentName.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
    {
      try
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback);
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArFaceCallback);
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(RemoteArConfigManager.a(this.a));
        if (RemoteArConfigManager.a(this.a) != -1) {
          this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(RemoteArConfigManager.a(this.a));
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
      if (RemoteArConfigManager.a(this.a) != null) {
        RemoteArConfigManager.a(this.a).sendEmptyMessage(0);
      }
      if (this.a.c)
      {
        paramComponentName = this.a;
        paramComponentName.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramComponentName.a();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (RemoteArConfigManager.a(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
          RemoteArConfigManager.a(this.a).sendMessage(paramComponentName);
        }
      }
      paramComponentName = this.a;
      paramComponentName.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = paramComponentName.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (RemoteArConfigManager.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        RemoteArConfigManager.a(this.a).sendMessage(paramComponentName);
      }
      paramComponentName = this.a;
      paramComponentName.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramComponentName.a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (RemoteArConfigManager.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        RemoteArConfigManager.a(this.a).sendMessage(paramComponentName);
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
    {
      try
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback);
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArFaceCallback);
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(RemoteArConfigManager.a(this.a));
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
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager.1
 * JD-Core Version:    0.7.0.1
 */