package com.bumptech.glide.request.transition;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

final class BitmapContainerTransitionFactory$BitmapGlideAnimation
  implements Transition<R>
{
  private final Transition<Drawable> b;
  
  BitmapContainerTransitionFactory$BitmapGlideAnimation(Transition<Drawable> paramTransition)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public boolean a(R paramR, Transition.ViewAdapter paramViewAdapter)
  {
    paramR = new BitmapDrawable(paramViewAdapter.h().getResources(), this.a.a(paramR));
    return this.b.a(paramR, paramViewAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.BitmapContainerTransitionFactory.BitmapGlideAnimation
 * JD-Core Version:    0.7.0.1
 */