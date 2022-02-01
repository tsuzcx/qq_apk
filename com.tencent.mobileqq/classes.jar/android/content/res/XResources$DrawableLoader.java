package android.content.res;

import android.graphics.drawable.Drawable;

public abstract class XResources$DrawableLoader
{
  public abstract Drawable newDrawable(XResources paramXResources, int paramInt);
  
  public Drawable newDrawableForDensity(XResources paramXResources, int paramInt1, int paramInt2)
  {
    return newDrawable(paramXResources, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.DrawableLoader
 * JD-Core Version:    0.7.0.1
 */