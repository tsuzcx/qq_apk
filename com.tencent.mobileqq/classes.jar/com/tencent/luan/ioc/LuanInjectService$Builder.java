package com.tencent.luan.ioc;

import com.tencent.luan.core.LuanLog;
import com.tencent.luan.core.Utility;
import com.tencent.luan.ioc.index.IndexInjectAnalysisService;
import com.tencent.luan.ioc.index.IndexInjectInfoService;
import com.tencent.luan.ioc.reflect.ReflectInjectAnalysisService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LuanInjectService$Builder
{
  private boolean debugMode = false;
  private List<IndexInjectInfoService> indexInjectInfoServices = new LinkedList();
  private ClassLoader loader = null;
  private Map<String, Class<?>> nameTypeMap = new HashMap();
  private Set<Class<?>> providerTypes = new LinkedHashSet();
  private boolean reflectValid = true;
  
  public LuanInjectService$Builder() {}
  
  public LuanInjectService$Builder(LuanInjectService paramLuanInjectService)
  {
    Utility.makeSureNotNull(paramLuanInjectService, "injectService");
    this.loader = LuanInjectService.access$600(paramLuanInjectService).getLoader();
    this.debugMode = LuanInjectService.access$700(paramLuanInjectService);
    this.reflectValid = LuanInjectService.access$600(paramLuanInjectService).isValid();
    this.indexInjectInfoServices.addAll(LuanInjectService.access$800(paramLuanInjectService).getIndexInfos());
    this.nameTypeMap.putAll(LuanInjectService.access$900(paramLuanInjectService));
    this.providerTypes.addAll(LuanInjectService.access$1000(paramLuanInjectService));
  }
  
  public Builder addIndexInfo(IndexInjectInfoService paramIndexInjectInfoService)
  {
    Utility.makeSureNotNull(paramIndexInjectInfoService, "indexInfo");
    this.indexInjectInfoServices.add(paramIndexInjectInfoService);
    return this;
  }
  
  public Builder addIndexInfos(Iterable<IndexInjectInfoService> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      addIndexInfo((IndexInjectInfoService)paramIterable.next());
    }
    return this;
  }
  
  public Builder addNamedType(Class<?> paramClass)
  {
    Utility.makeSureNotNull(paramClass, "namedType");
    Object localObject = LuanInjectService.access$1100(paramClass);
    if (((String)localObject).isEmpty())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addNamedType: this class ");
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(" is not named or named empty string, ignored");
      LuanLog.d("LuanInjectService", ((StringBuilder)localObject).toString());
      return this;
    }
    Class localClass = (Class)this.nameTypeMap.put(localObject, paramClass);
    if (localClass != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addNamedType: ");
      localStringBuilder.append(localClass.getName());
      localStringBuilder.append(" with the name of ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" is override by ");
      localStringBuilder.append(paramClass.getName());
      LuanLog.d("LuanInjectService", localStringBuilder.toString());
    }
    return this;
  }
  
  public Builder addNamedTypes(Iterable<Class<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      addNamedType((Class)paramIterable.next());
    }
    return this;
  }
  
  public Builder addProviderType(Class<?> paramClass)
  {
    Utility.makeSureNotNull(paramClass, "providerType");
    this.providerTypes.add(paramClass);
    return this;
  }
  
  public Builder addProviderTypes(Iterable<Class<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      addProviderType((Class)paramIterable.next());
    }
    return this;
  }
  
  public LuanInjectService create()
  {
    return new LuanInjectService(this, null);
  }
  
  public Builder setClassLoader(ClassLoader paramClassLoader)
  {
    this.loader = paramClassLoader;
    return this;
  }
  
  public Builder setDebugMode(boolean paramBoolean)
  {
    this.debugMode = paramBoolean;
    return this;
  }
  
  public Builder setReflectValid(boolean paramBoolean)
  {
    this.reflectValid = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjectService.Builder
 * JD-Core Version:    0.7.0.1
 */