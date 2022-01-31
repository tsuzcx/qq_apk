package com.sixgod.pluginsdk.a;

import com.sixgod.pluginsdk.log.SixGodReporter;

public final class b
{
  public static Class a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
      SixGodReporter.reportException("ReflectExp", paramClassLoader);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.a.b
 * JD-Core Version:    0.7.0.1
 */