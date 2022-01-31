package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import bcwh;

public class QCircleRelativeLayout
  extends RelativeLayout
{
  public QCircleRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleRelativeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleRelativeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
    int i2 = bcwh.a(getContext(), 5.0F);
    localPaint.setShadowLayer(bcwh.a(getContext(), 10.0F), 0, i2, Color.parseColor("#99A6ABBD"));
    i2 = bcwh.a(getContext(), 6.0F);
    paramCanvas.drawRoundRect(new RectF(i, j, k - m, n - i1), i2, i2, localPaint);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */