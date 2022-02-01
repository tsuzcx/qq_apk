package com.tencent.biz.qqcircle.immersive.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.biz.qcircle.R.styleable;

public class ChrysanthemumLoadingView
  extends View
{
  private int a;
  private int b;
  private int c;
  private int d;
  private Paint e;
  private final int f = -6710887;
  private final int g = 10;
  private final int h = 20;
  private int i = 10;
  private int j = -6710887;
  private int k = 20;
  private int l = 1;
  private ValueAnimator m;
  
  public ChrysanthemumLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChrysanthemumLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChrysanthemumLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Q);
    this.j = paramContext.getColor(R.styleable.R, -6710887);
    this.k = paramContext.getDimensionPixelSize(R.styleable.S, 20);
    this.i = paramContext.getDimensionPixelSize(R.styleable.T, 10);
    paramContext.recycle();
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStrokeCap(Paint.Cap.ROUND);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setColor(this.j);
    this.e.setStrokeWidth(this.i);
  }
  
  public void a()
  {
    this.m = ValueAnimator.ofInt(new int[] { 12, 1 });
    this.m.setDuration(1000L);
    this.m.setInterpolator(new LinearInterpolator());
    this.m.setRepeatCount(-1);
    this.m.setRepeatMode(1);
    this.m.addUpdateListener(new ChrysanthemumLoadingView.1(this));
    this.m.start();
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = this.m;
    if (localValueAnimator == null) {
      return;
    }
    localValueAnimator.removeAllUpdateListeners();
    this.m.end();
    this.m = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = 0;
    while (n < 12)
    {
      Paint localPaint = this.e;
      n += 1;
      localPaint.setAlpha((this.l + n) % 12 * 255 / 12);
      int i1 = this.c;
      float f1 = i1;
      int i2 = this.d;
      float f2 = i2;
      int i3 = this.k;
      paramCanvas.drawLine(f1, f2 - i3 * 1.3F, i1, i2 - i3 * 2, this.e);
      paramCanvas.rotate(30.0F, this.c, this.d);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = View.MeasureSpec.getSize(paramInt1);
    this.b = View.MeasureSpec.getSize(paramInt2);
    this.c = (this.a / 2);
    this.d = (this.b / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.ChrysanthemumLoadingView
 * JD-Core Version:    0.7.0.1
 */