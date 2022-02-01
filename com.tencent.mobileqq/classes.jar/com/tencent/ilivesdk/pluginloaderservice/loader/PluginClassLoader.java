package com.tencent.ilivesdk.pluginloaderservice.loader;

import android.os.Build.VERSION;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginClassLoader;
import dalvik.system.DexClassLoader;

public class PluginClassLoader
  extends DexClassLoader
  implements IPluginClassLoader
{
  private final ClassLoader a;
  private final String[] b;
  
  public PluginClassLoader(IPlugin paramIPlugin, ClassLoader paramClassLoader, String[] paramArrayOfString, int paramInt)
  {
    super(paramIPlugin.g(), paramIPlugin.h(), paramIPlugin.i(), paramClassLoader);
    this.b = paramArrayOfString;
    int i = 0;
    while (i < paramInt)
    {
      paramClassLoader = paramClassLoader.getParent();
      i += 1;
    }
    this.a = paramClassLoader;
  }
  
  public <T> T a(Class<T> paramClass, String paramString)
  {
    return paramClass.cast(loadClass(paramString).newInstance());
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
    localObject3 = this.b;
    int j = k;
    if (localObject3 != null)
    {
      int m = localObject3.length;
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (((String)localObject1).equals(localObject3[i]))
        {
          j = 1;
          break;
        }
        i += 1;
      }
    }
    if (j != 0) {
      return super.loadClass(paramString, paramBoolean);
    }
    localObject3 = findLoadedClass(paramString);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = findClass(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
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
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.PluginClassLoader
 * JD-Core Version:    0.7.0.1
 */