package com.tencent.ilivesdk.pluginloaderservice.loader;

import android.os.Build.VERSION;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginClassLoader;
import dalvik.system.DexClassLoader;

public class PluginClassLoader
  extends DexClassLoader
  implements IPluginClassLoader
{
  private final ClassLoader jdField_a_of_type_JavaLangClassLoader;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public PluginClassLoader(IPlugin paramIPlugin, ClassLoader paramClassLoader, String[] paramArrayOfString, int paramInt)
  {
    super(paramIPlugin.e(), paramIPlugin.f(), paramIPlugin.g(), paramClassLoader);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    int i = 0;
    while (i < paramInt)
    {
      paramClassLoader = paramClassLoader.getParent();
      i += 1;
    }
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
  }
  
  public <T> T a(Class<T> paramClass, String paramString)
  {
    return paramClass.cast(loadClass(paramString).newInstance());
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    int i = paramString.lastIndexOf('.');
    Object localObject1;
    Object localObject2;
    if (i != -1)
    {
      localObject1 = paramString.substring(0, i);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
        break label163;
      }
      localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject2.length;
      i = 0;
      label40:
      if (i >= j) {
        break label163;
      }
      if (!((String)localObject1).equals(localObject2[i])) {
        break label82;
      }
    }
    label155:
    label163:
    for (i = 1;; i = 0)
    {
      Object localObject4;
      if (i != 0)
      {
        localObject4 = super.loadClass(paramString, paramBoolean);
        return localObject4;
        localObject1 = "";
        break;
        label82:
        i += 1;
        break label40;
      }
      localObject1 = findLoadedClass(paramString);
      if (localObject1 == null) {}
      for (;;)
      {
        try
        {
          localObject2 = findClass(paramString);
          localObject1 = localObject2;
          localObject2 = null;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          try
          {
            paramString = this.jdField_a_of_type_JavaLangClassLoader.loadClass(paramString);
            return paramString;
          }
          catch (ClassNotFoundException paramString)
          {
            if (Build.VERSION.SDK_INT < 19) {
              break label155;
            }
            paramString.addSuppressed(localClassNotFoundException);
            throw paramString;
          }
          localClassNotFoundException = localClassNotFoundException;
          continue;
        }
        localObject4 = localObject1;
        if (localObject1 != null) {
          break;
        }
        Object localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.loader.PluginClassLoader
 * JD-Core Version:    0.7.0.1
 */