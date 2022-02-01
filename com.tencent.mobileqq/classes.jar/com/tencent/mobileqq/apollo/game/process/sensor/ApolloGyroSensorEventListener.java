package com.tencent.mobileqq.apollo.game.process.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ApolloGyroSensorEventListener
  implements SensorEventListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public ApolloGyroSensorEventListener(Context paramContext, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloRender", 1, "SensorManager is null");
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 1, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
    localObject = ((SensorManager)localObject).getDefaultSensor(4);
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloRender", 1, "Sensor gyro is null");
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 2, "cs.xy_device_gyro_sensor_start.local", "{}");
      return;
    }
    boolean bool = this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, (Sensor)localObject, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    localObject = ApolloCmdChannel.getInstance();
    long l = this.jdField_a_of_type_Long;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 5;
    }
    ((ApolloCmdChannel)localObject).callbackFromRequest(l, i, "cs.xy_device_gyro_sensor_start.local", "{}");
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager == null)
    {
      QLog.e("[cmshow]ApolloRender", 1, "SensorManager is null");
      return;
    }
    localSensorManager.unregisterListener(this);
    this.jdField_a_of_type_Boolean = false;
    QLog.e("[cmshow]ApolloRender", 1, "Sensor unRegister");
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      paramSensorEvent = paramSensorEvent.values;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("gyroX", paramSensorEvent[0]);
      localJSONObject.put("gyroY", paramSensorEvent[1]);
      localJSONObject.put("gyroZ", paramSensorEvent[2]);
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_device_gyro_sensor_scope_update.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramSensorEvent)
    {
      QLog.e("[cmshow]ApolloRender", 1, paramSensorEvent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.sensor.ApolloGyroSensorEventListener
 * JD-Core Version:    0.7.0.1
 */