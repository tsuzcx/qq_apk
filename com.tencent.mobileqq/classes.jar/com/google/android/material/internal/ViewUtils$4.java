package com.google.android.material.internal;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

final class ViewUtils$4
  implements View.OnAttachStateChangeListener
{
  public void onViewAttachedToWindow(@NonNull View paramView)
  {
    paramView.removeOnAttachStateChangeListener(this);
    ViewCompat.requestApplyInsets(paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewUtils.4
 * JD-Core Version:    0.7.0.1
 */