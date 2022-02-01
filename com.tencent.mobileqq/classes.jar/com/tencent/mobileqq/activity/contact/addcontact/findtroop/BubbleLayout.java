package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class BubbleLayout
  extends RelativeLayout
{
  int a;
  int b;
  boolean c;
  float d;
  private int e;
  @BubbleLayout.Direction
  private int f;
  private Point g;
  private int h;
  private Paint i;
  private Path j;
  private RectF k;
  
  public BubbleLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.h);
    this.b = paramContext.getColor(R.styleable.i, -1);
    this.a = Color.parseColor("#F5F6FA");
    int m = paramContext.getColor(R.styleable.m, Color.parseColor("#999999"));
    int n = (int)TypedValue.applyDimension(0, 0.0F, getResources().getDisplayMetrics());
    n = paramContext.getDimensionPixelSize(R.styleable.n, n);
    this.e = paramContext.getDimensionPixelSize(R.styleable.j, 0);
    this.d = paramContext.getDimensionPixelSize(R.styleable.o, 0);
    this.f = paramContext.getInt(R.styleable.k, 4);
    this.h = paramContext.getDimensionPixelOffset(R.styleable.l, 0);
    paramContext.recycle();
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(this.a);
    this.i.setShadowLayer(n, 0.0F, 0.0F, m);
    this.j = new Path();
    this.k = new RectF();
    this.g = new Point();
    setWillNotDraw(false);
    setLayerType(1, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    int m = getPaddingLeft();
    if (m == 0) {
      return;
    }
    this.j.reset();
    Object localObject = this.j;
    RectF localRectF = this.k;
    int n = this.e;
    ((Path)localObject).addRoundRect(localRectF, n, n, Path.Direction.CCW);
    if (this.c)
    {
      this.j.moveTo(this.g.x, this.g.y - m);
      this.j.lineTo(this.g.x - m, this.g.y);
      this.j.lineTo(this.g.x, this.g.y + m);
      localObject = new CornerPathEffect(this.d);
      this.i.setPathEffect((PathEffect)localObject);
    }
    paramCanvas.drawPath(this.j, this.i);
  }
  
  private void b()
  {
    int m = this.f;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m == 3) {
          break label45;
        }
        if (m != 4) {
          return;
        }
      }
      localPoint = this.g;
      localPoint.x += this.h;
      return;
    }
    label45:
    Point localPoint = this.g;
    localPoint.y += this.h;
  }
  
  private void b(Canvas paramCanvas)
  {
    int m = getPaddingTop();
    if (m == 0) {
      return;
    }
    this.j.reset();
    Object localObject = this.j;
    RectF localRectF = this.k;
    int n = this.e;
    ((Path)localObject).addRoundRect(localRectF, n, n, Path.Direction.CCW);
    if (this.c)
    {
      this.j.moveTo(this.g.x + m, this.g.y);
      this.j.lineTo(this.g.x, this.g.y - m);
      this.j.lineTo(this.g.x - m, this.g.y);
      localObject = new CornerPathEffect(this.d);
      this.i.setPathEffect((PathEffect)localObject);
    }
    paramCanvas.drawPath(this.j, this.i);
  }
  
  private void c(Canvas paramCanvas)
  {
    int m = getPaddingRight();
    if (m == 0) {
      return;
    }
    this.j.reset();
    Object localObject = this.j;
    RectF localRectF = this.k;
    int n = this.e;
    ((Path)localObject).addRoundRect(localRectF, n, n, Path.Direction.CCW);
    if (this.c)
    {
      this.j.moveTo(this.g.x, this.g.y - m);
      this.j.lineTo(this.g.x + m, this.g.y);
      this.j.lineTo(this.g.x, this.g.y + m);
      localObject = new CornerPathEffect(this.d);
      this.i.setPathEffect((PathEffect)localObject);
    }
    paramCanvas.drawPath(this.j, this.i);
  }
  
  private void d(Canvas paramCanvas)
  {
    int m = getPaddingBottom();
    if (m == 0) {
      return;
    }
    this.j.reset();
    Object localObject = this.j;
    RectF localRectF = this.k;
    int n = this.e;
    ((Path)localObject).addRoundRect(localRectF, n, n, Path.Direction.CCW);
    if (this.c)
    {
      localObject = this.j;
      localRectF = this.k;
      n = this.e;
      ((Path)localObject).addRoundRect(localRectF, n, n, Path.Direction.CCW);
      this.j.moveTo(this.g.x + m, this.g.y);
      this.j.lineTo(this.g.x, this.g.y + m);
      this.j.lineTo(this.g.x - m, this.g.y);
      if (Build.VERSION.SDK_INT > 21)
      {
        localObject = new CornerPathEffect(this.d);
        this.i.setPathEffect((PathEffect)localObject);
      }
      else
      {
        this.j.close();
      }
    }
    paramCanvas.drawPath(this.j, this.i);
  }
  
  public void a()
  {
    int m = this.f;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m == 3) {
          break label45;
        }
        if (m != 4) {
          return;
        }
      }
      localPoint = this.g;
      localPoint.x -= this.h;
      return;
    }
    label45:
    Point localPoint = this.g;
    localPoint.y -= this.h;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.g.x > 0) && (this.g.y > 0)) {
      if (this.c) {
        this.i.setColor(this.b);
      } else {
        this.i.setColor(this.a);
      }
    }
    int m = this.f;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4) {
            return;
          }
          d(paramCanvas);
          return;
        }
        c(paramCanvas);
        return;
      }
      b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k.left = getPaddingLeft();
    this.k.top = getPaddingTop();
    this.k.right = (paramInt1 - getPaddingRight());
    this.k.bottom = (paramInt2 - getPaddingBottom());
    paramInt3 = this.f;
    if (paramInt3 != 1)
    {
      Point localPoint;
      if (paramInt3 != 2)
      {
        if (paramInt3 != 3)
        {
          if (paramInt3 == 4)
          {
            localPoint = this.g;
            localPoint.x = (paramInt1 / 2);
            localPoint.y = (paramInt2 - getPaddingBottom());
          }
        }
        else
        {
          this.g.x = (paramInt1 - getPaddingRight());
          this.g.y = (paramInt2 / 2);
        }
      }
      else
      {
        localPoint = this.g;
        localPoint.x = (paramInt1 / 2);
        localPoint.y = getPaddingTop();
      }
    }
    else
    {
      this.g.x = getPaddingLeft();
      this.g.y = (paramInt2 / 2);
    }
    if (this.h != 0) {
      b();
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.c = paramBoolean;
    postInvalidate();
  }
  
  public void setSelectedColor(String paramString)
  {
    try
    {
      this.b = Color.parseColor(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("BubbleLayout", 1, "setSelectedColor error", paramString);
    }
  }
  
  public void setTriangleOffset(int paramInt)
  {
    a();
    this.h = paramInt;
    b();
    invalidate();
  }
  
  public void setUnselectedColor(String paramString)
  {
    try
    {
      this.a = Color.parseColor(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("BubbleLayout", 1, "setUnselectedColor error", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */