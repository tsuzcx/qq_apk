package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public abstract class BitmapContainerTransitionFactory<R>
  implements TransitionFactory<R>
{
  private final TransitionFactory<Drawable> a;
  
  protected abstract Bitmap a(R paramR);
  
  public Transition<R> a(DataSource paramDataSource, boolean paramBoolean)
  {
    return new BitmapContainerTransitionFactory.BitmapGlideAnimation(this, this.a.a(paramDataSource, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
 * JD-Core Version:    0.7.0.1
 */