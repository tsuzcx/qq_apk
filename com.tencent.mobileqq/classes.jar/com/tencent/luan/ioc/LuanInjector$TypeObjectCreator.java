package com.tencent.luan.ioc;

class LuanInjector$TypeObjectCreator
  extends LuanInjector.ObjectCreator<Class<?>, Class<?>>
{
  private LuanInjector$TypeObjectCreator()
  {
    super(null);
  }
  
  Object createByInput(LuanInjector paramLuanInjector, Class<?> paramClass)
  {
    return LuanInjector.access$600(paramLuanInjector).getInjectConstructor(paramClass).newInstance(paramLuanInjector);
  }
  
  Class<?> getKey(Class<?> paramClass)
  {
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.TypeObjectCreator
 * JD-Core Version:    0.7.0.1
 */