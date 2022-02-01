package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;

final class ListPreloader$PreloadTarget
  extends BaseTarget<Object>
{
  int a;
  int b;
  
  public void a(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    paramSizeReadyCallback.a(this.b, this.a);
  }
  
  public void a(@NonNull Object paramObject, @Nullable Transition<? super Object> paramTransition) {}
  
  public void b(@NonNull SizeReadyCallback paramSizeReadyCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.ListPreloader.PreloadTarget
 * JD-Core Version:    0.7.0.1
 */