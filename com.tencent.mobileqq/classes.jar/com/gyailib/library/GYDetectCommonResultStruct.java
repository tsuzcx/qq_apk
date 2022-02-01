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
  
  public void setItem(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, String paramString1, String paramString2, float paramFloat, int paramInt3)
  {
    GYDetectCommonItemParams[] arrayOfGYDetectCommonItemParams = this.items;
    if (arrayOfGYDetectCommonItemParams != null)
    {
      if (paramInt1 >= arrayOfGYDetectCommonItemParams.length) {
        return;
      }
      arrayOfGYDetectCommonItemParams[paramInt1].pointsCount = paramInt2;
      arrayOfGYDetectCommonItemParams[paramInt1].pointX = paramArrayOfFloat1;
      arrayOfGYDetectCommonItemParams[paramInt1].pointY = paramArrayOfFloat2;
      arrayOfGYDetectCommonItemParams[paramInt1].heightMap = paramArrayOfFloat3;
      arrayOfGYDetectCommonItemParams[paramInt1].eulerAngle = paramArrayOfFloat4;
      arrayOfGYDetectCommonItemParams[paramInt1].classifyName = paramString1;
      arrayOfGYDetectCommonItemParams[paramInt1].classifyType = paramString2;
      arrayOfGYDetectCommonItemParams[paramInt1].classifyConfidence = paramFloat;
      arrayOfGYDetectCommonItemParams[paramInt1].index = paramInt3;
    }
  }
  
  public void setItemBase(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt3, int paramInt4)
  {
    GYDetectCommonItemParams[] arrayOfGYDetectCommonItemParams = this.items;
    if (arrayOfGYDetectCommonItemParams != null)
    {
      if (paramInt1 >= arrayOfGYDetectCommonItemParams.length) {
        return;
      }
      arrayOfGYDetectCommonItemParams[paramInt1].itemId = paramInt2;
      arrayOfGYDetectCommonItemParams[paramInt1].frameX = paramFloat1;
      arrayOfGYDetectCommonItemParams[paramInt1].frameY = paramFloat2;
      arrayOfGYDetectCommonItemParams[paramInt1].frameW = paramFloat3;
      arrayOfGYDetectCommonItemParams[paramInt1].frameH = paramFloat4;
      arrayOfGYDetectCommonItemParams[paramInt1].frameConfidence = paramFloat5;
      arrayOfGYDetectCommonItemParams[paramInt1].confidence = paramFloat6;
      arrayOfGYDetectCommonItemParams[paramInt1].age = paramInt3;
      arrayOfGYDetectCommonItemParams[paramInt1].gender = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYDetectCommonResultStruct
 * JD-Core Version:    0.7.0.1
 */