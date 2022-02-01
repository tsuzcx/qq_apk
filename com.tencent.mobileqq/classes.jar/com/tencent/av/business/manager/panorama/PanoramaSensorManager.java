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
  private static volatile PanoramaSensorManager jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaSensorManager;
  private volatile int jdField_a_of_type_Int = -1;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private WeakReference<SensorEventHandler.CameraChangedCallBack> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public static PanoramaSensorManager a()
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaSensorManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaSensorManager == null) {
          jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaSensorManager = new PanoramaSensorManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvBusinessManagerPanoramaPanoramaSensorManager;
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
      return;
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramActivity.getSystemService("sensor"));
    }
  }
  
  public void a(SensorEventListener paramSensorEventListener)
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localObject != null)
    {
      if (paramSensorEventListener == null) {
        return;
      }
      localObject = ((SensorManager)localObject).getDefaultSensor(11);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(paramSensorEventListener, (Sensor)localObject, 1);
      }
    }
  }
  
  public void a(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    if (paramCameraChangedCallBack == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCameraChangedCallBack);
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (SensorEventHandler.CameraChangedCallBack)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((SensorEventHandler.CameraChangedCallBack)localObject).onCameraChanged(paramBoolean);
  }
  
  public boolean a()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    boolean bool = false;
    if (localSensorManager == null) {
      return false;
    }
    if (localSensorManager.getDefaultSensor(11) != null) {
      bool = true;
    }
    return bool;
  }
  
  public void b(SensorEventListener paramSensorEventListener)
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getCameraID()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.panorama.PanoramaSensorManager
 * JD-Core Version:    0.7.0.1
 */