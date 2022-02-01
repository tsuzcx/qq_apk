package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.photo.RegionView;

@SuppressLint({"NewApi"})
public class PortraitImageview
  extends View
{
  private static int E = 20;
  private Runnable A = null;
  private Runnable B = null;
  private double C = 0.0D;
  private GestureDetector D;
  private float F;
  private float G;
  private float H;
  private float I;
  private int J = -1;
  Runnable a = null;
  ScaleGestureDetector b;
  RectF c = new RectF();
  int d;
  int e;
  RectF f = new RectF();
  RectF g = new RectF();
  float h;
  RegionView i;
  PortraitImageview.OnImageTouchedListener j;
  int k;
  int l;
  int m;
  int n;
  float o;
  private Matrix p = new Matrix();
  private Matrix q = new Matrix();
  private Matrix r = new Matrix();
  private Matrix s = new Matrix();
  private Matrix t = new Matrix();
  private Paint u;
  private float[] v = new float[9];
  private Bitmap w;
  private int x = -1;
  private int y = -1;
  private float z;
  
  public PortraitImageview(Context paramContext)
  {
    this(paramContext, null);
    this.h = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(RectF paramRectF1, RectF paramRectF2)
  {
    if (paramRectF1.left > paramRectF2.left) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i1 = i2;
    if (paramRectF1.right < paramRectF2.right) {
      i1 = i2 | 0x2;
    }
    int i2 = i1;
    if (paramRectF1.top > paramRectF2.top) {
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if (paramRectF1.bottom < paramRectF2.bottom) {
      i1 = i2 | 0x8;
    }
    return i1;
  }
  
  private void a(Context paramContext)
  {
    this.u = new Paint();
    this.u.setDither(true);
    this.u.setFilterBitmap(true);
    this.u.setAntiAlias(true);
    this.B = new PortraitImageview.1(this);
    this.b = new ScaleGestureDetector(paramContext, new PortraitImageview.ScaleListener(this));
    this.D = new GestureDetector(paramContext, new PortraitImageview.MyGestureListener(this, null));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  private void a(Bitmap paramBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMatrix.reset();
    float f3 = this.k / paramBitmap.getWidth();
    float f4 = this.l / paramBitmap.getHeight();
    if ((f3 < 1.0F) && (f4 < 1.0F))
    {
      float f5 = f1 / paramBitmap.getWidth();
      float f6 = f2 / paramBitmap.getHeight();
      this.o = Math.min(f5, f5);
      float f7 = this.o;
      if (f7 >= 1.0F) {
        this.o = 1.0F;
      } else if ((f7 < f3) || (f7 < f4)) {
        this.o = Math.max(f5, f6);
      }
    }
    else
    {
      this.o = Math.max(f3, f4);
    }
    f3 = this.o;
    paramMatrix.setScale(f3, f3);
    paramMatrix.postTranslate((f1 - paramBitmap.getWidth() * this.o) / 2.0F, (f2 - paramBitmap.getHeight() * this.o) / 2.0F);
    RectF localRectF = this.f;
    localRectF.left = 0.0F;
    localRectF.right = (localRectF.left + paramBitmap.getWidth());
    localRectF = this.f;
    localRectF.top = 0.0F;
    localRectF.bottom = (localRectF.top + paramBitmap.getHeight());
    paramMatrix.mapRect(this.f);
  }
  
  protected float a()
  {
    Bitmap localBitmap = this.w;
    if (localBitmap == null) {
      return 1.0F;
    }
    return Math.max(localBitmap.getWidth() / this.x, this.w.getHeight() / this.y) * 16.0F;
  }
  
  protected float a(Matrix paramMatrix)
  {
    if (this.w != null) {
      return a(paramMatrix, 0);
    }
    return 1.0F;
  }
  
  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.v);
    return this.v[paramInt];
  }
  
  public void a(float paramFloat)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    a(paramFloat, f1 / 2.0F, f2 / 2.0F);
  }
  
  protected void a(float paramFloat1, float paramFloat2)
  {
    this.t.set(this.q);
    this.t.postTranslate(paramFloat1, paramFloat2);
    this.t.mapRect(this.g, this.f);
    int i1 = a(this.g, this.c);
    if (((i1 & 0x1) == 0) && ((i1 & 0x2) == 0)) {
      this.q.postTranslate(paramFloat1, 0.0F);
    }
    if (((i1 & 0x4) == 0) && ((i1 & 0x8) == 0)) {
      this.q.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.z;
    float f1 = paramFloat1;
    if (paramFloat1 > f2) {
      f1 = f2;
    }
    b(f1 / getScale(), paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = (paramFloat1 - getScale()) / paramFloat4;
    float f1 = getScale();
    post(new PortraitImageview.3(this, paramFloat4, System.currentTimeMillis(), f1, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public float b()
  {
    Bitmap localBitmap = this.w;
    if (localBitmap == null) {
      return 1.0F;
    }
    return Math.max(Math.min(this.x / localBitmap.getWidth(), this.y / this.w.getHeight()), 1.0F);
  }
  
  float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 1.0F) + paramFloat2;
  }
  
  protected void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat3;
    if (paramFloat3 > this.c.bottom) {
      f1 = this.c.bottom;
    }
    float f2 = f1;
    if (f1 < this.c.top) {
      f2 = this.c.top;
    }
    paramFloat3 = paramFloat2;
    if (paramFloat2 > this.c.right) {
      paramFloat3 = this.c.right;
    }
    paramFloat2 = paramFloat3;
    if (paramFloat3 < this.c.left) {
      paramFloat2 = this.c.left;
    }
    this.t.set(this.q);
    this.t.postScale(paramFloat1, paramFloat1, paramFloat2, f2);
    this.t.mapRect(this.g, this.f);
    if (a(this.g, this.c) == 0)
    {
      this.q.set(this.t);
      return;
    }
    if ((this.g.width() / this.c.width() >= 1.0F) && (this.g.height() / this.c.height() >= 1.0F))
    {
      this.q.mapRect(this.g, this.f);
      paramFloat2 = this.c.width() / this.g.width();
      paramFloat3 = this.c.height() / this.g.height();
      if (paramFloat2 < paramFloat3) {
        paramFloat2 = paramFloat3;
      }
      f1 = this.c.centerX();
      f2 = this.g.centerX();
      paramFloat3 = 1.0F - paramFloat2;
      f1 = (f1 - f2 * paramFloat2) / paramFloat3;
      paramFloat2 = (this.c.centerY() - this.g.centerY() * paramFloat2) / paramFloat3;
      this.q.postScale(paramFloat1, paramFloat1, f1, paramFloat2);
    }
  }
  
  public int getClipHeight()
  {
    return this.l;
  }
  
  public int getClipWidth()
  {
    return this.k;
  }
  
  public Bitmap getImageBitmap()
  {
    return this.w;
  }
  
  public Matrix getImageViewMatrix()
  {
    this.r.set(this.p);
    this.r.postConcat(this.q);
    return this.r;
  }
  
  public float getImageViewScale()
  {
    return a(getImageViewMatrix());
  }
  
  public Matrix getMMatrix()
  {
    this.r.reset();
    this.r.set(this.p);
    this.r.postConcat(this.q);
    return this.r;
  }
  
  public float getPosX()
  {
    return this.F;
  }
  
  public float getPosY()
  {
    return this.G;
  }
  
  public RectF getRestrictRect()
  {
    return this.c;
  }
  
  public float getScale()
  {
    return a(this.q);
  }
  
  public float getTransX()
  {
    return a(getImageViewMatrix(), 2);
  }
  
  public float getTransY()
  {
    return a(getImageViewMatrix(), 5);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    Bitmap localBitmap = this.w;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      if ((Build.VERSION.SDK_INT >= 11) && (getLayerType() == 2))
      {
        paramCanvas.drawBitmap(this.w, this.s, null);
      }
      else
      {
        double d1 = System.currentTimeMillis();
        double d2 = this.C;
        Double.isNaN(d1);
        if (d1 - d2 > 250.0D)
        {
          paramCanvas.drawBitmap(this.w, this.s, this.u);
          this.C = System.currentTimeMillis();
        }
        else
        {
          paramCanvas.drawBitmap(this.w, this.s, null);
          removeCallbacks(this.B);
          postDelayed(this.B, 250L);
        }
      }
    }
    paramCanvas.restoreToCount(i1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.x = (paramInt3 - paramInt1);
    this.y = (paramInt4 - paramInt2);
    Object localObject = this.A;
    if (localObject != null)
    {
      this.A = null;
      ((Runnable)localObject).run();
    }
    localObject = this.w;
    if (localObject != null)
    {
      a((Bitmap)localObject, this.p);
      setImageMatrix(getImageViewMatrix());
    }
    this.d = (getWidth() / 2);
    this.e = (getHeight() / 2);
    setRestrict(this.m, this.n);
    localObject = this.c;
    paramInt1 = this.d;
    paramInt2 = this.k;
    ((RectF)localObject).left = (paramInt1 - paramInt2 / 2);
    ((RectF)localObject).right = (paramInt1 + paramInt2 / 2);
    paramInt1 = this.e;
    paramInt2 = this.l;
    ((RectF)localObject).top = (paramInt1 - paramInt2 / 2);
    ((RectF)localObject).bottom = (paramInt1 + paramInt2 / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.w != null)
    {
      this.b.onTouchEvent(paramMotionEvent);
      if (!this.b.isInProgress()) {
        this.D.onTouchEvent(paramMotionEvent);
      }
      int i2 = paramMotionEvent.getAction() & 0xFF;
      int i1 = 0;
      float f1;
      float f2;
      if (i2 != 0)
      {
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 6) {
                return true;
              }
              i2 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              if (paramMotionEvent.getPointerId(i2) == this.J)
              {
                if (i2 == 0) {
                  i1 = 1;
                }
                this.H = paramMotionEvent.getX(i1);
                this.I = paramMotionEvent.getY(i1);
                this.J = paramMotionEvent.getPointerId(i1);
                return true;
              }
            }
            else
            {
              this.J = -1;
              return true;
            }
          }
          else
          {
            i1 = paramMotionEvent.findPointerIndex(this.J);
            if ((i1 != -1) && (i1 < paramMotionEvent.getPointerCount()))
            {
              f1 = paramMotionEvent.getX(i1);
              f2 = paramMotionEvent.getY(i1);
              if (!this.b.isInProgress())
              {
                float f3 = f1 - this.H;
                float f4 = f2 - this.I;
                if (this.c != null)
                {
                  this.F += f3;
                  this.G += f4;
                }
                else
                {
                  this.F += f3;
                  this.G += f4;
                }
                invalidate();
              }
              this.H = f1;
              this.I = f2;
              return true;
            }
          }
        }
        else
        {
          this.J = -1;
          return true;
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.H = f1;
        this.I = f2;
        this.J = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      }
    }
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (getWidth() <= 0)
    {
      this.A = new PortraitImageview.2(this, paramBitmap);
      return;
    }
    if (paramBitmap != null)
    {
      a(paramBitmap, this.p);
      this.w = paramBitmap;
    }
    else
    {
      this.p.reset();
      this.w = paramBitmap;
    }
    this.q.reset();
    setImageMatrix(getImageViewMatrix());
    this.z = a();
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.s.isIdentity())) || ((localMatrix != null) && (!this.s.equals(localMatrix))))
    {
      this.s.set(localMatrix);
      invalidate();
    }
  }
  
  public void setOnImageTouchedListener(PortraitImageview.OnImageTouchedListener paramOnImageTouchedListener)
  {
    this.j = paramOnImageTouchedListener;
  }
  
  public void setRegionView(RegionView paramRegionView)
  {
    this.i = paramRegionView;
  }
  
  public void setRestrict(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    paramInt1 = this.x;
    if ((paramInt1 > 0) && ((this.m > paramInt1) || (this.n > this.y)))
    {
      float f2 = this.x;
      paramInt2 = E;
      float f3 = paramInt2;
      float f1 = this.h;
      paramInt1 = this.m;
      f2 = (f2 - f3 * f1) / paramInt1;
      f3 = this.y;
      float f4 = paramInt2;
      paramInt2 = this.n;
      f1 = (f3 - f4 * f1) / paramInt2;
      if (f2 <= f1)
      {
        this.k = ((int)(paramInt1 * f2));
        this.l = ((int)(paramInt2 * f2));
        return;
      }
      this.k = ((int)(paramInt1 * f1));
      this.l = ((int)(paramInt2 * f1));
      return;
    }
    this.k = this.m;
    this.l = this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview
 * JD-Core Version:    0.7.0.1
 */