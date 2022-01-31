package com.tencent.luan.ioc;

class LuanInjector$ProviderObjectCreator
  extends LuanInjector.ObjectCreator<ProvideMethod, LuanInjector.ProvideMethodKey>
{
  private LuanInjector$ProviderObjectCreator()
  {
    super(null);
  }
  
  Object createByInput(LuanInjector paramLuanInjector, ProvideMethod paramProvideMethod)
  {
    return paramProvideMethod.provide(paramLuanInjector);
  }
  
  LuanInjector.ProvideMethodKey getKey(ProvideMethod paramProvideMethod)
  {
    return new LuanInjector.ProvideMethodKey(paramProvideMethod, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.ProviderObjectCreator
 * JD-Core Version:    0.7.0.1
 */