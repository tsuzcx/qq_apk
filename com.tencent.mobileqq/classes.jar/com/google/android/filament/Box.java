package com.google.android.filament;

import android.support.annotation.NonNull;
import android.support.annotation.Size;

public class Box
{
  private final float[] mCenter = new float[3];
  private final float[] mHalfExtent = new float[3];
  
  public Box() {}
  
  public Box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.mCenter[0] = paramFloat1;
    this.mCenter[1] = paramFloat2;
    this.mCenter[2] = paramFloat3;
    this.mHalfExtent[0] = paramFloat4;
    this.mHalfExtent[1] = paramFloat5;
    this.mHalfExtent[2] = paramFloat6;
  }
  
  public Box(@NonNull @Size(min=3L) float[] paramArrayOfFloat1, @NonNull @Size(min=3L) float[] paramArrayOfFloat2)
  {
    this.mCenter[0] = paramArrayOfFloat1[0];
    this.mCenter[1] = paramArrayOfFloat1[1];
    this.mCenter[2] = paramArrayOfFloat1[2];
    this.mHalfExtent[0] = paramArrayOfFloat2[0];
    this.mHalfExtent[1] = paramArrayOfFloat2[1];
    this.mHalfExtent[2] = paramArrayOfFloat2[2];
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getCenter()
  {
    return this.mCenter;
  }
  
  @NonNull
  @Size(min=3L)
  public float[] getHalfExtent()
  {
    return this.mHalfExtent;
  }
  
  public void setCenter(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mCenter[0] = paramFloat1;
    this.mCenter[1] = paramFloat2;
    this.mCenter[2] = paramFloat3;
  }
  
  public void setHalfExtent(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mHalfExtent[0] = paramFloat1;
    this.mHalfExtent[1] = paramFloat2;
    this.mHalfExtent[2] = paramFloat3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Box
 * JD-Core Version:    0.7.0.1
 */