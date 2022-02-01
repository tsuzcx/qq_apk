package com.tencent.av.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class UtilsServiceForAV
  extends AppService
{
  VideoAppInterface a = null;
  final IBinder b = new UtilsServiceForAV.LocalBinder(this);
  PowerManager.WakeLock c = null;
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toggleProximityWakeLock turnOn = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("UtilsServiceForAV", 2, localStringBuilder.toString());
    }
    try
    {
      if (this.c != null)
      {
        if ((paramBoolean) && (!this.c.isHeld()))
        {
          this.c.acquire();
          return;
        }
        this.c.release();
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
      this.a = ((VideoAppInterface)this.app);
    }
    return this.b;
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
      this.c = localPowerManager.newWakeLock(32, "mobileqq:serforav");
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("UtilsServiceForAV", 2, "Exception", localException1);
      }
    }
    try
    {
      if (this.c != null)
      {
        this.c.setReferenceCounted(false);
        return;
      }
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
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
    if (this.c != null) {
      a(false);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onStartCommand");
    }
    if ((this.app instanceof VideoAppInterface)) {
      this.a = ((VideoAppInterface)this.app);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.UtilsServiceForAV
 * JD-Core Version:    0.7.0.1
 */