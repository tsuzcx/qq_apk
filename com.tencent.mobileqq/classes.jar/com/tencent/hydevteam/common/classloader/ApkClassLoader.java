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
    throws Exception
  {
    try
    {
      paramClass = paramClass.cast(loadClass(paramString).newInstance());
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new Exception(paramClass);
    }
    catch (ClassCastException paramClass)
    {
      break label16;
    }
    catch (InstantiationException paramClass)
    {
      break label16;
    }
    catch (IllegalAccessException paramClass)
    {
      label16:
      break label16;
    }
  }
  
  public final <T> T a(Class<T> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    try
    {
      paramClass = paramClass.cast(loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject));
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new Exception(paramClass);
    }
    catch (ClassCastException paramClass)
    {
      break label22;
    }
    catch (InstantiationException paramClass)
    {
      break label22;
    }
    catch (IllegalAccessException paramClass)
    {
      label22:
      break label22;
    }
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    int i = 0;
    int j = paramString.lastIndexOf('.');
    Object localObject1;
    Object localObject2;
    if (j != -1)
    {
      localObject1 = paramString.substring(0, j);
      int k = 0;
      localObject2 = this.b;
      int m = localObject2.length;
      label39:
      j = k;
      if (i < m)
      {
        if (!((String)localObject1).equals(localObject2[i])) {
          break label87;
        }
        j = 1;
      }
      if (j == 0) {
        break label94;
      }
      localObject1 = super.loadClass(paramString, paramBoolean);
    }
    label87:
    label94:
    do
    {
      do
      {
        return localObject1;
        localObject1 = "";
        break;
        i += 1;
        break label39;
        localObject2 = findLoadedClass(paramString);
        localObject1 = localObject2;
      } while (localObject2 != null);
      Object localObject3 = null;
      try
      {
        localObject1 = findClass(paramString);
        localObject2 = localObject1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          try
          {
            paramString = this.a.loadClass(paramString);
            return paramString;
          }
          catch (ClassNotFoundException paramString)
          {
            if (Build.VERSION.SDK_INT < 19) {
              continue;
            }
            paramString.addSuppressed(localClassNotFoundException);
            throw paramString;
          }
          localClassNotFoundException = localClassNotFoundException;
        }
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.common.classloader.ApkClassLoader
 * JD-Core Version:    0.7.0.1
 */