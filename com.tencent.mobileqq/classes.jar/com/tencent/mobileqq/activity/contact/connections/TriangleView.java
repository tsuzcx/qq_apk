package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class TriangleView
  extends View
{
  public static final int a = ViewUtils.a(7.0F);
  public static final int b = ViewUtils.a(2.0F);
  public static final int c = ViewUtils.a(2.0F);
  private int d = 1;
  private int e = Color.parseColor("#00CAFC");
  
  public TriangleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
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
    int j = getMeasuredWidth();
    int i = getMeasuredHeight();
    float f1;
    if (this.d == 0)
    {
      j /= 2;
      localPath.moveTo(j, 0.0F);
      f1 = j - a;
      float f2 = i;
      localPath.lineTo(f1, f2);
      localPath.lineTo(j + a, f2);
    }
    else
    {
      j /= 2;
      f1 = j;
      localPath.moveTo(f1, 0.0F);
      localPath.lineTo(j - a, 0.0F);
      localPath.lineTo(j - b, i - c);
      localPath.quadTo(f1, i, b + j, i - c);
      localPath.lineTo(j + a, 0.0F);
    }
    localPath.close();
    paramCanvas.drawPath(localPath, localPaint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TriangleView
 * JD-Core Version:    0.7.0.1
 */