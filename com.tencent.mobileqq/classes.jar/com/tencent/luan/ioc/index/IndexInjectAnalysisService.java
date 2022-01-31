package com.tencent.luan.ioc.index;

import com.tencent.luan.core.Utility;
import com.tencent.luan.ioc.InjectAnalysisService;
import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.ProvideMethod;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IndexInjectAnalysisService
  implements InjectAnalysisService
{
  private final List<IndexInjectInfoService> indexInfos;
  
  public IndexInjectAnalysisService(List<IndexInjectInfoService> paramList)
  {
    Utility.makeSureNotNull(paramList, "indexInfos");
    this.indexInfos = paramList;
  }
  
  public List<IndexInjectInfoService> getIndexInfos()
  {
    return new LinkedList(this.indexInfos);
  }
  
  public InjectConstructor<?> getInjectConstructor(Class<?> paramClass)
  {
    Object localObject = null;
    Iterator localIterator = this.indexInfos.iterator();
    while (localIterator.hasNext())
    {
      InjectConstructor localInjectConstructor = ((IndexInjectInfoService)localIterator.next()).getDeclareInjectConstructor(paramClass);
      localObject = localInjectConstructor;
      if (localInjectConstructor != null) {
        localObject = localInjectConstructor;
      }
    }
    return localObject;
  }
  
  public List<InjectMethod> getInjectMethods(Class<?> paramClass)
  {
    Iterator localIterator = this.indexInfos.iterator();
    while (localIterator.hasNext())
    {
      InjectMethod localInjectMethod = ((IndexInjectInfoService)localIterator.next()).getAllInjectMethods(paramClass);
      if (localInjectMethod != null) {
        return Collections.singletonList(localInjectMethod);
      }
    }
    return null;
  }
  
  public List<ProvideMethod<?>> getProvideMethods(Class<?> paramClass)
  {
    Iterator localIterator = this.indexInfos.iterator();
    while (localIterator.hasNext())
    {
      List localList = ((IndexInjectInfoService)localIterator.next()).getAllDeclareProvideMethods(paramClass);
      if (localList != null) {
        return Collections.unmodifiableList(localList);
      }
    }
    return null;
  }
  
  public boolean isValid()
  {
    return this.indexInfos.size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.ioc.index.IndexInjectAnalysisService
 * JD-Core Version:    0.7.0.1
 */