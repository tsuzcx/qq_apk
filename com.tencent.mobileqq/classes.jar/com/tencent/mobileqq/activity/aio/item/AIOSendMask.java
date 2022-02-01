package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

public class AIOSendMask
  extends Drawable
{
  private static final RectF g = new RectF();
  private static final Rect h = new Rect();
  private Paint a = new Paint(1);
  private float b;
  private boolean c = false;
  private Paint d;
  private Rect e;
  private String f;
  
  public AIOSendMask(int paramInt, float paramFloat)
  {
    this.a.setColor(paramInt);
    this.b = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = true;
    this.d = new Paint(1);
    this.d.setTextSize(paramInt1);
    this.d.setColor(paramInt2);
    this.e = new Rect();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = getLevel();
    if (i == 0) {
      return;
    }
    Object localObject1 = h;
    Rect localRect = getBounds();
    int j = localRect.width();
    int k = localRect.height();
    k -= (10000 - i) * k / 10000;
    int m = paramCanvas.getHeight();
    Gravity.apply(48, j, k, localRect, (Rect)localObject1);
    if ((j > 0) && (k > 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(100 - i / 100);
      ((StringBuilder)localObject2).append("%");
      this.f = ((StringBuilder)localObject2).toString();
      paramCanvas.save();
      boolean bool = this.c;
      float f2 = 0.0F;
      float f1;
      if (bool)
      {
        localObject2 = this.d;
        String str = this.f;
        ((Paint)localObject2).getTextBounds(str, 0, str.length(), this.e);
        f2 = (paramCanvas.getWidth() - this.e.width()) / 2;
        f1 = (m + this.e.height()) / 2;
        paramCanvas.drawText(this.f, f2, f1, this.d);
      }
      else
      {
        f1 = 0.0F;
      }
      paramCanvas.clipRect((Rect)localObject1);
      g.set(localRect);
      localObject1 = g;
      float f3 = this.b;
      paramCanvas.drawRoundRect((RectF)localObject1, f3, f3, this.a);
      if (this.c) {
        paramCanvas.drawText(this.f, f2, f1, this.d);
      }
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOSendMask
 * JD-Core Version:    0.7.0.1
 */