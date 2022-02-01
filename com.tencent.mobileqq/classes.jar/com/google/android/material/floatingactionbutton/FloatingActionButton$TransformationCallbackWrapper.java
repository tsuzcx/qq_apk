package com.google.android.material.floatingactionbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.TransformationCallback;

class FloatingActionButton$TransformationCallbackWrapper<T extends FloatingActionButton>
  implements FloatingActionButtonImpl.InternalTransformationCallback
{
  @NonNull
  private final TransformationCallback<T> jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback;
  
  FloatingActionButton$TransformationCallbackWrapper(TransformationCallback<T> paramTransformationCallback)
  {
    Object localObject;
    this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback = localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback.b(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof TransformationCallbackWrapper)) && (((TransformationCallbackWrapper)paramObject).jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback.equals(this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback));
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationTransformationCallback.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */