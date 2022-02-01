package com.tencent.mobileqq.armap.sensor.provider;

import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OrientationProvider
  implements SensorEventListener
{
  private boolean a = false;
  private float b = -1.0F;
  private float c = -1.0F;
  protected List<Sensor> d = new ArrayList();
  protected float[] e = new float[3];
  protected SensorManager f;
  protected ARSensorManager.OnSensorChangeListener g;
  private float h = -1.0F;
  
  public OrientationProvider(SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    this.f = paramSensorManager;
    this.g = paramOnSensorChangeListener;
  }
  
  private GeomagneticField a()
  {
    if (this.a) {
      return new GeomagneticField(this.b, this.c, this.h, System.currentTimeMillis());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.f.registerListener(this, localSensor, paramInt);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.f.registerListener(this, localSensor, 1);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.f.unregisterListener(this, localSensor);
    }
  }
  
  protected float d()
  {
    GeomagneticField localGeomagneticField = a();
    if (localGeomagneticField != null) {
      return localGeomagneticField.getDeclination();
    }
    return 0.0F;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.OrientationProvider
 * JD-Core Version:    0.7.0.1
 */