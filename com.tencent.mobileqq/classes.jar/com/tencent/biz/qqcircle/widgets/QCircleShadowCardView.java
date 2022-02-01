package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

public class QCircleShadowCardView
  extends FrameLayout
{
  private static final int a = 2131167950;
  private static final int b = 2131168464;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public QCircleShadowCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleShadowCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleShadowCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      int m = getResources().getColor(b);
      int n = getResources().getColor(a);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ga);
      this.c = paramContext.getDimensionPixelSize(R.styleable.gj, 0);
      this.d = paramContext.getResourceId(R.styleable.gg, n);
      this.e = paramContext.getResourceId(R.styleable.gd, m);
      this.i = paramContext.getDimensionPixelSize(R.styleable.gk, 5);
      this.k = paramContext.getDimensionPixelSize(R.styleable.gi, 5);
      this.j = paramContext.getDimensionPixelSize(R.styleable.gh, 5);
      this.l = paramContext.getDimensionPixelSize(R.styleable.gc, 5);
      this.g = paramContext.getDimensionPixelSize(R.styleable.gf, 0);
      this.h = paramContext.getDimensionPixelSize(R.styleable.ge, 0);
      this.f = paramContext.getDimensionPixelSize(R.styleable.gb, 10);
      paramContext.recycle();
    }
    catch (Exception paramContext)
    {
      label161:
      break label161;
    }
    QLog.e("QCircleShadowCardView", 1, "init ShadowCardView catch exception");
    setPadding(this.j, this.i, this.k, this.l);
    setWillNotDraw(false);
    setLayerType(1, null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int i1 = getWidth();
    int i2 = getPaddingRight();
    int i3 = getHeight();
    int i4 = getPaddingBottom();
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setColor(QCircleSkinHelper.getInstance().getColor(this.e));
    localPaint.setShadowLayer(this.f, this.h, this.g, QCircleSkinHelper.getInstance().getColor(this.d));
    RectF localRectF = new RectF(m, n, i1 - i2, i3 - i4);
    m = this.c;
    paramCanvas.drawRoundRect(localRectF, m, m, localPaint);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleShadowCardView
 * JD-Core Version:    0.7.0.1
 */