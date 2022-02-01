package com.tencent.avgame.gameroom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CoverRoundCornerRelativeLayout
  extends RelativeLayout
{
  protected boolean a = false;
  protected float[] b = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  protected int c = 0;
  protected int d = 0;
  protected int e;
  protected int f;
  protected Path g;
  protected Path h;
  protected Paint i = new Paint();
  
  public CoverRoundCornerRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoverRoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoverRoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.FILL);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.g == null) || (this.h == null) || (this.e != getMeasuredWidth()) || (this.f != getMeasuredHeight()))
    {
      this.e = getMeasuredWidth();
      this.f = getMeasuredHeight();
      this.h = new Path();
      this.g = new Path();
      RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), this.e - getPaddingRight(), this.f - getPaddingBottom());
      this.g.addRoundRect(localRectF, this.b, Path.Direction.CW);
      this.h.addRect(new RectF(0.0F, 0.0F, this.e, this.f), Path.Direction.CCW);
      this.h.addRoundRect(localRectF, this.b, Path.Direction.CW);
    }
    super.dispatchDraw(paramCanvas);
    if (this.a)
    {
      paramCanvas.save();
      this.i.setColor(this.d);
      paramCanvas.drawPath(this.g, this.i);
      paramCanvas.restore();
    }
    paramCanvas.save();
    this.i.setColor(this.c);
    paramCanvas.drawPath(this.h, this.i);
    paramCanvas.restore();
  }
  
  public void setIsPressed(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setPressCoverColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setRadius(int paramInt, float paramFloat)
  {
    setRadius(paramInt, paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setRadius(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */