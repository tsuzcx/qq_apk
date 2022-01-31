package com.tencent.av.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lxw;
import mqq.app.AppService;

public class UtilsServiceForAV
  extends AppService
{
  final IBinder jdField_a_of_type_AndroidOsIBinder = new lxw(this);
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "toggleProximityWakeLock turnOn = " + paramBoolean);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
      {
        if ((paramBoolean) && (!this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()))
        {
          this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
          return;
        }
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("UtilsServiceForAV", 2, "Exception", localException);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return this.jdField_a_of_type_AndroidOsIBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onCreate");
    }
    PowerManager localPowerManager = (PowerManager)getSystemService("power");
    try
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = localPowerManager.newWakeLock(32, "mobileqq:serforav");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
            this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("UtilsServiceForAV", 2, "Exception", localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("UtilsServiceForAV", 2, "Exception", localException2);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
      a(false);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onStartCommand");
    }
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.service.UtilsServiceForAV
 * JD-Core Version:    0.7.0.1
 */