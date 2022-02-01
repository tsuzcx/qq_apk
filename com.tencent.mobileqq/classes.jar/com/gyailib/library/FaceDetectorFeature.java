package com.gyailib.library;

public class FaceDetectorFeature
{
  public int boundsH;
  public int boundsW;
  public int boundsX;
  public int boundsY;
  public float[] fFeatures;
  public float[] fFeaturesYoutuOriginX;
  public float[] fFeaturesYoutuOriginY;
  Face3DResult facekit3DResult;
  FaceDetectorFeaturePerspective featurePerspective;
  public boolean hasOutline;
  public float imageHeight;
  public float imageWidth;
  public int leBoundsH;
  public int leBoundsW;
  public int leBoundsX;
  public int leBoundsY;
  public int mouthBoundsH;
  public int mouthBoundsW;
  public int mouthBoundsX;
  public int mouthBoundsY;
  public float pitch;
  public float[] pointsVisibility;
  public int reBoundsH;
  public int reBoundsW;
  public int reBoundsX;
  public int reBoundsY;
  public float roll;
  public int traceId;
  public float yaw;
  public float[] youtuVisibility;
  
  public FaceDetectorFeature(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, boolean paramBoolean, float paramFloat3, float paramFloat4, float paramFloat5, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, FaceDetectorFeaturePerspective paramFaceDetectorFeaturePerspective, Face3DResult paramFace3DResult)
  {
    this.traceId = paramInt1;
    this.imageWidth = paramFloat1;
    this.imageHeight = paramFloat2;
    this.boundsX = paramInt2;
    this.boundsY = paramInt3;
    this.boundsW = paramInt4;
    this.boundsH = paramInt5;
    this.leBoundsX = paramInt6;
    this.leBoundsY = paramInt7;
    this.leBoundsW = paramInt8;
    this.leBoundsH = paramInt9;
    this.reBoundsX = paramInt10;
    this.reBoundsY = paramInt11;
    this.reBoundsW = paramInt12;
    this.reBoundsH = paramInt13;
    this.mouthBoundsX = paramInt14;
    this.mouthBoundsY = paramInt15;
    this.mouthBoundsW = paramInt16;
    this.mouthBoundsH = paramInt17;
    this.hasOutline = paramBoolean;
    this.pitch = paramFloat3;
    this.yaw = paramFloat4;
    this.roll = paramFloat5;
    this.fFeaturesYoutuOriginX = paramArrayOfFloat1;
    this.fFeaturesYoutuOriginY = paramArrayOfFloat2;
    this.youtuVisibility = paramArrayOfFloat3;
    this.pointsVisibility = paramArrayOfFloat4;
    this.fFeatures = paramArrayOfFloat5;
    this.featurePerspective = paramFaceDetectorFeaturePerspective;
    this.facekit3DResult = paramFace3DResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.FaceDetectorFeature
 * JD-Core Version:    0.7.0.1
 */