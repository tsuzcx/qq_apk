package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class TipsView
  extends View
{
  protected String a = "";
  protected float b;
  protected float c;
  protected Paint d;
  protected Paint e;
  protected RectF f = new RectF();
  protected int g = 1;
  protected int h = 3;
  protected int i;
  protected Path j;
  
  public TipsView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setColor(-1);
    this.d.setTextSize(DisplayUtil.a(super.getContext(), 14.0F));
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setColor(Color.argb(178, 0, 0, 0));
    this.j = new Path();
    int k = DisplayUtil.a(super.getContext(), 10.0F);
    super.setPadding(k, k, k, k);
  }
  
  public float getRealHeight()
  {
    float f2 = this.c;
    float f1 = f2;
    if (f2 == 0.0F)
    {
      Paint.FontMetrics localFontMetrics = this.d.getFontMetrics();
      f1 = localFontMetrics.bottom;
      f2 = localFontMetrics.top;
      f1 = super.getPaddingTop() + super.getPaddingBottom() + (f1 - f2) + DisplayUtil.a(super.getContext(), 6.5F);
    }
    return f1;
  }
  
  public float getRealWidth()
  {
    float f1 = this.b;
    if (f1 == 0.0F)
    {
      f1 = this.d.measureText(this.a);
      return super.getPaddingLeft() + super.getPaddingRight() + f1;
    }
    return f1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.d.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f3 = ((Paint.FontMetrics)localObject).top;
    float f4 = ((Paint.FontMetrics)localObject).bottom;
    float f5 = super.getPaddingTop();
    int k = this.g;
    int m = 0;
    if (k == 1) {
      k = DisplayUtil.a(super.getContext(), 6.5F);
    } else {
      k = 0;
    }
    localObject = this.f;
    float f2 = k;
    float f6 = this.b;
    float f7 = this.c;
    if (this.g == 1) {
      k = 0;
    } else {
      k = DisplayUtil.a(super.getContext(), 6.5F);
    }
    ((RectF)localObject).set(0.0F, f2, f6, f7 - k);
    paramCanvas.drawRoundRect(this.f, DisplayUtil.a(super.getContext(), 4.0F), DisplayUtil.a(super.getContext(), 4.0F), this.e);
    paramCanvas.drawText(this.a, super.getPaddingLeft(), f5 + (f1 - f3 - f4) + f2, this.d);
    this.j.reset();
    f3 = this.b;
    f1 = f3 / 2.0F;
    k = this.h;
    if (k == 1) {
      f1 = this.i;
    } else if (k == 2) {
      f1 = f3 - this.i;
    }
    if (this.g == 1)
    {
      this.j.moveTo(f1, 0.0F);
      this.j.lineTo(f1 - DisplayUtil.a(super.getContext(), 6.5F), f2);
      this.j.lineTo(f1 + DisplayUtil.a(super.getContext(), 6.5F), f2);
      this.j.close();
      paramCanvas.drawPath(this.j, this.e);
    }
    else
    {
      this.j.moveTo(f1, this.c);
      localObject = this.j;
      f2 = DisplayUtil.a(super.getContext(), 6.5F);
      f3 = this.c;
      if (this.g == 1) {
        k = 0;
      } else {
        k = DisplayUtil.a(super.getContext(), 6.5F);
      }
      ((Path)localObject).lineTo(f1 - f2, f3 - k);
      localObject = this.j;
      f2 = DisplayUtil.a(super.getContext(), 6.5F);
      f3 = this.c;
      if (this.g == 1) {
        k = m;
      } else {
        k = DisplayUtil.a(super.getContext(), 6.5F);
      }
      ((Path)localObject).lineTo(f1 + f2, f3 - k);
      this.j.close();
      paramCanvas.drawPath(this.j, this.e);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = this.d.measureText(this.a);
    this.b = (super.getPaddingLeft() + super.getPaddingRight() + f1);
    Paint.FontMetrics localFontMetrics = this.d.getFontMetrics();
    f1 = localFontMetrics.bottom;
    float f2 = localFontMetrics.top;
    this.c = (super.getPaddingTop() + super.getPaddingBottom() + (f1 - f2) + DisplayUtil.a(super.getContext(), 6.5F));
    super.setMeasuredDimension((int)this.b, (int)this.c);
  }
  
  public void setArrowPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    super.invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    this.e.setColor(paramInt);
    super.invalidate();
  }
  
  public void setText(String paramString)
  {
    this.a = paramString;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.TipsView
 * JD-Core Version:    0.7.0.1
 */