package com.tencent.luan.ioc;

import com.tencent.luan.core.LuanLog;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.index.IndexInjectAnalysisService;
import com.tencent.luan.ioc.index.IndexInjectInfoService;
import com.tencent.luan.ioc.reflect.ReflectInjectAnalysisService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LuanInjectService
  implements InjectService
{
  private static final String TAG = "LuanInjectService";
  static final String VERSION_NAME = "0.3.4";
  private final Map<Class<?>, InjectConstructor<?>> classInjectConstructorCache = new ConcurrentHashMap();
  private final Map<Class<?>, List<InjectMethod>> classInjectMethodsCache = new ConcurrentHashMap();
  private final Map<Class<?>, ProvideMethod> classProvideMethodCache = new HashMap();
  private final boolean debugMode;
  private final IndexInjectAnalysisService indexAnalyst = new IndexInjectAnalysisService();
  private final ReadWriteLock lock = new ReentrantReadWriteLock();
  private final Map<String, ProvideMethod> nameProvideMethodCache = new HashMap();
  private final Map<String, Class<?>> namedClassCache = new HashMap();
  private final InjectAnalysisService reflectAnalyst;
  
  public LuanInjectService()
  {
    this.debugMode = false;
    this.reflectAnalyst = new ReflectInjectAnalysisService();
  }
  
  private LuanInjectService(LuanInjectService.Builder paramBuilder)
  {
    this.debugMode = LuanInjectService.Builder.access$000(paramBuilder);
    this.reflectAnalyst = new ReflectInjectAnalysisService(LuanInjectService.Builder.access$100(paramBuilder));
  }
  
  public static String getVersionName()
  {
    return "0.3.4";
  }
  
  private static String typeNamed(Class<?> paramClass)
  {
    paramClass = (Named)paramClass.getAnnotation(Named.class);
    if (paramClass == null) {
      return "";
    }
    return paramClass.value();
  }
  
  public void addIndexInfo(IndexInjectInfoService paramIndexInjectInfoService)
  {
    if (paramIndexInjectInfoService != null)
    {
      if (this.debugMode) {
        LuanLog.d("LuanInjectService", "addIndexInfo: " + paramIndexInjectInfoService.getClass().getName());
      }
      this.indexAnalyst.addIndexInfo(paramIndexInjectInfoService);
    }
  }
  
  public void addIndexInfo(Iterable<IndexInjectInfoService> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        addIndexInfo((IndexInjectInfoService)paramIterable.next());
      }
    }
  }
  
  public Class<?> addNamedType(Class<?> paramClass)
  {
    String str = typeNamed(paramClass);
    if (str.isEmpty())
    {
      LuanLog.d("LuanInjectService", "addNamedType: this class " + paramClass.getName() + " is not named or named empty string, ignored");
      return null;
    }
    if (this.debugMode) {
      LuanLog.d("LuanInjectService", "addNamedType: type to add named type " + paramClass.getName() + " with name " + str);
    }
    this.lock.writeLock().lock();
    try
    {
      paramClass = (Class)this.namedClassCache.put(str, paramClass);
      return paramClass;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }
  
  public void addNamedTypes(Iterable<Class<?>> paramIterable)
  {
    HashMap localHashMap = new HashMap();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Class localClass = (Class)paramIterable.next();
      String str = typeNamed(localClass);
      if (str.isEmpty())
      {
        LuanLog.d("LuanInjectService", "addNamedType: this class " + localClass.getName() + " is not named or named empty string, ignored");
      }
      else
      {
        localHashMap.put(str, localClass);
        if (this.debugMode) {
          LuanLog.d("LuanInjectService", "addNamedTypes: type to add named type " + localClass.getName() + " with name " + str);
        }
      }
    }
    if (localHashMap.isEmpty()) {
      return;
    }
    this.lock.writeLock().lock();
    try
    {
      this.namedClassCache.putAll(localHashMap);
      return;
    }
    finally
    {
      this.lock.writeLock().unlock();
    }
  }
  
  public void addProvider(Class<?> paramClass)
  {
    if (paramClass == null) {
      throw new NullPointerException("provide type cannot be null");
    }
    Object localObject1 = null;
    if (this.indexAnalyst.isValid()) {
      localObject1 = this.indexAnalyst.getProvideMethods(paramClass);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.reflectAnalyst.getProvideMethods(paramClass);
    }
    if (this.debugMode) {
      LuanLog.d("LuanInjectService", "addProvider: " + paramClass.getName() + " which has " + ((List)localObject2).size() + " provide methods");
    }
    this.lock.writeLock().lock();
    for (;;)
    {
      try
      {
        paramClass = ((List)localObject2).iterator();
        if (!paramClass.hasNext()) {
          break;
        }
        localObject1 = (ProvideMethod)paramClass.next();
        localObject2 = ((ProvideMethod)localObject1).provideParam();
        if (((InjectParam)localObject2).name.isEmpty()) {
          this.classProvideMethodCache.put(((InjectParam)localObject2).type, localObject1);
        } else {
          this.nameProvideMethodCache.put(((InjectParam)localObject2).name, localObject1);
        }
      }
      finally
      {
        this.lock.writeLock().unlock();
      }
    }
    this.lock.writeLock().unlock();
  }
  
  /* Error */
  public <T> T get(Class<T> paramClass, String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 206	java/lang/NullPointerException
    //   7: dup
    //   8: ldc_w 257
    //   11: invokespecial 211	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 64	com/tencent/luan/ioc/LuanInjectService:debugMode	Z
    //   19: ifeq +40 -> 59
    //   22: ldc 10
    //   24: new 110	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 259
    //   34: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 124	java/lang/Class:getName	()Ljava/lang/String;
    //   41: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 173
    //   46: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 133	com/tencent/luan/core/LuanLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 48	com/tencent/luan/ioc/LuanInjectService:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   63: invokeinterface 262 1 0
    //   68: invokeinterface 183 1 0
    //   73: new 264	com/tencent/luan/ioc/LuanInjector
    //   76: dup
    //   77: aconst_null
    //   78: aload_0
    //   79: new 266	com/tencent/luan/ioc/LuanInjector$ProviderAndNamedTypeSnapshot
    //   82: dup
    //   83: aload_0
    //   84: getfield 53	com/tencent/luan/ioc/LuanInjectService:classProvideMethodCache	Ljava/util/Map;
    //   87: invokestatic 272	java/util/Collections:unmodifiableMap	(Ljava/util/Map;)Ljava/util/Map;
    //   90: aload_0
    //   91: getfield 55	com/tencent/luan/ioc/LuanInjectService:nameProvideMethodCache	Ljava/util/Map;
    //   94: invokestatic 272	java/util/Collections:unmodifiableMap	(Ljava/util/Map;)Ljava/util/Map;
    //   97: aload_0
    //   98: getfield 57	com/tencent/luan/ioc/LuanInjectService:namedClassCache	Ljava/util/Map;
    //   101: invokestatic 272	java/util/Collections:unmodifiableMap	(Ljava/util/Map;)Ljava/util/Map;
    //   104: invokespecial 275	com/tencent/luan/ioc/LuanInjector$ProviderAndNamedTypeSnapshot:<init>	(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
    //   107: invokespecial 278	com/tencent/luan/ioc/LuanInjector:<init>	(Ljava/lang/Object;Lcom/tencent/luan/ioc/LuanInjectService;Lcom/tencent/luan/ioc/LuanInjector$ProviderAndNamedTypeSnapshot;)V
    //   110: astore 4
    //   112: aload_2
    //   113: invokestatic 283	com/tencent/luan/core/Utility:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifeq +27 -> 143
    //   119: aload 4
    //   121: aload_1
    //   122: aload_3
    //   123: invokevirtual 286	com/tencent/luan/ioc/LuanInjector:get	(Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore_1
    //   127: aload_0
    //   128: getfield 48	com/tencent/luan/ioc/LuanInjectService:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   131: invokeinterface 262 1 0
    //   136: invokeinterface 192 1 0
    //   141: aload_1
    //   142: areturn
    //   143: aload 4
    //   145: aload_2
    //   146: aload_3
    //   147: invokevirtual 289	com/tencent/luan/ioc/LuanInjector:get	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   150: astore_1
    //   151: goto -24 -> 127
    //   154: astore_1
    //   155: aload_0
    //   156: getfield 48	com/tencent/luan/ioc/LuanInjectService:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   159: invokeinterface 262 1 0
    //   164: invokeinterface 192 1 0
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	LuanInjectService
    //   0	171	1	paramClass	Class<T>
    //   0	171	2	paramString	String
    //   0	171	3	paramVarArgs	Object[]
    //   110	34	4	localLuanInjector	LuanInjector
    // Exception table:
    //   from	to	target	type
    //   73	127	154	finally
    //   143	151	154	finally
  }
  
  InjectConstructor<?> getInjectConstructor(Class<?> paramClass)
  {
    InjectConstructor localInjectConstructor1 = (InjectConstructor)this.classInjectConstructorCache.get(paramClass);
    InjectConstructor localInjectConstructor2 = localInjectConstructor1;
    if (localInjectConstructor1 == null)
    {
      if (this.indexAnalyst.isValid()) {
        localInjectConstructor1 = this.indexAnalyst.getInjectConstructor(paramClass);
      }
      localInjectConstructor2 = localInjectConstructor1;
      if (localInjectConstructor1 == null) {
        localInjectConstructor2 = this.reflectAnalyst.getInjectConstructor(paramClass);
      }
      this.classInjectConstructorCache.put(paramClass, localInjectConstructor2);
    }
    return localInjectConstructor2;
  }
  
  List<InjectMethod> getInjectMethods(Class<?> paramClass)
  {
    List localList1 = (List)this.classInjectMethodsCache.get(paramClass);
    List localList2 = localList1;
    if (localList1 == null)
    {
      if (this.indexAnalyst.isValid()) {
        localList1 = this.indexAnalyst.getInjectMethods(paramClass);
      }
      if (localList1 != null)
      {
        localList2 = localList1;
        if (!localList1.isEmpty()) {}
      }
      else
      {
        localList2 = this.reflectAnalyst.getInjectMethods(paramClass);
      }
      this.classInjectMethodsCache.put(paramClass, localList2);
    }
    return localList2;
  }
  
  public void inject(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("injected object cannot be null");
    }
    if (this.debugMode) {
      LuanLog.d("LuanInjectService", "start to inject " + paramObject.getClass().getName());
    }
    this.lock.readLock().lock();
    try
    {
      new LuanInjector(paramObject, this, new LuanInjector.ProviderAndNamedTypeSnapshot(Collections.unmodifiableMap(this.classProvideMethodCache), Collections.unmodifiableMap(this.nameProvideMethodCache), Collections.unmodifiableMap(this.namedClassCache))).inject();
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
    }
  }
  
  public boolean isDebugMode()
  {
    return this.debugMode;
  }
  
  public void openIndexSpeedup(boolean paramBoolean)
  {
    if (this.debugMode) {
      LuanLog.d("LuanInjectService", "openIndexSpeedup: " + paramBoolean);
    }
    this.indexAnalyst.setOpen(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjectService
 * JD-Core Version:    0.7.0.1
 */