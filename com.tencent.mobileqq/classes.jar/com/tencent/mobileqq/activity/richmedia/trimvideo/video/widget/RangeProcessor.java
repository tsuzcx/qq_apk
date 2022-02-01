package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.mobileqq.utils.ViewUtils;

public class RangeProcessor
{
  private final Paint a = new Paint(1);
  private final Bitmap b;
  private final Bitmap c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private float h;
  private float i;
  private int j = -1;
  private RangeProcessor.OnRangeChangeListener k;
  private float l;
  private float m;
  private int n = 4;
  private FrameParent o;
  private float p;
  private float q;
  private float r;
  private int s = Color.parseColor("#298be7");
  
  public RangeProcessor(FrameParent paramFrameParent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.o = paramFrameParent;
    Object localObject = this.o.getContext();
    this.d = (ViewUtils.getScreenWidth() * 0.0375F);
    this.e = paramFloat2;
    this.f = (this.d * 0.5F);
    paramFloat2 = paramInt3;
    this.g = paramFloat2;
    paramFrameParent = a(((Context)localObject).getResources(), 2130851112, (int)this.d, (int)this.e);
    localObject = a(((Context)localObject).getResources(), 2130851114, (int)this.d, (int)this.e);
    ColorDrawable localColorDrawable = new ColorDrawable(this.s);
    localColorDrawable.setBounds(0, 0, (int)this.d, (int)this.e);
    this.b = Bitmap.createBitmap((int)this.d, (int)this.e, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(this.b);
    localColorDrawable.draw(localCanvas);
    if (paramFrameParent != null) {
      localCanvas.drawBitmap(paramFrameParent, (this.d - paramFrameParent.getWidth()) / 2.0F, (this.e - paramFrameParent.getHeight()) / 2.0F, this.a);
    }
    this.c = Bitmap.createBitmap((int)this.d, (int)this.e, Bitmap.Config.RGB_565);
    localCanvas.setBitmap(this.c);
    localColorDrawable.draw(localCanvas);
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, (this.d - ((Bitmap)localObject).getWidth()) / 2.0F, (this.e - ((Bitmap)localObject).getHeight()) / 2.0F, this.a);
    }
    float f2 = paramInt4;
    float f1 = paramInt2;
    f2 = f2 * 1.0F / f1;
    float f3 = this.d;
    this.m = (f2 * paramFloat1 + f3);
    this.l = (2000.0F / f1 * paramFloat1);
    this.q = (paramFloat2 - f3);
    this.r = f3;
    this.h = f3;
    this.i = this.m;
  }
  
  private void a(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.c, paramFloat, 0.0F, this.a);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= this.d * 2.0F) && (paramFloat2 > 0.0F) && (paramFloat2 < this.e);
  }
  
  private void b(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.b, paramFloat - this.d, 0.0F, this.a);
  }
  
  private boolean c(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public float a()
  {
    return this.e;
  }
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i3 = paramOptions.outHeight;
    int i4 = paramOptions.outWidth;
    int i2 = 1;
    int i1 = 1;
    if ((i3 > paramInt2) || (i4 > paramInt1))
    {
      i3 /= 2;
      i4 /= 2;
      for (;;)
      {
        i2 = i1;
        if (i3 / i1 <= paramInt2) {
          break;
        }
        i2 = i1;
        if (i4 / i1 <= paramInt1) {
          break;
        }
        i1 *= 2;
      }
    }
    return i2;
  }
  
  public Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramResources == null) {
      return null;
    }
    if (paramInt1 <= 0) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      int i1 = 1;
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
        paramInt2 = i1;
      } else {
        paramInt2 = a(localOptions, paramInt2, paramInt3);
      }
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = paramInt2;
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
      return null;
    }
    catch (Exception paramResources)
    {
      paramResources.printStackTrace();
    }
    return null;
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i1 = this.a.getColor();
    this.a.setColor(this.s);
    paramCanvas.drawRect(this.h, 0.0F, this.i, this.n, this.a);
    float f1 = this.h;
    float f2 = this.e;
    paramCanvas.drawRect(f1, f2 - this.n, this.i, f2, this.a);
    this.a.setColor(i1);
    b(this.h, paramCanvas);
    a(this.i, paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.j = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.p = paramMotionEvent.getX();
      return;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      float f2 = f1 - this.p;
      int i1 = this.j;
      float f3;
      if (i1 == 0)
      {
        f3 = Math.max(this.i - this.m, this.r);
        if (f1 < f3)
        {
          this.h = f3;
          return;
        }
        if ((f2 < 0.0F) && (this.h + f2 <= this.d))
        {
          this.h = f3;
        }
        else
        {
          f2 = this.i;
          f3 = this.l;
          if (f2 - f1 < f3) {
            this.h = (f2 - f3);
          } else {
            this.h = f1;
          }
        }
      }
      else if (i1 == 1)
      {
        f3 = Math.min(this.h + this.m, this.q);
        if (f1 > f3)
        {
          this.i = f3;
          return;
        }
        if ((f2 > 0.0F) && (this.i + f2 >= this.m))
        {
          this.i = f3;
        }
        else
        {
          f2 = this.h;
          f3 = this.l;
          if (f1 - f2 < f3) {
            this.i = (f2 + f3);
          } else {
            this.i = f1;
          }
        }
      }
    }
    this.o.invalidate();
    paramMotionEvent = this.k;
    if (paramMotionEvent != null) {
      paramMotionEvent.a(this.h, this.i);
    }
  }
  
  public void a(RangeProcessor.OnRangeChangeListener paramOnRangeChangeListener)
  {
    this.k = paramOnRangeChangeListener;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.h - this.f);
    boolean bool2 = a(paramFloat1, paramFloat2, this.i + this.f);
    if (bool1)
    {
      this.j = 0;
      return true;
    }
    if (bool2)
    {
      this.j = 1;
      return true;
    }
    return false;
  }
  
  public float b()
  {
    return this.d;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F) {
      this.r = (paramFloat1 + this.d);
    } else {
      this.r = this.d;
    }
    if (paramFloat2 >= 0.0F)
    {
      paramFloat1 = this.d;
      this.q = Math.min(paramFloat2 + paramFloat1, this.g - paramFloat1);
    }
  }
  
  public float c()
  {
    return this.i - this.h;
  }
  
  public boolean d()
  {
    return (!c(this.h, this.d)) || (!c(this.i, this.m));
  }
  
  public void e()
  {
    this.k = null;
    this.b.recycle();
    this.c.recycle();
  }
  
  public void f()
  {
    this.k = null;
    this.h = 0.0F;
    this.i = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.RangeProcessor
 * JD-Core Version:    0.7.0.1
 */