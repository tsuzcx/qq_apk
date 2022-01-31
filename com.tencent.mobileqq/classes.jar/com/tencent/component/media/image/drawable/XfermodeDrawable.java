package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import pih;

public class XfermodeDrawable
  extends DrawableContainer
{
  private pih a;
  
  public XfermodeDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public XfermodeDrawable(Drawable paramDrawable, Xfermode paramXfermode)
  {
    if (!support(paramDrawable)) {
      throw new RuntimeException("No xfermode support for " + paramDrawable.getClass().getSimpleName());
    }
    this.a = new pih(paramDrawable, this, paramXfermode);
    setConstantState(this.a);
  }
  
  private XfermodeDrawable(pih parampih, Resources paramResources)
  {
    this.a = parampih;
    setConstantState(this.a);
  }
  
  private static Paint a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return null;
      } while ((paramDrawable instanceof XfermodeDrawable));
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getPaint();
      }
      if ((paramDrawable instanceof NinePatchDrawable)) {
        return ((NinePatchDrawable)paramDrawable).getPaint();
      }
      if ((paramDrawable instanceof ShapeDrawable)) {
        return ((ShapeDrawable)paramDrawable).getPaint();
      }
      if ((paramDrawable instanceof ImageDrawable)) {
        return ((ImageDrawable)paramDrawable).getPaint();
      }
    } while (!(paramDrawable instanceof DrawableContainer));
    return a(((DrawableContainer)paramDrawable).getDrawable());
  }
  
  public static Drawable create(Drawable paramDrawable, Xfermode paramXfermode)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (support(paramDrawable)) {
        localObject = new XfermodeDrawable(paramDrawable, paramXfermode);
      }
    }
    return localObject;
  }
  
  public static boolean support(Drawable paramDrawable)
  {
    return (paramDrawable == null) || (a(paramDrawable) != null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = a(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    Xfermode localXfermode = this.a.jdField_a_of_type_AndroidGraphicsXfermode;
    if ((localPaint != null) && (localPaint.getXfermode() != localXfermode)) {
      localPaint.setXfermode(localXfermode);
    }
    super.draw(paramCanvas);
  }
  
  public void setXfermode(Xfermode paramXfermode)
  {
    if (this.a.jdField_a_of_type_AndroidGraphicsXfermode != paramXfermode)
    {
      this.a.jdField_a_of_type_AndroidGraphicsXfermode = paramXfermode;
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.XfermodeDrawable
 * JD-Core Version:    0.7.0.1
 */