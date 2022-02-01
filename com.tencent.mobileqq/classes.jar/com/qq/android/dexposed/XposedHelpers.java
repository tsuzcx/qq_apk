package com.qq.android.dexposed;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.WeakHashMap;

public class XposedHelpers
{
  private static final HashMap<String, Field> a = new HashMap();
  private static final HashMap<String, Method> b = new HashMap();
  private static final HashMap<String, Constructor<?>> c = new HashMap();
  private static final WeakHashMap<Object, HashMap<String, Object>> d = new WeakHashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.XposedHelpers
 * JD-Core Version:    0.7.0.1
 */