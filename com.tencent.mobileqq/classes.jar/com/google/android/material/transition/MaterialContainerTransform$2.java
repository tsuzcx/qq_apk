package com.google.android.material.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;

class MaterialContainerTransform$2
  extends TransitionListenerAdapter
{
  MaterialContainerTransform$2(MaterialContainerTransform paramMaterialContainerTransform, View paramView1, MaterialContainerTransform.TransitionDrawable paramTransitionDrawable, View paramView2, View paramView3) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    this.e.removeListener(this);
    if (MaterialContainerTransform.a(this.e)) {
      return;
    }
    this.c.setAlpha(1.0F);
    this.d.setAlpha(1.0F);
    ViewUtils.e(this.a).b(this.b);
  }
  
  public void onTransitionStart(@NonNull Transition paramTransition)
  {
    ViewUtils.e(this.a).a(this.b);
    this.c.setAlpha(0.0F);
    this.d.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.MaterialContainerTransform.2
 * JD-Core Version:    0.7.0.1
 */