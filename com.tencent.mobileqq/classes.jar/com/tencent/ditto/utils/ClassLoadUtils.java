package com.tencent.ditto.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClassLoadUtils
{
  private static final Set<ClassLoader> LOADERS = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public static void addSubstituteLoader(ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {
      return;
    }
    LOADERS.add(paramClassLoader);
  }
  
  public static Class<?> load(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      if (LOADERS.isEmpty()) {
        break label80;
      }
    }
    paramClassLoader = null;
    if (paramClassLoader != null) {
      return paramClassLoader;
    }
    Iterator localIterator = LOADERS.iterator();
    while (localIterator.hasNext())
    {
      try
      {
        Class localClass = ((ClassLoader)localIterator.next()).loadClass(paramString);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
      if (!localIterator.hasNext()) {
        throw localClassNotFoundException;
      }
    }
    return paramClassLoader;
    for (;;)
    {
      label80:
      throw paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.utils.ClassLoadUtils
 * JD-Core Version:    0.7.0.1
 */