package com.tencent.luggage.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public final class b
{
  public static <L extends List<T>, T> L a(@NonNull L paramL, @Nullable List<T> paramList)
  {
    if (paramList != null) {
      paramL.addAll(paramList);
    }
    return paramL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.b
 * JD-Core Version:    0.7.0.1
 */