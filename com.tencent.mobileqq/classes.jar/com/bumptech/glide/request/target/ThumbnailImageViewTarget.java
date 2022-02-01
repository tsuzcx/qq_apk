package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public abstract class ThumbnailImageViewTarget<T>
  extends ImageViewTarget<T>
{
  protected void a(@Nullable T paramT)
  {
    ViewGroup.LayoutParams localLayoutParams = ((ImageView)this.a).getLayoutParams();
    Drawable localDrawable = b(paramT);
    paramT = localDrawable;
    if (localLayoutParams != null)
    {
      paramT = localDrawable;
      if (localLayoutParams.width > 0)
      {
        paramT = localDrawable;
        if (localLayoutParams.height > 0) {
          paramT = new FixedSizeDrawable(localDrawable, localLayoutParams.width, localLayoutParams.height);
        }
      }
    }
    ((ImageView)this.a).setImageDrawable(paramT);
  }
  
  protected abstract Drawable b(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.ThumbnailImageViewTarget
 * JD-Core Version:    0.7.0.1
 */