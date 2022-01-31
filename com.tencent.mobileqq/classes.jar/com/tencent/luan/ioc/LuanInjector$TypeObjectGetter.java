package com.tencent.luan.ioc;

import java.util.List;
import java.util.Map;

class LuanInjector$TypeObjectGetter
  extends LuanInjector.ObjectGetter<Class<?>>
{
  private LuanInjector$TypeObjectGetter(LuanInjector paramLuanInjector)
  {
    super(paramLuanInjector, null);
  }
  
  Object getFromCache(Class<?> paramClass)
  {
    List localList = (List)LuanInjector.access$1100(this.this$0).get(paramClass);
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    if (localList.size() > 1) {
      throw new InjectException("failed to inference inject type such as more than one types " + paramClass.getName());
    }
    return localList.get(0);
  }
  
  ProvideMethod getProvideMethod(Class<?> paramClass)
  {
    return (ProvideMethod)LuanInjector.ProviderAndNamedTypeSnapshot.access$1300(LuanInjector.access$1200(this.this$0)).get(paramClass);
  }
  
  Class<?> getType(Class<?> paramClass)
  {
    return paramClass;
  }
  
  void putToCache(Class<?> paramClass, Object paramObject)
  {
    LuanInjector.access$1400(this.this$0, paramObject, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.TypeObjectGetter
 * JD-Core Version:    0.7.0.1
 */