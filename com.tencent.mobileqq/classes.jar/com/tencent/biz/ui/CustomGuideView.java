package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.app.HardCodeUtil;

public class CustomGuideView
  extends View
{
  public String a = HardCodeUtil.a(2131900851);
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public float g;
  public int h;
  public int i;
  public int j;
  private TextPaint k;
  private Paint l;
  private Path m;
  
  public CustomGuideView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CustomGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CustomGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    if (n == 1073741824) {
      return i1;
    }
    paramInt2 = paramInt1;
    if (n == -2147483648) {
      paramInt2 = Math.min(paramInt1, i1);
    }
    return paramInt2;
  }
  
  public void a()
  {
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setFilterBitmap(true);
    this.k = new TextPaint();
    this.m = new Path();
    this.f = a(12.5F);
    this.b = a(30.0F);
    this.c = a(7.0F);
    this.d = a(5.0F);
    this.e = 0;
    this.g = a(12.0F);
  }
  
  public int b()
  {
    return this.b + this.c;
  }
  
  public int c()
  {
    this.k.setTextSize(this.g);
    return (int)(this.k.measureText(this.a) + this.d * 2 + this.e * 2 + this.f * 2 + 0.5F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    float f1 = getWidth() * 0.9F - this.j;
    float f2 = this.c;
    this.m.reset();
    this.m.moveTo(f1, f2);
    this.m.lineTo(this.j / 2 + f1, 0.0F);
    this.m.lineTo(f1 + this.j, f2);
    this.l.setColor(this.i);
    this.l.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.m, this.l);
    RectF localRectF = new RectF(0.0F, this.c, getWidth(), getHeight());
    int n = this.f;
    paramCanvas.drawRoundRect(localRectF, n, n, this.l);
    this.k.setColor(this.h);
    this.k.setTextSize(this.g);
    Paint.FontMetrics localFontMetrics = this.k.getFontMetrics();
    paramCanvas.drawText(this.a, (getWidth() - this.k.measureText(this.a)) / 2.0F, this.c + (localRectF.height() - (localFontMetrics.ascent + localFontMetrics.bottom)) / 2.0F, this.k);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(c(), paramInt1), a(b(), paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomGuideView
 * JD-Core Version:    0.7.0.1
 */