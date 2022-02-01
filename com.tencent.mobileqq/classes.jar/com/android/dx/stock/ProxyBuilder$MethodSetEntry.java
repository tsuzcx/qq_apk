package com.android.dx.stock;

import java.lang.reflect.Method;
import java.util.Arrays;

class ProxyBuilder$MethodSetEntry
{
  private final String name;
  private final Method originalMethod;
  private final Class<?>[] paramTypes;
  private final Class<?> returnType;
  
  public ProxyBuilder$MethodSetEntry(Method paramMethod)
  {
    this.originalMethod = paramMethod;
    this.name = paramMethod.getName();
    this.paramTypes = paramMethod.getParameterTypes();
    this.returnType = paramMethod.getReturnType();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MethodSetEntry))
    {
      paramObject = (MethodSetEntry)paramObject;
      bool1 = bool2;
      if (this.name.equals(paramObject.name))
      {
        bool1 = bool2;
        if (this.returnType.equals(paramObject.returnType))
        {
          bool1 = bool2;
          if (Arrays.equals(this.paramTypes, paramObject.paramTypes)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = 17 + (this.name.hashCode() + 527);
    i += i * 31 + this.returnType.hashCode();
    return i + (i * 31 + Arrays.hashCode(this.paramTypes));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.stock.ProxyBuilder.MethodSetEntry
 * JD-Core Version:    0.7.0.1
 */