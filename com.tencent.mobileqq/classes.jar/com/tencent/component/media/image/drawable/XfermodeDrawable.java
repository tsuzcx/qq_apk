package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;

public class XfermodeDrawable
  extends DrawableContainer
{
  private XfermodeDrawable.XfermodeState mState;
  
  public XfermodeDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public XfermodeDrawable(Drawable paramDrawable, Xfermode paramXfermode)
  {
    if (support(paramDrawable))
    {
      this.mState = new XfermodeDrawable.XfermodeState(paramDrawable, this, paramXfermode);
      setConstantState(this.mState);
      return;
    }
    paramXfermode = new StringBuilder();
    paramXfermode.append("No xfermode support for ");
    paramXfermode.append(paramDrawable.getClass().getSimpleName());
    throw new RuntimeException(paramXfermode.toString());
  }
  
  private XfermodeDrawable(XfermodeDrawable.XfermodeState paramXfermodeState, Resources paramResources)
  {
    this.mState = paramXfermodeState;
    setConstantState(this.mState);
  }
  
  public static Drawable create(Drawable paramDrawable, Xfermode paramXfermode)
  {
    if ((paramDrawable != null) && (support(paramDrawable))) {
      return new XfermodeDrawable(paramDrawable, paramXfermode);
    }
    return paramDrawable;
  }
  
  private static Paint obtainPaint(Drawable paramDrawable)
  {
    Paint localPaint = null;
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof XfermodeDrawable)) {
      return null;
    }
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
    if ((paramDrawable instanceof DrawableContainer)) {
      localPaint = obtainPaint(((DrawableContainer)paramDrawable).getDrawable());
    }
    return localPaint;
  }
  
  public static boolean support(Drawable paramDrawable)
  {
    return (paramDrawable == null) || (obtainPaint(paramDrawable) != null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = obtainPaint(this.mState.mDrawable);
    Xfermode localXfermode = this.mState.mXfermode;
    if ((localPaint != null) && (localPaint.getXfermode() != localXfermode)) {
      localPaint.setXfermode(localXfermode);
    }
    super.draw(paramCanvas);
  }
  
  public void setXfermode(Xfermode paramXfermode)
  {
    if (this.mState.mXfermode != paramXfermode)
    {
      this.mState.mXfermode = paramXfermode;
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.XfermodeDrawable
 * JD-Core Version:    0.7.0.1
 */