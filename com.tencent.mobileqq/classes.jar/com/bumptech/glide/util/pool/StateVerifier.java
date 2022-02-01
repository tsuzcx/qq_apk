package com.bumptech.glide.util.pool;

import android.support.annotation.NonNull;

public abstract class StateVerifier
{
  @NonNull
  public static StateVerifier a()
  {
    return new StateVerifier.DefaultStateVerifier();
  }
  
  abstract void a(boolean paramBoolean);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.pool.StateVerifier
 * JD-Core Version:    0.7.0.1
 */