package com.tencent.common.galleryactivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class URLImageView2
  extends URLImageView
{
  public URLDrawable a;
  public boolean b = false;
  
  public URLImageView2(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    URLDrawable localURLDrawable = this.a;
    if (paramURLDrawable == localURLDrawable)
    {
      setImageDrawable(localURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a)
    {
      Drawable localDrawable = getDrawable();
      if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
      {
        this.b = true;
        setImageDrawable(this.a);
        this.b = false;
        return;
      }
      setImageDrawable(this.a);
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void requestLayout()
  {
    if (!this.b) {
      super.requestLayout();
    }
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    URLDrawable localURLDrawable = this.a;
    if (localURLDrawable != null) {
      localURLDrawable.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.a = paramURLDrawable;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null)
    {
      paramDrawable.setURLDrawableListener(null);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.URLImageView2
 * JD-Core Version:    0.7.0.1
 */