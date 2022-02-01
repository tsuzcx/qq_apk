package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.R.styleable;

public class ShadowCardView
  extends FrameLayout
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public ShadowCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShadowCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShadowCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      int k = getResources().getColor(2131167374);
      int m = getResources().getColor(2131166991);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.shadowCardView);
      this.a = paramContext.getDimensionPixelSize(8, 0);
      this.b = paramContext.getColor(5, m);
      this.c = paramContext.getColor(2, k);
      this.g = paramContext.getDimensionPixelSize(9, 5);
      this.i = paramContext.getDimensionPixelSize(7, 5);
      this.h = paramContext.getDimensionPixelSize(6, 5);
      this.j = paramContext.getDimensionPixelSize(1, 5);
      this.e = paramContext.getDimensionPixelSize(4, 0);
      this.f = paramContext.getDimensionPixelSize(3, 0);
      this.d = paramContext.getDimensionPixelSize(0, 10);
      paramContext.recycle();
      setPadding(this.h, this.g, this.i, this.j);
      setWillNotDraw(false);
      setLayerType(1, null);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        SLog.e("ShadowCardView", "init ShadowCardView catch exception");
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int k = getPaddingLeft();
    int m = getPaddingTop();
    int n = getWidth();
    int i1 = getPaddingRight();
    int i2 = getHeight();
    int i3 = getPaddingBottom();
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setColor(this.c);
    localPaint.setShadowLayer(this.d, this.f, this.e, this.b);
    paramCanvas.drawRoundRect(new RectF(k, m, n - i1, i2 - i3), this.a, this.a, localPaint);
    super.onDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.ShadowCardView
 * JD-Core Version:    0.7.0.1
 */