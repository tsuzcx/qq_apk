package com.tencent.luan.ioc;

import com.tencent.luan.core.LuanLog;
import com.tencent.luan.core.Utility;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.index.IndexInjectAnalysisService;
import com.tencent.luan.ioc.reflect.ReflectInjectAnalysisService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LuanInjectService
  implements InjectService
{
  private static final String TAG = "LuanInjectService";
  static final String VERSION_NAME = "0.4.4";
  private final boolean debugMode;
  private final IndexInjectAnalysisService indexAnalyst;
  final Map<String, InjectConstructor<?>> nameInjectConstructorMap;
  private final Map<String, Class<?>> nameTypeMap;
  private final Set<Class<?>> providerTypes;
  private final ReflectInjectAnalysisService reflectAnalyst;
  private final Map<Class<?>, InjectConstructor<?>> typeInjectConstructorMap;
  private final Map<Class<?>, List<InjectMethod>> typeInjectMethodsMap = new ConcurrentHashMap();
  
  public LuanInjectService()
  {
    this.debugMode = false;
    this.reflectAnalyst = new ReflectInjectAnalysisService(null);
    this.indexAnalyst = new IndexInjectAnalysisService(Collections.emptyList());
    this.nameTypeMap = Collections.emptyMap();
    this.providerTypes = Collections.emptySet();
    this.typeInjectConstructorMap = new ConcurrentHashMap();
    this.nameInjectConstructorMap = Collections.emptyMap();
  }
  
  private LuanInjectService(LuanInjectService.Builder paramBuilder)
  {
    this.debugMode = LuanInjectService.Builder.access$000(paramBuilder);
    this.reflectAnalyst = new ReflectInjectAnalysisService(LuanInjectService.Builder.access$100(paramBuilder));
    this.reflectAnalyst.setValid(LuanInjectService.Builder.access$200(paramBuilder));
    this.indexAnalyst = new IndexInjectAnalysisService(Collections.unmodifiableList(LuanInjectService.Builder.access$300(paramBuilder)));
    this.nameTypeMap = Collections.unmodifiableMap(new HashMap(LuanInjectService.Builder.access$400(paramBuilder)));
    this.providerTypes = Collections.unmodifiableSet(new LinkedHashSet(LuanInjectService.Builder.access$500(paramBuilder)));
    paramBuilder = new HashMap();
    HashMap localHashMap = new HashMap();
    collectProvideMethods(paramBuilder, localHashMap);
    this.typeInjectConstructorMap = new ConcurrentHashMap(paramBuilder);
    this.nameInjectConstructorMap = Collections.unmodifiableMap(collectNamedTypeConstructors(localHashMap));
  }
  
  private Map<String, InjectConstructor<?>> collectNamedTypeConstructors(Map<String, InjectConstructor<?>> paramMap)
  {
    Iterator localIterator = this.nameTypeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!paramMap.containsKey(localEntry.getKey())) {
        paramMap.put(localEntry.getKey(), getInjectConstructor((Class)localEntry.getValue()));
      }
    }
    return paramMap;
  }
  
  private void collectProvideMethods(Map<Class<?>, InjectConstructor<?>> paramMap, Map<String, InjectConstructor<?>> paramMap1)
  {
    Iterator localIterator = this.providerTypes.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (Class)localIterator.next();
      Object localObject1 = null;
      if (this.indexAnalyst.isValid()) {
        localObject1 = this.indexAnalyst.getProvideMethods((Class)localObject3);
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.reflectAnalyst.isValid()) {
          localObject2 = this.reflectAnalyst.getProvideMethods((Class)localObject3);
        }
      }
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        LuanLog.i("LuanInjectService", "addProvider: this type has no provide method " + ((Class)localObject3).getName());
      }
      else
      {
        if (this.debugMode) {
          LuanLog.d("LuanInjectService", "addProvider: " + ((Class)localObject3).getName() + " which has " + ((List)localObject2).size() + " provide methods");
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ProvideMethod)((Iterator)localObject1).next();
          localObject3 = ((ProvideMethod)localObject2).provideParam();
          if (((InjectParam)localObject3).name.isEmpty()) {
            paramMap.put(((InjectParam)localObject3).type, localObject2);
          } else {
            paramMap1.put(((InjectParam)localObject3).name, localObject2);
          }
        }
      }
    }
  }
  
  public static String getVersionName()
  {
    return "0.4.4";
  }
  
  private static String typeNamed(Class<?> paramClass)
  {
    paramClass = (Named)paramClass.getAnnotation(Named.class);
    if (paramClass == null) {
      return "";
    }
    return paramClass.value();
  }
  
  public <T> T get(Class<T> paramClass, String paramString, Object... paramVarArgs)
  {
    if (paramClass == null) {
      throw new NullPointerException("type for get object cannot be null");
    }
    if (this.debugMode) {
      LuanLog.d("LuanInjectService", "get type " + paramClass.getName() + " with name " + paramString);
    }
    LuanInjector localLuanInjector = new LuanInjector(null, this);
    if (Utility.isEmpty(paramString)) {
      return localLuanInjector.get(paramClass, paramVarArgs);
    }
    return localLuanInjector.get(paramString, paramVarArgs);
  }
  
  public LuanInjectService.Builder getCloneBuilder()
  {
    return new LuanInjectService.Builder(this);
  }
  
  InjectConstructor<?> getInjectConstructor(Class<?> paramClass)
  {
    InjectConstructor localInjectConstructor = (InjectConstructor)this.typeInjectConstructorMap.get(paramClass);
    Object localObject = localInjectConstructor;
    if (localInjectConstructor == null)
    {
      if (this.indexAnalyst.isValid()) {
        localInjectConstructor = this.indexAnalyst.getInjectConstructor(paramClass);
      }
      localObject = localInjectConstructor;
      if (localInjectConstructor == null)
      {
        localObject = localInjectConstructor;
        if (this.reflectAnalyst.isValid()) {
          localObject = this.reflectAnalyst.getInjectConstructor(paramClass);
        }
      }
      if (localObject == null) {
        throw new InjectException("failed to create object " + paramClass.getName());
      }
      this.typeInjectConstructorMap.put(paramClass, localObject);
    }
    return localObject;
  }
  
  List<InjectMethod> getInjectMethods(Class<?> paramClass)
  {
    Object localObject2 = (List)this.typeInjectMethodsMap.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.indexAnalyst.isValid()) {
        localObject2 = this.indexAnalyst.getInjectMethods(paramClass);
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.reflectAnalyst.isValid()) {
          localObject1 = this.reflectAnalyst.getInjectMethods(paramClass);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        LuanLog.i("LuanInjectService", "getInjectMethods: this type has no inject method " + paramClass.getName());
        localObject2 = Collections.emptyList();
      }
      this.typeInjectMethodsMap.put(paramClass, localObject2);
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void inject(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("injected object cannot be null");
    }
    if (this.debugMode) {
      LuanLog.d("LuanInjectService", "start to inject " + paramObject.getClass().getName());
    }
    new LuanInjector(paramObject, this).inject();
  }
  
  public boolean isDebugMode()
  {
    return this.debugMode;
  }
  
  public boolean isReflectValid()
  {
    return this.reflectAnalyst.isValid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjectService
 * JD-Core Version:    0.7.0.1
 */