package com.tencent.aelight.camera.ae.album.nocropper;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class CropInfo
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final boolean e;
  public final int f;
  public final int g;
  public final int h;
  
  public CropInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramBoolean;
    this.g = paramInt5;
    this.f = paramInt6;
    this.h = paramInt7;
  }
  
  public static CropInfo a(Bitmap paramBitmap, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return new CropInfo(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public static CropInfo a(Rect paramRect, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return new CropInfo(paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CropConfig{x=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", addPadding=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", verticalPadding=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", horizontalPadding=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.CropInfo
 * JD-Core Version:    0.7.0.1
 */