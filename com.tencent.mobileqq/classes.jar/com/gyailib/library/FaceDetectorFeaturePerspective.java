package com.gyailib.library;

public class FaceDetectorFeaturePerspective
{
  public float[] facePoints3dX;
  public float[] facePoints3dY;
  public float[] facePoints3dZ;
  public float pitch;
  public float roll;
  public float[] transform;
  public float yaw;
  
  public FaceDetectorFeaturePerspective(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat4)
  {
    this.facePoints3dX = paramArrayOfFloat1;
    this.facePoints3dY = paramArrayOfFloat2;
    this.facePoints3dZ = paramArrayOfFloat3;
    this.pitch = paramFloat1;
    this.yaw = paramFloat2;
    this.roll = paramFloat3;
    this.transform = this.transform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.FaceDetectorFeaturePerspective
 * JD-Core Version:    0.7.0.1
 */