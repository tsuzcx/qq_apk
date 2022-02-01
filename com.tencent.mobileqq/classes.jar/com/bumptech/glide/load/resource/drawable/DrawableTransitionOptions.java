package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder;

public final class DrawableTransitionOptions
  extends TransitionOptions<DrawableTransitionOptions, Drawable>
{
  @NonNull
  public static DrawableTransitionOptions c()
  {
    return new DrawableTransitionOptions().d();
  }
  
  @NonNull
  public DrawableTransitionOptions a(@NonNull DrawableCrossFadeFactory.Builder paramBuilder)
  {
    return a(paramBuilder.a());
  }
  
  @NonNull
  public DrawableTransitionOptions a(@NonNull DrawableCrossFadeFactory paramDrawableCrossFadeFactory)
  {
    return (DrawableTransitionOptions)a(paramDrawableCrossFadeFactory);
  }
  
  @NonNull
  public DrawableTransitionOptions d()
  {
    return a(new DrawableCrossFadeFactory.Builder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
 * JD-Core Version:    0.7.0.1
 */