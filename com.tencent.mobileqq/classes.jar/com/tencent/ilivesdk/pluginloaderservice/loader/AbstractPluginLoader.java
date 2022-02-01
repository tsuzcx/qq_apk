package com.tencent.ilivesdk.pluginloaderservice.loader;

import android.annotation.TargetApi;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;

public abstract class AbstractPluginLoader
{
  private static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = paramArrayOfString1.length;
    int j = paramArrayOfString2.length;
    String[] arrayOfString = new String[i + j];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, i);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, i, j);
    return arrayOfString;
  }
  
  @TargetApi(17)
  protected String[] a(IPlugin paramIPlugin)
  {
    Object localObject = new DexClassLoader(paramIPlugin.g(), paramIPlugin.h(), paramIPlugin.i(), getClass().getClassLoader());
    paramIPlugin = null;
    try
    {
      try
      {
        localObject = (String[])((DexClassLoader)localObject).loadClass("com.tencent.shadow.dynamic.impl.WhiteList").getDeclaredField("sWhiteList").get(null);
        paramIPlugin = (IPlugin)localObject;
      }
      catch (IllegalAccessException paramIPlugin)
      {
        throw new RuntimeException(paramIPlugin);
      }
      catch (NoSuchFieldException paramIPlugin)
      {
        throw new RuntimeException(paramIPlugin);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label82:
      break label82;
    }
    if (paramIPlugin != null) {
      return a(b(), paramIPlugin);
    }
    return b();
  }
  
  protected abstract String[] b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.AbstractPluginLoader
 * JD-Core Version:    0.7.0.1
 */