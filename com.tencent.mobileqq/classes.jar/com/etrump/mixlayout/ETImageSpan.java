package com.etrump.mixlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import fk;

public class ETImageSpan
  extends fk
{
  private int mLeft;
  private int mTop;
  
  public ETImageSpan(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ETImageSpan(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramPaint = getDrawable();
    paramCharSequence = paramPaint;
    if ((paramPaint instanceof AnimatedImageDrawable)) {
      paramCharSequence = ((AnimatedImageDrawable)paramPaint).a();
    }
    if (paramCharSequence == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt5 - getDrawable().getBounds().height());
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    return super.getDrawable();
  }
  
  public int getLeft()
  {
    return this.mLeft;
  }
  
  public int getTop()
  {
    return this.mTop;
  }
  
  public void setLeft(int paramInt)
  {
    this.mLeft = paramInt;
  }
  
  public void setTop(int paramInt)
  {
    this.mTop = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.ETImageSpan
 * JD-Core Version:    0.7.0.1
 */