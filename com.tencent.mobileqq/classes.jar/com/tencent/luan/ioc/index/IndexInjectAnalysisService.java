package com.tencent.luan.ioc.index;

import com.tencent.luan.ioc.InjectAnalysisService;
import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.ProvideMethod;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IndexInjectAnalysisService
  implements InjectAnalysisService
{
  private List<IndexInjectInfoService> indexInfos = new CopyOnWriteArrayList();
  private volatile boolean isOpen = true;
  
  public void addIndexInfo(IndexInjectInfoService paramIndexInjectInfoService)
  {
    this.indexInfos.add(paramIndexInjectInfoService);
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
  
  public List<ProvideMethod> getProvideMethods(Class<?> paramClass)
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
    return (this.isOpen) && (this.indexInfos.size() > 0);
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.index.IndexInjectAnalysisService
 * JD-Core Version:    0.7.0.1
 */