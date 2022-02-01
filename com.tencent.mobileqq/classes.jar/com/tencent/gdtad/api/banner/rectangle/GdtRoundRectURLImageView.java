package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.tencent.image.URLImageView;

final class GdtRoundRectURLImageView
  extends URLImageView
{
  private Path a = new Path();
  private RectF b = new RectF();
  private int c;
  
  public GdtRoundRectURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if (Build.VERSION.SDK_INT < 21)
    {
      this.a.reset();
      this.b.set(0.0F, 0.0F, i, j);
      Path localPath = this.a;
      RectF localRectF = this.b;
      i = this.c;
      localPath.addRoundRect(localRectF, i, i, Path.Direction.CW);
      paramCanvas.clipPath(this.a);
    }
    else
    {
      setClipToOutline(true);
      setOutlineProvider(new GdtRoundRectURLImageView.1(this, i, j));
    }
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtRoundRectURLImageView
 * JD-Core Version:    0.7.0.1
 */