package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewOverlayApi18
  implements ViewOverlayImpl
{
  private final ViewOverlay a;
  
  ViewOverlayApi18(@NonNull View paramView)
  {
    this.a = paramView.getOverlay();
  }
  
  public void a(@NonNull Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void b(@NonNull Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ViewOverlayApi18
 * JD-Core Version:    0.7.0.1
 */