package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class ViewAware
  implements ImageAware
{
  public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
  public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
  protected boolean checkActualViewSize;
  protected Reference<View> viewRef;
  
  public ViewAware(View paramView)
  {
    this(paramView, true);
  }
  
  public ViewAware(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("view must not be null");
    }
    this.viewRef = new WeakReference(paramView);
    this.checkActualViewSize = paramBoolean;
  }
  
  public int getHeight()
  {
    View localView = (View)this.viewRef.get();
    ViewGroup.LayoutParams localLayoutParams;
    if (localView != null)
    {
      localLayoutParams = localView.getLayoutParams();
      if ((!this.checkActualViewSize) || (localLayoutParams == null) || (localLayoutParams.height == -2)) {
        break label71;
      }
    }
    label71:
    for (int i = localView.getHeight();; i = 0)
    {
      int j = i;
      if (i <= 0)
      {
        j = i;
        if (localLayoutParams != null) {
          j = localLayoutParams.height;
        }
      }
      return j;
      return 0;
    }
  }
  
  public int getId()
  {
    View localView = (View)this.viewRef.get();
    if (localView == null) {
      return super.hashCode();
    }
    return localView.hashCode();
  }
  
  public ViewScaleType getScaleType()
  {
    return ViewScaleType.CROP;
  }
  
  public int getWidth()
  {
    View localView = (View)this.viewRef.get();
    ViewGroup.LayoutParams localLayoutParams;
    if (localView != null)
    {
      localLayoutParams = localView.getLayoutParams();
      if ((!this.checkActualViewSize) || (localLayoutParams == null) || (localLayoutParams.width == -2)) {
        break label71;
      }
    }
    label71:
    for (int i = localView.getWidth();; i = 0)
    {
      int j = i;
      if (i <= 0)
      {
        j = i;
        if (localLayoutParams != null) {
          j = localLayoutParams.width;
        }
      }
      return j;
      return 0;
    }
  }
  
  public View getWrappedView()
  {
    return (View)this.viewRef.get();
  }
  
  public boolean isCollected()
  {
    return this.viewRef.get() == null;
  }
  
  public boolean setImageBitmap(Bitmap paramBitmap)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      View localView = (View)this.viewRef.get();
      if (localView != null)
      {
        setImageBitmapInto(paramBitmap, localView);
        return true;
      }
    }
    else
    {
      L.w("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
    }
    return false;
  }
  
  protected abstract void setImageBitmapInto(Bitmap paramBitmap, View paramView);
  
  public boolean setImageDrawable(Drawable paramDrawable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      View localView = (View)this.viewRef.get();
      if (localView != null)
      {
        setImageDrawableInto(paramDrawable, localView);
        return true;
      }
    }
    else
    {
      L.w("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
    }
    return false;
  }
  
  protected abstract void setImageDrawableInto(Drawable paramDrawable, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.imageaware.ViewAware
 * JD-Core Version:    0.7.0.1
 */