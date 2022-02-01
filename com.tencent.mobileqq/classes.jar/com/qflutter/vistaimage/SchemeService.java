package com.qflutter.vistaimage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SchemeService
{
  static String DEFAULT_SCHEME = "default";
  public static final String TAG = "VistaImage.SchemeService";
  private Map<String, IVistaImage> schemeClazzImplMap = new ConcurrentHashMap();
  private Map<String, Class<? extends IVistaImage>> schemeClazzMap = new ConcurrentHashMap();
  
  private IVistaImage createSchemeHandlerClassImpl(Class<? extends IVistaImage> paramClass)
  {
    try
    {
      paramClass = (IVistaImage)paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      VistaImageLog.e("VistaImage.SchemeService", "[createSchemeHandlerClassImpl]", paramClass);
    }
    return null;
  }
  
  public static SchemeService getInstance()
  {
    return SchemeService.SingleHolder.INSTANCE;
  }
  
  private IVistaImage getSchemeHandlerFromClass(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (isTextEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      localObject2 = "[getSchemeHandlerFromClass] invalid scheme, ";
      ((StringBuilder)localObject1).append((String)localObject2);
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(paramString);
      VistaImageLog.w("VistaImage.SchemeService", ((StringBuilder)localObject1).toString());
      return null;
      if (!this.schemeClazzMap.containsKey(paramString))
      {
        localObject1 = new StringBuilder();
        localObject2 = "[getSchemeHandlerFromClass] no registered scheme, ";
        break;
      }
      localObject2 = (IVistaImage)this.schemeClazzImplMap.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createSchemeHandlerClassImpl((Class)this.schemeClazzMap.get(paramString));
      }
      if (localObject1 != null) {
        break label138;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getSchemeHandlerFromClass] can not create scheme handler ");
      ((StringBuilder)localObject1).append(paramString);
      paramString = "'s instances";
    }
    label138:
    this.schemeClazzImplMap.put(paramString, localObject1);
    return localObject1;
  }
  
  private boolean isTextEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  void clear()
  {
    VistaImageLog.d("VistaImage.SchemeService", "[clear]");
    this.schemeClazzMap.clear();
    Iterator localIterator = this.schemeClazzImplMap.values().iterator();
    while (localIterator.hasNext())
    {
      IVistaImage localIVistaImage = (IVistaImage)localIterator.next();
      if (localIVistaImage != null) {
        localIVistaImage.clear();
      }
    }
    this.schemeClazzImplMap.clear();
  }
  
  IVistaImage getSchemeHandler(String paramString)
  {
    Object localObject = paramString;
    if (isTextEmpty(paramString))
    {
      VistaImageLog.d("VistaImage.SchemeService", "[getSchemeHandler] use default scheme when empty");
      localObject = DEFAULT_SCHEME;
    }
    localObject = getSchemeHandlerFromClass((String)localObject);
    paramString = (String)localObject;
    if (localObject == null)
    {
      VistaImageLog.d("VistaImage.SchemeService", "[getSchemeHandler] use default scheme when no handler");
      paramString = getSchemeHandlerFromClass(DEFAULT_SCHEME);
    }
    if (paramString == null) {
      VistaImageLog.w("VistaImage.SchemeService", "[getSchemeHandler] no handler found, please call registerScheme() first");
    }
    return paramString;
  }
  
  boolean registerScheme(String paramString, Class<? extends IVistaImage> paramClass)
  {
    StringBuilder localStringBuilder;
    if ((!isTextEmpty(paramString)) && (paramClass != null))
    {
      if (VistaImageLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[registerScheme]  scheme=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", clazz=");
        localStringBuilder.append(paramClass.getName());
        VistaImageLog.d("VistaImage.SchemeService", localStringBuilder.toString());
      }
      if (this.schemeClazzMap.containsKey(paramString))
      {
        paramClass = new StringBuilder();
        paramClass.append("[registerScheme] scheme [");
        paramClass.append(paramString);
        paramClass.append("] already registered at ");
        paramClass.append(((Class)this.schemeClazzMap.get(paramString)).getName());
        paramClass.append(", please call unregisterScheme() to remove it first");
      }
    }
    for (paramString = paramClass.toString();; paramString = localStringBuilder.toString())
    {
      VistaImageLog.w("VistaImage.SchemeService", paramString);
      return false;
      this.schemeClazzMap.put(paramString, paramClass);
      return true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[registerScheme] invalid parameters, scheme=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", clazz=");
      localStringBuilder.append(paramClass);
    }
  }
  
  void unregisterScheme(String paramString)
  {
    StringBuilder localStringBuilder;
    if (isTextEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[unregisterClass] invalid parameters, scheme=");
      localStringBuilder.append(paramString);
      VistaImageLog.w("VistaImage.SchemeService", localStringBuilder.toString());
      return;
    }
    if (VistaImageLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[unregisterClass]  scheme=");
      localStringBuilder.append(paramString);
      VistaImageLog.d("VistaImage.SchemeService", localStringBuilder.toString());
    }
    this.schemeClazzMap.remove(paramString);
    paramString = (IVistaImage)this.schemeClazzImplMap.remove(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.SchemeService
 * JD-Core Version:    0.7.0.1
 */