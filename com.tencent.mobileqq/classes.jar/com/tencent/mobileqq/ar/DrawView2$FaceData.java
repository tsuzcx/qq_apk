package com.tencent.mobileqq.ar;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;

public class DrawView2$FaceData
{
  public float[] a;
  public Rect b;
  public RectF c;
  public String d;
  public String e;
  public int f;
  public String g;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public boolean m;
  public boolean n;
  public float o;
  public String p;
  public boolean q;
  public boolean r;
  
  public static RectF a(Rect paramRect, float[] paramArrayOfFloat)
  {
    if ((paramRect != null) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 180))
    {
      paramArrayOfFloat = (float[])paramArrayOfFloat.clone();
      float[] arrayOfFloat1 = new float[2];
      float[] arrayOfFloat2 = new float[2];
      float[] arrayOfFloat3 = new float[2];
      float[] arrayOfFloat4 = new float[2];
      arrayOfFloat1[0] = paramArrayOfFloat[12];
      arrayOfFloat1[1] = paramArrayOfFloat[13];
      arrayOfFloat2[0] = paramArrayOfFloat[28];
      arrayOfFloat2[1] = paramArrayOfFloat[29];
      arrayOfFloat3[0] = paramArrayOfFloat[64];
      arrayOfFloat3[1] = paramArrayOfFloat[65];
      arrayOfFloat4[0] = (arrayOfFloat1[0] + arrayOfFloat2[0] - arrayOfFloat3[0]);
      arrayOfFloat4[1] = (arrayOfFloat1[1] + arrayOfFloat2[1] - arrayOfFloat3[1]);
      float f2 = Math.min(paramRect.left, arrayOfFloat4[0]);
      float f3 = Math.max(paramRect.right, arrayOfFloat4[0]);
      float f4 = Math.min(paramRect.top, arrayOfFloat4[1]);
      float f5 = Math.max(paramRect.bottom, arrayOfFloat4[1]);
      float f1 = DrawView2.e / DrawView2.f;
      float f6 = Math.max(DrawView2.c, DrawView2.d);
      float f7 = Math.min(DrawView2.c, DrawView2.d);
      if (f1 > f7 / f6) {
        f1 = DrawView2.e / f7;
      } else {
        f1 = DrawView2.f / f6;
      }
      float f8 = f7 * f1;
      f7 = (f8 - DrawView2.e) / 2.0F;
      f8 = (f8 - DrawView2.e) / 2.0F;
      f6 *= f1;
      paramRect = new RectF(f2 * f1 - f7, f4 * f1 - (f6 - DrawView2.f) / 2.0F, f3 * f1 - f8, f5 * f1 - (f6 - DrawView2.f) / 2.0F);
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append("mapFaceRect2Screen  result = ");
        paramArrayOfFloat.append(paramRect.toString());
        QLog.d("DrawView", 2, paramArrayOfFloat.toString());
      }
      return paramRect;
    }
    return null;
  }
  
  public static RectF a(RectF paramRectF)
  {
    if (paramRectF == null) {
      return null;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("faceRect  result = ");
      localStringBuilder.append(paramRectF.toString());
      QLog.d("DrawView", 2, localStringBuilder.toString());
    }
    if ((paramRectF.left == 0.0F) && (paramRectF.top == 0.0F) && (paramRectF.right == 0.0F)) {
      return new RectF(DrawView2.e / 2 - 210, DrawView2.f / 2 - 210, DrawView2.e / 2 + 210, DrawView2.f / 2 + 210);
    }
    float f3 = paramRectF.left;
    float f4 = paramRectF.right;
    float f1 = paramRectF.top;
    float f2 = paramRectF.bottom;
    f3 = (f3 + f4) / 2.0F;
    f2 = (f1 + f2) / 2.0F;
    f1 = f3 * (DrawView2.e / 480);
    f2 *= DrawView2.f / 856;
    f4 = f1 - 210.0F;
    float f6 = f2 - 210.0F;
    float f7 = f1 + 210.0F;
    float f5 = f2 + 210.0F;
    if (QLog.isColorLevel())
    {
      paramRectF = new StringBuilder();
      paramRectF.append("mapMigObjectRect2Screen1  result = ");
      paramRectF.append(f4);
      paramRectF.append("   ：");
      paramRectF.append(f6);
      paramRectF.append("  ：");
      paramRectF.append(f7);
      paramRectF.append("  ：");
      paramRectF.append(f5);
      QLog.d("DrawView", 2, paramRectF.toString());
    }
    f3 = 40.0F;
    f2 = f7;
    f1 = f4;
    if (f4 < 40.0F)
    {
      f2 = f7 - f4 + 40.0F;
      f1 = 40.0F;
    }
    if (f6 < 40.0F)
    {
      f5 = f5 - f6 + 40.0F;
      f6 = f3;
    }
    f4 = f2;
    f3 = f1;
    if (f2 > DrawView2.e - 40)
    {
      f3 = DrawView2.e - 40 - (f2 - f1);
      f4 = DrawView2.e - 40;
    }
    f2 = f5;
    f1 = f6;
    if (f5 > DrawView2.f - 40)
    {
      f1 = DrawView2.f - 40 - (f5 - f6);
      f2 = DrawView2.f - 40;
    }
    if (QLog.isColorLevel())
    {
      paramRectF = new StringBuilder();
      paramRectF.append("mapMigObjectRect2Screen1  result = ");
      paramRectF.append(f3);
      paramRectF.append("   ：");
      paramRectF.append(f1);
      paramRectF.append("  ：");
      paramRectF.append(f4);
      paramRectF.append("  ：");
      paramRectF.append(f2);
      QLog.d("DrawView", 2, paramRectF.toString());
    }
    f6 = f4;
    f5 = f3;
    if ((f3 + f4) / 2.0F < DrawView2.e / 2 - 125)
    {
      f5 = DrawView2.e / 2 - 125 - 210;
      f6 = DrawView2.e / 2 - 125 + 210;
    }
    float f8 = f6;
    f7 = f5;
    if ((f5 + f6) / 2.0F > DrawView2.e / 2 + 125)
    {
      f7 = DrawView2.e / 2 + 125 - 210;
      f8 = DrawView2.e / 2 + 125 + 210;
    }
    f4 = f2;
    f3 = f1;
    if ((f1 + f2) / 2.0F < DrawView2.f / 2 - 417)
    {
      f3 = DrawView2.f / 2 - 417 - 210;
      f4 = DrawView2.f / 2 - 417 + 210;
    }
    f2 = f4;
    f1 = f3;
    if ((f3 + f4) / 2.0F > DrawView2.f / 2 + 417)
    {
      f1 = DrawView2.f / 2 + 417 - 210;
      f2 = DrawView2.f / 2 + 417 + 210;
    }
    paramRectF = new RectF(f7, f1, f8, f2);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mapMigObjectRect2Screen3  result = ");
      localStringBuilder.append(paramRectF.toString());
      QLog.d("DrawView", 2, localStringBuilder.toString());
    }
    return paramRectF;
  }
  
  public RectF a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.DrawView2.FaceData
 * JD-Core Version:    0.7.0.1
 */