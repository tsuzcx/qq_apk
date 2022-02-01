package com.tencent.mobileqq.ark.component;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkAppEventObserverManager
{
  private String a;
  private SosoInterfaceOnLocationListener b;
  private SensorEventListener c = null;
  private ArkAppEventObserverManager.ArkConnectionHandler d = null;
  private Sensor e = null;
  private float[] f = new float[3];
  private float[] g = new float[3];
  private Sensor h = null;
  private float i;
  private float j;
  private float k;
  private double l = 0.0D;
  private double m = 0.0D;
  private String n = null;
  private final int o = 0;
  private ArkAppEventObserverManager.MotionCallback p = null;
  private long q = 0L;
  private ArkAppEventObserverManager.OrientationCallback r = null;
  private long s = 0L;
  private ArkAppEventObserverManager.PositionCallback t = null;
  private long u = 0L;
  private ArkAppEventObserverManager.ConnectionCallback v = null;
  private long w = 0L;
  private ArkAppEventObserverManager.GetCurrentPositionCallback x = null;
  private long y = 0L;
  
  public ArkAppEventObserverManager(String paramString)
  {
    this.a = paramString;
    this.c = new ArkAppEventObserverManager.ArkSensorEventListener(this);
    this.b = new ArkAppEventObserverManager.1(this, 3, true, true, 0L, true, true, "ArkAppEventObserverManager");
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    long l1 = System.currentTimeMillis();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.a, new ArkAppEventObserverManager.2(this, paramSensorEvent, l1));
  }
  
  private void b(SensorEvent paramSensorEvent)
  {
    long l1 = System.currentTimeMillis();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.a, new ArkAppEventObserverManager.3(this, l1, paramSensorEvent));
  }
  
  public void a()
  {
    a("Motion");
    a("Orientation");
    a("Position");
    a("ConnectionTypeChange");
  }
  
  public void a(ArkAppEventObserverManager.ObserverCallback paramObserverCallback, long paramLong)
  {
    long l1;
    Object localObject;
    if ((paramObserverCallback instanceof ArkAppEventObserverManager.MotionCallback))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "attachEvent MotionCallback");
      }
      l1 = this.q;
      if (l1 != 0L)
      {
        localObject = this.p;
        if (localObject != null) {
          ((ArkAppEventObserverManager.MotionCallback)localObject).a(l1);
        }
      }
      this.p = ((ArkAppEventObserverManager.MotionCallback)paramObserverCallback);
      this.q = paramLong;
      if (this.e == null)
      {
        paramObserverCallback = (SensorManager)b().getApp().getSystemService("sensor");
        this.e = paramObserverCallback.getDefaultSensor(1);
        localObject = this.e;
        if (localObject != null)
        {
          paramObserverCallback.registerListener(this.c, (Sensor)localObject, 1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "mMotionSensor is NULL");
        }
        this.p.a(false, 0.0F, 0.0F, 0.0F);
      }
    }
    else if ((paramObserverCallback instanceof ArkAppEventObserverManager.OrientationCallback))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "attachEvent OrientationCallback");
      }
      l1 = this.s;
      if (l1 != 0L)
      {
        localObject = this.r;
        if (localObject != null) {
          ((ArkAppEventObserverManager.OrientationCallback)localObject).a(l1);
        }
      }
      this.r = ((ArkAppEventObserverManager.OrientationCallback)paramObserverCallback);
      this.s = paramLong;
      if (this.h == null)
      {
        paramObserverCallback = (SensorManager)b().getApp().getSystemService("sensor");
        this.h = paramObserverCallback.getDefaultSensor(3);
        paramObserverCallback.registerListener(this.c, this.h, 1);
      }
    }
    else
    {
      if ((paramObserverCallback instanceof ArkAppEventObserverManager.PositionCallback))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("attachEvent PositionCallback callback=");
          ((StringBuilder)localObject).append(paramObserverCallback);
          ((StringBuilder)localObject).append(", cbId=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", mPositionCallback=");
          ((StringBuilder)localObject).append(this.t);
          ((StringBuilder)localObject).append(", mPositionCallbackId=");
          ((StringBuilder)localObject).append(this.u);
          QLog.d("ArkAppEventObserverManager", 2, ((StringBuilder)localObject).toString());
        }
        l1 = this.u;
        if (l1 != 0L)
        {
          localObject = this.t;
          if (localObject != null) {
            ((ArkAppEventObserverManager.PositionCallback)localObject).a(l1);
          }
        }
        this.t = ((ArkAppEventObserverManager.PositionCallback)paramObserverCallback);
        this.u = paramLong;
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.b);
        return;
      }
      if ((paramObserverCallback instanceof ArkAppEventObserverManager.ConnectionCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "attachEvent ConnectionCallback");
        }
        l1 = this.w;
        if (l1 != 0L)
        {
          localObject = this.v;
          if (localObject != null) {
            ((ArkAppEventObserverManager.ConnectionCallback)localObject).a(l1);
          }
        }
        this.v = ((ArkAppEventObserverManager.ConnectionCallback)paramObserverCallback);
        this.w = paramLong;
        if (this.d == null)
        {
          this.d = new ArkAppEventObserverManager.ArkConnectionHandler(this);
          AppNetConnInfo.registerConnectionChangeReceiver(b().getApp(), this.d);
        }
      }
      else if ((paramObserverCallback instanceof ArkAppEventObserverManager.GetCurrentPositionCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "attachEvent GetCurrentPositionCallback");
        }
        l1 = this.y;
        if (l1 != 0L)
        {
          localObject = this.x;
          if (localObject != null) {
            ((ArkAppEventObserverManager.GetCurrentPositionCallback)localObject).a(l1);
          }
        }
        this.x = ((ArkAppEventObserverManager.GetCurrentPositionCallback)paramObserverCallback);
        this.y = paramLong;
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.b);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detachEvent eventName=");
      localStringBuilder.append(paramString);
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    long l1;
    if ("Motion".equals(paramString))
    {
      if (this.e != null)
      {
        ((SensorManager)b().getApp().getSystemService("sensor")).unregisterListener(this.c, this.e);
        this.e = null;
      }
      l1 = this.q;
      if (l1 != 0L)
      {
        paramString = this.p;
        if (paramString != null) {
          paramString.a(l1);
        }
      }
      this.p = null;
      this.q = 0L;
      return;
    }
    if ("Orientation".equals(paramString))
    {
      if (this.h != null)
      {
        ((SensorManager)b().getApp().getSystemService("sensor")).unregisterListener(this.c, this.h);
        this.h = null;
      }
      l1 = this.s;
      if (l1 != 0L)
      {
        paramString = this.r;
        if (paramString != null) {
          paramString.a(l1);
        }
      }
      this.r = null;
      this.s = 0L;
      return;
    }
    if ("Position".equals(paramString))
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.b);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("detachEvent PositionCallback mPositionCallback=");
        paramString.append(this.t);
        paramString.append(", mPositionCallbackId=");
        paramString.append(this.u);
        QLog.d("ArkAppEventObserverManager", 2, paramString.toString());
      }
      l1 = this.u;
      if (l1 != 0L)
      {
        paramString = this.t;
        if (paramString != null) {
          paramString.a(l1);
        }
      }
      this.t = null;
      this.u = 0L;
      this.l = 0.0D;
      this.m = 0.0D;
      return;
    }
    if ("ConnectionTypeChange".equals(paramString))
    {
      paramString = this.d;
      if (paramString != null)
      {
        AppNetConnInfo.unregisterNetInfoHandler(paramString);
        this.d = null;
      }
      l1 = this.w;
      if (l1 != 0L)
      {
        paramString = this.v;
        if (paramString != null) {
          paramString.a(l1);
        }
      }
      this.v = null;
      this.w = 0L;
      this.n = null;
    }
  }
  
  AppRuntime b()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager
 * JD-Core Version:    0.7.0.1
 */