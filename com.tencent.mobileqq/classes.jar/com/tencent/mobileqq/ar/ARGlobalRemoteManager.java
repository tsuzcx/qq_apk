package com.tencent.mobileqq.ar;

import aadw;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager;
import com.tencent.qphone.base.util.QLog;

public final class ARGlobalRemoteManager
{
  private static volatile ARGlobalRemoteManager jdField_a_of_type_ComTencentMobileqqArARGlobalRemoteManager;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new aadw(this);
  private volatile IArGlobalConfigManager jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager;
  
  private ARGlobalRemoteManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static ARGlobalRemoteManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqArARGlobalRemoteManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArARGlobalRemoteManager == null) {
        jdField_a_of_type_ComTencentMobileqqArARGlobalRemoteManager = new ARGlobalRemoteManager(paramContext.getApplicationContext());
      }
      return jdField_a_of_type_ComTencentMobileqqArARGlobalRemoteManager;
    }
    finally {}
  }
  
  public ARScanStarFaceConfigInfo a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager.a();
      QLog.d("ARGlobalRemoteManager", 2, String.format("getScanStarFaceConfigInfo IService=%s configInfo=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager, localObject1 }));
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ARGlobalRemoteManager", 1, "getScanStarFaceConfigInfo fail!", localRemoteException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager == null)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ARGlobalConfigService.class);
        this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalRemoteManager
 * JD-Core Version:    0.7.0.1
 */