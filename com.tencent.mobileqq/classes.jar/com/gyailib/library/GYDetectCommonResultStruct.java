package com.gyailib.library;

public class GYDetectCommonResultStruct
{
  public float height;
  public GYDetectCommonItemParams[] items;
  public float width;
  
  public void initStruct(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.items = new GYDetectCommonItemParams[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      this.items[i] = new GYDetectCommonItemParams();
      i += 1;
    }
  }
  
  public void setItem(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, boolean paramBoolean, String paramString, float paramFloat7, int paramInt4, float paramFloat8)
  {
    if ((this.items == null) || (paramInt1 >= this.items.length)) {
      return;
    }
    this.items[paramInt1].itemId = paramInt2;
    this.items[paramInt1].frame_x = paramFloat1;
    this.items[paramInt1].frame_y = paramFloat2;
    this.items[paramInt1].frame_w = paramFloat3;
    this.items[paramInt1].frame_h = paramFloat4;
    this.items[paramInt1].frame_confidence = paramFloat5;
    this.items[paramInt1].confidence = paramFloat6;
    this.items[paramInt1].pointsCount = paramInt3;
    this.items[paramInt1].point_x = paramArrayOfFloat1;
    this.items[paramInt1].point_y = paramArrayOfFloat2;
    this.items[paramInt1].heightMap = paramArrayOfFloat3;
    this.items[paramInt1].eulerAngle = paramArrayOfFloat4;
    this.items[paramInt1].keep = paramBoolean;
    this.items[paramInt1].classifyName = paramString;
    this.items[paramInt1].classifyConfidence = paramFloat7;
    this.items[paramInt1].index = paramInt4;
    this.items[paramInt1].face_classify = paramFloat8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYDetectCommonResultStruct
 * JD-Core Version:    0.7.0.1
 */