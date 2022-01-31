package com.tencent.luan.ioc;

import java.lang.reflect.AnnotatedElement;

abstract class LuanInjector$ObjectGetter<K>
{
  private LuanInjector$ObjectGetter(LuanInjector paramLuanInjector) {}
  
  final Object get(K paramK)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject2 = getFromCache(paramK);
    if (localObject2 != null) {
      return localObject2;
    }
    Object localObject1 = getProvideMethod(paramK);
    if (localObject1 == null)
    {
      localObject1 = getType(paramK);
      i = InjectChecker.checkAndGetScope((AnnotatedElement)localObject1);
      localObject2 = LuanInjector.access$800();
      localLuanInjector = this.this$0;
      if (i == 1) {}
      for (;;)
      {
        localObject1 = ((LuanInjector.TypeObjectCreator)localObject2).create(localLuanInjector, localObject1, bool1);
        localObject2 = localObject1;
        if (i == 2) {
          break;
        }
        putToCache(paramK, localObject1);
        return localObject1;
        bool1 = false;
      }
    }
    int i = ((ProvideMethod)localObject1).scope();
    localObject2 = LuanInjector.access$900();
    LuanInjector localLuanInjector = this.this$0;
    if (i == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localObject1 = ((LuanInjector.ProviderObjectCreator)localObject2).create(localLuanInjector, localObject1, bool1);
      break;
    }
  }
  
  abstract Object getFromCache(K paramK);
  
  abstract ProvideMethod getProvideMethod(K paramK);
  
  abstract Class<?> getType(K paramK);
  
  abstract void putToCache(K paramK, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.ObjectGetter
 * JD-Core Version:    0.7.0.1
 */