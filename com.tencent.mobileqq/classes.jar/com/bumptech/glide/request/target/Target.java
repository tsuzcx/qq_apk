package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public abstract interface Target<R>
  extends LifecycleListener
{
  @Nullable
  public abstract Request a();
  
  public abstract void a(@Nullable Drawable paramDrawable);
  
  public abstract void a(@Nullable Request paramRequest);
  
  public abstract void a(@NonNull SizeReadyCallback paramSizeReadyCallback);
  
  public abstract void a(@NonNull R paramR, @Nullable Transition<? super R> paramTransition);
  
  public abstract void b(@Nullable Drawable paramDrawable);
  
  public abstract void b(@NonNull SizeReadyCallback paramSizeReadyCallback);
  
  public abstract void c(@Nullable Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.Target
 * JD-Core Version:    0.7.0.1
 */