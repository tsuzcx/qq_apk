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
    catch (ClassNotFoundException paramClassLoader)
    {
      label13:
      break label13;
    }
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
    catch (ClassCastException paramClassLoader)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class is a valid subclass of Fragment");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class name exists");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
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
    catch (InvocationTargetException paramClassLoader)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": calling Fragment constructor caused an exception");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": could not find Fragment constructor");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
    }
    catch (IllegalAccessException paramClassLoader)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
    }
    catch (InstantiationException paramClassLoader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentFactory
 * JD-Core Version:    0.7.0.1
 */