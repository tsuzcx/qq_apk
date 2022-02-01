package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import bmqa;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import teh;
import tek;
import tel;
import tem;
import tez;

public class TemplateFactoryCache
  extends QQHashMap<String, tem>
{
  private volatile tek mStyleConfigHelper = new tek();
  
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
    if (!bmqa.o()) {
      clear();
    }
  }
  
  public tem get(String paramString)
  {
    try
    {
      paramString = (tem)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public teh getAutoCreate(Context paramContext, String paramString)
  {
    tem localtem = get(paramString);
    if ((localtem != null) && (localtem.a != null))
    {
      paramContext = tez.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
      if ((paramContext != null) && (localtem.a.a().equals(paramContext.a())) && (localtem.a.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localtem.a;
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
  
  public tem put(String paramString, tem paramtem)
  {
    try
    {
      paramString = (tem)super.put(paramString, paramtem);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public tem remove(String paramString)
  {
    try
    {
      paramString = (tem)super.remove(paramString);
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
    tek localtek = new tek();
    Object localObject2 = ((tek)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((tel)localEntry.getValue()).equals(localtek.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localtek);
    this.mStyleConfigHelper = localtek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */