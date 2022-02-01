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
  static int p = -1;
  String a = "SensorHelper";
  boolean b = false;
  Sensor c = null;
  SensorHelper.AccelerationSensorEventListener d = null;
  Sensor e = null;
  SensorHelper.ProximitySensorEventListener f = null;
  SensorManager g = null;
  boolean h = false;
  SensorHelper.ScreenActionReceiver i = null;
  SensorReport j = new SensorReport();
  int k = 0;
  VideoController l = null;
  WeakReference<Context> m = null;
  TraeHelper n;
  boolean o = false;
  PowerManager.WakeLock q = null;
  boolean r = false;
  private boolean s = true;
  private boolean t = false;
  private boolean u = true;
  private boolean v = true;
  private boolean w = false;
  private boolean x = true;
  
  private SensorHelper(Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    this.m = new WeakReference(paramActivity);
    this.l = paramVideoController;
    this.n = paramTraeHelper;
    c();
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
    this.j.a(this.l);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSensor ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (this.f != null))
    {
      localObject = this.m;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        if (paramBoolean)
        {
          this.j.a();
          if (!this.h)
          {
            this.h = true;
            this.g.registerListener(this.d, this.c, 3);
            this.g.registerListener(this.f, this.e, 3);
            if (this.i == null)
            {
              localObject = new IntentFilter();
              ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
              ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
              ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
              ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
              this.i = new SensorHelper.ScreenActionReceiver(this);
              ((Context)this.m.get()).registerReceiver(this.i, (IntentFilter)localObject);
              return;
            }
            QLog.e(this.a, 1, "startSensor error, mSreenActionReceive had exist");
          }
        }
        else
        {
          if (this.h)
          {
            this.g.unregisterListener(this.d);
            this.g.unregisterListener(this.f);
            QLog.d(this.a, 1, "toggleProximityWakeLock[false], when[StopSensor]");
            a(false, true);
            b(false);
            c(false);
            if (this.i != null)
            {
              ((Context)this.m.get()).unregisterReceiver(this.i);
              this.i = null;
            }
          }
          this.h = false;
          this.j.b();
        }
        return;
      }
    }
    Object localObject = this.a;
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
        bool = b();
        if (this.r != paramBoolean1)
        {
          if (this.t) {
            break label345;
          }
          if (!paramBoolean1)
          {
            break label345;
            if (this.q == null)
            {
              PowerManager localPowerManager = (PowerManager)((Context)this.m.get()).getSystemService("power");
              try
              {
                this.q = localPowerManager.newWakeLock(32, "mobileqq:sensor");
                if (this.q != null) {
                  this.q.setReferenceCounted(false);
                }
              }
              catch (Exception localException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(this.a, 2, "toggleProximityWakeLock off Exception", localException1);
                }
              }
            }
            if (this.q == null)
            {
              QLog.d(this.a, 1, "toggleProximityWakeLock: mWakeLockForScreenOff is null");
              return;
            }
            try
            {
              if (this.q != null)
              {
                bool = this.q.isHeld();
                QLog.d(this.a, 1, String.format("toggleProximityWakeLock, start[%s], bHeld[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool) }));
                if ((paramBoolean1) && (!bool))
                {
                  this.q.acquire();
                  this.r = true;
                  this.j.c();
                }
                else if ((!paramBoolean1) && (bool))
                {
                  this.q.release();
                  this.r = false;
                  this.j.a(this.x, this.t, this.v, this.k, paramBoolean2, this.l);
                }
                this.r = paramBoolean1;
              }
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel()) {
                QLog.e(this.a, 2, "toggleProximityWakeLock Exception", localException2);
              }
            }
          }
        }
        QLog.d(this.a, 1, String.format("toggleProximityWakeLock error, start[%s], mIsStarted[%s], mEnbaleProximiy[%s], bProximityIgnoreDevice[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.r), Boolean.valueOf(this.t), Boolean.valueOf(bool) }));
        return;
      }
      finally {}
      label345:
      if (!bool) {}
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.t = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean b()
  {
    int i1 = p;
    boolean bool = false;
    if (i1 == -1)
    {
      String str = Build.MODEL;
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        if ((!str.equalsIgnoreCase("GT-I9200")) && (!str.equalsIgnoreCase("GT-I8262D")) && (!str.equalsIgnoreCase("SM-N9008"))) {
          p = 0;
        } else {
          p = 1;
        }
      }
      else {
        p = 0;
      }
    }
    if (p == 1) {
      bool = true;
    }
    return bool;
  }
  
  void c()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = (Context)((WeakReference)localObject).get();
      if ((localObject != null) && (this.g == null)) {
        this.g = ((SensorManager)((Context)localObject).getSystemService("sensor"));
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      if (this.c == null) {
        this.c = ((SensorManager)localObject).getDefaultSensor(1);
      }
      if (this.e == null) {
        this.e = this.g.getDefaultSensor(8);
      }
    }
    if (this.d == null) {
      this.d = new SensorHelper.AccelerationSensorEventListener(this);
    }
    if (this.f == null) {
      this.f = new SensorHelper.ProximitySensorEventListener(this);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
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