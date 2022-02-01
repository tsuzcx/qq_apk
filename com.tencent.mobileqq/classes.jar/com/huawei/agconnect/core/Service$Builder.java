package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service$Builder
{
  Class<?> a;
  Class<?> b;
  private boolean c;
  
  private Service$Builder(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass1 != null)
    {
      if (paramClass2 != null)
      {
        if ((!paramClass2.isInterface()) && (Modifier.isPublic(paramClass2.getModifiers())))
        {
          this.a = paramClass1;
          this.b = paramClass2;
          this.c = paramClass2.isAnnotationPresent(Singleton.class);
          return;
        }
        throw new IllegalArgumentException("the clazz parameter must be interface type and public");
      }
      throw new IllegalArgumentException("the clazz parameter cannot be NULL");
    }
    throw new IllegalArgumentException("the interface parameter cannot be NULL");
  }
  
  public Service build()
  {
    Service localService = new Service(this.a, this.b, null);
    Service.a(localService, this.c);
    return localService;
  }
  
  public Builder isSingleton(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.core.Service.Builder
 * JD-Core Version:    0.7.0.1
 */