package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;

public abstract interface Resource<Z>
{
  @NonNull
  public abstract Class<Z> c();
  
  @NonNull
  public abstract Z d();
  
  public abstract int e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Resource
 * JD-Core Version:    0.7.0.1
 */