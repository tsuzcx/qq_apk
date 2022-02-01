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
  private double jdField_a_of_type_Double = 0.0D;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Sensor jdField_a_of_type_AndroidHardwareSensor = null;
  private SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener = null;
  private ArkAppEventObserverManager.ArkConnectionHandler jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ArkConnectionHandler = null;
  private ArkAppEventObserverManager.ConnectionCallback jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ConnectionCallback = null;
  private ArkAppEventObserverManager.GetCurrentPositionCallback jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$GetCurrentPositionCallback = null;
  private ArkAppEventObserverManager.MotionCallback jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$MotionCallback = null;
  private ArkAppEventObserverManager.OrientationCallback jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$OrientationCallback = null;
  private ArkAppEventObserverManager.PositionCallback jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback = null;
  private SosoInterfaceOnLocationListener jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private double jdField_b_of_type_Double = 0.0D;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = 0L;
  private Sensor jdField_b_of_type_AndroidHardwareSensor = null;
  private String jdField_b_of_type_JavaLangString = null;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[3];
  private float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long = 0L;
  private long d = 0L;
  private long e = 0L;
  
  public ArkAppEventObserverManager(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new ArkAppEventObserverManager.ArkSensorEventListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new ArkAppEventObserverManager.1(this, 3, true, true, 0L, true, true, "ArkAppEventObserverManager");
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    long l = System.currentTimeMillis();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.jdField_a_of_type_JavaLangString, new ArkAppEventObserverManager.2(this, paramSensorEvent, l));
  }
  
  private void b(SensorEvent paramSensorEvent)
  {
    long l = System.currentTimeMillis();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.jdField_a_of_type_JavaLangString, new ArkAppEventObserverManager.3(this, l, paramSensorEvent));
  }
  
  AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
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
    long l;
    Object localObject;
    if ((paramObserverCallback instanceof ArkAppEventObserverManager.MotionCallback))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "attachEvent MotionCallback");
      }
      l = this.jdField_a_of_type_Long;
      if (l != 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$MotionCallback;
        if (localObject != null) {
          ((ArkAppEventObserverManager.MotionCallback)localObject).a(l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$MotionCallback = ((ArkAppEventObserverManager.MotionCallback)paramObserverCallback);
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_AndroidHardwareSensor == null)
      {
        paramObserverCallback = (SensorManager)a().getApp().getSystemService("sensor");
        this.jdField_a_of_type_AndroidHardwareSensor = paramObserverCallback.getDefaultSensor(1);
        localObject = this.jdField_a_of_type_AndroidHardwareSensor;
        if (localObject != null)
        {
          paramObserverCallback.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, (Sensor)localObject, 1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "mMotionSensor is NULL");
        }
        this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$MotionCallback.a(false, 0.0F, 0.0F, 0.0F);
      }
    }
    else if ((paramObserverCallback instanceof ArkAppEventObserverManager.OrientationCallback))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "attachEvent OrientationCallback");
      }
      l = this.jdField_b_of_type_Long;
      if (l != 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$OrientationCallback;
        if (localObject != null) {
          ((ArkAppEventObserverManager.OrientationCallback)localObject).a(l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$OrientationCallback = ((ArkAppEventObserverManager.OrientationCallback)paramObserverCallback);
      this.jdField_b_of_type_Long = paramLong;
      if (this.jdField_b_of_type_AndroidHardwareSensor == null)
      {
        paramObserverCallback = (SensorManager)a().getApp().getSystemService("sensor");
        this.jdField_b_of_type_AndroidHardwareSensor = paramObserverCallback.getDefaultSensor(3);
        paramObserverCallback.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor, 1);
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
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback);
          ((StringBuilder)localObject).append(", mPositionCallbackId=");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
          QLog.d("ArkAppEventObserverManager", 2, ((StringBuilder)localObject).toString());
        }
        l = this.jdField_c_of_type_Long;
        if (l != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback;
          if (localObject != null) {
            ((ArkAppEventObserverManager.PositionCallback)localObject).a(l);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback = ((ArkAppEventObserverManager.PositionCallback)paramObserverCallback);
        this.jdField_c_of_type_Long = paramLong;
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
        return;
      }
      if ((paramObserverCallback instanceof ArkAppEventObserverManager.ConnectionCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "attachEvent ConnectionCallback");
        }
        l = this.d;
        if (l != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ConnectionCallback;
          if (localObject != null) {
            ((ArkAppEventObserverManager.ConnectionCallback)localObject).a(l);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ConnectionCallback = ((ArkAppEventObserverManager.ConnectionCallback)paramObserverCallback);
        this.d = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ArkConnectionHandler == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ArkConnectionHandler = new ArkAppEventObserverManager.ArkConnectionHandler(this);
          AppNetConnInfo.registerConnectionChangeReceiver(a().getApp(), this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ArkConnectionHandler);
        }
      }
      else if ((paramObserverCallback instanceof ArkAppEventObserverManager.GetCurrentPositionCallback))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "attachEvent GetCurrentPositionCallback");
        }
        l = this.e;
        if (l != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$GetCurrentPositionCallback;
          if (localObject != null) {
            ((ArkAppEventObserverManager.GetCurrentPositionCallback)localObject).a(l);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$GetCurrentPositionCallback = ((ArkAppEventObserverManager.GetCurrentPositionCallback)paramObserverCallback);
        this.e = paramLong;
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
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
    long l;
    if ("Motion".equals(paramString))
    {
      if (this.jdField_a_of_type_AndroidHardwareSensor != null)
      {
        ((SensorManager)a().getApp().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor);
        this.jdField_a_of_type_AndroidHardwareSensor = null;
      }
      l = this.jdField_a_of_type_Long;
      if (l != 0L)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$MotionCallback;
        if (paramString != null) {
          paramString.a(l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$MotionCallback = null;
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    if ("Orientation".equals(paramString))
    {
      if (this.jdField_b_of_type_AndroidHardwareSensor != null)
      {
        ((SensorManager)a().getApp().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor);
        this.jdField_b_of_type_AndroidHardwareSensor = null;
      }
      l = this.jdField_b_of_type_Long;
      if (l != 0L)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$OrientationCallback;
        if (paramString != null) {
          paramString.a(l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$OrientationCallback = null;
      this.jdField_b_of_type_Long = 0L;
      return;
    }
    if ("Position".equals(paramString))
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("detachEvent PositionCallback mPositionCallback=");
        paramString.append(this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback);
        paramString.append(", mPositionCallbackId=");
        paramString.append(this.jdField_c_of_type_Long);
        QLog.d("ArkAppEventObserverManager", 2, paramString.toString());
      }
      l = this.jdField_c_of_type_Long;
      if (l != 0L)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback;
        if (paramString != null) {
          paramString.a(l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$PositionCallback = null;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
      return;
    }
    if ("ConnectionTypeChange".equals(paramString))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ArkConnectionHandler;
      if (paramString != null)
      {
        AppNetConnInfo.unregisterNetInfoHandler(paramString);
        this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ArkConnectionHandler = null;
      }
      l = this.d;
      if (l != 0L)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ConnectionCallback;
        if (paramString != null) {
          paramString.a(l);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager$ConnectionCallback = null;
      this.d = 0L;
      this.jdField_b_of_type_JavaLangString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager
 * JD-Core Version:    0.7.0.1
 */