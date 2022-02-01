package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class SensorHelper
{
  static int jdField_b_of_type_Int = -1;
  int jdField_a_of_type_Int = 0;
  Sensor jdField_a_of_type_AndroidHardwareSensor = null;
  SensorManager jdField_a_of_type_AndroidHardwareSensorManager = null;
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  SensorHelper.AccelerationSensorEventListener jdField_a_of_type_ComTencentAvUtilsSensorHelper$AccelerationSensorEventListener = null;
  SensorHelper.ProximitySensorEventListener jdField_a_of_type_ComTencentAvUtilsSensorHelper$ProximitySensorEventListener = null;
  SensorHelper.ScreenActionReceiver jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver = null;
  SensorReport jdField_a_of_type_ComTencentAvUtilsSensorReport = new SensorReport();
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  String jdField_a_of_type_JavaLangString = "SensorHelper";
  WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  Sensor jdField_b_of_type_AndroidHardwareSensor = null;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  private boolean e = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = true;
  private boolean i = false;
  private boolean j = true;
  
  private SensorHelper(Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = paramTraeHelper;
    b();
  }
  
  public static SensorHelper a(SensorHelper paramSensorHelper, Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    if (paramSensorHelper != null) {
      paramSensorHelper.a(false);
    }
    return new SensorHelper(paramActivity, paramVideoController, paramTraeHelper);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUtilsSensorReport.a(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSensor ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$AccelerationSensorEventListener != null) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ProximitySensorEventListener != null))
    {
      localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentAvUtilsSensorReport.a();
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$AccelerationSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 3);
            this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ProximitySensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor, 3);
            if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver == null)
            {
              localObject = new IntentFilter();
              ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
              ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
              ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
              ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
              this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver = new SensorHelper.ScreenActionReceiver(this);
              ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).registerReceiver(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver, (IntentFilter)localObject);
              return;
            }
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "startSensor error, mSreenActionReceive had exist");
          }
        }
        else
        {
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$AccelerationSensorEventListener);
            this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ProximitySensorEventListener);
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "toggleProximityWakeLock[false], when[StopSensor]");
            a(false, true);
            b(false);
            c(false);
            if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver != null)
            {
              ((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver);
              this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ScreenActionReceiver = null;
            }
          }
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvUtilsSensorReport.b();
        }
        return;
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startSensor error, start[");
    localStringBuilder.append(paramBoolean);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = a();
        if (this.d != paramBoolean1)
        {
          if (this.f) {
            break label343;
          }
          if (!paramBoolean1)
          {
            break label343;
            if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null)
            {
              PowerManager localPowerManager = (PowerManager)((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("power");
              try
              {
                this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = localPowerManager.newWakeLock(32, "mobileqq:sensor");
                if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
                  this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
                }
              }
              catch (Exception localException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "toggleProximityWakeLock off Exception", localException1);
                }
              }
            }
            if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null)
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 1, "toggleProximityWakeLock: mWakeLockForScreenOff is null");
              return;
            }
            try
            {
              if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
              {
                bool = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld();
                QLog.d(this.jdField_a_of_type_JavaLangString, 1, String.format("toggleProximityWakeLock, start[%s], bHeld[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool) }));
                if ((paramBoolean1) && (!bool))
                {
                  this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
                  this.d = true;
                  this.jdField_a_of_type_ComTencentAvUtilsSensorReport.c();
                }
                else if ((!paramBoolean1) && (bool))
                {
                  this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
                  this.d = false;
                  this.jdField_a_of_type_ComTencentAvUtilsSensorReport.a(this.j, this.f, this.h, this.jdField_a_of_type_Int, paramBoolean2, this.jdField_a_of_type_ComTencentAvVideoController);
                }
                this.d = paramBoolean1;
              }
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel()) {
                QLog.e(this.jdField_a_of_type_JavaLangString, 2, "toggleProximityWakeLock Exception", localException2);
              }
            }
          }
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, String.format("toggleProximityWakeLock error, start[%s], mIsStarted[%s], mEnbaleProximiy[%s], bProximityIgnoreDevice[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.d), Boolean.valueOf(this.f), Boolean.valueOf(bool) }));
        return;
      }
      finally {}
      label343:
      if (!bool) {}
    }
  }
  
  boolean a()
  {
    int k = jdField_b_of_type_Int;
    boolean bool = false;
    if (k == -1)
    {
      String str = Build.MODEL;
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        if ((!str.equalsIgnoreCase("GT-I9200")) && (!str.equalsIgnoreCase("GT-I8262D")) && (!str.equalsIgnoreCase("SM-N9008"))) {
          jdField_b_of_type_Int = 0;
        } else {
          jdField_b_of_type_Int = 1;
        }
      }
      else {
        jdField_b_of_type_Int = 0;
      }
    }
    if (jdField_b_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null)
    {
      localObject = (Context)((WeakReference)localObject).get();
      if ((localObject != null) && (this.jdField_a_of_type_AndroidHardwareSensorManager == null)) {
        this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)((Context)localObject).getSystemService("sensor"));
      }
    }
    localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
        this.jdField_a_of_type_AndroidHardwareSensor = ((SensorManager)localObject).getDefaultSensor(1);
      }
      if (this.jdField_b_of_type_AndroidHardwareSensor == null) {
        this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$AccelerationSensorEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$AccelerationSensorEventListener = new SensorHelper.AccelerationSensorEventListener(this);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ProximitySensorEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper$ProximitySensorEventListener = new SensorHelper.ProximitySensorEventListener(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper
 * JD-Core Version:    0.7.0.1
 */