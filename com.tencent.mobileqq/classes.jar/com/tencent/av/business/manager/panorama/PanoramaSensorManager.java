package com.tencent.av.business.manager.panorama;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import java.lang.ref.WeakReference;

public class PanoramaSensorManager
  implements CameraInterFace
{
  private static volatile PanoramaSensorManager a;
  private SensorManager b;
  private WeakReference<SensorEventHandler.CameraChangedCallBack> c;
  private boolean d = true;
  private volatile int e = -1;
  
  public static PanoramaSensorManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PanoramaSensorManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      this.b = null;
      return;
    }
    if (this.b == null) {
      this.b = ((SensorManager)paramActivity.getSystemService("sensor"));
    }
  }
  
  public void a(SensorEventListener paramSensorEventListener)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (paramSensorEventListener == null) {
        return;
      }
      localObject = ((SensorManager)localObject).getDefaultSensor(11);
      if (localObject != null) {
        this.b.registerListener(paramSensorEventListener, (Sensor)localObject, 1);
      }
    }
  }
  
  public void a(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    if (paramCameraChangedCallBack == null) {
      return;
    }
    this.c = new WeakReference(paramCameraChangedCallBack);
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = (SensorEventHandler.CameraChangedCallBack)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((SensorEventHandler.CameraChangedCallBack)localObject).onCameraChanged(paramBoolean);
  }
  
  public void b(SensorEventListener paramSensorEventListener)
  {
    SensorManager localSensorManager = this.b;
    if (localSensorManager != null)
    {
      if (paramSensorEventListener == null) {
        return;
      }
      localSensorManager.unregisterListener(paramSensorEventListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.e = i;
  }
  
  public boolean b()
  {
    SensorManager localSensorManager = this.b;
    boolean bool = false;
    if (localSensorManager == null) {
      return false;
    }
    if (localSensorManager.getDefaultSensor(11) != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public int getCameraID()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.panorama.PanoramaSensorManager
 * JD-Core Version:    0.7.0.1
 */