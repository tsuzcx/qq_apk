package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewGroupOverlayApi18
  implements ViewGroupOverlayImpl
{
  private final ViewGroupOverlay a;
  
  public void a(@NonNull Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void b(@NonNull Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewGroupOverlayApi18
 * JD-Core Version:    0.7.0.1
 */