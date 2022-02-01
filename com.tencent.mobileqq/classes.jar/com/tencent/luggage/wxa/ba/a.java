package com.tencent.luggage.wxa.ba;

import androidx.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private final Map<Class<? extends b>, b> a = new ConcurrentHashMap();
  private final Map<Class<? extends d>, d> b = new ConcurrentHashMap();
  
  public <T extends b> T a(Class<T> paramClass)
  {
    return (b)a().get(paramClass);
  }
  
  @NonNull
  public Map<Class<? extends b>, b> a()
  {
    return this.a;
  }
  
  public <T extends d> T b(Class<T> paramClass)
  {
    return (d)b().get(paramClass);
  }
  
  @NonNull
  public Map<Class<? extends d>, d> b()
  {
    return this.b;
  }
  
  public String c()
  {
    return "luggage-core";
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ba.a
 * JD-Core Version:    0.7.0.1
 */