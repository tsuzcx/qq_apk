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
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  
  public GdtRoundRectURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if (Build.VERSION.SDK_INT < 21)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      i = this.jdField_a_of_type_Int;
      localPath.addRoundRect(localRectF, i, i, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    else
    {
      setClipToOutline(true);
      setOutlineProvider(new GdtRoundRectURLImageView.1(this, i, j));
    }
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtRoundRectURLImageView
 * JD-Core Version:    0.7.0.1
 */