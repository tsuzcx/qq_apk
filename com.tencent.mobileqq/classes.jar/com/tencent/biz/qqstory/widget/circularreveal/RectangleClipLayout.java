package com.tencent.biz.qqstory.widget.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RectangleClipLayout
  extends FrameLayout
{
  private RectF a = new RectF();
  private float b;
  private final Path c = new Path();
  private boolean d = true;
  
  public RectangleClipLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RectangleClipLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RectangleClipLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.d) && (!this.c.isEmpty()))
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.c);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public float getRadius()
  {
    if (this.d) {
      return this.b;
    }
    return -1.0F;
  }
  
  public void setClipRect(RectF paramRectF, float paramFloat)
  {
    if ((paramRectF.width() >= getWidth()) && (paramRectF.height() >= getHeight()))
    {
      this.d = false;
      invalidate();
      return;
    }
    this.d = true;
    this.a.set(paramRectF);
    this.b = paramFloat;
    this.c.reset();
    paramRectF = this.c;
    RectF localRectF = this.a;
    paramFloat = this.b;
    paramRectF.addRoundRect(localRectF, paramFloat, paramFloat, Path.Direction.CW);
    this.c.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.RectangleClipLayout
 * JD-Core Version:    0.7.0.1
 */