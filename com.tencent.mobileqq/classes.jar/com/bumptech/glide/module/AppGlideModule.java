package com.bumptech.glide.module;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;

public abstract class AppGlideModule
  extends LibraryGlideModule
  implements AppliesOptions
{
  public void a(@NonNull Context paramContext, @NonNull GlideBuilder paramGlideBuilder) {}
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.module.AppGlideModule
 * JD-Core Version:    0.7.0.1
 */