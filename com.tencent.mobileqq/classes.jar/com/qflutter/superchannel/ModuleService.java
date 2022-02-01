package com.qflutter.superchannel;

import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class ModuleService
{
  static final String TAG = "SuperChannelModuleService";
  private Map<String, IModule> moduleClazzImplMap = new ConcurrentHashMap();
  private Map<String, Class<? extends IModule>> moduleClazzMap = new ConcurrentHashMap();
  private Map<String, Stack<IModule>> moduleStackMap = new ConcurrentHashMap();
  
  private IModule createModuleClassImpl(Class<? extends IModule> paramClass)
  {
    try
    {
      paramClass = (IModule)paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      SuperChannelLog.e("SuperChannelModuleService", "[createModuleClassImpl]", paramClass);
    }
    return null;
  }
  
  private Stack<IModule> ensureModuleStack(String paramString)
  {
    Stack localStack2 = (Stack)this.moduleStackMap.get(paramString);
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      this.moduleStackMap.put(paramString, localStack1);
    }
    return localStack1;
  }
  
  static ModuleService getInstance()
  {
    return ModuleService.SingleHolder.INSTANCE;
  }
  
  private IModule getModuleFromClass(String paramString)
  {
    IModule localIModule = (IModule)this.moduleClazzImplMap.get(paramString);
    Object localObject = localIModule;
    if (localIModule == null) {
      localObject = createModuleClassImpl((Class)this.moduleClazzMap.get(paramString));
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getModuleFromClass] can not create module ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'s instances");
      SuperChannelLog.w("SuperChannelModuleService", ((StringBuilder)localObject).toString());
      return null;
    }
    this.moduleClazzImplMap.put(paramString, localObject);
    return localObject;
  }
  
  private IModule getModuleFromStack(String paramString)
  {
    paramString = (Stack)this.moduleStackMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = (IModule)paramString.peek();
      if (SuperChannelLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getModule]  module is ");
        localStringBuilder.append(paramString.getClass().getName());
        localStringBuilder.append(", hashCode=");
        localStringBuilder.append(paramString.hashCode());
        SuperChannelLog.d("SuperChannelModuleService", localStringBuilder.toString());
      }
      return paramString;
    }
    return null;
  }
  
  private boolean isTextEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  IModule getModule(String paramString)
  {
    if (isTextEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getModule] invalid parameter, moduleName=");
      ((StringBuilder)localObject).append(paramString);
      SuperChannelLog.w("SuperChannelModuleService", ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = getModuleFromStack(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = getModuleFromClass(paramString);
    if (localObject == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getModule] moduleName ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" not registered, please call registerModule() or registerModuleClass() first");
      SuperChannelLog.w("SuperChannelModuleService", localStringBuilder.toString());
    }
    return localObject;
  }
  
  void registerModule(String paramString, IModule paramIModule)
  {
    if ((!isTextEmpty(paramString)) && (paramIModule != null))
    {
      if (SuperChannelLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[registerModule] moduleName=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", hashCode=");
        ((StringBuilder)localObject).append(paramIModule.hashCode());
        SuperChannelLog.d("SuperChannelModuleService", ((StringBuilder)localObject).toString());
      }
      localObject = ensureModuleStack(paramString);
      ((Stack)localObject).push(paramIModule);
      if (SuperChannelLog.isColorLevel())
      {
        paramIModule = new StringBuilder();
        paramIModule.append("[registerModule] ");
        paramIModule.append(paramString);
        paramIModule.append(" has ");
        paramIModule.append(((Stack)localObject).size());
        paramIModule.append(" instances");
        SuperChannelLog.d("SuperChannelModuleService", paramIModule.toString());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[registerModule] invalid parametersmoduleName=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", moduleImpl=");
    ((StringBuilder)localObject).append(paramIModule);
    SuperChannelLog.w("SuperChannelModuleService", ((StringBuilder)localObject).toString());
  }
  
  void registerModuleClass(String paramString, Class<? extends IModule> paramClass)
  {
    if ((!isTextEmpty(paramString)) && (paramClass != null))
    {
      if (SuperChannelLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[registerModuleClass]  moduleName=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", clazz=");
        localStringBuilder.append(paramClass.getName());
        SuperChannelLog.d("SuperChannelModuleService", localStringBuilder.toString());
      }
      if (this.moduleClazzMap.containsKey(paramString))
      {
        paramClass = new StringBuilder();
        paramClass.append("[registerModuleClass] module ");
        paramClass.append(paramString);
        paramClass.append(" already registered,  please call unregisterModuleClass() to remove it first");
        SuperChannelLog.w("SuperChannelModuleService", paramClass.toString());
        return;
      }
      this.moduleClazzMap.put(paramString, paramClass);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[registerModuleClass] invalid parameters, moduleName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", clazz=");
    localStringBuilder.append(paramClass);
    SuperChannelLog.w("SuperChannelModuleService", localStringBuilder.toString());
  }
  
  void unregisterModule(String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (isTextEmpty(paramString))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[registerModuleClass] invalid parameters, moduleName=");
      localObject1 = paramString;
      paramString = (String)localObject2;
      paramString.append((String)localObject1);
    }
    for (paramString = paramString.toString();; paramString = paramString.toString())
    {
      SuperChannelLog.w("SuperChannelModuleService", paramString);
      return;
      if (SuperChannelLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[unregisterModule] moduleName=");
        ((StringBuilder)localObject1).append(paramString);
        SuperChannelLog.d("SuperChannelModuleService", ((StringBuilder)localObject1).toString());
      }
      if (!this.moduleStackMap.containsKey(paramString))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[unregisterModule] moduleName ");
        ((StringBuilder)localObject1).append(paramString);
        localObject2 = " not registered";
        paramString = (String)localObject1;
        localObject1 = localObject2;
        break;
      }
      localObject1 = (Stack)this.moduleStackMap.get(paramString);
      if ((localObject1 != null) && (!((Stack)localObject1).isEmpty()))
      {
        localObject2 = (IModule)((Stack)localObject1).pop();
        if (SuperChannelLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[unregisterModule] , unregister module hashCode=");
          localStringBuilder.append(localObject2.hashCode());
          localStringBuilder.append(paramString);
          localStringBuilder.append(" has ");
          localStringBuilder.append(((Stack)localObject1).size());
          localStringBuilder.append(" instances");
          SuperChannelLog.d("SuperChannelModuleService", localStringBuilder.toString());
        }
        if (((Stack)localObject1).isEmpty()) {
          this.moduleStackMap.remove(paramString);
        }
        return;
      }
      paramString = new StringBuilder();
      paramString.append("[unregisterModule] invalid module stack, ");
      paramString.append(localObject1);
    }
  }
  
  void unregisterModuleClass(String paramString)
  {
    StringBuilder localStringBuilder;
    if (isTextEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[registerModuleClass] invalid parameters, moduleName=");
      localStringBuilder.append(paramString);
      SuperChannelLog.w("SuperChannelModuleService", localStringBuilder.toString());
      return;
    }
    if (SuperChannelLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[unregisterModuleClass]  moduleName=");
      localStringBuilder.append(paramString);
      SuperChannelLog.d("SuperChannelModuleService", localStringBuilder.toString());
    }
    this.moduleClazzMap.remove(paramString);
    this.moduleClazzImplMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.superchannel.ModuleService
 * JD-Core Version:    0.7.0.1
 */