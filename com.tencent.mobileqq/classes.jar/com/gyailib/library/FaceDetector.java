package com.gyailib.library;

public class FaceDetector
{
  public FaceDetectorFeature[] faces;
  
  public void initStruct(int paramInt)
  {
    this.faces = new FaceDetectorFeature[paramInt];
  }
  
  public void setFaceDetectFeature(int paramInt, FaceDetectorFeature paramFaceDetectorFeature)
  {
    if (paramFaceDetectorFeature == null) {
      return;
    }
    this.faces[paramInt] = paramFaceDetectorFeature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.FaceDetector
 * JD-Core Version:    0.7.0.1
 */