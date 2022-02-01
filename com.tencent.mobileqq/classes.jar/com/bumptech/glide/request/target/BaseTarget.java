package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.bumptech.glide.request.Request;

public abstract class BaseTarget<Z>
  implements Target<Z>
{
  private Request a;
  
  @Nullable
  public Request a()
  {
    return this.a;
  }
  
  public void a(@Nullable Drawable paramDrawable) {}
  
  public void a(@Nullable Request paramRequest)
  {
    this.a = paramRequest;
  }
  
  public void b(@Nullable Drawable paramDrawable) {}
  
  public void c() {}
  
  public void c(@Nullable Drawable paramDrawable) {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.BaseTarget
 * JD-Core Version:    0.7.0.1
 */