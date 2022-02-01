package com.tencent.mobileqq.armap.sensor;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.AccelMagnetGyroProvider;
import com.tencent.mobileqq.armap.sensor.provider.AccelMagnetProvider;
import com.tencent.mobileqq.armap.sensor.provider.AccelProvider;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProvider;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import com.tencent.mobileqq.armap.sensor.provider.RotationGameVectorProvider;
import com.tencent.mobileqq.armap.sensor.provider.RotationVectorProvider;
import com.tencent.mobileqq.armap.sensor.provider.TypeAccOrientationProvider;
import com.tencent.mobileqq.armap.sensor.provider.TypeOrientationProvider;
import com.tencent.qphone.base.util.QLog;

public class ARSensorManager
{
  private int a = 2;
  private Context b;
  private SensorManager c;
  private OrientationProvider d = null;
  private boolean e = false;
  
  public ARSensorManager(Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.a = paramInt;
    try
    {
      this.c = ((SensorManager)this.b.getSystemService("sensor"));
      return;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARSensorManager getSystemService error:");
      localStringBuilder.append(paramContext.getMessage());
      QLog.e("ARSensorManager", 1, localStringBuilder.toString());
      this.c = null;
    }
  }
  
  public OrientationProvider a(int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    if (paramSensorManager == null) {
      return null;
    }
    if (paramInt == 1) {}
    try
    {
      localObject1 = new TypeOrientationProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
    }
    catch (OrientationProviderNotFound localOrientationProviderNotFound1)
    {
      Object localObject1;
      label30:
      Object localObject3;
      break label30;
    }
    localObject1 = null;
    localObject3 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject3 = new RotationVectorProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
    }
    catch (OrientationProviderNotFound localOrientationProviderNotFound2)
    {
      label61:
      break label61;
    }
    localObject3 = null;
    localObject1 = localObject3;
    if (localObject3 == null) {}
    label146:
    label177:
    label308:
    try
    {
      localObject1 = new AccelMagnetProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
    }
    catch (OrientationProviderNotFound paramSensorManager)
    {
      label208:
      label339:
      label367:
      for (;;)
      {
        label115:
        if ((paramInt != 2) && (paramInt != 3)) {
          if ((paramInt != 4) && (paramInt != 5)) {
            Object localObject2 = null;
          }
        }
      }
    }
    if (paramInt == 0)
    {
      try
      {
        localObject3 = new RotationGameVectorProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound3)
      {
        label277:
        break label115;
      }
      localObject3 = null;
      localObject1 = localObject3;
      if (localObject3 == null) {}
      try
      {
        localObject1 = new RotationVectorProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound4)
      {
        break label146;
      }
      localObject1 = null;
      localObject3 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject3 = new TypeOrientationProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound5)
      {
        Object localObject4;
        break label177;
      }
      localObject3 = null;
      localObject4 = localObject3;
      if (localObject3 == null) {}
      try
      {
        localObject4 = new AccelMagnetGyroProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound6)
      {
        break label208;
      }
      localObject4 = null;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        localObject1 = new AccelProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
        break label367;
        localObject1 = new TypeAccOrientationProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      try
      {
        localObject3 = new RotationVectorProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound7)
      {
        break label277;
      }
      localObject3 = null;
      localObject1 = localObject3;
      if (localObject3 == null) {}
      try
      {
        localObject1 = new TypeOrientationProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound8)
      {
        break label308;
      }
      localObject1 = null;
      localObject3 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject3 = new AccelMagnetGyroProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound9)
      {
        break label339;
      }
      localObject3 = null;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new AccelMagnetProvider(this.b, paramInt, paramSensorManager, paramOnSensorChangeListener);
      }
      if (localObject1 == null) {
        paramSensorManager = "null";
      } else {
        paramSensorManager = localObject1.getClass().getSimpleName();
      }
      paramOnSensorChangeListener = new StringBuilder();
      paramOnSensorChangeListener.append("getProvider:");
      paramOnSensorChangeListener.append(paramSensorManager);
      QLog.d("ARSensorManager", 1, paramOnSensorChangeListener.toString());
      return localObject1;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = a(2);
    boolean bool1 = true;
    if (bool2)
    {
      if (a(1)) {
        return bool1;
      }
      if (a(4)) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    SensorManager localSensorManager = this.c;
    boolean bool = false;
    if (localSensorManager == null) {
      return false;
    }
    if (localSensorManager.getDefaultSensor(paramInt) != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    if (!this.e)
    {
      this.d = a(this.a, this.c, paramOnSensorChangeListener);
      paramOnSensorChangeListener = this.d;
      if (paramOnSensorChangeListener != null)
      {
        paramOnSensorChangeListener.b();
        this.e = true;
      }
      else
      {
        this.e = false;
      }
    }
    return this.e;
  }
  
  public boolean a(ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener, int paramInt)
  {
    if (!this.e)
    {
      this.d = a(this.a, this.c, paramOnSensorChangeListener);
      if (this.d != null)
      {
        int i = paramInt;
        if (paramInt != 2)
        {
          i = paramInt;
          if (paramInt != 1)
          {
            i = paramInt;
            if (paramInt != 0)
            {
              i = paramInt;
              if (paramInt != 3) {
                i = 2;
              }
            }
          }
        }
        this.d.a(i);
        this.e = true;
      }
      else
      {
        this.e = false;
      }
    }
    return this.e;
  }
  
  public void b()
  {
    if (this.e)
    {
      this.e = false;
      OrientationProvider localOrientationProvider = this.d;
      if (localOrientationProvider != null) {
        localOrientationProvider.c();
      }
    }
  }
  
  public boolean c()
  {
    Object localObject = this.c;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    int i;
    if (this.a == 5) {
      i = 15;
    } else {
      i = 11;
    }
    localObject = ((SensorManager)localObject).getDefaultSensor(i);
    boolean bool1 = bool2;
    if (this.c.getDefaultSensor(4) != null)
    {
      bool1 = bool2;
      if (localObject != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.ARSensorManager
 * JD-Core Version:    0.7.0.1
 */