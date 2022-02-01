package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;

public class SystemEmoCell
  extends TextCell
{
  public Drawable emoDrawable;
  public int mHeight;
  public int mWidth;
  
  public SystemEmoCell(String paramString, int paramInt)
  {
    super(0, paramString);
    this.mHeight = paramInt;
    this.mWidth = paramInt;
  }
  
  public SystemEmoCell(String paramString, int paramInt, Drawable paramDrawable)
  {
    super(0, paramString);
    this.emoDrawable = paramDrawable;
    if ((paramDrawable != null) && (paramInt > 0))
    {
      this.mHeight = paramInt;
      int j = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int i = paramInt;
      if (j > 0)
      {
        i = paramInt;
        if (k > 0) {
          i = (int)(paramInt * j / k);
        }
      }
      this.mWidth = i;
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if ((!this.useDefaultFont) && ((paramPaint instanceof ETPaint)))
    {
      localObject = (ETPaint)paramPaint;
      if ((((ETPaint)localObject).d()) && (!((ETPaint)localObject).a)) {
        return;
      }
    }
    Object localObject = this.emoDrawable;
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds(0, 0, this.mWidth, this.mHeight);
      paramCanvas.save();
      paramCanvas.translate(paramRect.left, paramRect.top - 1 + (paramInt1 - this.emoDrawable.getBounds().height()) / 2);
      this.emoDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.draw(paramCanvas, paramPaint, paramInt1, paramRect, paramInt2, paramInt3, paramBitmap);
  }
  
  public int getHeight(Paint paramPaint)
  {
    return this.mHeight;
  }
  
  public float getWidth(Paint paramPaint)
  {
    return this.mWidth;
  }
  
  public int getWidths(Paint paramPaint, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = this.mWidth;
    return 1;
  }
  
  public void reloadDrawable(TextLayoutBase paramTextLayoutBase, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    EmoObjectPool.a().a(this, paramTextLayoutBase, paramImageLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.SystemEmoCell
 * JD-Core Version:    0.7.0.1
 */