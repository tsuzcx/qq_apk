package com.bumptech.glide.load.resource;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T>
  implements Transformation<T>
{
  private static final Transformation<?> b = new UnitTransformation();
  
  @NonNull
  public static <T> UnitTransformation<T> a()
  {
    return (UnitTransformation)b;
  }
  
  @NonNull
  public Resource<T> a(@NonNull Context paramContext, @NonNull Resource<T> paramResource, int paramInt1, int paramInt2)
  {
    return paramResource;
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.UnitTransformation
 * JD-Core Version:    0.7.0.1
 */