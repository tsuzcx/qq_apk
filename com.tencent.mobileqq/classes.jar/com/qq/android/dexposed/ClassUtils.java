package com.qq.android.dexposed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ClassUtils
{
  public static final String a = String.valueOf('.');
  public static final String b = String.valueOf('$');
  private static final Map<Class<?>, Class<?>> c = new HashMap();
  private static final Map<Class<?>, Class<?>> d;
  private static final Map<String, String> e;
  private static final Map<String, String> f;
  
  static
  {
    c.put(Boolean.TYPE, Boolean.class);
    c.put(Byte.TYPE, Byte.class);
    c.put(Character.TYPE, Character.class);
    c.put(Short.TYPE, Short.class);
    c.put(Integer.TYPE, Integer.class);
    c.put(Long.TYPE, Long.class);
    c.put(Double.TYPE, Double.class);
    c.put(Float.TYPE, Float.class);
    c.put(Void.TYPE, Void.TYPE);
    d = new HashMap();
    Iterator localIterator = c.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        e = new HashMap();
        f = new HashMap();
        a("int", "I");
        a("boolean", "Z");
        a("float", "F");
        a("long", "J");
        a("short", "S");
        a("byte", "B");
        a("double", "D");
        a("char", "C");
        return;
      }
      Class localClass1 = (Class)localIterator.next();
      Class localClass2 = (Class)c.get(localClass1);
      if (!localClass1.equals(localClass2)) {
        d.put(localClass2, localClass1);
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    e.put(paramString1, paramString2);
    f.put(paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.ClassUtils
 * JD-Core Version:    0.7.0.1
 */