package com.tencent.component.media.image.processor;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.gif.NewGifDrawable;

public class NewGifDrawableSpecifiedRegionProcessor
  extends SpecifiedSizeCropByPivotProcessor
{
  public int height;
  private final Rect mDisplayRect = new Rect();
  public int width;
  
  public NewGifDrawableSpecifiedRegionProcessor(int paramInt1, int paramInt2, Rect paramRect)
  {
    super(paramInt1, paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
    if (paramRect != null) {
      this.mDisplayRect.set(paramRect);
    }
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if (!(paramDrawable instanceof NewGifDrawable)) {
      return super.process(paramDrawable);
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Drawable localDrawable = paramDrawable;
    if (i != 0)
    {
      if (j == 0) {
        return paramDrawable;
      }
      paramDrawable = (NewGifDrawable)paramDrawable;
      int k;
      if (i > j)
      {
        k = this.mDisplayRect.left + this.mDisplayRect.right;
        localDrawable = paramDrawable;
        if (k > 0)
        {
          i = (i - j) * this.mDisplayRect.left / k;
          paramDrawable.setSrcRect(new Rect(i, 0, i + j, j));
          paramDrawable.setIntrinsicWidth(j);
          paramDrawable.setIntrinsicHeight(j);
          return paramDrawable;
        }
      }
      else
      {
        localDrawable = paramDrawable;
        if (i < j)
        {
          k = this.mDisplayRect.top + this.mDisplayRect.bottom;
          localDrawable = paramDrawable;
          if (k > 0)
          {
            j = (j - i) * this.mDisplayRect.top / k;
            paramDrawable.setSrcRect(new Rect(0, j, i, j + i));
            paramDrawable.setIntrinsicWidth(i);
            paramDrawable.setIntrinsicHeight(i);
            localDrawable = paramDrawable;
          }
        }
      }
    }
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor
 * JD-Core Version:    0.7.0.1
 */