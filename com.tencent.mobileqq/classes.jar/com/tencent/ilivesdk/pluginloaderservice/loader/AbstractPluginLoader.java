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
  
  protected abstract String[] a();
  
  @TargetApi(17)
  protected String[] a(IPlugin paramIPlugin)
  {
    paramIPlugin = new DexClassLoader(paramIPlugin.e(), paramIPlugin.f(), paramIPlugin.g(), getClass().getClassLoader());
    try
    {
      paramIPlugin = (String[])paramIPlugin.loadClass("com.tencent.shadow.dynamic.impl.WhiteList").getDeclaredField("sWhiteList").get(null);
      if (paramIPlugin != null) {
        return a(a(), paramIPlugin);
      }
    }
    catch (ClassNotFoundException paramIPlugin)
    {
      for (;;)
      {
        paramIPlugin = null;
      }
    }
    catch (NoSuchFieldException paramIPlugin)
    {
      throw new RuntimeException(paramIPlugin);
    }
    catch (IllegalAccessException paramIPlugin)
    {
      throw new RuntimeException(paramIPlugin);
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.AbstractPluginLoader
 * JD-Core Version:    0.7.0.1
 */