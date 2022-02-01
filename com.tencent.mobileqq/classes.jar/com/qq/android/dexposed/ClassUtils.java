package com.qq.android.dexposed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassUtils
{
  public static final String INNER_CLASS_SEPARATOR;
  public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
  public static final String PACKAGE_SEPARATOR = String.valueOf('.');
  public static final char PACKAGE_SEPARATOR_CHAR = '.';
  public static final String STRING_EMPTY = "";
  private static final Map<String, String> abbreviationMap;
  private static final Map<Class<?>, Class<?>> primitiveWrapperMap;
  private static final Map<String, String> reverseAbbreviationMap;
  private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
  
  static
  {
    INNER_CLASS_SEPARATOR = String.valueOf('$');
    primitiveWrapperMap = new HashMap();
    primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
    primitiveWrapperMap.put(Byte.TYPE, Byte.class);
    primitiveWrapperMap.put(Character.TYPE, Character.class);
    primitiveWrapperMap.put(Short.TYPE, Short.class);
    primitiveWrapperMap.put(Integer.TYPE, Integer.class);
    primitiveWrapperMap.put(Long.TYPE, Long.class);
    primitiveWrapperMap.put(Double.TYPE, Double.class);
    primitiveWrapperMap.put(Float.TYPE, Float.class);
    primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
    wrapperPrimitiveMap = new HashMap();
    Iterator localIterator = primitiveWrapperMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        abbreviationMap = new HashMap();
        reverseAbbreviationMap = new HashMap();
        addAbbreviation("int", "I");
        addAbbreviation("boolean", "Z");
        addAbbreviation("float", "F");
        addAbbreviation("long", "J");
        addAbbreviation("short", "S");
        addAbbreviation("byte", "B");
        addAbbreviation("double", "D");
        addAbbreviation("char", "C");
        return;
      }
      Class localClass1 = (Class)localIterator.next();
      Class localClass2 = (Class)primitiveWrapperMap.get(localClass1);
      if (!localClass1.equals(localClass2)) {
        wrapperPrimitiveMap.put(localClass2, localClass1);
      }
    }
  }
  
  private static void addAbbreviation(String paramString1, String paramString2)
  {
    abbreviationMap.put(paramString1, paramString2);
    reverseAbbreviationMap.put(paramString2, paramString1);
  }
  
  public static List<Class<?>> convertClassNamesToClasses(List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localArrayList;
      }
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Class.forName(str));
      }
      catch (Exception localException)
      {
        label62:
        break label62;
      }
      localArrayList.add(null);
    }
  }
  
  public static List<String> convertClassesToClassNames(List<Class<?>> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localArrayList;
      }
      Class localClass = (Class)paramList.next();
      if (localClass == null) {
        localArrayList.add(null);
      } else {
        localArrayList.add(localClass.getName());
      }
    }
  }
  
  public static String deleteWhitespace(String paramString)
  {
    if (isEmpty(paramString)) {
      return paramString;
    }
    int m = paramString.length();
    char[] arrayOfChar = new char[m];
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i >= m)
      {
        if (j == m) {
          return paramString;
        }
        return new String(arrayOfChar, 0, j);
      }
      k = j;
      if (!Character.isWhitespace(paramString.charAt(i)))
      {
        arrayOfChar[j] = paramString.charAt(i);
        k = j + 1;
      }
      i += 1;
    }
  }
  
  public static List<Class<?>> getAllInterfaces(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    getAllInterfaces(paramClass, localLinkedHashSet);
    return new ArrayList(localLinkedHashSet);
  }
  
  private static void getAllInterfaces(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
  {
    if (paramClass == null) {
      return;
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramClass = paramClass.getSuperclass();
        break;
      }
      Class localClass = arrayOfClass[i];
      if (paramHashSet.add(localClass)) {
        getAllInterfaces(localClass, paramHashSet);
      }
      i += 1;
    }
  }
  
  public static List<Class<?>> getAllSuperclasses(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (paramClass = paramClass.getSuperclass();; paramClass = paramClass.getSuperclass())
    {
      if (paramClass == null) {
        return localArrayList;
      }
      localArrayList.add(paramClass);
    }
  }
  
  public static Class<?> getClass(ClassLoader paramClassLoader, String paramString)
  {
    return getClass(paramClassLoader, paramString, true);
  }
  
  public static Class<?> getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
  {
    int i;
    try
    {
      if (abbreviationMap.containsKey(paramString))
      {
        localObject = new StringBuilder("[");
        ((StringBuilder)localObject).append((String)abbreviationMap.get(paramString));
        return Class.forName(((StringBuilder)localObject).toString(), paramBoolean, paramClassLoader).getComponentType();
      }
      Object localObject = Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      i = paramString.lastIndexOf('.');
      if (i == -1) {}
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString.substring(0, i)));
      localStringBuilder.append('$');
      localStringBuilder.append(paramString.substring(i + 1));
      paramClassLoader = getClass(paramClassLoader, localStringBuilder.toString(), paramBoolean);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      label135:
      break label135;
    }
    throw localClassNotFoundException;
  }
  
  public static Class<?> getClass(String paramString)
  {
    return getClass(paramString, true);
  }
  
  public static Class<?> getClass(String paramString, boolean paramBoolean)
  {
    ClassLoader localClassLoader2 = Thread.currentThread().getContextClassLoader();
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = ClassUtils.class.getClassLoader();
    }
    return getClass(localClassLoader1, paramString, paramBoolean);
  }
  
  public static String getPackageName(Class<?> paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return getPackageName(paramClass.getName());
  }
  
  public static String getPackageName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getPackageName(paramObject.getClass());
  }
  
  public static String getPackageName(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.length() == 0) {
        return "";
      }
      for (;;)
      {
        if (str.charAt(0) != '[')
        {
          paramString = str;
          if (str.charAt(0) == 'L')
          {
            paramString = str;
            if (str.charAt(str.length() - 1) == ';') {
              paramString = str.substring(1);
            }
          }
          int i = paramString.lastIndexOf('.');
          if (i == -1) {
            return "";
          }
          return paramString.substring(0, i);
        }
        str = str.substring(1);
      }
    }
    return "";
  }
  
  public static String getShortClassName(Class<?> paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return getShortClassName(paramClass.getName());
  }
  
  public static String getShortClassName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getShortClassName(paramObject.getClass());
  }
  
  public static String getShortClassName(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = paramString.startsWith("[");
    int i = 0;
    String str = paramString;
    if (bool) {
      for (;;)
      {
        if (paramString.charAt(0) != '[')
        {
          str = paramString;
          if (paramString.charAt(0) != 'L') {
            break;
          }
          str = paramString;
          if (paramString.charAt(paramString.length() - 1) != ';') {
            break;
          }
          str = paramString.substring(1, paramString.length() - 1);
          break;
        }
        paramString = paramString.substring(1);
        localStringBuilder.append("[]");
      }
    }
    paramString = str;
    if (reverseAbbreviationMap.containsKey(str)) {
      paramString = (String)reverseAbbreviationMap.get(str);
    }
    int j = paramString.lastIndexOf('.');
    if (j != -1) {
      i = j + 1;
    }
    i = paramString.indexOf('$', i);
    str = paramString.substring(j + 1);
    paramString = str;
    if (i != -1) {
      paramString = str.replace('$', '.');
    }
    paramString = new StringBuilder(String.valueOf(paramString));
    paramString.append(localStringBuilder);
    return paramString.toString();
  }
  
  public static String getSimpleName(Class<?> paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return paramClass.getSimpleName();
  }
  
  public static String getSimpleName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getSimpleName(paramObject.getClass());
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  private static String toCanonicalName(String paramString)
  {
    paramString = deleteWhitespace(paramString);
    if (paramString != null)
    {
      if (paramString.endsWith("[]"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          if (!paramString.endsWith("[]"))
          {
            String str = (String)abbreviationMap.get(paramString);
            if (str != null)
            {
              localStringBuilder.append(str);
            }
            else
            {
              localStringBuilder.append("L");
              localStringBuilder.append(paramString);
              localStringBuilder.append(";");
            }
            return localStringBuilder.toString();
          }
          paramString = paramString.substring(0, paramString.length() - 2);
          localStringBuilder.append("[");
        }
      }
      return paramString;
    }
    paramString = new NullPointerException("className must not be null.");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static Class<?>[] toClass(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    int j = paramVarArgs.length;
    int i = 0;
    if (j == 0) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    for (;;)
    {
      if (i >= paramVarArgs.length) {
        return arrayOfClass;
      }
      Class localClass;
      if (paramVarArgs[i] == null) {
        localClass = null;
      } else {
        localClass = paramVarArgs[i].getClass();
      }
      arrayOfClass[i] = localClass;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.ClassUtils
 * JD-Core Version:    0.7.0.1
 */