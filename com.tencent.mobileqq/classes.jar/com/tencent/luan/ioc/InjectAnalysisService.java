package com.tencent.luan.ioc;

import java.util.List;

public abstract interface InjectAnalysisService
{
  public abstract InjectConstructor<?> getInjectConstructor(Class<?> paramClass);
  
  public abstract List<InjectMethod> getInjectMethods(Class<?> paramClass);
  
  public abstract List<ProvideMethod> getProvideMethods(Class<?> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.InjectAnalysisService
 * JD-Core Version:    0.7.0.1
 */