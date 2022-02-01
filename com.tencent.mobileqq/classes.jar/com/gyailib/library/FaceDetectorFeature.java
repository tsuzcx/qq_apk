package com.gyailib.library;

public class FaceDetectorFeature
{
  public int bounds_h;
  public int bounds_w;
  public int bounds_x;
  public int bounds_y;
  public float[] f_features;
  public float[] f_features_youtu_origin_x;
  public float[] f_features_youtu_origin_y;
  Face3DResult facekit3DResult;
  FaceDetectorFeaturePerspective feature_perspective_;
  public boolean hasOutline;
  public float image_height;
  public float image_width;
  public int leBounds_h;
  public int leBounds_w;
  public int leBounds_x;
  public int leBounds_y;
  public int mouthBounds_h;
  public int mouthBounds_w;
  public int mouthBounds_x;
  public int mouthBounds_y;
  public float pitch;
  public float[] pointsVisibility;
  public int reBounds_h;
  public int reBounds_w;
  public int reBounds_x;
  public int reBounds_y;
  public float roll;
  public int trace_id;
  public float yaw;
  public float[] youtu_visibility;
  
  public FaceDetectorFeature(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, boolean paramBoolean, float paramFloat3, float paramFloat4, float paramFloat5, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, FaceDetectorFeaturePerspective paramFaceDetectorFeaturePerspective, Face3DResult paramFace3DResult)
  {
    this.trace_id = paramInt1;
    this.image_width = paramFloat1;
    this.image_height = paramFloat2;
    this.bounds_x = paramInt2;
    this.bounds_y = paramInt3;
    this.bounds_w = paramInt4;
    this.bounds_h = paramInt5;
    this.leBounds_x = paramInt6;
    this.leBounds_y = paramInt7;
    this.leBounds_w = paramInt8;
    this.leBounds_h = paramInt9;
    this.reBounds_x = paramInt10;
    this.reBounds_y = paramInt11;
    this.reBounds_w = paramInt12;
    this.reBounds_h = paramInt13;
    this.mouthBounds_x = paramInt14;
    this.mouthBounds_y = paramInt15;
    this.mouthBounds_w = paramInt16;
    this.mouthBounds_h = paramInt17;
    this.hasOutline = paramBoolean;
    this.pitch = paramFloat3;
    this.yaw = paramFloat4;
    this.roll = paramFloat5;
    this.f_features_youtu_origin_x = paramArrayOfFloat1;
    this.f_features_youtu_origin_y = paramArrayOfFloat2;
    this.youtu_visibility = paramArrayOfFloat3;
    this.pointsVisibility = paramArrayOfFloat4;
    this.f_features = paramArrayOfFloat5;
    this.feature_perspective_ = paramFaceDetectorFeaturePerspective;
    this.facekit3DResult = paramFace3DResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.FaceDetectorFeature
 * JD-Core Version:    0.7.0.1
 */