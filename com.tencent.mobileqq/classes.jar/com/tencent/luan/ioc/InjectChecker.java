package com.tencent.luan.ioc;

import com.tencent.luan.ioc.annotation.Prototype;
import com.tencent.luan.ioc.annotation.Singleton;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InjectChecker
{
  public static final int SCOPE_DEFAULT = 0;
  public static final int SCOPE_PROTOTYPE = 2;
  public static final int SCOPE_SINGLETON = 1;
  
  public static int checkAndGetScope(AnnotatedElement paramAnnotatedElement)
  {
    int i;
    int j;
    if (paramAnnotatedElement.getAnnotation(Singleton.class) != null)
    {
      i = 1;
      if (paramAnnotatedElement.getAnnotation(Prototype.class) == null) {
        break label81;
      }
      j = 1;
      label26:
      if ((i == 0) || (j == 0)) {
        break label112;
      }
      if (!(paramAnnotatedElement instanceof Class)) {
        break label86;
      }
      paramAnnotatedElement = ((Class)paramAnnotatedElement).getName();
    }
    for (;;)
    {
      throw new InjectException("one class should be annotated by only one scope annotation: " + paramAnnotatedElement);
      i = 0;
      break;
      label81:
      j = 0;
      break label26;
      label86:
      if ((paramAnnotatedElement instanceof Method)) {
        paramAnnotatedElement = ((Method)paramAnnotatedElement).getName();
      } else {
        paramAnnotatedElement = paramAnnotatedElement.toString();
      }
    }
    label112:
    if (i != 0) {
      return 1;
    }
    if (j != 0) {
      return 2;
    }
    return 0;
  }
  
  static boolean isInvalidParamType(Class<?> paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass.isArray());
  }
  
  private static boolean isInvalidParamTypes(Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass.length > 1) {
      return true;
    }
    if (paramArrayOfClass.length == 1) {
      return isInvalidParamType(paramArrayOfClass[0]);
    }
    return false;
  }
  
  public static boolean isValidInjectConstructor(Constructor<?> paramConstructor)
  {
    if (paramConstructor == null) {}
    while (isInvalidParamTypes(paramConstructor.getParameterTypes())) {
      return false;
    }
    return Modifier.isPublic(paramConstructor.getModifiers());
  }
  
  public static boolean isValidInjectMethod(Method paramMethod)
  {
    if (paramMethod == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((paramMethod.getParameterTypes().length != 1) || (isInvalidParamType(paramMethod.getParameterTypes()[0])));
      i = paramMethod.getModifiers();
    } while (Modifier.isStatic(i));
    return Modifier.isPublic(i);
  }
  
  public static boolean isValidProvideMethod(Method paramMethod)
  {
    if (paramMethod == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((isInvalidParamTypes(paramMethod.getParameterTypes())) || (isInvalidParamType(paramMethod.getReturnType())));
      i = paramMethod.getModifiers();
    } while ((!Modifier.isStatic(i)) || (!Modifier.isPublic(i)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.ioc.InjectChecker
 * JD-Core Version:    0.7.0.1
 */