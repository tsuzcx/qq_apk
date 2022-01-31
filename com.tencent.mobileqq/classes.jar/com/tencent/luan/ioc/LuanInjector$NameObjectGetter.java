package com.tencent.luan.ioc;

import java.util.Map;

class LuanInjector$NameObjectGetter
  extends LuanInjector.ObjectGetter<String>
{
  private LuanInjector$NameObjectGetter(LuanInjector paramLuanInjector)
  {
    super(paramLuanInjector, null);
  }
  
  Object getFromCache(String paramString)
  {
    return LuanInjector.access$1500(this.this$0).get(paramString);
  }
  
  ProvideMethod getProvideMethod(String paramString)
  {
    return (ProvideMethod)LuanInjector.ProviderAndNamedTypeSnapshot.access$1600(LuanInjector.access$1200(this.this$0)).get(paramString);
  }
  
  Class<?> getType(String paramString)
  {
    Class localClass = (Class)LuanInjector.ProviderAndNamedTypeSnapshot.access$1700(LuanInjector.access$1200(this.this$0)).get(paramString);
    if (localClass == null) {
      throw new InjectException("no class or provider mapping to this name " + paramString);
    }
    return localClass;
  }
  
  void putToCache(String paramString, Object paramObject)
  {
    LuanInjector.access$1500(this.this$0).put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.NameObjectGetter
 * JD-Core Version:    0.7.0.1
 */