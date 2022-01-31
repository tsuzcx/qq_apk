package com.tencent.luan.ioc;

import java.util.Map;

class LuanInjector$ProviderAndNamedTypeSnapshot
{
  private final Map<String, ProvideMethod> nameProvideMethodMap;
  private final Map<String, Class<?>> namedClassMap;
  private final Map<Class<?>, ProvideMethod> typeProvideMethodMap;
  
  LuanInjector$ProviderAndNamedTypeSnapshot(Map<Class<?>, ProvideMethod> paramMap, Map<String, ProvideMethod> paramMap1, Map<String, Class<?>> paramMap2)
  {
    this.typeProvideMethodMap = paramMap;
    this.nameProvideMethodMap = paramMap1;
    this.namedClassMap = paramMap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.ProviderAndNamedTypeSnapshot
 * JD-Core Version:    0.7.0.1
 */