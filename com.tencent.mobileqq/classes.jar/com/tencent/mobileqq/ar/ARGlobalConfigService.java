package com.tencent.mobileqq.ar;

import akiu;
import akiv;
import akpx;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class ARGlobalConfigService
  extends AppService
{
  public akiu a;
  private akpx jdField_a_of_type_Akpx = new akiv(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  
  public void onAccountChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
    this.jdField_a_of_type_Akiu = ((akiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onAccountChanged");
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_Akpx;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      this.jdField_a_of_type_Akiu = ((akiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onDestroy");
    }
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalConfigService
 * JD-Core Version:    0.7.0.1
 */