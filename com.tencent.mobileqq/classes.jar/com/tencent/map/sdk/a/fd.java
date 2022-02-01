package com.tencent.map.sdk.a;

import java.lang.reflect.Type;

public class fd<T>
{
  public final Class<? super T> a;
  public final Type b;
  final int c;
  
  protected fd()
  {
    Type localType = getClass().getGenericSuperclass();
    if (!(localType instanceof Class))
    {
      this.b = eh.a(((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0]);
      this.a = eh.b(this.b);
      this.c = this.b.hashCode();
      return;
    }
    throw new RuntimeException("Missing type parameter.");
  }
  
  private fd(Type paramType)
  {
    this.b = eh.a((Type)eg.a(paramType));
    this.a = eh.b(this.b);
    this.c = this.b.hashCode();
  }
  
  public static <T> fd<T> a(Class<T> paramClass)
  {
    return new fd(paramClass);
  }
  
  public static fd<?> a(Type paramType)
  {
    return new fd(paramType);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof fd)) && (eh.a(this.b, ((fd)paramObject).b));
  }
  
  public final int hashCode()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return eh.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fd
 * JD-Core Version:    0.7.0.1
 */