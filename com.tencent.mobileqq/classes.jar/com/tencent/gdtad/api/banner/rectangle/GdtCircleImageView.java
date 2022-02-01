package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.gdtad.views.image.GdtCircle;
import com.tencent.image.URLImageView;

final class GdtCircleImageView
  extends URLImageView
{
  private GdtCircle a = new GdtCircle();
  
  public GdtCircleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(float paramFloat)
  {
    GdtCircle localGdtCircle = this.a;
    double d = 2.0F * paramFloat;
    localGdtCircle.a(Double.valueOf(d).intValue(), Double.valueOf(d).intValue());
    this.a.a(paramFloat, paramFloat);
    this.a.a(paramFloat);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.a.a(paramCanvas, getDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtCircleImageView
 * JD-Core Version:    0.7.0.1
 */