package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class AIOFilePicMask
  extends Drawable
{
  private static final RectF c = new RectF();
  private static final Rect d = new Rect();
  private Paint a = new Paint(1);
  private float b;
  private int e;
  private ColorFilter f;
  
  public AIOFilePicMask(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a.setColor(paramInt1);
    this.a.setAlpha(paramInt2);
    this.b = paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = getBounds();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    if ((i > 0) && (j > 0))
    {
      paramCanvas.save();
      c.set((Rect)localObject);
      localObject = c;
      float f1 = this.b;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.a);
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.f = paramColorFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOFilePicMask
 * JD-Core Version:    0.7.0.1
 */