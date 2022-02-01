package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory
{
  private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
  
  static boolean isFragmentClass(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      boolean bool = Fragment.class.isAssignableFrom(loadClass(paramClassLoader, paramString));
      return bool;
    }
    catch (ClassNotFoundException paramClassLoader) {}
    return false;
  }
  
  @NonNull
  private static Class<?> loadClass(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    Class localClass2 = (Class)sClassMap.get(paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(paramString, false, paramClassLoader);
      sClassMap.put(paramString, localClass1);
    }
    return localClass1;
  }
  
  @NonNull
  public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      paramClassLoader = loadClass(paramClassLoader, paramString);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists", paramClassLoader);
    }
    catch (ClassCastException paramClassLoader)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class is a valid subclass of Fragment", paramClassLoader);
    }
  }
  
  @NonNull
  public Fragment instantiate(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      paramClassLoader = (Fragment)loadFragmentClass(paramClassLoader, paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (InstantiationException paramClassLoader)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramClassLoader);
    }
    catch (IllegalAccessException paramClassLoader)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramClassLoader);
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramClassLoader);
    }
    catch (InvocationTargetException paramClassLoader)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramClassLoader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentFactory
 * JD-Core Version:    0.7.0.1
 */