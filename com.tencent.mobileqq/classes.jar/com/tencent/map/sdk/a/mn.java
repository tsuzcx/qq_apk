package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.tencent.map.lib.basemap.data.GeoPoint;

public final class mn
  extends mo
  implements mo.a
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E = 0;
  private float F = 0.0F;
  private float G = 0.0F;
  private float H = 0.0F;
  private float I = 0.0F;
  private boolean J = true;
  public int a;
  public String b;
  public String c;
  public Bitmap[] d;
  public double e;
  public double f;
  public float g = 0.5F;
  public float h = 0.5F;
  public boolean i = false;
  public float j = 1.0F;
  public int k = 0;
  public float l = 1.0F;
  public float m = 1.0F;
  public boolean n = false;
  public boolean o = false;
  public boolean p = true;
  public boolean q = false;
  private RectF z;
  
  public mn(String paramString, GeoPoint paramGeoPoint, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Bitmap... paramVarArgs)
  {
    a(this);
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.A = paramInt1;
    this.B = paramInt2;
    if (paramGeoPoint != null)
    {
      double d1 = paramGeoPoint.getLongitudeE6();
      Double.isNaN(d1);
      this.e = (d1 / 1000000.0D);
      d1 = paramGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      this.f = (d1 / 1000000.0D);
    }
    a(paramString, paramVarArgs);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.C == paramInt1) && (this.D == paramInt2)) {
      return;
    }
    this.C = paramInt1;
    this.D = paramInt2;
    float f1 = this.A / paramInt1;
    float f2 = this.B / paramInt2;
    this.z = new RectF(f1, -f2, 0.0F, 0.0F);
    this.g -= f1;
    this.h -= f2;
    paramInt1 = this.C;
    this.F = (-paramInt1 * this.g);
    this.G = (paramInt1 + this.F);
    paramInt1 = this.D;
    this.H = (paramInt1 * this.h);
    this.I = (this.H - paramInt1);
  }
  
  private Bitmap c(int paramInt)
  {
    Bitmap[] arrayOfBitmap = this.d;
    if (arrayOfBitmap == null) {
      return null;
    }
    if ((paramInt >= 0) && (paramInt < arrayOfBitmap.length)) {
      return arrayOfBitmap[paramInt];
    }
    return this.d[0];
  }
  
  public final Bitmap a()
  {
    try
    {
      Bitmap localBitmap = c(this.r);
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(float paramFloat)
  {
    this.j = paramFloat;
    this.i = true;
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    this.g = paramFloat1;
    this.h = paramFloat2;
    a(this.C, this.D);
    this.i = true;
  }
  
  public final void a(int paramInt)
  {
    this.k = paramInt;
    this.i = true;
  }
  
  public final void a(String paramString, Bitmap... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    try
    {
      this.i = true;
      a(true);
      this.b = paramString;
      this.d = paramVarArgs;
      if ((this.E < 0) || (this.E >= paramVarArgs.length)) {
        this.E = 0;
      }
      if (paramVarArgs[this.E] != null) {
        a(paramVarArgs[this.E].getWidth(), paramVarArgs[this.E].getHeight());
      }
      return;
    }
    finally {}
  }
  
  public final void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (!paramBoolean) {
      this.c = this.b;
    }
  }
  
  public final void b(int paramInt)
  {
    try
    {
      this.E = paramInt;
      this.i = true;
      a(true);
      Bitmap localBitmap = c(paramInt);
      if (localBitmap != null)
      {
        int i1 = localBitmap.getWidth();
        int i2 = localBitmap.getHeight();
        if ((this.C != i1) || (this.D != i2)) {
          a(i1, i2);
        }
      }
      super.b(paramInt);
      return;
    }
    finally {}
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof mn)) {
      return false;
    }
    return this.a == ((mn)paramObject).a;
  }
  
  public final int hashCode()
  {
    return String.valueOf(this.a).hashCode() + 527;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mn
 * JD-Core Version:    0.7.0.1
 */