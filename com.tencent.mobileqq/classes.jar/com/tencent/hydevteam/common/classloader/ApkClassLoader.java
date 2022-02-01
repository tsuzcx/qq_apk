package com.tencent.hydevteam.common.classloader;

import android.os.Build.VERSION;
import com.tencent.hydevteam.common.annotation.API;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;

@API
public class ApkClassLoader
  extends DexClassLoader
{
  private ClassLoader a;
  private final String[] b;
  
  public ApkClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String[] paramArrayOfString)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.a = paramClassLoader.getParent();
    this.b = paramArrayOfString;
  }
  
  public final <T> T a(Class<T> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.cast(loadClass(paramString).newInstance());
      return paramClass;
    }
    catch (IllegalAccessException paramClass) {}catch (ClassCastException paramClass) {}catch (InstantiationException paramClass) {}catch (ClassNotFoundException paramClass) {}
    throw new Exception(paramClass);
  }
  
  public final <T> T a(Class<T> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramClass = paramClass.cast(loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject));
      return paramClass;
    }
    catch (IllegalAccessException paramClass) {}catch (ClassCastException paramClass) {}catch (InstantiationException paramClass) {}catch (ClassNotFoundException paramClass) {}
    throw new Exception(paramClass);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    int i = paramString.lastIndexOf('.');
    int k = 0;
    if (i != -1) {
      localObject1 = paramString.substring(0, i);
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.b;
    int m = localObject2.length;
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (((String)localObject1).equals(localObject2[i]))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0) {
      return super.loadClass(paramString, paramBoolean);
    }
    Object localObject1 = findLoadedClass(paramString);
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = findClass(paramString);
      localObject1 = localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label117:
      break label117;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        paramString = this.a.loadClass(paramString);
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        i = Build.VERSION.SDK_INT;
        throw paramString;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.common.classloader.ApkClassLoader
 * JD-Core Version:    0.7.0.1
 */