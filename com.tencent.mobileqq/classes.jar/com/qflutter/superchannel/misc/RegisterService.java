package com.qflutter.superchannel.misc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qflutter.superchannel.SuperChannelLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterService
{
  public static final String TAG = "SuperChannel.RegisterService";
  static Map<String, Object> classInstanceMap = new ConcurrentHashMap();
  static Map<String, Class> classMap = new ConcurrentHashMap();
  
  @Nullable
  public static Object createAlways(@NonNull String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (isTextEmpty(paramString))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[create] invalid parameters, name=");
      localObject1 = paramString;
      paramString = (String)localObject2;
    }
    for (;;)
    {
      paramString.append((String)localObject1);
      SuperChannelLog.w("SuperChannel.RegisterService", paramString.toString());
      return null;
      if (classMap.containsKey(paramString)) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[create] no service registered, name=");
      ((StringBuilder)localObject1).append(paramString);
      localObject2 = ", please call register() first";
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
    try
    {
      paramString = ((Class)classMap.get(paramString)).newInstance();
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      SuperChannelLog.e("SuperChannel.RegisterService", "", paramString);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      SuperChannelLog.e("SuperChannel.RegisterService", "", paramString);
    }
    return null;
  }
  
  @Nullable
  public static Object createOnce(@NonNull String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (isTextEmpty(paramString))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[create] invalid parameters, name=");
      localObject1 = paramString;
      paramString = (String)localObject2;
    }
    for (;;)
    {
      paramString.append((String)localObject1);
      SuperChannelLog.w("SuperChannel.RegisterService", paramString.toString());
      return null;
      if (classInstanceMap.containsKey(paramString)) {
        return classInstanceMap.get(paramString);
      }
      if (classMap.containsKey(paramString)) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[create] no service registered, name=");
      ((StringBuilder)localObject1).append(paramString);
      localObject2 = ", please call register() first";
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
    try
    {
      localObject1 = ((Class)classMap.get(paramString)).newInstance();
      classInstanceMap.put(paramString, localObject1);
      return localObject1;
    }
    catch (InstantiationException paramString)
    {
      SuperChannelLog.e("SuperChannel.RegisterService", "", paramString);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      SuperChannelLog.e("SuperChannel.RegisterService", "", paramString);
    }
    return null;
  }
  
  private static boolean isTextEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean register(@NonNull String paramString, @NonNull Class paramClass)
  {
    if (!isTextEmpty(paramString))
    {
      if (SuperChannelLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[register]  name=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", clazz=");
        localStringBuilder.append(paramClass.getName());
        SuperChannelLog.d("SuperChannel.RegisterService", localStringBuilder.toString());
      }
      if (classMap.containsKey(paramString))
      {
        paramClass = new StringBuilder();
        paramClass.append("[register] name ");
        paramClass.append(paramString);
        paramClass.append(" already registered, ");
        paramClass.append(" please call unregister() to remove it first");
        SuperChannelLog.w("SuperChannel.RegisterService", paramClass.toString());
        return false;
      }
      classMap.put(paramString, paramClass);
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[register] invalid parameters, name=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", clazz=");
    localStringBuilder.append(paramClass);
    SuperChannelLog.w("SuperChannel.RegisterService", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameters, name=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", clazz=");
    localStringBuilder.append(paramClass);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static void release(@NonNull String paramString)
  {
    StringBuilder localStringBuilder;
    if (isTextEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[release] invalid parameters, name=");
      localStringBuilder.append(paramString);
      SuperChannelLog.w("SuperChannel.RegisterService", localStringBuilder.toString());
      return;
    }
    if (SuperChannelLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[release]  name=");
      localStringBuilder.append(paramString);
      SuperChannelLog.d("SuperChannel.RegisterService", localStringBuilder.toString());
    }
    classInstanceMap.remove(paramString);
  }
  
  public static void unregister(@NonNull String paramString)
  {
    StringBuilder localStringBuilder;
    if (isTextEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[unregister] invalid parameters, name=");
      localStringBuilder.append(paramString);
      SuperChannelLog.w("SuperChannel.RegisterService", localStringBuilder.toString());
      return;
    }
    if (SuperChannelLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[unregister]  name=");
      localStringBuilder.append(paramString);
      SuperChannelLog.d("SuperChannel.RegisterService", localStringBuilder.toString());
    }
    classMap.remove(paramString);
    classInstanceMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.superchannel.misc.RegisterService
 * JD-Core Version:    0.7.0.1
 */