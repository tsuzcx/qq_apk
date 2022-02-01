package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;

class SensorTrackManager$1
  extends SimpleSensorChangeListener
{
  SensorTrackManager$1(SensorTrackManager paramSensorTrackManager) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (SensorTrackManager.a(this.a) != null) {
      SensorTrackManager.a(this.a).a(paramArrayOfFloat);
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (SensorTrackManager.a(this.a) != null) {
      SensorTrackManager.a(this.a).a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.1
 * JD-Core Version:    0.7.0.1
 */