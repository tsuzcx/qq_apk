package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import bgmq;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rdg;
import rdj;
import rdk;
import rdl;
import rdz;

public class TemplateFactoryCache
  extends QQHashMap<String, rdl>
{
  private volatile rdj mStyleConfigHelper = new rdj();
  
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
    if (!bgmq.p()) {
      clear();
    }
  }
  
  public rdl get(String paramString)
  {
    try
    {
      paramString = (rdl)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rdg getAutoCreate(Context paramContext, String paramString)
  {
    rdl localrdl = get(paramString);
    if ((localrdl != null) && (localrdl.a != null))
    {
      paramContext = rdz.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
      if ((paramContext != null) && (localrdl.a.a().equals(paramContext.a())) && (localrdl.a.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localrdl.a;
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
  
  public rdl put(String paramString, rdl paramrdl)
  {
    try
    {
      paramString = (rdl)super.put(paramString, paramrdl);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rdl remove(String paramString)
  {
    try
    {
      paramString = (rdl)super.remove(paramString);
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
    rdj localrdj = new rdj();
    Object localObject2 = ((rdj)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((rdk)localEntry.getValue()).equals(localrdj.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localrdj);
    this.mStyleConfigHelper = localrdj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */