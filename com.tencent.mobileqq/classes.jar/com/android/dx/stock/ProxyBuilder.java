package com.android.dx.stock;

import com.android.dx.Code;
import com.android.dx.Comparison;
import com.android.dx.DexMaker;
import com.android.dx.FieldId;
import com.android.dx.Label;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ProxyBuilder<T>
{
  private static final String FIELD_NAME_HANDLER = "$__handler";
  private static final String FIELD_NAME_METHODS = "$__methodArray";
  private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_BOXED;
  private static final Map<Class<?>, MethodId<?, ?>> PRIMITIVE_TO_UNBOX_METHOD;
  private static final Map<TypeId<?>, MethodId<?, ?>> PRIMITIVE_TYPE_TO_UNBOX_METHOD;
  public static final int VERSION = 1;
  private static final Map<Class<?>, Class<?>> generatedProxyClasses = Collections.synchronizedMap(new HashMap());
  private final Class<T> baseClass;
  private Class<?>[] constructorArgTypes = new Class[0];
  private Object[] constructorArgValues = new Object[0];
  private File dexCache;
  private InvocationHandler handler;
  private Set<Class<?>> interfaces = new HashSet();
  private ClassLoader parentClassLoader = ProxyBuilder.class.getClassLoader();
  
  static
  {
    PRIMITIVE_TO_BOXED = new HashMap();
    PRIMITIVE_TO_BOXED.put(Boolean.TYPE, Boolean.class);
    PRIMITIVE_TO_BOXED.put(Integer.TYPE, Integer.class);
    PRIMITIVE_TO_BOXED.put(Byte.TYPE, Byte.class);
    PRIMITIVE_TO_BOXED.put(Long.TYPE, Long.class);
    PRIMITIVE_TO_BOXED.put(Short.TYPE, Short.class);
    PRIMITIVE_TO_BOXED.put(Float.TYPE, Float.class);
    PRIMITIVE_TO_BOXED.put(Double.TYPE, Double.class);
    PRIMITIVE_TO_BOXED.put(Character.TYPE, Character.class);
    PRIMITIVE_TYPE_TO_UNBOX_METHOD = new HashMap();
    Object localObject1 = PRIMITIVE_TO_BOXED.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      TypeId localTypeId = TypeId.get((Class)((Map.Entry)localObject2).getKey());
      localObject2 = TypeId.get((Class)((Map.Entry)localObject2).getValue());
      localObject2 = ((TypeId)localObject2).getMethod((TypeId)localObject2, "valueOf", new TypeId[] { localTypeId });
      PRIMITIVE_TYPE_TO_UNBOX_METHOD.put(localTypeId, localObject2);
    }
    localObject1 = new HashMap();
    ((Map)localObject1).put(Boolean.TYPE, TypeId.get(Boolean.class).getMethod(TypeId.BOOLEAN, "booleanValue", new TypeId[0]));
    ((Map)localObject1).put(Integer.TYPE, TypeId.get(Integer.class).getMethod(TypeId.INT, "intValue", new TypeId[0]));
    ((Map)localObject1).put(Byte.TYPE, TypeId.get(Byte.class).getMethod(TypeId.BYTE, "byteValue", new TypeId[0]));
    ((Map)localObject1).put(Long.TYPE, TypeId.get(Long.class).getMethod(TypeId.LONG, "longValue", new TypeId[0]));
    ((Map)localObject1).put(Short.TYPE, TypeId.get(Short.class).getMethod(TypeId.SHORT, "shortValue", new TypeId[0]));
    ((Map)localObject1).put(Float.TYPE, TypeId.get(Float.class).getMethod(TypeId.FLOAT, "floatValue", new TypeId[0]));
    ((Map)localObject1).put(Double.TYPE, TypeId.get(Double.class).getMethod(TypeId.DOUBLE, "doubleValue", new TypeId[0]));
    ((Map)localObject1).put(Character.TYPE, TypeId.get(Character.class).getMethod(TypeId.CHAR, "charValue", new TypeId[0]));
    PRIMITIVE_TO_UNBOX_METHOD = (Map)localObject1;
  }
  
  private ProxyBuilder(Class<T> paramClass)
  {
    this.baseClass = paramClass;
  }
  
  private static <T> Set<T> asSet(T... paramVarArgs)
  {
    return new CopyOnWriteArraySet(Arrays.asList(paramVarArgs));
  }
  
  private static Local<?> boxIfRequired(Code paramCode, Local<?> paramLocal, Local<Object> paramLocal1)
  {
    MethodId localMethodId = (MethodId)PRIMITIVE_TYPE_TO_UNBOX_METHOD.get(paramLocal.getType());
    if (localMethodId == null) {
      return paramLocal;
    }
    paramCode.invokeStatic(localMethodId, paramLocal1, new Local[] { paramLocal });
    return paramLocal1;
  }
  
  public static Object callSuper(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramObject = paramObject.getClass().getMethod(superMethodName(paramMethod), paramMethod.getParameterTypes()).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw paramObject.getCause();
    }
  }
  
  private static void check(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  private static TypeId<?>[] classArrayToTypeArray(Class<?>[] paramArrayOfClass)
  {
    TypeId[] arrayOfTypeId = new TypeId[paramArrayOfClass.length];
    int i = 0;
    while (i < paramArrayOfClass.length)
    {
      arrayOfTypeId[i] = TypeId.get(paramArrayOfClass[i]);
      i += 1;
    }
    return arrayOfTypeId;
  }
  
  public static <T> ProxyBuilder<T> forClass(Class<T> paramClass)
  {
    return new ProxyBuilder(paramClass);
  }
  
  private static <T, G extends T> void generateCodeForAllMethods(DexMaker paramDexMaker, TypeId<G> paramTypeId, Method[] paramArrayOfMethod, TypeId<T> paramTypeId1)
  {
    TypeId localTypeId1 = TypeId.get(InvocationHandler.class);
    TypeId localTypeId2 = TypeId.get([Ljava.lang.reflect.Method.class);
    FieldId localFieldId1 = paramTypeId.getField(localTypeId1, "$__handler");
    FieldId localFieldId2 = paramTypeId.getField(localTypeId2, "$__methodArray");
    TypeId localTypeId3 = TypeId.get(Method.class);
    TypeId localTypeId4 = TypeId.get([Ljava.lang.Object.class);
    MethodId localMethodId1 = localTypeId1.getMethod(TypeId.OBJECT, "invoke", new TypeId[] { TypeId.OBJECT, localTypeId3, localTypeId4 });
    int i = 0;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int j;
    Class localClass;
    TypeId localTypeId5;
    MethodId localMethodId2;
    Code localCode;
    Local localLocal1;
    Local localLocal2;
    Local localLocal3;
    Local localLocal4;
    Local localLocal5;
    Object localObject5;
    Local localLocal6;
    Local localLocal7;
    Local localLocal9;
    Local localLocal8;
    Local localLocal10;
    if (i < paramArrayOfMethod.length)
    {
      localObject4 = paramArrayOfMethod[i];
      localObject1 = ((Method)localObject4).getName();
      localObject3 = ((Method)localObject4).getParameterTypes();
      localObject2 = new TypeId[localObject3.length];
      j = 0;
      while (j < localObject2.length)
      {
        localObject2[j] = TypeId.get(localObject3[j]);
        j += 1;
      }
      localClass = ((Method)localObject4).getReturnType();
      localTypeId5 = TypeId.get(localClass);
      localMethodId2 = paramTypeId1.getMethod(localTypeId5, (String)localObject1, (TypeId[])localObject2);
      localCode = paramDexMaker.declare(paramTypeId.getMethod(localTypeId5, (String)localObject1, (TypeId[])localObject2), 1);
      localLocal1 = localCode.getThis(paramTypeId);
      localLocal2 = localCode.newLocal(localTypeId1);
      localLocal3 = localCode.newLocal(TypeId.OBJECT);
      localLocal4 = localCode.newLocal(TypeId.INT);
      localLocal5 = localCode.newLocal(localTypeId4);
      localObject5 = localCode.newLocal(TypeId.INT);
      localLocal6 = localCode.newLocal(TypeId.OBJECT);
      localLocal7 = localCode.newLocal(localTypeId5);
      localLocal9 = localCode.newLocal(localTypeId2);
      localLocal8 = localCode.newLocal(localTypeId3);
      localLocal10 = localCode.newLocal(TypeId.INT);
      localObject1 = (Class)PRIMITIVE_TO_BOXED.get(localClass);
      if (localObject1 == null) {
        break label796;
      }
    }
    label796:
    for (Object localObject1 = localCode.newLocal(TypeId.get((Class)localObject1));; localObject1 = null)
    {
      Local[] arrayOfLocal = new Local[localObject3.length];
      Local localLocal11 = localCode.newLocal(localTypeId5);
      Local localLocal12 = localCode.newLocal(localTypeId1);
      localCode.loadConstant(localLocal10, Integer.valueOf(i));
      localCode.sget(localFieldId2, localLocal9);
      localCode.aget(localLocal8, localLocal9, localLocal10);
      localCode.loadConstant((Local)localObject5, Integer.valueOf(localObject2.length));
      localCode.newArray(localLocal5, (Local)localObject5);
      localCode.iget(localFieldId1, localLocal2, localLocal1);
      localCode.loadConstant(localLocal12, null);
      localObject5 = new Label();
      localCode.compare(Comparison.EQ, (Label)localObject5, localLocal12, localLocal2);
      j = 0;
      while (j < localObject2.length)
      {
        localCode.loadConstant(localLocal4, Integer.valueOf(j));
        localCode.aput(localLocal5, localLocal4, boxIfRequired(localCode, localCode.getParameter(j, localObject2[j]), localLocal6));
        j += 1;
      }
      localCode.invokeInterface(localMethodId1, localLocal3, localLocal2, new Local[] { localLocal1, localLocal8, localLocal5 });
      generateCodeForReturnStatement(localCode, localClass, localLocal3, localLocal7, (Local)localObject1);
      localCode.mark((Label)localObject5);
      j = 0;
      while (j < arrayOfLocal.length)
      {
        arrayOfLocal[j] = localCode.getParameter(j, localObject2[j]);
        j += 1;
      }
      if (Void.TYPE.equals(localClass))
      {
        localCode.invokeSuper(localMethodId2, null, localLocal1, arrayOfLocal);
        localCode.returnVoid();
      }
      for (;;)
      {
        localObject1 = paramDexMaker.declare(paramTypeId.getMethod(localTypeId5, superMethodName((Method)localObject4), (TypeId[])localObject2), 1);
        localObject4 = ((Code)localObject1).getThis(paramTypeId);
        localObject3 = new Local[localObject3.length];
        j = 0;
        while (j < localObject3.length)
        {
          localObject3[j] = ((Code)localObject1).getParameter(j, localObject2[j]);
          j += 1;
        }
        invokeSuper(localMethodId2, localCode, localLocal1, arrayOfLocal, localLocal11);
        localCode.returnValue(localLocal11);
      }
      if (Void.TYPE.equals(localClass))
      {
        ((Code)localObject1).invokeSuper(localMethodId2, null, (Local)localObject4, (Local[])localObject3);
        ((Code)localObject1).returnVoid();
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((Code)localObject1).newLocal(localTypeId5);
        invokeSuper(localMethodId2, (Code)localObject1, (Local)localObject4, (Local[])localObject3, (Local)localObject2);
        ((Code)localObject1).returnValue((Local)localObject2);
      }
      return;
    }
  }
  
  private static void generateCodeForReturnStatement(Code paramCode, Class paramClass, Local paramLocal1, Local paramLocal2, Local paramLocal3)
  {
    if (PRIMITIVE_TO_UNBOX_METHOD.containsKey(paramClass))
    {
      paramCode.cast(paramLocal3, paramLocal1);
      paramCode.invokeVirtual(getUnboxMethodForPrimitive(paramClass), paramLocal2, paramLocal3, new Local[0]);
      paramCode.returnValue(paramLocal2);
      return;
    }
    if (Void.TYPE.equals(paramClass))
    {
      paramCode.returnVoid();
      return;
    }
    paramCode.cast(paramLocal2, paramLocal1);
    paramCode.returnValue(paramLocal2);
  }
  
  private static <T, G extends T> void generateConstructorsAndFields(DexMaker paramDexMaker, TypeId<G> paramTypeId, TypeId<T> paramTypeId1, Class<T> paramClass)
  {
    Object localObject1 = TypeId.get(InvocationHandler.class);
    Object localObject2 = TypeId.get([Ljava.lang.reflect.Method.class);
    paramDexMaker.declare(paramTypeId.getField((TypeId)localObject1, "$__handler"), 2, null);
    paramDexMaker.declare(paramTypeId.getField((TypeId)localObject2, "$__methodArray"), 10, null);
    paramClass = getConstructorsToOverwrite(paramClass);
    int k = paramClass.length;
    int i = 0;
    if (i < k)
    {
      localObject1 = paramClass[i];
      if (((Constructor)localObject1).getModifiers() == 16) {}
      for (;;)
      {
        i += 1;
        break;
        localObject1 = classArrayToTypeArray(((Constructor)localObject1).getParameterTypes());
        localObject2 = paramDexMaker.declare(paramTypeId.getConstructor((TypeId[])localObject1), 1);
        Local localLocal = ((Code)localObject2).getThis(paramTypeId);
        Local[] arrayOfLocal = new Local[localObject1.length];
        int j = 0;
        while (j < arrayOfLocal.length)
        {
          arrayOfLocal[j] = ((Code)localObject2).getParameter(j, localObject1[j]);
          j += 1;
        }
        ((Code)localObject2).invokeDirect(paramTypeId1.getConstructor((TypeId[])localObject1), null, localLocal, arrayOfLocal);
        ((Code)localObject2).returnVoid();
      }
    }
  }
  
  private static <T> Constructor<T>[] getConstructorsToOverwrite(Class<T> paramClass)
  {
    return (Constructor[])paramClass.getDeclaredConstructors();
  }
  
  private TypeId<?>[] getInterfacesAsTypeIds()
  {
    TypeId[] arrayOfTypeId = new TypeId[this.interfaces.size()];
    Iterator localIterator = this.interfaces.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfTypeId[i] = TypeId.get((Class)localIterator.next());
      i += 1;
    }
    return arrayOfTypeId;
  }
  
  public static InvocationHandler getInvocationHandler(Object paramObject)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("$__handler");
      localField.setAccessible(true);
      paramObject = (InvocationHandler)localField.get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      throw new IllegalArgumentException("Not a valid proxy instance", paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AssertionError(paramObject);
    }
  }
  
  private static <T> String getMethodNameForProxyOf(Class<T> paramClass)
  {
    return paramClass.getSimpleName() + "_Proxy";
  }
  
  private void getMethodsToProxy(Set<ProxyBuilder.MethodSetEntry> paramSet1, Set<ProxyBuilder.MethodSetEntry> paramSet2, Class<?> paramClass)
  {
    int j = 0;
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int k = arrayOfMethod.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfMethod[i];
      if ((((Method)localObject).getModifiers() & 0x10) != 0)
      {
        localObject = new ProxyBuilder.MethodSetEntry((Method)localObject);
        paramSet2.add(localObject);
        paramSet1.remove(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((((Method)localObject).getModifiers() & 0x8) == 0) && ((Modifier.isPublic(((Method)localObject).getModifiers())) || (Modifier.isProtected(((Method)localObject).getModifiers()))) && ((!((Method)localObject).getName().equals("finalize")) || (((Method)localObject).getParameterTypes().length != 0)))
        {
          localObject = new ProxyBuilder.MethodSetEntry((Method)localObject);
          if (!paramSet2.contains(localObject)) {
            paramSet1.add(localObject);
          }
        }
      }
    }
    if (paramClass.isInterface())
    {
      paramClass = paramClass.getInterfaces();
      k = paramClass.length;
      i = j;
      while (i < k)
      {
        getMethodsToProxy(paramSet1, paramSet2, paramClass[i]);
        i += 1;
      }
    }
  }
  
  private Method[] getMethodsToProxyRecursive()
  {
    int j = 0;
    Object localObject2 = new HashSet();
    HashSet localHashSet = new HashSet();
    for (Object localObject1 = this.baseClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      getMethodsToProxy((Set)localObject2, localHashSet, (Class)localObject1);
    }
    for (localObject1 = this.baseClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
    {
      Class[] arrayOfClass = ((Class)localObject1).getInterfaces();
      int k = arrayOfClass.length;
      i = 0;
      while (i < k)
      {
        getMethodsToProxy((Set)localObject2, localHashSet, arrayOfClass[i]);
        i += 1;
      }
    }
    localObject1 = this.interfaces.iterator();
    while (((Iterator)localObject1).hasNext()) {
      getMethodsToProxy((Set)localObject2, localHashSet, (Class)((Iterator)localObject1).next());
    }
    localObject1 = new Method[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = j;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1[i] = ProxyBuilder.MethodSetEntry.access$000((ProxyBuilder.MethodSetEntry)((Iterator)localObject2).next());
      i += 1;
    }
    Arrays.sort((Object[])localObject1, new ProxyBuilder.1(this));
    return localObject1;
  }
  
  private static MethodId<?, ?> getUnboxMethodForPrimitive(Class<?> paramClass)
  {
    return (MethodId)PRIMITIVE_TO_UNBOX_METHOD.get(paramClass);
  }
  
  private static void invokeSuper(MethodId paramMethodId, Code paramCode, Local paramLocal1, Local[] paramArrayOfLocal, Local paramLocal2)
  {
    paramCode.invokeSuper(paramMethodId, paramLocal2, paramLocal1, paramArrayOfLocal);
  }
  
  public static boolean isProxyClass(Class<?> paramClass)
  {
    try
    {
      paramClass.getDeclaredField("$__handler");
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  private static RuntimeException launderCause(InvocationTargetException paramInvocationTargetException)
  {
    paramInvocationTargetException = paramInvocationTargetException.getCause();
    if ((paramInvocationTargetException instanceof Error)) {
      throw ((Error)paramInvocationTargetException);
    }
    if ((paramInvocationTargetException instanceof RuntimeException)) {
      throw ((RuntimeException)paramInvocationTargetException);
    }
    throw new UndeclaredThrowableException(paramInvocationTargetException);
  }
  
  private Class<? extends T> loadClass(ClassLoader paramClassLoader, String paramString)
  {
    return paramClassLoader.loadClass(paramString);
  }
  
  public static void setInvocationHandler(Object paramObject, InvocationHandler paramInvocationHandler)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("$__handler");
      localField.setAccessible(true);
      localField.set(paramObject, paramInvocationHandler);
      return;
    }
    catch (NoSuchFieldException paramObject)
    {
      throw new IllegalArgumentException("Not a valid proxy instance", paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AssertionError(paramObject);
    }
  }
  
  private static void setMethodsStaticField(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    try
    {
      paramClass = paramClass.getDeclaredField("$__methodArray");
      paramClass.setAccessible(true);
      paramClass.set(null, paramArrayOfMethod);
      return;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AssertionError(paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  private static String superMethodName(Method paramMethod)
  {
    String str = paramMethod.getReturnType().getName();
    return "super$" + paramMethod.getName() + "$" + str.replace('.', '_').replace('[', '_').replace(';', '_');
  }
  
  public T build()
  {
    boolean bool2 = true;
    if (this.handler != null)
    {
      bool1 = true;
      check(bool1, "handler == null");
      if (this.constructorArgTypes.length != this.constructorArgValues.length) {
        break label78;
      }
    }
    label78:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      check(bool1, "constructorArgValues.length != constructorArgTypes.length");
      Object localObject = buildProxyClass();
      try
      {
        localObject = ((Class)localObject).getConstructor(this.constructorArgTypes);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new IllegalArgumentException("No constructor for " + this.baseClass.getName() + " with parameter types " + Arrays.toString(this.constructorArgTypes));
      }
      try
      {
        localObject = ((Constructor)localObject).newInstance(this.constructorArgValues);
        setInvocationHandler(localObject, this.handler);
        return localObject;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new AssertionError(localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw launderCause(localInvocationTargetException);
      }
      bool1 = false;
      break;
    }
  }
  
  public Class<? extends T> buildProxyClass()
  {
    Object localObject1 = (Class)generatedProxyClasses.get(this.baseClass);
    if ((localObject1 != null) && (((Class)localObject1).getClassLoader().getParent() == this.parentClassLoader) && (this.interfaces.equals(asSet(((Class)localObject1).getInterfaces())))) {
      return localObject1;
    }
    Object localObject3 = new DexMaker();
    Object localObject2 = getMethodNameForProxyOf(this.baseClass);
    TypeId localTypeId1 = TypeId.get("L" + (String)localObject2 + ";");
    TypeId localTypeId2 = TypeId.get(this.baseClass);
    generateConstructorsAndFields((DexMaker)localObject3, localTypeId1, localTypeId2, this.baseClass);
    localObject1 = getMethodsToProxyRecursive();
    generateCodeForAllMethods((DexMaker)localObject3, localTypeId1, (Method[])localObject1, localTypeId2);
    ((DexMaker)localObject3).declare(localTypeId1, (String)localObject2 + ".generated", 1, localTypeId2, getInterfacesAsTypeIds());
    localObject3 = ((DexMaker)localObject3).generateAndLoad(this.parentClassLoader, this.dexCache);
    try
    {
      localObject2 = loadClass((ClassLoader)localObject3, (String)localObject2);
      setMethodsStaticField((Class)localObject2, (Method[])localObject1);
      generatedProxyClasses.put(this.baseClass, localObject2);
      return localObject2;
    }
    catch (IllegalAccessError localIllegalAccessError)
    {
      throw new UnsupportedOperationException("cannot proxy inaccessible class " + this.baseClass, localIllegalAccessError);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new AssertionError(localClassNotFoundException);
    }
  }
  
  public ProxyBuilder<T> constructorArgTypes(Class<?>... paramVarArgs)
  {
    this.constructorArgTypes = paramVarArgs;
    return this;
  }
  
  public ProxyBuilder<T> constructorArgValues(Object... paramVarArgs)
  {
    this.constructorArgValues = paramVarArgs;
    return this;
  }
  
  public ProxyBuilder<T> dexCache(File paramFile)
  {
    this.dexCache = new File(paramFile, "v" + Integer.toString(1));
    this.dexCache.mkdir();
    return this;
  }
  
  public ProxyBuilder<T> handler(InvocationHandler paramInvocationHandler)
  {
    this.handler = paramInvocationHandler;
    return this;
  }
  
  public ProxyBuilder<T> implementing(Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramVarArgs[i];
      if (!localClass.isInterface()) {
        throw new IllegalArgumentException("Not an interface: " + localClass.getName());
      }
      this.interfaces.add(localClass);
      i += 1;
    }
    return this;
  }
  
  public ProxyBuilder<T> parentClassLoader(ClassLoader paramClassLoader)
  {
    this.parentClassLoader = paramClassLoader;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.stock.ProxyBuilder
 * JD-Core Version:    0.7.0.1
 */