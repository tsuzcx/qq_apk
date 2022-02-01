package com.tencent.luggage.wxa.kt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.luggage.wxa.mn.g;

public class t
  extends FrameLayout
  implements r, s, g
{
  GradientDrawable a = new GradientDrawable();
  float[] b = new float[8];
  private FrameLayout c;
  private ScrollView d;
  private q e;
  private boolean f = true;
  private boolean g = true;
  private float h;
  private float[] i;
  private float j;
  private int k;
  private int l;
  private Paint m = new Paint();
  
  public t(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.d = new t.1(this, getContext());
    this.c = new FrameLayout(getContext());
    super.addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
    this.d.addView(this.c, 0, new ViewGroup.LayoutParams(-1, -2));
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setAntiAlias(true);
    setWillNotDraw(false);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = this.h;
    if (f1 <= 0.0F) {
      return true;
    }
    double d1 = Math.pow(f1, 2.0D);
    f1 = getWidth();
    float f2 = getHeight();
    float f3 = this.h;
    if (paramFloat1 < f3)
    {
      if (paramFloat2 < f3)
      {
        if (Math.pow(f3 - paramFloat1, 2.0D) + Math.pow(this.h - paramFloat2, 2.0D) > d1) {
          return false;
        }
      }
      else if ((paramFloat2 > f2 - f3) && (Math.pow(f3 - paramFloat1, 2.0D) + Math.pow(paramFloat2 + this.h - f2, 2.0D) > d1)) {
        return false;
      }
    }
    else if (paramFloat1 > f1 - f3) {
      if (paramFloat2 < f3)
      {
        if (Math.pow(paramFloat1 + f3 - f1, 2.0D) + Math.pow(this.h - paramFloat2, 2.0D) > d1) {
          return false;
        }
      }
      else if ((paramFloat2 > f2 - f3) && (Math.pow(paramFloat1 + f3 - f1, 2.0D) + Math.pow(paramFloat2 + this.h - f2, 2.0D) > d1)) {
        return false;
      }
    }
    return true;
  }
  
  private Drawable getShadowDrawable()
  {
    int n = this.l;
    if (n != 0) {
      this.a.setColor(n);
    }
    float[] arrayOfFloat1 = this.i;
    if ((arrayOfFloat1 != null) && (arrayOfFloat1.length > 3))
    {
      float[] arrayOfFloat2 = this.b;
      arrayOfFloat2[0] = arrayOfFloat1[0];
      arrayOfFloat2[1] = arrayOfFloat1[0];
      arrayOfFloat2[2] = arrayOfFloat1[1];
      arrayOfFloat2[3] = arrayOfFloat1[1];
      arrayOfFloat2[4] = arrayOfFloat1[3];
      arrayOfFloat2[5] = arrayOfFloat1[3];
      arrayOfFloat2[6] = arrayOfFloat1[2];
      arrayOfFloat2[7] = arrayOfFloat1[2];
      this.a.setCornerRadii(arrayOfFloat2);
    }
    float f1 = this.j;
    if (f1 > 0.0F)
    {
      n = this.k;
      if (n != 0) {
        this.a.setStroke((int)f1, n);
      }
    }
    return this.a;
  }
  
  public void addView(View paramView, int paramInt)
  {
    this.c.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.c.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getActionMasked() == 0) && (!a(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.i;
    if ((localObject != null) && (localObject.length == 4))
    {
      super.draw(paramCanvas);
      return;
    }
    float f1 = this.h;
    float f2 = 0.0F;
    if (f1 > 0.0F) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      paramCanvas.save();
      localObject = new Path();
      RectF localRectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      f1 = this.h;
      ((Path)localObject).addRoundRect(localRectF, f1, f1, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject);
    }
    int i1 = this.l;
    if (i1 != 0) {
      paramCanvas.drawColor(i1);
    }
    f1 = this.j;
    i1 = n;
    if (f1 > 0.0F)
    {
      f1 /= 2.0F;
      localObject = new RectF(f1, f1, getWidth() - f1, getHeight() - f1);
      f1 = this.h;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.m);
      if (n != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      localObject = new Path();
      float f3 = this.h;
      f1 = f2;
      if (f3 > 0.0F)
      {
        float f4 = this.j;
        f1 = f2;
        if (f3 - f4 > 0.0F) {
          f1 = f3 - f4;
        }
      }
      f2 = this.j;
      ((Path)localObject).addRoundRect(new RectF(f2, f2, getWidth() - this.j, getHeight() - this.j), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject);
      i1 = 1;
    }
    int n = paramCanvas.save();
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(n);
    if (i1 != 0) {
      paramCanvas.restore();
    }
  }
  
  public ViewGroup getTargetView()
  {
    return this.c;
  }
  
  public int getTargetViewChildCount()
  {
    return this.c.getChildCount();
  }
  
  public void removeView(View paramView)
  {
    this.c.removeView(paramView);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    this.d.scrollTo(paramInt1, paramInt2);
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.k = paramInt;
    this.m.setColor(paramInt);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    this.i = paramArrayOfFloat;
    paramArrayOfFloat = this.i;
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length > 0)) {
      setBackground(getShadowDrawable());
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.j = paramFloat;
    this.m.setStrokeWidth(paramFloat);
  }
  
  public void setOnScrollChangedListener(q paramq)
  {
    this.e = paramq;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.t
 * JD-Core Version:    0.7.0.1
 */