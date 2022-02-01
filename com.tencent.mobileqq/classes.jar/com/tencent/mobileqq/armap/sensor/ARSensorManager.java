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
  private int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private OrientationProvider jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ARSensorManager(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor"));
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("ARSensorManager", 1, "ARSensorManager getSystemService error:" + paramContext.getMessage());
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    }
  }
  
  public OrientationProvider a(int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    if (paramSensorManager == null) {
      return null;
    }
    if (paramInt == 1) {
      if (0 != 0) {
        break label515;
      }
    }
    for (;;)
    {
      Object localObject7;
      label89:
      Object localObject3;
      try
      {
        localObject1 = new TypeOrientationProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
        localObject7 = localObject1;
        if (localObject1 != null) {}
      }
      catch (OrientationProviderNotFound localOrientationProviderNotFound2)
      {
        try
        {
          localObject7 = new RotationVectorProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
          localObject1 = localObject7;
          if (localObject7 != null) {}
        }
        catch (OrientationProviderNotFound localOrientationProviderNotFound2)
        {
          try
          {
            Object localObject1 = new AccelMagnetProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
            if (localObject1 != null) {
              break label485;
            }
            paramSensorManager = "null";
            QLog.d("ARSensorManager", 1, "getProvider:" + paramSensorManager);
            return localObject1;
            localOrientationProviderNotFound1 = localOrientationProviderNotFound1;
            Object localObject2 = null;
            continue;
            localOrientationProviderNotFound2 = localOrientationProviderNotFound2;
            localObject7 = null;
          }
          catch (OrientationProviderNotFound paramSensorManager)
          {
            localObject3 = null;
            continue;
          }
        }
      }
      if (paramInt == 0) {
        if (0 != 0) {
          break label509;
        }
      }
      for (;;)
      {
        try
        {
          localObject7 = new RotationGameVectorProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
          localObject3 = localObject7;
          if (localObject7 != null) {}
        }
        catch (OrientationProviderNotFound localOrientationProviderNotFound5)
        {
          try
          {
            localObject3 = new RotationVectorProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
            localObject7 = localObject3;
            if (localObject3 != null) {}
          }
          catch (OrientationProviderNotFound localOrientationProviderNotFound5)
          {
            try
            {
              localObject7 = new TypeOrientationProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
              localObject8 = localObject7;
              if (localObject7 != null) {}
            }
            catch (OrientationProviderNotFound localOrientationProviderNotFound5)
            {
              try
              {
                for (;;)
                {
                  localObject8 = new AccelMagnetGyroProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
                  localObject3 = localObject8;
                  if (localObject8 != null) {
                    break;
                  }
                  try
                  {
                    localObject3 = new AccelProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
                  }
                  catch (OrientationProviderNotFound paramSensorManager)
                  {
                    localObject3 = null;
                  }
                }
                break;
                localOrientationProviderNotFound3 = localOrientationProviderNotFound3;
                localObject7 = null;
                continue;
                localOrientationProviderNotFound4 = localOrientationProviderNotFound4;
                Object localObject4 = null;
                continue;
                localOrientationProviderNotFound5 = localOrientationProviderNotFound5;
                localObject7 = null;
              }
              catch (OrientationProviderNotFound localOrientationProviderNotFound6)
              {
                Object localObject8 = null;
                continue;
              }
            }
          }
        }
        if ((paramInt == 2) || (paramInt == 3)) {
          if (0 != 0) {
            break label503;
          }
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject7 = new RotationVectorProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
              localObject5 = localObject7;
              if (localObject7 != null) {}
            }
            catch (OrientationProviderNotFound localOrientationProviderNotFound8)
            {
              try
              {
                localObject5 = new TypeOrientationProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
                localObject7 = localObject5;
                if (localObject5 != null) {}
              }
              catch (OrientationProviderNotFound localOrientationProviderNotFound8)
              {
                try
                {
                  for (;;)
                  {
                    localObject7 = new AccelMagnetGyroProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
                    Object localObject5 = localObject7;
                    if (localObject7 != null) {
                      break;
                    }
                    try
                    {
                      localObject5 = new AccelMagnetProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
                    }
                    catch (OrientationProviderNotFound paramSensorManager)
                    {
                      localObject5 = null;
                    }
                  }
                  break;
                  localOrientationProviderNotFound7 = localOrientationProviderNotFound7;
                  localObject7 = null;
                  continue;
                  localOrientationProviderNotFound8 = localOrientationProviderNotFound8;
                  Object localObject6 = null;
                }
                catch (OrientationProviderNotFound localOrientationProviderNotFound9)
                {
                  localObject7 = null;
                  continue;
                }
              }
            }
            if (((paramInt != 4) && (paramInt != 5)) || (0 != 0)) {
              break label497;
            }
            try
            {
              localTypeAccOrientationProvider = new TypeAccOrientationProvider(this.jdField_a_of_type_AndroidContentContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
            }
            catch (OrientationProviderNotFound paramSensorManager)
            {
              localTypeAccOrientationProvider = null;
            }
          }
          break;
          label485:
          paramSensorManager = localTypeAccOrientationProvider.getClass().getSimpleName();
          break label89;
          label497:
          localTypeAccOrientationProvider = null;
          break;
          label503:
          localObject7 = null;
        }
        label509:
        localObject7 = null;
      }
      label515:
      TypeAccOrientationProvider localTypeAccOrientationProvider = null;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider.c();
      }
    }
  }
  
  public boolean a()
  {
    return (a(2)) && ((a(1)) || (a(4)));
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {}
    while (this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(paramInt) == null) {
      return false;
    }
    return true;
  }
  
  public boolean a(ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidHardwareSensorManager, paramOnSensorChangeListener);
      if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider == null) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider.b();
    }
    label48:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false) {
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a(ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidHardwareSensorManager, paramOnSensorChangeListener);
      if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider == null) {
        break label78;
      }
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
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorProviderOrientationProvider.a(i);
    }
    label78:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false) {
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      i = 15;
      localObject = ((SensorManager)localObject).getDefaultSensor(i);
      if ((this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4) == null) || (localObject == null)) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i = 11;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.ARSensorManager
 * JD-Core Version:    0.7.0.1
 */