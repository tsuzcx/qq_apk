package com.tencent.luggage.wxa.fy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface i
{
  @Nullable
  public abstract <AddOn extends j> AddOn a(@NonNull Class<AddOn> paramClass);
  
  @NonNull
  public abstract String a();
  
  public abstract <AddOn extends j> void a(@NonNull Class<AddOn> paramClass, @Nullable AddOn paramAddOn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.i
 * JD-Core Version:    0.7.0.1
 */