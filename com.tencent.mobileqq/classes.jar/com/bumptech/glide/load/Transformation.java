package com.bumptech.glide.load;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

public abstract interface Transformation<T>
  extends Key
{
  @NonNull
  public abstract Resource<T> a(@NonNull Context paramContext, @NonNull Resource<T> paramResource, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.Transformation
 * JD-Core Version:    0.7.0.1
 */