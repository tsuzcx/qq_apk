package com.tencent.gdtad.api.banner.rectangle;

import android.graphics.Canvas;
import com.tencent.gdtad.views.image.GdtCircle;
import com.tencent.image.URLImageView;

final class GdtCircleImageView
  extends URLImageView
{
  private GdtCircle a;
  
  public void onDraw(Canvas paramCanvas)
  {
    this.a.a(paramCanvas, getDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtCircleImageView
 * JD-Core Version:    0.7.0.1
 */