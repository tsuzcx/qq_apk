package com.google.android.material.transition.platform;

import android.transition.Transition;
import android.view.Window;

class MaterialContainerTransformSharedElementCallback$1
  extends TransitionListenerAdapter
{
  MaterialContainerTransformSharedElementCallback$1(MaterialContainerTransformSharedElementCallback paramMaterialContainerTransformSharedElementCallback, Window paramWindow) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    MaterialContainerTransformSharedElementCallback.b(this.jdField_a_of_type_AndroidViewWindow);
  }
  
  public void onTransitionStart(Transition paramTransition)
  {
    MaterialContainerTransformSharedElementCallback.a(this.jdField_a_of_type_AndroidViewWindow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.1
 * JD-Core Version:    0.7.0.1
 */