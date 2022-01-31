package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
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
    paramContext = getContentDescription();
    if (!TextUtils.isEmpty(paramContext)) {}
    try
    {
      setImageURL(paramContext.toString());
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("URLDrawable_", 2, "Illegal url: " + paramContext);
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.listener != null) {
      this.listener.onLoadCancelled(this, paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (getDrawable() == paramURLDrawable)
    {
      super.setImageDrawable(null);
      super.setImageDrawable(paramURLDrawable);
    }
    for (;;)
    {
      if (this.listener != null) {
        this.listener.onLoadFailed(this, paramURLDrawable, null);
      }
      return;
      if (getBackground() == paramURLDrawable)
      {
        super.setBackgroundDrawable(null);
        super.setBackgroundDrawable(paramURLDrawable);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.listener != null) {
      this.listener.onLoadProgressed(this, paramURLDrawable, paramInt);
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
    for (;;)
    {
      if (this.listener != null) {
        this.listener.onLoadSuccessed(this, paramURLDrawable);
      }
      return;
      if (getBackground() == paramURLDrawable)
      {
        super.setBackgroundDrawable(null);
        super.setBackgroundDrawable(paramURLDrawable);
      }
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
    if (paramString == null) {
      throw new IllegalArgumentException("url can't be null");
    }
    if (((getBackground() instanceof URLDrawable)) && (((URLDrawable)getBackground()).getURL().toString().equals(paramString))) {
      return;
    }
    setBackgroundDrawable(URLDrawable.getDrawable(paramString));
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
    if (paramString == null) {
      throw new IllegalArgumentException("url can't be null");
    }
    if (((getDrawable() instanceof URLDrawable)) && (((URLDrawable)getDrawable()).getURL().toString().equals(paramString))) {
      return;
    }
    setImageDrawable(URLDrawable.getDrawable(paramString));
  }
  
  public void setURLDrawableDownListener(URLDrawableDownListener paramURLDrawableDownListener)
  {
    this.listener = paramURLDrawableDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLImageView
 * JD-Core Version:    0.7.0.1
 */