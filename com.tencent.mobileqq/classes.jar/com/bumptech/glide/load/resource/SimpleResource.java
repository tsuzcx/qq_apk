package com.bumptech.glide.load.resource;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T>
  implements Resource<T>
{
  protected final T a;
  
  public SimpleResource(@NonNull T paramT)
  {
    this.a = Preconditions.a(paramT);
  }
  
  @NonNull
  public Class<T> c()
  {
    return this.a.getClass();
  }
  
  @NonNull
  public final T d()
  {
    return this.a;
  }
  
  public final int e()
  {
    return 1;
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.SimpleResource
 * JD-Core Version:    0.7.0.1
 */