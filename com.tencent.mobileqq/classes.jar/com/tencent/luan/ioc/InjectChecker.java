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
    if (paramAnnotatedElement.getAnnotation(Singleton.class) != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramAnnotatedElement.getAnnotation(Prototype.class) != null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      if (!(paramAnnotatedElement instanceof Class))
      {
        if ((paramAnnotatedElement instanceof Method)) {
          paramAnnotatedElement = ((Method)paramAnnotatedElement).getName();
        } else {
          paramAnnotatedElement = paramAnnotatedElement.toString();
        }
      }
      else {
        paramAnnotatedElement = ((Class)paramAnnotatedElement).getName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("one class should be annotated by only one scope annotation: ");
      localStringBuilder.append(paramAnnotatedElement);
      throw new InjectException(localStringBuilder.toString());
    }
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
    if (paramConstructor == null) {
      return false;
    }
    if (isInvalidParamTypes(paramConstructor.getParameterTypes())) {
      return false;
    }
    return Modifier.isPublic(paramConstructor.getModifiers());
  }
  
  public static boolean isValidInjectMethod(Method paramMethod)
  {
    if (paramMethod == null) {
      return false;
    }
    if (paramMethod.getParameterTypes().length != 1) {
      return false;
    }
    if (isInvalidParamType(paramMethod.getParameterTypes()[0])) {
      return false;
    }
    int i = paramMethod.getModifiers();
    if (Modifier.isStatic(i)) {
      return false;
    }
    return Modifier.isPublic(i);
  }
  
  public static boolean isValidProvideMethod(Method paramMethod)
  {
    boolean bool2 = false;
    if (paramMethod == null) {
      return false;
    }
    if (isInvalidParamTypes(paramMethod.getParameterTypes())) {
      return false;
    }
    if (isInvalidParamType(paramMethod.getReturnType())) {
      return false;
    }
    int i = paramMethod.getModifiers();
    boolean bool1 = bool2;
    if (Modifier.isStatic(i))
    {
      bool1 = bool2;
      if (Modifier.isPublic(i)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.InjectChecker
 * JD-Core Version:    0.7.0.1
 */