package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import bggq;

public class QCircleLinearLayout
  extends LinearLayout
{
  public QCircleLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    setLayerType(1, null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#EBECF0"));
    int i2 = bggq.a(getContext(), 5.0F);
    localPaint.setShadowLayer(bggq.a(getContext(), 15.0F), 0, i2, Color.parseColor("#99A6ABBD"));
    int i3 = bggq.a(getContext(), 6.0F);
    paramCanvas.drawRoundRect(new RectF(i, j - i2 / 2, k - m, n - i1 + i2 / 2), i3, i3, localPaint);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleLinearLayout
 * JD-Core Version:    0.7.0.1
 */