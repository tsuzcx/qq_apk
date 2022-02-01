package com.gyailib.library;

public class GYARDetectResult
{
  float[] cameraModelMatrix;
  float[] projectionMatrix;
  
  public void setData(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.cameraModelMatrix = paramArrayOfFloat1;
    this.projectionMatrix = paramArrayOfFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.GYARDetectResult
 * JD-Core Version:    0.7.0.1
 */