package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import bnrf;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import suz;
import svc;
import svd;
import sve;
import svr;

public class TemplateFactoryCache
  extends QQHashMap<String, sve>
{
  private volatile svc mStyleConfigHelper = new svc();
  
  public TemplateFactoryCache()
  {
    super(2018, 10, 230000);
  }
  
  public void clear()
  {
    try
    {
      super.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearMemory()
  {
    if (!bnrf.o()) {
      clear();
    }
  }
  
  public sve get(String paramString)
  {
    try
    {
      paramString = (sve)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public suz getAutoCreate(Context paramContext, String paramString)
  {
    sve localsve = get(paramString);
    if ((localsve != null) && (localsve.a != null))
    {
      paramContext = svr.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
      if ((paramContext != null) && (localsve.a.a().equals(paramContext.a())) && (localsve.a.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localsve.a;
    }
    paramContext = this.mStyleConfigHelper.a(paramContext, paramString);
    if ((paramContext != null) && (paramContext.a != null))
    {
      paramContext.a.b(paramString);
      put(paramString, paramContext);
      return paramContext.a;
    }
    return null;
  }
  
  public sve put(String paramString, sve paramsve)
  {
    try
    {
      paramString = (sve)super.put(paramString, paramsve);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public sve remove(String paramString)
  {
    try
    {
      paramString = (sve)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reset()
  {
    Object localObject1 = this.mStyleConfigHelper;
    svc localsvc = new svc();
    Object localObject2 = ((svc)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((svd)localEntry.getValue()).equals(localsvc.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localsvc);
    this.mStyleConfigHelper = localsvc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */