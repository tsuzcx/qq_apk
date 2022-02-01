package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.biz.qcircle.R.styleable;

public class QFSRoundProgressBar
  extends View
{
  private Rect a;
  private Paint b;
  private RectF c;
  private float d;
  private String e = "0%";
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public QFSRoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFSRoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFSRoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.dR, paramInt, 0);
    this.f = paramContext.getDimensionPixelSize(R.styleable.dX, (int)TypedValue.applyDimension(2, 16.0F, getResources().getDisplayMetrics()));
    this.g = paramContext.getColor(R.styleable.dW, -16777216);
    this.i = paramContext.getColor(R.styleable.dS, -16777216);
    this.h = paramContext.getDimensionPixelSize(R.styleable.dT, (int)TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics()));
    this.j = paramContext.getColor(R.styleable.dU, -16777216);
    this.k = paramContext.getInt(R.styleable.dV, 10);
    paramContext.recycle();
    a();
  }
  
  private void a()
  {
    this.a = new Rect();
    this.b = new Paint(1);
    this.c = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.b.setAntiAlias(true);
    this.b.setColor(this.i);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.h);
    this.b.setStrokeCap(Paint.Cap.ROUND);
    int m = getWidth() / 2;
    int n = m - this.h;
    float f1 = m;
    paramCanvas.drawCircle(f1, f1, n, this.b);
    this.b.setColor(this.j);
    Object localObject = this.c;
    float f2 = m - n;
    float f3 = n + m;
    ((RectF)localObject).set(f2, f2, f3, f3);
    paramCanvas.drawArc(this.c, -90.0F, this.d, false, this.b);
    this.b.reset();
    this.b.setAntiAlias(true);
    this.b.setStrokeWidth(0.0F);
    this.b.setColor(this.g);
    this.b.setTextSize(this.f);
    localObject = this.b;
    String str = this.e;
    ((Paint)localObject).getTextBounds(str, 0, str.length(), this.a);
    paramCanvas.drawText(this.e, f1 - this.a.width() / 2.0F, f1 + this.a.height() / 2.0F, this.b);
  }
  
  public void setProgress(int paramInt)
  {
    this.d = (paramInt * 3.6F);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Math.round(this.d / 360.0F * 100.0F));
    localStringBuilder.append("%");
    this.e = localStringBuilder.toString();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSRoundProgressBar
 * JD-Core Version:    0.7.0.1
 */