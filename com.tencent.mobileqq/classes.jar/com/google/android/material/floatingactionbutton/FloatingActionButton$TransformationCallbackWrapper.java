package com.google.android.material.floatingactionbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.TransformationCallback;

class FloatingActionButton$TransformationCallbackWrapper<T extends FloatingActionButton>
  implements FloatingActionButtonImpl.InternalTransformationCallback
{
  @NonNull
  private final TransformationCallback<T> b;
  
  FloatingActionButton$TransformationCallbackWrapper(TransformationCallback<T> paramTransformationCallback)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void a()
  {
    this.b.a(this.a);
  }
  
  public void b()
  {
    this.b.b(this.a);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof TransformationCallbackWrapper)) && (((TransformationCallbackWrapper)paramObject).b.equals(this.b));
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */