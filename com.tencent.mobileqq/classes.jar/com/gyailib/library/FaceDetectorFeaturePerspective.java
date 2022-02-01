package com.gyailib.library;

public class FaceDetectorFeaturePerspective
{
  public float[] face_points_3d_x;
  public float[] face_points_3d_y;
  public float[] face_points_3d_z;
  public float pitch;
  public float roll;
  public float[] transform;
  public float yaw;
  
  public FaceDetectorFeaturePerspective(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat4)
  {
    this.face_points_3d_x = paramArrayOfFloat1;
    this.face_points_3d_y = paramArrayOfFloat2;
    this.face_points_3d_z = paramArrayOfFloat3;
    this.pitch = paramFloat1;
    this.yaw = paramFloat2;
    this.roll = paramFloat3;
    this.transform = this.transform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.FaceDetectorFeaturePerspective
 * JD-Core Version:    0.7.0.1
 */