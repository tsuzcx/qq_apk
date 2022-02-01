package com.google.android.material.transition.platform;

import android.transition.Transition;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;

class MaterialContainerTransform$2
  extends TransitionListenerAdapter
{
  MaterialContainerTransform$2(MaterialContainerTransform paramMaterialContainerTransform, View paramView1, MaterialContainerTransform.TransitionDrawable paramTransitionDrawable, View paramView2, View paramView3) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform.removeListener(this);
    if (MaterialContainerTransform.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform)) {
      return;
    }
    this.b.setAlpha(1.0F);
    this.c.setAlpha(1.0F);
    ViewUtils.a(this.jdField_a_of_type_AndroidViewView).b(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$TransitionDrawable);
  }
  
  public void onTransitionStart(@NonNull Transition paramTransition)
  {
    ViewUtils.a(this.jdField_a_of_type_AndroidViewView).a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransitionPlatformMaterialContainerTransform$TransitionDrawable);
    this.b.setAlpha(0.0F);
    this.c.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransform.2
 * JD-Core Version:    0.7.0.1
 */