package com.tencent.mm.plugin.appbrand.page;

import androidx.annotation.NonNull;
import org.joor.Reflect;

public final class bl
{
  public static <P extends u, R extends w> w a(@NonNull P paramP, @NonNull Class<R> paramClass)
  {
    return (w)Reflect.on(paramClass).create(new Object[] { paramP }).get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */