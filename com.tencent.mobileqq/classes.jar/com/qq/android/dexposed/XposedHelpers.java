package com.qq.android.dexposed;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

public class XposedHelpers
{
  private static final WeakHashMap<Object, HashMap<String, Object>> additionalFields = new WeakHashMap();
  private static final HashMap<String, Constructor<?>> constructorCache;
  private static final HashMap<String, Field> fieldCache = new HashMap();
  private static final HashMap<String, Method> methodCache = new HashMap();
  
  static
  {
    constructorCache = new HashMap();
  }
  
  public static byte[] assetAsByteArray(Resources paramResources, String paramString)
  {
    paramResources = paramResources.getAssets().open(paramString);
    paramString = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramResources.read(arrayOfByte);
      if (i <= 0)
      {
        paramResources.close();
        return paramString.toByteArray();
      }
      paramString.write(arrayOfByte, 0, i);
    }
  }
  
  public static Object callMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramObject = findMethodBestMatch(paramObject.getClass(), paramString, paramArrayOfClass, paramVarArgs).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static Object callMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramObject = findMethodBestMatch(paramObject.getClass(), paramString, paramVarArgs).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static Object callStaticMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodBestMatch(paramClass, paramString, paramArrayOfClass, paramVarArgs).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static Object callStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodBestMatch(paramClass, paramString, paramVarArgs).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static Class<?> findClass(String paramString, ClassLoader paramClassLoader)
  {
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = DexposedBridge.BOOTCLASSLOADER;
    }
    try
    {
      paramString = ClassUtils.getClass(localClassLoader, paramString, false);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new XposedHelpers.ClassNotFoundError(paramString);
    }
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append(getParametersString(paramVarArgs));
    ((StringBuilder)localObject).append("#bestmatch");
    localObject = ((StringBuilder)localObject).toString();
    if (constructorCache.containsKey(localObject))
    {
      paramClass = (Constructor)constructorCache.get(localObject);
      if (paramClass != null) {
        return paramClass;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramVarArgs = findConstructorExact(paramClass, paramVarArgs);
      constructorCache.put(localObject, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodError paramVarArgs)
    {
      label95:
      int j;
      int i;
      break label95;
    }
    paramClass = paramClass.getDeclaredConstructors();
    j = paramClass.length;
    i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramClass = new NoSuchMethodError((String)localObject);
        constructorCache.put(localObject, null);
        throw paramClass;
      }
      paramVarArgs = paramClass[i];
      i += 1;
    }
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfClass.length) {
        return findConstructorBestMatch(paramClass, paramArrayOfClass);
      }
      if (paramArrayOfClass[i] == null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getParameterTypes(paramArrayOfObject);
        }
        paramArrayOfClass[i] = localObject2[i];
        localObject1 = localObject2;
      }
      i += 1;
    }
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Object... paramVarArgs)
  {
    return findConstructorBestMatch(paramClass, getParameterTypes(paramVarArgs));
  }
  
  public static Constructor<?> findConstructorExact(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append(getParametersString(paramVarArgs));
    ((StringBuilder)localObject).append("#exact");
    localObject = ((StringBuilder)localObject).toString();
    if (constructorCache.containsKey(localObject))
    {
      paramClass = (Constructor)constructorCache.get(localObject);
      if (paramClass != null) {
        return paramClass;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(paramVarArgs);
      paramClass.setAccessible(true);
      constructorCache.put(localObject, paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      label91:
      break label91;
    }
    constructorCache.put(localObject, null);
    throw new NoSuchMethodError((String)localObject);
  }
  
  public static Field findField(Class<?> paramClass, String paramString)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    if (fieldCache.containsKey(localObject))
    {
      paramClass = (Field)fieldCache.get(localObject);
      if (paramClass != null) {
        return paramClass;
      }
      throw new NoSuchFieldError((String)localObject);
    }
    try
    {
      paramClass = findFieldRecursiveImpl(paramClass, paramString);
      paramClass.setAccessible(true);
      fieldCache.put(localObject, paramClass);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      label88:
      break label88;
    }
    fieldCache.put(localObject, null);
    throw new NoSuchFieldError((String)localObject);
  }
  
  private static Field findFieldRecursiveImpl(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField1 = paramClass.getDeclaredField(paramString);
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      paramClass = paramClass.getSuperclass();
      if ((paramClass != null) && (!paramClass.equals(Object.class))) {}
      try
      {
        Field localField2 = paramClass.getDeclaredField(paramString);
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2) {}
      throw localNoSuchFieldException1;
    }
  }
  
  public static Field findFirstFieldByExactType(Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject = paramClass1;
    Field[] arrayOfField = ((Class)localObject).getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        localObject = ((Class)localObject).getSuperclass();
        if (localObject != null) {
          break;
        }
        localObject = new StringBuilder("Field of type ");
        ((StringBuilder)localObject).append(paramClass2.getName());
        ((StringBuilder)localObject).append(" in class ");
        ((StringBuilder)localObject).append(paramClass1.getName());
        throw new NoSuchFieldError(((StringBuilder)localObject).toString());
      }
      Field localField = arrayOfField[i];
      if (localField.getType() == paramClass2)
      {
        localField.setAccessible(true);
        return localField;
      }
      i += 1;
    }
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getParametersString(paramVarArgs));
    ((StringBuilder)localObject).append("#bestmatch");
    localObject = ((StringBuilder)localObject).toString();
    if (methodCache.containsKey(localObject))
    {
      paramClass = (Method)methodCache.get(localObject);
      if (paramClass != null) {
        return paramClass;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramString = findMethodExact(paramClass, paramString, paramVarArgs);
      methodCache.put(localObject, paramString);
      return paramString;
    }
    catch (NoSuchMethodError paramString)
    {
      label111:
      int i;
      int k;
      int j;
      break label111;
    }
    i = 1;
    paramString = paramClass.getDeclaredMethods();
    k = paramString.length;
    j = 0;
    for (;;)
    {
      if (j >= k)
      {
        paramClass = paramClass.getSuperclass();
        if (paramClass == null)
        {
          paramClass = new NoSuchMethodError((String)localObject);
          methodCache.put(localObject, null);
          throw paramClass;
        }
        i = 0;
        break;
      }
      paramVarArgs = paramString[j];
      if (i == 0) {
        Modifier.isPrivate(paramVarArgs.getModifiers());
      }
      j += 1;
    }
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfClass.length) {
        return findMethodBestMatch(paramClass, paramString, paramArrayOfClass);
      }
      if (paramArrayOfClass[i] == null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getParameterTypes(paramArrayOfObject);
        }
        paramArrayOfClass[i] = localObject2[i];
        localObject1 = localObject2;
      }
      i += 1;
    }
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    return findMethodBestMatch(paramClass, paramString, getParameterTypes(paramVarArgs));
  }
  
  public static Method findMethodExact(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getParametersString(paramVarArgs));
    ((StringBuilder)localObject).append("#exact");
    localObject = ((StringBuilder)localObject).toString();
    if (methodCache.containsKey(localObject))
    {
      paramClass = (Method)methodCache.get(localObject);
      if (paramClass != null) {
        return paramClass;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramClass.setAccessible(true);
      methodCache.put(localObject, paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      label105:
      break label105;
    }
    methodCache.put(localObject, null);
    throw new NoSuchMethodError((String)localObject);
  }
  
  public static Method findMethodExact(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length - 1;
    Object localObject1 = null;
    for (;;)
    {
      if (i < 0)
      {
        paramVarArgs = localObject1;
        if (localObject1 == null) {
          paramVarArgs = new Class[0];
        }
        return findMethodExact(paramClass, paramString, paramVarArgs);
      }
      Object localObject3 = paramVarArgs[i];
      if (localObject3 == null) {
        break label141;
      }
      if (!(localObject3 instanceof XC_MethodHook))
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Class[i + 1];
        }
        if ((localObject3 instanceof Class))
        {
          localObject2[i] = ((Class)localObject3);
          localObject1 = localObject2;
        }
        else
        {
          if (!(localObject3 instanceof String)) {
            break;
          }
          localObject2[i] = findClass((String)localObject3, paramClass.getClassLoader());
          localObject1 = localObject2;
        }
      }
      i -= 1;
    }
    throw new XposedHelpers.ClassNotFoundError("parameter type must either be specified as Class or String", null);
    label141:
    paramClass = new XposedHelpers.ClassNotFoundError("parameter type must not be null", null);
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static Method findMethodExact(String paramString1, ClassLoader paramClassLoader, String paramString2, Object... paramVarArgs)
  {
    return findMethodExact(findClass(paramString1, paramClassLoader), paramString2, paramVarArgs);
  }
  
  public static Method[] findMethodsByExactParameters(Class<?> paramClass1, Class<?> paramClass2, Class<?>... paramVarArgs)
  {
    LinkedList localLinkedList = new LinkedList();
    paramClass1 = paramClass1.getDeclaredMethods();
    int k = paramClass1.length;
    int i = 0;
    if (i >= k) {
      return (Method[])localLinkedList.toArray(new Method[localLinkedList.size()]);
    }
    Object localObject = paramClass1[i];
    Class[] arrayOfClass;
    int j;
    if ((paramClass2 == null) || (paramClass2 == localObject.getReturnType()))
    {
      arrayOfClass = localObject.getParameterTypes();
      if (paramVarArgs.length == arrayOfClass.length) {
        j = 0;
      }
    }
    for (;;)
    {
      if (j >= paramVarArgs.length)
      {
        j = 1;
      }
      else
      {
        if (paramVarArgs[j] == arrayOfClass[j]) {
          break label148;
        }
        j = 0;
      }
      if (j != 0)
      {
        localObject.setAccessible(true);
        localLinkedList.add(localObject);
      }
      i += 1;
      break;
      label148:
      j += 1;
    }
  }
  
  public static Object getAdditionalInstanceField(Object paramObject, String paramString)
  {
    if (paramObject != null)
    {
      if (paramString != null) {
        synchronized (additionalFields)
        {
          paramObject = (HashMap)additionalFields.get(paramObject);
          if (paramObject == null) {
            return null;
          }
          try
          {
            paramString = paramObject.get(paramString);
            return paramString;
          }
          finally {}
        }
      }
      throw new NullPointerException("key must not be null");
    }
    throw new NullPointerException("object must not be null");
  }
  
  public static Object getAdditionalStaticField(Class<?> paramClass, String paramString)
  {
    return getAdditionalInstanceField(paramClass, paramString);
  }
  
  public static Object getAdditionalStaticField(Object paramObject, String paramString)
  {
    return getAdditionalInstanceField(paramObject.getClass(), paramString);
  }
  
  public static boolean getBooleanField(Object paramObject, String paramString)
  {
    try
    {
      boolean bool = findField(paramObject.getClass(), paramString).getBoolean(paramObject);
      return bool;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static byte getByteField(Object paramObject, String paramString)
  {
    try
    {
      byte b = findField(paramObject.getClass(), paramString).getByte(paramObject);
      return b;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static char getCharField(Object paramObject, String paramString)
  {
    try
    {
      char c = findField(paramObject.getClass(), paramString).getChar(paramObject);
      return c;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static Class<?>[] getClassesAsArray(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  public static double getDoubleField(Object paramObject, String paramString)
  {
    try
    {
      double d = findField(paramObject.getClass(), paramString).getDouble(paramObject);
      return d;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static float getFloatField(Object paramObject, String paramString)
  {
    try
    {
      float f = findField(paramObject.getClass(), paramString).getFloat(paramObject);
      return f;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static int getIntField(Object paramObject, String paramString)
  {
    try
    {
      int i = findField(paramObject.getClass(), paramString).getInt(paramObject);
      return i;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static long getLongField(Object paramObject, String paramString)
  {
    try
    {
      long l = findField(paramObject.getClass(), paramString).getLong(paramObject);
      return l;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static String getMD5Sum(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i <= 0)
        {
          paramString.close();
          return new BigInteger(1, localMessageDigest.digest()).toString(16);
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label64:
      break label64;
    }
    return "";
  }
  
  public static Object getObjectField(Object paramObject, String paramString)
  {
    try
    {
      paramObject = findField(paramObject.getClass(), paramString).get(paramObject);
      return paramObject;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static Class<?>[] getParameterTypes(Object... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    for (;;)
    {
      if (i >= paramVarArgs.length) {
        return arrayOfClass;
      }
      Class localClass;
      if (paramVarArgs[i] != null) {
        localClass = paramVarArgs[i].getClass();
      } else {
        localClass = null;
      }
      arrayOfClass[i] = localClass;
      i += 1;
    }
  }
  
  private static String getParametersString(Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    int k = paramVarArgs.length;
    int i = 0;
    int j = 1;
    for (;;)
    {
      if (i >= k)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      Class<?> localClass = paramVarArgs[i];
      if (j != 0) {
        j = 0;
      } else {
        localStringBuilder.append(",");
      }
      if (localClass != null) {
        localStringBuilder.append(localClass.getCanonicalName());
      } else {
        localStringBuilder.append("null");
      }
      i += 1;
    }
  }
  
  public static short getShortField(Object paramObject, String paramString)
  {
    try
    {
      short s = findField(paramObject.getClass(), paramString).getShort(paramObject);
      return s;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static boolean getStaticBooleanField(Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = findField(paramClass, paramString).getBoolean(null);
      return bool;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static byte getStaticByteField(Class<?> paramClass, String paramString)
  {
    try
    {
      byte b = findField(paramClass, paramString).getByte(null);
      return b;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static char getStaticCharField(Class<?> paramClass, String paramString)
  {
    try
    {
      char c = findField(paramClass, paramString).getChar(null);
      return c;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static double getStaticDoubleField(Class<?> paramClass, String paramString)
  {
    try
    {
      double d = findField(paramClass, paramString).getDouble(null);
      return d;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static float getStaticFloatField(Class<?> paramClass, String paramString)
  {
    try
    {
      float f = findField(paramClass, paramString).getFloat(null);
      return f;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static int getStaticIntField(Class<?> paramClass, String paramString)
  {
    try
    {
      int i = findField(paramClass, paramString).getInt(null);
      return i;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static long getStaticLongField(Class<?> paramClass, String paramString)
  {
    try
    {
      long l = findField(paramClass, paramString).getLong(null);
      return l;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static Object getStaticObjectField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = findField(paramClass, paramString).get(null);
      return paramClass;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static short getStaticShortField(Class<?> paramClass, String paramString)
  {
    try
    {
      short s = findField(paramClass, paramString).getShort(null);
      return s;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static Object getSurroundingThis(Object paramObject)
  {
    return getObjectField(paramObject, "this$0");
  }
  
  public static Object newInstance(Class<?> paramClass, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findConstructorBestMatch(paramClass, paramArrayOfClass, paramVarArgs).newInstance(paramVarArgs);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new InstantiationError(paramClass.getMessage());
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static Object newInstance(Class<?> paramClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findConstructorBestMatch(paramClass, paramVarArgs).newInstance(paramVarArgs);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new InstantiationError(paramClass.getMessage());
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static Object removeAdditionalInstanceField(Object paramObject, String paramString)
  {
    if (paramObject != null)
    {
      if (paramString != null) {
        synchronized (additionalFields)
        {
          paramObject = (HashMap)additionalFields.get(paramObject);
          if (paramObject == null) {
            return null;
          }
          try
          {
            paramString = paramObject.remove(paramString);
            return paramString;
          }
          finally {}
        }
      }
      throw new NullPointerException("key must not be null");
    }
    throw new NullPointerException("object must not be null");
  }
  
  public static Object removeAdditionalStaticField(Class<?> paramClass, String paramString)
  {
    return removeAdditionalInstanceField(paramClass, paramString);
  }
  
  public static Object removeAdditionalStaticField(Object paramObject, String paramString)
  {
    return removeAdditionalInstanceField(paramObject.getClass(), paramString);
  }
  
  public static Object setAdditionalInstanceField(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramString != null) {
        synchronized (additionalFields)
        {
          HashMap localHashMap2 = (HashMap)additionalFields.get(paramObject1);
          HashMap localHashMap1 = localHashMap2;
          if (localHashMap2 == null)
          {
            localHashMap1 = new HashMap();
            additionalFields.put(paramObject1, localHashMap1);
          }
          try
          {
            paramObject1 = localHashMap1.put(paramString, paramObject2);
            return paramObject1;
          }
          finally {}
        }
      }
      throw new NullPointerException("key must not be null");
    }
    throw new NullPointerException("object must not be null");
  }
  
  public static Object setAdditionalStaticField(Class<?> paramClass, String paramString, Object paramObject)
  {
    return setAdditionalInstanceField(paramClass, paramString, paramObject);
  }
  
  public static Object setAdditionalStaticField(Object paramObject1, String paramString, Object paramObject2)
  {
    return setAdditionalInstanceField(paramObject1.getClass(), paramString, paramObject2);
  }
  
  public static void setBooleanField(Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setBoolean(paramObject, paramBoolean);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setByteField(Object paramObject, String paramString, byte paramByte)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setByte(paramObject, paramByte);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setCharField(Object paramObject, String paramString, char paramChar)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setChar(paramObject, paramChar);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setDoubleField(Object paramObject, String paramString, double paramDouble)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setDouble(paramObject, paramDouble);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setFloatField(Object paramObject, String paramString, float paramFloat)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setFloat(paramObject, paramFloat);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setIntField(Object paramObject, String paramString, int paramInt)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setInt(paramObject, paramInt);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setLongField(Object paramObject, String paramString, long paramLong)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setLong(paramObject, paramLong);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setObjectField(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      findField(paramObject1.getClass(), paramString).set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalArgumentException paramObject1)
    {
      throw paramObject1;
    }
    catch (IllegalAccessException paramObject1)
    {
      DexposedBridge.log(paramObject1);
      throw new IllegalAccessError(paramObject1.getMessage());
    }
  }
  
  public static void setShortField(Object paramObject, String paramString, short paramShort)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setShort(paramObject, paramShort);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
  }
  
  public static void setStaticBooleanField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    try
    {
      findField(paramClass, paramString).setBoolean(null, paramBoolean);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticByteField(Class<?> paramClass, String paramString, byte paramByte)
  {
    try
    {
      findField(paramClass, paramString).setByte(null, paramByte);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticCharField(Class<?> paramClass, String paramString, char paramChar)
  {
    try
    {
      findField(paramClass, paramString).setChar(null, paramChar);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticDoubleField(Class<?> paramClass, String paramString, double paramDouble)
  {
    try
    {
      findField(paramClass, paramString).setDouble(null, paramDouble);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticFloatField(Class<?> paramClass, String paramString, float paramFloat)
  {
    try
    {
      findField(paramClass, paramString).setFloat(null, paramFloat);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticIntField(Class<?> paramClass, String paramString, int paramInt)
  {
    try
    {
      findField(paramClass, paramString).setInt(null, paramInt);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticLongField(Class<?> paramClass, String paramString, long paramLong)
  {
    try
    {
      findField(paramClass, paramString).setLong(null, paramLong);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticObjectField(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      findField(paramClass, paramString).set(null, paramObject);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
  
  public static void setStaticShortField(Class<?> paramClass, String paramString, short paramShort)
  {
    try
    {
      findField(paramClass, paramString).setShort(null, paramShort);
      return;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.XposedHelpers
 * JD-Core Version:    0.7.0.1
 */