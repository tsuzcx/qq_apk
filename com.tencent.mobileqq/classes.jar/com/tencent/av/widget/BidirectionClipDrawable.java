package com.tencent.av.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;

public class BidirectionClipDrawable
  extends ClipDrawable
{
  private Drawable a;
  private Drawable b;
  private int c;
  private int d;
  private final Rect e = new Rect();
  private final Rect f = new Rect();
  
  private BidirectionClipDrawable()
  {
    super(null, 17, 1);
  }
  
  public BidirectionClipDrawable(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2)
  {
    super(paramDrawable1, paramInt1, 1);
    this.a = paramDrawable1;
    this.b = paramDrawable2;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    int i = this.d;
    return a(0.0F, paramFloat2, paramFloat1, i / 2 + 0, paramFloat2 - i / 2);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramFloat2 = (paramFloat2 + paramFloat1) / 2.0F;
    paramFloat5 = (paramFloat5 + paramFloat4) / 2.0F;
    return paramFloat5 + (paramFloat3 - paramFloat2) * (paramFloat5 - paramFloat4) / (paramFloat2 - paramFloat1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect1 = this.e;
    Rect localRect2 = this.f;
    Rect localRect3 = getBounds();
    float f1 = getLevel() / 10000.0F;
    localRect1.set(localRect3);
    localRect2.set(localRect3);
    if ((this.c & 0x1) != 0)
    {
      float f2 = a(localRect3.left + localRect3.width() * f1, localRect3.width());
      localRect1.right = ((int)(f2 - this.d / 2) + localRect3.width() / 45);
      localRect2.left = ((int)(f2 + this.d / 2) - localRect3.width() / 45);
    }
    if ((this.c & 0x2) != 0)
    {
      f1 = a(localRect3.top + localRect3.height() * f1, localRect3.height());
      localRect1.bottom = ((int)(f1 - this.d / 2) + localRect3.height() / 45);
      localRect2.top = ((int)(f1 + this.d / 2) - localRect3.height() / 45);
    }
    paramCanvas.save();
    paramCanvas.clipRect(localRect1);
    this.a.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(localRect2);
    this.b.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.b.setBounds(paramRect);
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.b.setLevel(paramInt);
    return super.onLevelChange(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.b.setState(paramArrayOfInt);
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
    super.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.BidirectionClipDrawable
 * JD-Core Version:    0.7.0.1
 */