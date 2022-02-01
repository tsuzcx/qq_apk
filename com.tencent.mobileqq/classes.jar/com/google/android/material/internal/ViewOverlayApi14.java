package com.google.android.material.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class ViewOverlayApi14
  implements ViewOverlayImpl
{
  protected ViewOverlayApi14.OverlayViewGroup a = new ViewOverlayApi14.OverlayViewGroup(paramContext, paramViewGroup, paramView, this);
  
  ViewOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static ViewOverlayApi14 a(View paramView)
  {
    ViewGroup localViewGroup = ViewUtils.f(paramView);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof ViewOverlayApi14.OverlayViewGroup)) {
          return ((ViewOverlayApi14.OverlayViewGroup)localView).e;
        }
        i += 1;
      }
      return new ViewGroupOverlayApi14(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  public void a(@NonNull Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }
  
  public void b(@NonNull Drawable paramDrawable)
  {
    this.a.b(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewOverlayApi14
 * JD-Core Version:    0.7.0.1
 */