package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collection;

public final class Preconditions
{
  @NonNull
  public static <T> T a(@Nullable T paramT)
  {
    return a(paramT, "Argument must not be null");
  }
  
  @NonNull
  public static <T> T a(@Nullable T paramT, @NonNull String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(paramString);
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException("Must not be null or empty");
  }
  
  @NonNull
  public static <T extends Collection<Y>, Y> T a(@NonNull T paramT)
  {
    if (!paramT.isEmpty()) {
      return paramT;
    }
    throw new IllegalArgumentException("Must not be empty.");
  }
  
  public static void a(boolean paramBoolean, @NonNull String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.Preconditions
 * JD-Core Version:    0.7.0.1
 */