package com.tencent.luan.ioc;

import com.tencent.luan.core.SingleLinkedListNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LuanInjector
  implements Injector
{
  private static final LuanInjector.ProviderObjectCreator PROVIDER_OBJECT_CREATOR = new LuanInjector.ProviderObjectCreator(null);
  private static final LuanInjector.TypeObjectCreator TYPE_OBJECT_CREATOR = new LuanInjector.TypeObjectCreator(null);
  private SingleLinkedListNode<Object> createObjHeadNode;
  private SingleLinkedListNode<Object> createObjTailNode;
  private boolean isInjected;
  private final Map<String, Object> nameObjCache = new HashMap();
  private LuanInjector.NameObjectGetter nameObjectGetter;
  private final LuanInjectService service;
  private final LuanInjector.ProviderAndNamedTypeSnapshot snapshot;
  private final Object source;
  private final Map<Class<?>, List<Object>> typeObjCache = new HashMap();
  private LuanInjector.TypeObjectGetter typeObjectGetter;
  
  LuanInjector(Object paramObject, LuanInjectService paramLuanInjectService, LuanInjector.ProviderAndNamedTypeSnapshot paramProviderAndNamedTypeSnapshot)
  {
    this.source = paramObject;
    this.service = paramLuanInjectService;
    this.snapshot = paramProviderAndNamedTypeSnapshot;
  }
  
  private void addCreateObjectToLinkedList(Object paramObject)
  {
    paramObject = new SingleLinkedListNode(paramObject);
    if (this.createObjTailNode == null) {
      this.createObjHeadNode = paramObject;
    }
    for (;;)
    {
      this.createObjTailNode = paramObject;
      return;
      this.createObjTailNode.setNext(paramObject);
    }
  }
  
  private void inject(Object paramObject)
  {
    Iterator localIterator = this.service.getInjectMethods(paramObject.getClass()).iterator();
    while (localIterator.hasNext()) {
      ((InjectMethod)localIterator.next()).invoke(paramObject, this);
    }
  }
  
  private void putArgs(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        if (localObject != null) {
          putObjInAllTypeCache(localObject, localObject.getClass());
        }
        i += 1;
      }
    }
  }
  
  private void putObjInAllTypeCache(Object paramObject, Class<?> paramClass)
  {
    HashSet localHashSet = new HashSet();
    readAllType(paramClass, localHashSet);
    paramClass = localHashSet.iterator();
    while (paramClass.hasNext()) {
      putObjInSingleTypeCache(paramObject, (Class)paramClass.next());
    }
  }
  
  private void putObjInSingleTypeCache(Object paramObject, Class<?> paramClass)
  {
    List localList = (List)this.typeObjCache.get(paramClass);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.typeObjCache.put(paramClass, localObject);
    }
    ((List)localObject).add(paramObject);
  }
  
  private void readAllType(Class<?> paramClass, Set<Class<?>> paramSet)
  {
    paramSet.add(paramClass);
    Class localClass = paramClass.getSuperclass();
    if (localClass != null) {
      readAllType(localClass, paramSet);
    }
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      readAllType(paramClass[i], paramSet);
      i += 1;
    }
  }
  
  Object get(Class<?> paramClass, Object... paramVarArgs)
  {
    putArgs(paramVarArgs);
    paramClass = getOrCreateObject(paramClass);
    if (this.createObjHeadNode != null)
    {
      paramVarArgs = this.createObjHeadNode.iterator();
      while (paramVarArgs.hasNext()) {
        inject(paramVarArgs.next());
      }
    }
    this.isInjected = true;
    return paramClass;
  }
  
  Object get(String paramString, Object... paramVarArgs)
  {
    putArgs(paramVarArgs);
    paramString = getOrCreateObject(paramString);
    if (this.createObjHeadNode != null)
    {
      paramVarArgs = this.createObjHeadNode.iterator();
      while (paramVarArgs.hasNext()) {
        inject(paramVarArgs.next());
      }
    }
    this.isInjected = true;
    return paramString;
  }
  
  public Object getOrCreateObject(Class<?> paramClass)
  {
    if (this.isInjected) {
      throw new IllegalStateException("injection is already done");
    }
    if (this.typeObjectGetter == null) {
      this.typeObjectGetter = new LuanInjector.TypeObjectGetter(this, null);
    }
    return this.typeObjectGetter.get(paramClass);
  }
  
  public Object getOrCreateObject(String paramString)
  {
    if (this.isInjected) {
      throw new IllegalStateException("injection is already done");
    }
    if (this.nameObjectGetter == null) {
      this.nameObjectGetter = new LuanInjector.NameObjectGetter(this, null);
    }
    return this.nameObjectGetter.get(paramString);
  }
  
  void inject()
  {
    if (this.isInjected) {
      return;
    }
    if (this.source == null) {
      throw new NullPointerException("inject source object is null");
    }
    putObjInAllTypeCache(this.source, this.source.getClass());
    inject(this.source);
    if (this.createObjHeadNode != null)
    {
      Iterator localIterator = this.createObjHeadNode.iterator();
      while (localIterator.hasNext()) {
        inject(localIterator.next());
      }
    }
    this.isInjected = true;
  }
  
  boolean isInjected()
  {
    return this.isInjected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector
 * JD-Core Version:    0.7.0.1
 */