package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class TriangleView
  extends View
{
  public static final int a = ViewUtils.dip2px(7.0F);
  public static final int b = ViewUtils.dip2px(2.0F);
  public static final int c = ViewUtils.dip2px(2.0F);
  private int d = 1;
  private int e = Color.parseColor("#00CAFC");
  
  public TriangleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TriangleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(this.e);
    localPaint.setStyle(Paint.Style.FILL);
    Path localPath = new Path();
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if (this.d == 0)
    {
      localPath.moveTo(i / 2, 0.0F);
      localPath.lineTo(i / 2 - a, j);
      localPath.lineTo(i / 2 + a, j);
    }
    for (;;)
    {
      localPath.close();
      paramCanvas.drawPath(localPath, localPaint);
      return;
      localPath.moveTo(i / 2, 0.0F);
      localPath.lineTo(i / 2 - a, 0.0F);
      localPath.lineTo(i / 2 - b, j - c);
      localPath.quadTo(i / 2, j, i / 2 + b, j - c);
      localPath.lineTo(i / 2 + a, 0.0F);
    }
  }
  
  public void setDirection(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setDrawColor(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TriangleView
 * JD-Core Version:    0.7.0.1
 */