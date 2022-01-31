package com.tencent.luan.ioc.index;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.ProvideMethod;
import java.util.List;

public abstract interface IndexInjectInfoService
{
  public abstract List<ProvideMethod> getAllDeclareProvideMethods(Class<?> paramClass);
  
  public abstract InjectMethod getAllInjectMethods(Class<?> paramClass);
  
  public abstract InjectConstructor<?> getDeclareInjectConstructor(Class<?> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.index.IndexInjectInfoService
 * JD-Core Version:    0.7.0.1
 */