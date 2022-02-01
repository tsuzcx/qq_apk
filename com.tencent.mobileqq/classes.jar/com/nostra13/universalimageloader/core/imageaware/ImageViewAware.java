package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.reflect.Field;

public class ImageViewAware
  extends ViewAware
{
  public ImageViewAware(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  public ImageViewAware(ImageView paramImageView, boolean paramBoolean)
  {
    super(paramImageView, paramBoolean);
  }
  
  private static int getImageViewFieldValue(Object paramObject, String paramString)
  {
    try
    {
      paramString = ImageView.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      int i = ((Integer)paramString.get(paramObject)).intValue();
      if ((i > 0) && (i < 2147483647)) {
        return i;
      }
    }
    catch (Exception paramObject)
    {
      L.e(paramObject);
    }
    return 0;
  }
  
  public int getHeight()
  {
    int j = super.getHeight();
    int i = j;
    if (j <= 0)
    {
      ImageView localImageView = (ImageView)this.viewRef.get();
      i = j;
      if (localImageView != null) {
        i = getImageViewFieldValue(localImageView, "mMaxHeight");
      }
    }
    return i;
  }
  
  public ViewScaleType getScaleType()
  {
    ImageView localImageView = (ImageView)this.viewRef.get();
    if (localImageView != null) {
      return ViewScaleType.fromImageView(localImageView);
    }
    return super.getScaleType();
  }
  
  public int getWidth()
  {
    int j = super.getWidth();
    int i = j;
    if (j <= 0)
    {
      ImageView localImageView = (ImageView)this.viewRef.get();
      i = j;
      if (localImageView != null) {
        i = getImageViewFieldValue(localImageView, "mMaxWidth");
      }
    }
    return i;
  }
  
  public ImageView getWrappedView()
  {
    return (ImageView)super.getWrappedView();
  }
  
  protected void setImageBitmapInto(Bitmap paramBitmap, View paramView)
  {
    ((ImageView)paramView).setImageBitmap(paramBitmap);
  }
  
  protected void setImageDrawableInto(Drawable paramDrawable, View paramView)
  {
    ((ImageView)paramView).setImageDrawable(paramDrawable);
    if ((paramDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramDrawable).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.imageaware.ImageViewAware
 * JD-Core Version:    0.7.0.1
 */