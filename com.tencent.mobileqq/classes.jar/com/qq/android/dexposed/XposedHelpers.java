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
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
  }
  
  public static Object callMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramObject = findMethodBestMatch(paramObject.getClass(), paramString, paramVarArgs).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
  }
  
  public static Object callStaticMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodBestMatch(paramClass, paramString, paramArrayOfClass, paramVarArgs).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
  }
  
  public static Object callStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramClass = findMethodBestMatch(paramClass, paramString, paramVarArgs).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
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
      paramVarArgs = (Constructor)constructorCache.get(localObject);
      paramClass = paramVarArgs;
      if (paramVarArgs != null) {
        break label95;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramVarArgs = findConstructorExact(paramClass, paramVarArgs);
      constructorCache.put(localObject, paramVarArgs);
      paramClass = paramVarArgs;
      label95:
      return paramClass;
    }
    catch (NoSuchMethodError paramVarArgs)
    {
      paramVarArgs = paramClass.getDeclaredConstructors();
      int j = paramVarArgs.length;
      int i = 0;
      for (;;)
      {
        if (i >= j)
        {
          if (0 == 0) {
            break;
          }
          throw new NullPointerException();
        }
        paramClass = paramVarArgs[i];
        i += 1;
      }
      paramClass = new NoSuchMethodError((String)localObject);
      constructorCache.put(localObject, null);
      throw paramClass;
    }
  }
  
  public static Constructor<?> findConstructorBestMatch(Class<?> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = 0;
    if (i >= paramArrayOfClass.length) {
      return findConstructorBestMatch(paramClass, paramArrayOfClass);
    }
    if (paramArrayOfClass[i] != null) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getParameterTypes(paramArrayOfObject);
      }
      paramArrayOfClass[i] = localObject2[i];
      localObject1 = localObject2;
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
      paramVarArgs = (Constructor)constructorCache.get(localObject);
      paramClass = paramVarArgs;
      if (paramVarArgs != null) {
        break label89;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(paramVarArgs);
      paramClass.setAccessible(true);
      constructorCache.put(localObject, paramClass);
      label89:
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      constructorCache.put(localObject, null);
      throw new NoSuchMethodError((String)localObject);
    }
  }
  
  public static Field findField(Class<?> paramClass, String paramString)
  {
    Object localObject = new StringBuilder(paramClass.getName());
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    if (fieldCache.containsKey(localObject))
    {
      paramString = (Field)fieldCache.get(localObject);
      paramClass = paramString;
      if (paramString != null) {
        break label86;
      }
      throw new NoSuchFieldError((String)localObject);
    }
    try
    {
      paramClass = findFieldRecursiveImpl(paramClass, paramString);
      paramClass.setAccessible(true);
      fieldCache.put(localObject, paramClass);
      label86:
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      fieldCache.put(localObject, null);
      throw new NoSuchFieldError((String)localObject);
    }
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
      if ((paramClass == null) || (paramClass.equals(Object.class))) {
        throw localNoSuchFieldException1;
      }
      try
      {
        Field localField2 = paramClass.getDeclaredField(paramString);
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2) {}
    }
  }
  
  public static Field findFirstFieldByExactType(Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject1 = paramClass1;
    Object localObject2 = ((Class)localObject1).getDeclaredFields();
    int j = localObject2.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        localObject2 = ((Class)localObject1).getSuperclass();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        throw new NoSuchFieldError("Field of type " + paramClass2.getName() + " in class " + paramClass1.getName());
      }
      Field localField = localObject2[i];
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
      paramString = (Method)methodCache.get(localObject);
      paramClass = paramString;
      if (paramString != null) {
        break label111;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    label111:
    int i;
    try
    {
      paramString = findMethodExact(paramClass, paramString, paramVarArgs);
      methodCache.put(localObject, paramString);
      paramClass = paramString;
      return paramClass;
    }
    catch (NoSuchMethodError paramString)
    {
      i = 1;
    }
    for (;;)
    {
      paramVarArgs = paramClass.getDeclaredMethods();
      int k = paramVarArgs.length;
      int j = 0;
      for (;;)
      {
        if (j >= k)
        {
          paramClass = paramClass.getSuperclass();
          if (paramClass != null) {
            break label206;
          }
          if (0 == 0) {
            break;
          }
          throw new NullPointerException();
        }
        paramString = paramVarArgs[j];
        if ((i == 0) && (Modifier.isPrivate(paramString.getModifiers()))) {}
        j += 1;
      }
      paramClass = new NoSuchMethodError((String)localObject);
      methodCache.put(localObject, null);
      throw paramClass;
      label206:
      i = 0;
    }
  }
  
  public static Method findMethodBestMatch(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = 0;
    if (i >= paramArrayOfClass.length) {
      return findMethodBestMatch(paramClass, paramString, paramArrayOfClass);
    }
    if (paramArrayOfClass[i] != null) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getParameterTypes(paramArrayOfObject);
      }
      paramArrayOfClass[i] = localObject2[i];
      localObject1 = localObject2;
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
      paramString = (Method)methodCache.get(localObject);
      paramClass = paramString;
      if (paramString != null) {
        break label103;
      }
      throw new NoSuchMethodError((String)localObject);
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramClass.setAccessible(true);
      methodCache.put(localObject, paramClass);
      label103:
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      methodCache.put(localObject, null);
      throw new NoSuchMethodError((String)localObject);
    }
  }
  
  public static Method findMethodExact(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length - 1;
    Object localObject1 = null;
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
      throw new XposedHelpers.ClassNotFoundError("parameter type must not be null", null);
    }
    if ((localObject3 instanceof XC_MethodHook)) {}
    for (;;)
    {
      i -= 1;
      break;
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
          break label141;
        }
        localObject2[i] = findClass((String)localObject3, paramClass.getClassLoader());
        localObject1 = localObject2;
      }
    }
    label141:
    throw new XposedHelpers.ClassNotFoundError("parameter type must either be specified as Class or String", null);
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
    if ((paramClass2 != null) && (paramClass2 != localObject.getReturnType())) {}
    Class[] arrayOfClass;
    do
    {
      i += 1;
      break;
      arrayOfClass = localObject.getParameterTypes();
    } while (paramVarArgs.length != arrayOfClass.length);
    int j = 0;
    for (;;)
    {
      if (j >= paramVarArgs.length) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label140;
        }
        localObject.setAccessible(true);
        localLinkedList.add(localObject);
        break;
        if (paramVarArgs[j] == arrayOfClass[j]) {
          break label142;
        }
      }
      label140:
      break;
      label142:
      j += 1;
    }
  }
  
  public static Object getAdditionalInstanceField(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("object must not be null");
    }
    if (paramString == null) {
      throw new NullPointerException("key must not be null");
    }
    synchronized (additionalFields)
    {
      paramObject = (HashMap)additionalFields.get(paramObject);
      if (paramObject == null) {
        return null;
      }
    }
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
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static byte getByteField(Object paramObject, String paramString)
  {
    try
    {
      byte b = findField(paramObject.getClass(), paramString).getByte(paramObject);
      return b;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static char getCharField(Object paramObject, String paramString)
  {
    try
    {
      char c = findField(paramObject.getClass(), paramString).getChar(paramObject);
      return c;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
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
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static float getFloatField(Object paramObject, String paramString)
  {
    try
    {
      float f = findField(paramObject.getClass(), paramString).getFloat(paramObject);
      return f;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static int getIntField(Object paramObject, String paramString)
  {
    try
    {
      int i = findField(paramObject.getClass(), paramString).getInt(paramObject);
      return i;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static long getLongField(Object paramObject, String paramString)
  {
    try
    {
      long l = findField(paramObject.getClass(), paramString).getLong(paramObject);
      return l;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
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
      return "";
    }
    catch (NoSuchAlgorithmException paramString) {}
  }
  
  public static Object getObjectField(Object paramObject, String paramString)
  {
    try
    {
      paramObject = findField(paramObject.getClass(), paramString).get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static Class<?>[] getParameterTypes(Object... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    if (i >= paramVarArgs.length) {
      return arrayOfClass;
    }
    if (paramVarArgs[i] != null) {}
    for (Class localClass = paramVarArgs[i].getClass();; localClass = null)
    {
      arrayOfClass[i] = localClass;
      i += 1;
      break;
    }
  }
  
  private static String getParametersString(Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    int j = 1;
    int k = paramVarArgs.length;
    int i = 0;
    if (i >= k)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    Class<?> localClass = paramVarArgs[i];
    if (j != 0)
    {
      j = 0;
      label50:
      if (localClass == null) {
        break label85;
      }
      localStringBuilder.append(localClass.getCanonicalName());
    }
    for (;;)
    {
      i += 1;
      break;
      localStringBuilder.append(",");
      break label50;
      label85:
      localStringBuilder.append("null");
    }
  }
  
  public static short getShortField(Object paramObject, String paramString)
  {
    try
    {
      short s = findField(paramObject.getClass(), paramString).getShort(paramObject);
      return s;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static boolean getStaticBooleanField(Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = findField(paramClass, paramString).getBoolean(null);
      return bool;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static byte getStaticByteField(Class<?> paramClass, String paramString)
  {
    try
    {
      byte b = findField(paramClass, paramString).getByte(null);
      return b;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static char getStaticCharField(Class<?> paramClass, String paramString)
  {
    try
    {
      char c = findField(paramClass, paramString).getChar(null);
      return c;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static double getStaticDoubleField(Class<?> paramClass, String paramString)
  {
    try
    {
      double d = findField(paramClass, paramString).getDouble(null);
      return d;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static float getStaticFloatField(Class<?> paramClass, String paramString)
  {
    try
    {
      float f = findField(paramClass, paramString).getFloat(null);
      return f;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static int getStaticIntField(Class<?> paramClass, String paramString)
  {
    try
    {
      int i = findField(paramClass, paramString).getInt(null);
      return i;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static long getStaticLongField(Class<?> paramClass, String paramString)
  {
    try
    {
      long l = findField(paramClass, paramString).getLong(null);
      return l;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static Object getStaticObjectField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = findField(paramClass, paramString).get(null);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static short getStaticShortField(Class<?> paramClass, String paramString)
  {
    try
    {
      short s = findField(paramClass, paramString).getShort(null);
      return s;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
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
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (InstantiationException paramClass)
    {
      throw new InstantiationError(paramClass.getMessage());
    }
  }
  
  public static Object newInstance(Class<?> paramClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = findConstructorBestMatch(paramClass, paramVarArgs).newInstance(paramVarArgs);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      throw new XposedHelpers.InvocationTargetError(paramClass.getCause());
    }
    catch (InstantiationException paramClass)
    {
      throw new InstantiationError(paramClass.getMessage());
    }
  }
  
  public static Object removeAdditionalInstanceField(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("object must not be null");
    }
    if (paramString == null) {
      throw new NullPointerException("key must not be null");
    }
    synchronized (additionalFields)
    {
      paramObject = (HashMap)additionalFields.get(paramObject);
      if (paramObject == null) {
        return null;
      }
    }
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
    if (paramObject1 == null) {
      throw new NullPointerException("object must not be null");
    }
    if (paramString == null) {
      throw new NullPointerException("key must not be null");
    }
    for (;;)
    {
      HashMap localHashMap;
      synchronized (additionalFields)
      {
        localHashMap = (HashMap)additionalFields.get(paramObject1);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          additionalFields.put(paramObject1, localHashMap);
          paramObject1 = localHashMap;
        }
      }
      paramObject1 = localHashMap;
    }
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
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setByteField(Object paramObject, String paramString, byte paramByte)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setByte(paramObject, paramByte);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setCharField(Object paramObject, String paramString, char paramChar)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setChar(paramObject, paramChar);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setDoubleField(Object paramObject, String paramString, double paramDouble)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setDouble(paramObject, paramDouble);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setFloatField(Object paramObject, String paramString, float paramFloat)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setFloat(paramObject, paramFloat);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setIntField(Object paramObject, String paramString, int paramInt)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setInt(paramObject, paramInt);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setLongField(Object paramObject, String paramString, long paramLong)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setLong(paramObject, paramLong);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setObjectField(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      findField(paramObject1.getClass(), paramString).set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      DexposedBridge.log(paramObject1);
      throw new IllegalAccessError(paramObject1.getMessage());
    }
    catch (IllegalArgumentException paramObject1)
    {
      throw paramObject1;
    }
  }
  
  public static void setShortField(Object paramObject, String paramString, short paramShort)
  {
    try
    {
      findField(paramObject.getClass(), paramString).setShort(paramObject, paramShort);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      DexposedBridge.log(paramObject);
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
  }
  
  public static void setStaticBooleanField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    try
    {
      findField(paramClass, paramString).setBoolean(null, paramBoolean);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticByteField(Class<?> paramClass, String paramString, byte paramByte)
  {
    try
    {
      findField(paramClass, paramString).setByte(null, paramByte);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticCharField(Class<?> paramClass, String paramString, char paramChar)
  {
    try
    {
      findField(paramClass, paramString).setChar(null, paramChar);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticDoubleField(Class<?> paramClass, String paramString, double paramDouble)
  {
    try
    {
      findField(paramClass, paramString).setDouble(null, paramDouble);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticFloatField(Class<?> paramClass, String paramString, float paramFloat)
  {
    try
    {
      findField(paramClass, paramString).setFloat(null, paramFloat);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticIntField(Class<?> paramClass, String paramString, int paramInt)
  {
    try
    {
      findField(paramClass, paramString).setInt(null, paramInt);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticLongField(Class<?> paramClass, String paramString, long paramLong)
  {
    try
    {
      findField(paramClass, paramString).setLong(null, paramLong);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticObjectField(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      findField(paramClass, paramString).set(null, paramObject);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
  
  public static void setStaticShortField(Class<?> paramClass, String paramString, short paramShort)
  {
    try
    {
      findField(paramClass, paramString).setShort(null, paramShort);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      DexposedBridge.log(paramClass);
      throw new IllegalAccessError(paramClass.getMessage());
    }
    catch (IllegalArgumentException paramClass)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.android.dexposed.XposedHelpers
 * JD-Core Version:    0.7.0.1
 */