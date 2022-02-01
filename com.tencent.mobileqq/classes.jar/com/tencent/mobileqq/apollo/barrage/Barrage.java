package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.StaticLayout;

public class Barrage
{
  private RectF A;
  private AbsBarrageCache B;
  public CharSequence a;
  public boolean b;
  public String c;
  public int d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public int k = -16777216;
  public float l = 24.0F;
  public long m;
  public long n;
  public int o = 20000;
  public int p = 255;
  public int q;
  public int r;
  public int s;
  public int t;
  public float u = 1.0F;
  public boolean v;
  public StaticLayout w;
  public String x;
  private boolean y;
  private Bitmap z;
  
  public Barrage(AbsBarrageCache paramAbsBarrageCache, float paramFloat1, float paramFloat2, float paramFloat3, String paramString1, String paramString2)
  {
    this.a = paramString2;
    this.c = paramString1;
    this.y = true;
    this.s = ((int)(12.0F * paramFloat1));
    this.t = ((int)(paramFloat1 * 6.0F));
    this.A = new RectF(0.0F, 0.0F, paramFloat2, paramFloat3);
    long l1 = System.currentTimeMillis();
    this.m = l1;
    this.n = l1;
    this.B = paramAbsBarrageCache;
  }
  
  public boolean a()
  {
    return this.y;
  }
  
  public void b()
  {
    AbsBarrageCache localAbsBarrageCache = this.B;
    if (localAbsBarrageCache != null)
    {
      localAbsBarrageCache.a(this);
      this.z = this.B.b(this);
    }
  }
  
  public Bitmap c()
  {
    Object localObject = this.z;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      return this.z;
    }
    localObject = this.B;
    if (localObject != null) {
      this.z = ((AbsBarrageCache)localObject).b(this);
    }
    return this.z;
  }
  
  public void d()
  {
    long l1 = System.currentTimeMillis();
    float f1 = this.i;
    float f2 = this.g;
    long l2 = this.n;
    this.i = (f1 + f2 * (float)(l1 - l2));
    this.j += this.h * (float)(l1 - l2);
    this.n = l1;
    if (this.i + this.q >= 0.0F)
    {
      this.y = true;
    }
    else if (this.v)
    {
      this.i = this.A.width();
      this.y = true;
    }
    else
    {
      this.y = false;
    }
    if (System.currentTimeMillis() - this.m >= this.o) {
      this.y = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsAlive: ");
    localStringBuilder.append(this.y);
    localStringBuilder.append(" mText: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mMeasured: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mBgFilePath: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mActionId: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mStartX: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mStartY: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" mSpeedX: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" mSpeedY: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" mCurrentX: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" mCurrentY: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" mTextColor: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" mTextSize: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" mStartTime: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" mAlpha: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" mWidth: ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" mHeight: ");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" mLeftPadding: ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" mTopPadding: ");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" mViewRect: ");
    localStringBuilder.append(this.A);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.Barrage
 * JD-Core Version:    0.7.0.1
 */