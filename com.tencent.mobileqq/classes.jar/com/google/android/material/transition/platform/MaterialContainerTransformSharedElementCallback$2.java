package com.google.android.material.transition.platform;

import android.app.Activity;
import android.transition.Transition;
import android.view.View;
import java.lang.ref.WeakReference;

class MaterialContainerTransformSharedElementCallback$2
  extends TransitionListenerAdapter
{
  MaterialContainerTransformSharedElementCallback$2(MaterialContainerTransformSharedElementCallback paramMaterialContainerTransformSharedElementCallback, Activity paramActivity) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    if (MaterialContainerTransformSharedElementCallback.a() != null)
    {
      paramTransition = (View)MaterialContainerTransformSharedElementCallback.a().get();
      if (paramTransition != null)
      {
        paramTransition.setAlpha(1.0F);
        MaterialContainerTransformSharedElementCallback.a(null);
      }
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.2
 * JD-Core Version:    0.7.0.1
 */