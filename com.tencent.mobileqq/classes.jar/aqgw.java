public abstract interface aqgw
{
  public abstract void onRotationUpdateOriginal(float[] paramArrayOfFloat);
  
  public abstract void onRotationUpdateQuaternion(float[] paramArrayOfFloat);
  
  public abstract void onSensorSupport(int paramInt, boolean paramBoolean);
  
  public abstract void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
  
  public abstract void updateAzimuth(float paramFloat);
  
  public abstract void updateGyroscope(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong);
  
  public abstract void updatePitch(float paramFloat);
  
  public abstract void updateRoll(float paramFloat);
  
  public abstract void updateRotation(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void updateSensor(float paramFloat1, float paramFloat2, float paramFloat3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgw
 * JD-Core Version:    0.7.0.1
 */