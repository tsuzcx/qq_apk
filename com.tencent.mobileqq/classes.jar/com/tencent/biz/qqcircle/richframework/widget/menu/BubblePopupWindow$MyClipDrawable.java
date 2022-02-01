package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.image.ProxyDrawable;

class BubblePopupWindow$MyClipDrawable
  extends ProxyDrawable
{
  int a;
  int b;
  
  public BubblePopupWindow$MyClipDrawable(BubblePopupWindow paramBubblePopupWindow, Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (this.b > this.a)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(this.a, 0, this.b, localRect.height());
      this.mCurrDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.MyClipDrawable
 * JD-Core Version:    0.7.0.1
 */