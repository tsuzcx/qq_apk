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
    Drawable localDrawable;
    if (!(paramDrawable instanceof NewGifDrawable)) {
      localDrawable = super.process(paramDrawable);
    }
    int i;
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localDrawable;
              i = paramDrawable.getIntrinsicWidth();
              j = paramDrawable.getIntrinsicHeight();
              localDrawable = paramDrawable;
            } while (i == 0);
            localDrawable = paramDrawable;
          } while (j == 0);
          paramDrawable = (NewGifDrawable)paramDrawable;
          if (i <= j) {
            break;
          }
          k = this.mDisplayRect.left + this.mDisplayRect.right;
          localDrawable = paramDrawable;
        } while (k <= 0);
        i = (i - j) * this.mDisplayRect.left / k;
        paramDrawable.setSrcRect(new Rect(i, 0, i + j, j));
        paramDrawable.setIntrinsicWidth(j);
        paramDrawable.setIntrinsicHeight(j);
        return paramDrawable;
        localDrawable = paramDrawable;
      } while (i >= j);
      k = this.mDisplayRect.top + this.mDisplayRect.bottom;
      localDrawable = paramDrawable;
    } while (k <= 0);
    int j = (j - i) * this.mDisplayRect.top / k;
    paramDrawable.setSrcRect(new Rect(0, j, i, j + i));
    paramDrawable.setIntrinsicWidth(i);
    paramDrawable.setIntrinsicHeight(i);
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor
 * JD-Core Version:    0.7.0.1
 */