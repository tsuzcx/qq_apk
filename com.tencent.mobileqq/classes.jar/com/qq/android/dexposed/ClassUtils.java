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
        localArrayList.add(null);
      }
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
    if (isEmpty(paramString)) {}
    int m;
    char[] arrayOfChar;
    int j;
    int i;
    do
    {
      return paramString;
      m = paramString.length();
      arrayOfChar = new char[m];
      j = 0;
      i = 0;
      if (j < m) {
        break;
      }
    } while (i == m);
    return new String(arrayOfChar, 0, i);
    if (!Character.isWhitespace(paramString.charAt(j)))
    {
      int k = i + 1;
      arrayOfChar[i] = paramString.charAt(j);
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
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
    if (paramClass == null)
    {
      paramClass = null;
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    for (Class localClass = paramClass.getSuperclass();; localClass = localClass.getSuperclass())
    {
      paramClass = localArrayList;
      if (localClass == null) {
        break;
      }
      localArrayList.add(localClass);
    }
  }
  
  public static Class<?> getClass(ClassLoader paramClassLoader, String paramString)
  {
    return getClass(paramClassLoader, paramString, true);
  }
  
  public static Class<?> getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
  {
    try
    {
      if (abbreviationMap.containsKey(paramString)) {
        return Class.forName("[" + (String)abbreviationMap.get(paramString), paramBoolean, paramClassLoader).getComponentType();
      }
      Class localClass = Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      int i = paramString.lastIndexOf('.');
      if (i != -1) {
        try
        {
          paramClassLoader = getClass(paramClassLoader, paramString.substring(0, i) + '$' + paramString.substring(i + 1), paramBoolean);
          return paramClassLoader;
        }
        catch (ClassNotFoundException paramClassLoader) {}
      }
      throw localClassNotFoundException;
    }
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
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      return "";
    }
    while (str.charAt(0) == '[') {
      str = str.substring(1);
    }
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
    int i = 0;
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString.startsWith("["))
    {
      if (paramString.charAt(0) == '[') {
        break label179;
      }
      str = paramString;
      if (paramString.charAt(0) == 'L')
      {
        str = paramString;
        if (paramString.charAt(paramString.length() - 1) == ';') {
          str = paramString.substring(1, paramString.length() - 1);
        }
      }
    }
    if (reverseAbbreviationMap.containsKey(str)) {}
    for (paramString = (String)reverseAbbreviationMap.get(str);; paramString = str)
    {
      int j = paramString.lastIndexOf('.');
      if (j == -1) {}
      for (;;)
      {
        i = paramString.indexOf('$', i);
        str = paramString.substring(j + 1);
        paramString = str;
        if (i != -1) {
          paramString = str.replace('$', '.');
        }
        return paramString + localStringBuilder;
        label179:
        paramString = paramString.substring(1);
        localStringBuilder.append("[]");
        break;
        i = j + 1;
      }
    }
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
    if (paramString == null) {
      throw new NullPointerException("className must not be null.");
    }
    Object localObject = paramString;
    if (paramString.endsWith("[]"))
    {
      localObject = new StringBuilder();
      if (paramString.endsWith("[]")) {
        break label80;
      }
      String str = (String)abbreviationMap.get(paramString);
      if (str == null) {
        break label102;
      }
      ((StringBuilder)localObject).append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
      label80:
      paramString = paramString.substring(0, paramString.length() - 2);
      ((StringBuilder)localObject).append("[");
      break;
      label102:
      ((StringBuilder)localObject).append("L").append(paramString).append(";");
    }
  }
  
  public static Class<?>[] toClass(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return null;
    }
    if (paramVarArgs.length == 0) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    if (i >= paramVarArgs.length) {
      return arrayOfClass;
    }
    if (paramVarArgs[i] == null) {}
    for (Class localClass = null;; localClass = paramVarArgs[i].getClass())
    {
      arrayOfClass[i] = localClass;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.ClassUtils
 * JD-Core Version:    0.7.0.1
 */