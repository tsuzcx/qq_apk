package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPickerView
  extends View
{
  private Paint a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private boolean n = false;
  private boolean o = false;
  private float p = -1.0F;
  private Drawable q = null;
  private Drawable r = null;
  private Drawable s = null;
  private Drawable t = null;
  private Drawable u = null;
  private Drawable v = null;
  private Drawable w = null;
  private int x = -65536;
  private int y = 1;
  private ColorPickerView.OnCancelClickListener z = null;
  
  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setId(2131441040);
    paramContext = paramContext.getResources();
    this.b = paramContext.getDimension(2131298387);
    this.c = paramContext.getDimension(2131298386);
    this.d = paramContext.getDimension(2131298384);
    this.e = paramContext.getDimension(2131298385);
    this.f = paramContext.getDimension(2131298390);
    this.g = paramContext.getDimension(2131298388);
    this.h = paramContext.getDimension(2131298391);
    this.k = paramContext.getDimension(2131298381);
    this.l = paramContext.getDimension(2131298381);
    this.i = paramContext.getDimension(2131298389);
    this.j = paramContext.getDimension(2131298380);
    this.m = paramContext.getDimension(2131298392);
    this.q = paramContext.getDrawable(2130843081);
    this.r = paramContext.getDrawable(2130843082);
    this.s = paramContext.getDrawable(2130843083);
    this.t = paramContext.getDrawable(2130843084);
    this.v = paramContext.getDrawable(2130843086);
    this.u = paramContext.getDrawable(2130843085);
    this.w = paramContext.getDrawable(2130843091);
    this.a = new Paint(1);
    this.a.setStyle(Paint.Style.FILL);
    this.s.setColorFilter(this.x, PorterDuff.Mode.SRC_ATOP);
    paramContext = this.u;
    float f1 = this.h;
    float f2 = this.f;
    int i1 = (int)(f1 - f2 / 2.0F);
    float f3 = this.c;
    paramContext.setBounds(i1, (int)(f3 / 2.0F), (int)(f1 + f2 / 2.0F), (int)(f3 / 2.0F + this.g));
    paramContext = this.v;
    f1 = this.h;
    f2 = this.f;
    i1 = (int)(f1 - f2 / 2.0F);
    f3 = this.c;
    float f4 = f3 / 2.0F;
    float f5 = this.g;
    float f6 = this.i;
    paramContext.setBounds(i1, (int)(f4 + f5 + f6), (int)(f1 + f2 / 2.0F), (int)(f3 / 2.0F + f5 + f6 + f2));
    paramContext = this.w;
    f1 = this.h;
    f2 = this.k;
    i1 = (int)(f1 - f2 / 2.0F);
    f3 = this.c;
    f4 = f3 / 2.0F;
    f5 = this.g;
    f6 = this.i;
    float f7 = this.j;
    paramContext.setBounds(i1, (int)(f4 + f5 + f6 + f7), (int)(f1 + f2 / 2.0F), (int)(f3 / 2.0F + f5 + f6 + f7 + this.l));
    paramContext = DoodleLogic.b();
    this.x = paramContext.d;
    this.y = paramContext.e;
    this.p = paramContext.f;
    this.a.setColor(this.x);
  }
  
  public void a()
  {
    float f1 = this.c;
    float f2 = this.g;
    float f3 = this.i;
    f1 = (this.p - f1 / 2.0F) / f2;
    Bitmap localBitmap = ((BitmapDrawable)this.u).getBitmap();
    int i1 = MathUtils.a((int)(f1 * localBitmap.getHeight()), 0, localBitmap.getHeight() - 1);
    this.x = ((BitmapDrawable)this.u).getBitmap().getPixel(localBitmap.getWidth() / 2, i1);
    this.s.setColorFilter(this.x, PorterDuff.Mode.SRC_ATOP);
    this.a.setColor(this.x);
    this.y = 1;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getHeight();
    this.u.draw(paramCanvas);
    float f1 = this.p;
    float f2 = this.c;
    f1 = MathUtils.a(f1, f2 / 2.0F, f2 / 2.0F + this.g);
    int i1 = this.y;
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (i1 != 1)
    {
      if (i1 != 3)
      {
        localDrawable1 = this.q;
        localDrawable2 = this.s;
      }
      else
      {
        localDrawable1 = this.r;
        localDrawable2 = this.t;
      }
    }
    else
    {
      localDrawable1 = this.q;
      localDrawable2 = this.s;
    }
    f2 = this.h;
    float f3 = this.d;
    localDrawable1.setBounds((int)(f2 - f3 / 2.0F), (int)(f1 - f3 / 2.0F), (int)(f2 + f3 / 2.0F), (int)(f3 / 2.0F + f1));
    localDrawable1.draw(paramCanvas);
    if (this.y == 1) {
      paramCanvas.drawCircle(this.h, f1, this.e, this.a);
    }
    if (this.n)
    {
      f2 = this.c;
      localDrawable2.setBounds(0, (int)(f1 - f2 / 2.0F), (int)this.b, (int)(f1 + f2 / 2.0F));
      localDrawable2.draw(paramCanvas);
    }
    this.w.draw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = this.h - this.d / 2.0F;
    float f5 = this.c;
    float f4 = f5 / 2.0F;
    f5 /= 2.0F;
    float f6 = this.g;
    boolean bool3 = true;
    boolean bool1;
    if ((f1 > f3) && (f1 < f3 + this.m) && (f2 > f4) && (f2 < f5 + f6)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    f3 = this.h;
    f5 = this.k;
    f4 = f5 / 2.0F;
    f5 /= 2.0F;
    float f10 = this.c;
    f6 = f10 / 2.0F;
    float f7 = this.g;
    float f8 = this.i;
    float f9 = this.j;
    f10 /= 2.0F;
    float f11 = this.l;
    boolean bool2;
    if ((f1 > f3 - f4) && (f1 < f3 + f5) && (f2 > f6 + f7 + f8 + f9) && (f2 < f10 + f7 + f8 + f9 + f11)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          break label389;
        }
      }
      else
      {
        if (this.n)
        {
          this.p = f2;
          a();
          paramMotionEvent = (DoodleSurfaceView)((View)getParent()).findViewById(2131441050);
          if (paramMotionEvent != null) {
            paramMotionEvent.setColor(this.x, this.y, this.p);
          }
        }
        if (this.o)
        {
          paramMotionEvent = this.z;
          if (paramMotionEvent != null) {
            paramMotionEvent.a();
          }
        }
        this.n = false;
        this.o = false;
        break label389;
      }
    }
    else
    {
      this.n = bool1;
      if (bool1)
      {
        this.p = f2;
        a();
        break label389;
      }
      this.o = bool2;
    }
    if (this.n)
    {
      this.p = f2;
      a();
    }
    this.o = bool2;
    label389:
    if (!bool1)
    {
      if (bool2) {
        return true;
      }
      bool3 = false;
    }
    return bool3;
  }
  
  public void setOnCancelClickListener(ColorPickerView.OnCancelClickListener paramOnCancelClickListener)
  {
    this.z = paramOnCancelClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.doodle.ColorPickerView
 * JD-Core Version:    0.7.0.1
 */