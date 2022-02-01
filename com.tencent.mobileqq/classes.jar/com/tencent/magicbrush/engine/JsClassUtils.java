package com.tencent.magicbrush.engine;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.gi.c.c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Keep
public class JsClassUtils
{
  private static final int BOOLEAN = 1;
  private static final int BYTE = 3;
  private static final int CHAR = 2;
  private static final int DOUBLE = 8;
  private static final int FLOAT = 6;
  private static final int INT = 5;
  private static final int LONG = 7;
  private static final int SHORT = 4;
  private static final String TAG = "MicroMsg.JsClassUtils";
  private static final int VOID = 0;
  public static final int log_type_d = 0;
  public static final int log_type_e = 2;
  public static final int log_type_i = 1;
  private static final int string = 9;
  private static final int unknown = 10;
  
  private static void getDescriptor(StringBuilder paramStringBuilder, Class<?> paramClass)
  {
    char c1;
    for (;;)
    {
      if (paramClass.isPrimitive())
      {
        if (paramClass == Integer.TYPE) {
          c1 = 'I';
        } else if (paramClass == Void.TYPE) {
          c1 = 'V';
        } else if (paramClass == Boolean.TYPE) {
          c1 = 'Z';
        } else if (paramClass == Byte.TYPE) {
          c1 = 'B';
        } else if (paramClass == Character.TYPE) {
          c1 = 'C';
        } else if (paramClass == Short.TYPE) {
          c1 = 'S';
        } else if (paramClass == Double.TYPE) {
          c1 = 'D';
        } else if (paramClass == Float.TYPE) {
          c1 = 'F';
        } else {
          c1 = 'J';
        }
        paramStringBuilder.append(c1);
        return;
      }
      if (!paramClass.isArray()) {
        break;
      }
      paramStringBuilder.append('[');
      paramClass = paramClass.getComponentType();
    }
    paramStringBuilder.append('L');
    paramClass = paramClass.getName();
    int j = paramClass.length();
    int i = 0;
    while (i < j)
    {
      char c2 = paramClass.charAt(i);
      c1 = c2;
      if (c2 == '.') {
        c1 = '/';
      }
      paramStringBuilder.append(c1);
      i += 1;
    }
    paramStringBuilder.append(';');
  }
  
  private static int getJavaType(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return 5;
    }
    if (paramClass == Void.TYPE) {
      return 0;
    }
    if (paramClass == Boolean.TYPE) {
      return 1;
    }
    if (paramClass == Byte.TYPE) {
      return 3;
    }
    if (paramClass == Character.TYPE) {
      return 2;
    }
    if (paramClass == Short.TYPE) {
      return 4;
    }
    if (paramClass == Double.TYPE) {
      return 8;
    }
    if (paramClass == Float.TYPE) {
      return 6;
    }
    if (paramClass.getCanonicalName().equals("java.lang.String")) {
      return 9;
    }
    return 10;
  }
  
  @Keep
  public static Method[] getJavascriptInterfaceMethod(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramObject = paramObject.getClass().getMethods();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramObject[i];
        if (localObject.isAnnotationPresent(JavascriptInterface.class)) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    catch (Exception paramObject)
    {
      label55:
      break label55;
    }
    return (Method[])localArrayList.toArray(new Method[localArrayList.size()]);
  }
  
  @Keep
  public static String getMethodName(Method paramMethod)
  {
    return paramMethod.getName();
  }
  
  @Keep
  public static String getMethodSignature(Method paramMethod)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    int i = 0;
    while (i < arrayOfClass.length)
    {
      getDescriptor(localStringBuilder, arrayOfClass[i]);
      i += 1;
    }
    localStringBuilder.append(')');
    getDescriptor(localStringBuilder, paramMethod.getReturnType());
    return localStringBuilder.toString();
  }
  
  @Keep
  public static int[] getMethodType(Method paramMethod)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int[] arrayOfInt = new int[arrayOfClass.length + 2];
    int j = arrayOfClass.length;
    int i = 0;
    arrayOfInt[0] = j;
    arrayOfInt[1] = getJavaType(paramMethod.getReturnType());
    while (i < arrayOfClass.length)
    {
      arrayOfInt[(i + 2)] = getJavaType(arrayOfClass[i]);
      i += 1;
    }
    return arrayOfInt;
  }
  
  @Keep
  public static byte[] getStringUtf8(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static boolean hasJavascriptInterface(Object paramObject)
  {
    try
    {
      paramObject = paramObject.getClass().getMethods();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramObject[i].isAnnotationPresent(JavascriptInterface.class);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  @Keep
  public static void jsLog(int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        c.c.a("MicroMsg.JsClassUtils", paramString, new Object[0]);
        return;
      }
      c.c.c("MicroMsg.JsClassUtils", paramString, new Object[0]);
      return;
    }
    c.c.b("MicroMsg.JsClassUtils", paramString, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsClassUtils
 * JD-Core Version:    0.7.0.1
 */