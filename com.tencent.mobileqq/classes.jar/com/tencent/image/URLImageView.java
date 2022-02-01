package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.net.URL;

public class URLImageView
  extends ImageView
  implements URLDrawable.URLDrawableListener
{
  private URLDrawableDownListener listener;
  
  public URLImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public URLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public URLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    URLDrawableDownListener localURLDrawableDownListener = this.listener;
    if (localURLDrawableDownListener != null) {
      localURLDrawableDownListener.onLoadCancelled(this, paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (getDrawable() == paramURLDrawable)
    {
      super.setImageDrawable(null);
      super.setImageDrawable(paramURLDrawable);
    }
    else if (getBackground() == paramURLDrawable)
    {
      super.setBackgroundDrawable(null);
      super.setBackgroundDrawable(paramURLDrawable);
    }
    paramThrowable = this.listener;
    if (paramThrowable != null) {
      paramThrowable.onLoadFailed(this, paramURLDrawable, null);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    URLDrawableDownListener localURLDrawableDownListener = this.listener;
    if (localURLDrawableDownListener != null) {
      localURLDrawableDownListener.onLoadProgressed(this, paramURLDrawable, paramInt);
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (getDrawable() == paramURLDrawable)
    {
      super.setImageDrawable(null);
      super.setImageDrawable(paramURLDrawable);
    }
    else if (getBackground() == paramURLDrawable)
    {
      super.setBackgroundDrawable(null);
      super.setBackgroundDrawable(paramURLDrawable);
    }
    URLDrawableDownListener localURLDrawableDownListener = this.listener;
    if (localURLDrawableDownListener != null) {
      localURLDrawableDownListener.onLoadSuccessed(this, paramURLDrawable);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getBackground();
    if (localDrawable == paramDrawable) {
      return;
    }
    if ((localDrawable instanceof URLDrawable)) {
      ((URLDrawable)localDrawable).setURLDrawableListener(null);
    }
    if ((paramDrawable instanceof URLDrawable)) {
      ((URLDrawable)paramDrawable).setURLDrawableListener(this);
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundURL(String paramString)
  {
    if (paramString != null)
    {
      if (((getBackground() instanceof URLDrawable)) && (((URLDrawable)getBackground()).getURL().toString().equals(paramString))) {
        return;
      }
      setBackgroundDrawable(URLDrawable.getDrawable(paramString));
      return;
    }
    throw new IllegalArgumentException("url can't be null");
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == paramDrawable) {
      return;
    }
    if ((localDrawable instanceof URLDrawable)) {
      ((URLDrawable)localDrawable).setURLDrawableListener(null);
    }
    if ((paramDrawable instanceof URLDrawable)) {
      ((URLDrawable)paramDrawable).setURLDrawableListener(this);
    }
    super.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setImageURL(String paramString)
  {
    if (paramString != null)
    {
      if (((getDrawable() instanceof URLDrawable)) && (((URLDrawable)getDrawable()).getURL().toString().equals(paramString))) {
        return;
      }
      setImageDrawable(URLDrawable.getDrawable(paramString));
      return;
    }
    throw new IllegalArgumentException("url can't be null");
  }
  
  public void setURLDrawableDownListener(URLDrawableDownListener paramURLDrawableDownListener)
  {
    this.listener = paramURLDrawableDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.URLImageView
 * JD-Core Version:    0.7.0.1
 */