package com.tencent.luan.ioc;

import com.tencent.luan.core.SingleLinkedListNode;
import com.tencent.luan.ioc.wrapper.FixObjectWrapper;
import com.tencent.luan.ioc.wrapper.ObjectHolder;
import com.tencent.luan.ioc.wrapper.ObjectWrapper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LuanInjector
  implements Injector
{
  private SingleLinkedListNode<Object> createObjHeadNode;
  private SingleLinkedListNode<Object> createObjTailNode;
  private boolean isInjected;
  private final Map<String, ObjectWrapper<?>> nameObjectWrapperMap = new HashMap();
  private final LuanInjectService service;
  private final Object source;
  private final Map<String, ObjectWrapper<?>> typeObjectWrapperMap = new HashMap();
  
  LuanInjector(Object paramObject, LuanInjectService paramLuanInjectService)
  {
    this.source = paramObject;
    this.service = paramLuanInjectService;
  }
  
  private void addCreateObjectToLinkedList(Object paramObject)
  {
    paramObject = new SingleLinkedListNode(paramObject);
    SingleLinkedListNode localSingleLinkedListNode = this.createObjTailNode;
    if (localSingleLinkedListNode == null) {
      this.createObjHeadNode = paramObject;
    } else {
      localSingleLinkedListNode.setNext(paramObject);
    }
    this.createObjTailNode = paramObject;
  }
  
  private static void combineWrapperAndPutToCache(Map<String, ObjectWrapper<?>> paramMap, ObjectWrapper<?> paramObjectWrapper, Object paramObject, String paramString)
  {
    paramObject = paramObjectWrapper.combine(paramObject);
    if (paramObjectWrapper != paramObject) {
      paramMap.put(paramString, paramObject);
    }
  }
  
  private Object getObjectByWrapper(ObjectWrapper<?> paramObjectWrapper)
  {
    try
    {
      paramObjectWrapper = paramObjectWrapper.createObjectIfAbsent(this);
      localObject = paramObjectWrapper.object;
      if (paramObjectWrapper.needInject) {
        addCreateObjectToLinkedList(localObject);
      }
      return localObject;
    }
    catch (IllegalStateException paramObjectWrapper)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed to inference inject type such as more than one types ");
      ((StringBuilder)localObject).append(paramObjectWrapper);
      throw new InjectException(((StringBuilder)localObject).toString());
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
    if (paramVarArgs == null) {
      return;
    }
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
  
  private void putObjInAllTypeCache(Object paramObject, Class<?> paramClass)
  {
    Object localObject1 = new HashSet();
    readAllType(paramClass, (Set)localObject1);
    paramClass = ((Set)localObject1).iterator();
    while (paramClass.hasNext())
    {
      localObject1 = ((Class)paramClass.next()).getName();
      Object localObject2 = (ObjectWrapper)this.typeObjectWrapperMap.get(localObject1);
      if (localObject2 == null)
      {
        localObject2 = new FixObjectWrapper(paramObject);
        this.typeObjectWrapperMap.put(localObject1, localObject2);
      }
      else
      {
        combineWrapperAndPutToCache(this.typeObjectWrapperMap, (ObjectWrapper)localObject2, paramObject, (String)localObject1);
      }
    }
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
    paramVarArgs = this.createObjHeadNode;
    if (paramVarArgs != null)
    {
      paramVarArgs = paramVarArgs.iterator();
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
    paramVarArgs = this.createObjHeadNode;
    if (paramVarArgs != null)
    {
      paramVarArgs = paramVarArgs.iterator();
      while (paramVarArgs.hasNext()) {
        inject(paramVarArgs.next());
      }
    }
    this.isInjected = true;
    return paramString;
  }
  
  public Object getOrCreateObject(Class<?> paramClass)
  {
    if (!this.isInjected)
    {
      String str = paramClass.getName();
      Object localObject2 = (ObjectWrapper)this.typeObjectWrapperMap.get(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.service.getInjectConstructor(paramClass).wrapper();
        this.typeObjectWrapperMap.put(str, localObject1);
      }
      localObject2 = getObjectByWrapper((ObjectWrapper)localObject1);
      if (((ObjectWrapper)localObject1).needCache()) {
        putObjInAllTypeCache(localObject2, paramClass);
      }
      return localObject2;
    }
    throw new IllegalStateException("injection is already done");
  }
  
  public Object getOrCreateObject(String paramString)
  {
    if (!this.isInjected)
    {
      Object localObject2 = (ObjectWrapper)this.nameObjectWrapperMap.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (InjectConstructor)this.service.nameInjectConstructorMap.get(paramString);
        if (localObject1 != null)
        {
          localObject1 = ((InjectConstructor)localObject1).wrapper();
          this.nameObjectWrapperMap.put(paramString, localObject1);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("failed to create instance by this name ");
          ((StringBuilder)localObject1).append(paramString);
          throw new InjectException(((StringBuilder)localObject1).toString());
        }
      }
      localObject2 = getObjectByWrapper((ObjectWrapper)localObject1);
      if (((ObjectWrapper)localObject1).needCache()) {
        combineWrapperAndPutToCache(this.nameObjectWrapperMap, (ObjectWrapper)localObject1, localObject2, paramString);
      }
      return localObject2;
    }
    throw new IllegalStateException("injection is already done");
  }
  
  void inject()
  {
    if (this.isInjected) {
      return;
    }
    Object localObject = this.source;
    if (localObject != null)
    {
      putObjInAllTypeCache(localObject, localObject.getClass());
      inject(this.source);
      localObject = this.createObjHeadNode;
      if (localObject != null)
      {
        localObject = ((SingleLinkedListNode)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          inject(((Iterator)localObject).next());
        }
      }
      this.isInjected = true;
      return;
    }
    localObject = new NullPointerException("inject source object is null");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  boolean isInjected()
  {
    return this.isInjected;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector
 * JD-Core Version:    0.7.0.1
 */