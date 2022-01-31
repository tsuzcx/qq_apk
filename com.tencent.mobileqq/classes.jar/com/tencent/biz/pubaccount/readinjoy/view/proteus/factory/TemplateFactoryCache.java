package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import bkbq;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sfq;
import sft;
import sfu;
import sfv;
import sgi;

public class TemplateFactoryCache
  extends QQHashMap<String, sfv>
{
  private volatile sft mStyleConfigHelper = new sft();
  
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
    if (!bkbq.p()) {
      clear();
    }
  }
  
  public sfv get(String paramString)
  {
    try
    {
      paramString = (sfv)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public sfq getAutoCreate(Context paramContext, String paramString)
  {
    sfv localsfv = get(paramString);
    if ((localsfv != null) && (localsfv.a != null))
    {
      paramContext = sgi.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
      if ((paramContext != null) && (localsfv.a.a().equals(paramContext.a())) && (localsfv.a.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localsfv.a;
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
  
  public sfv put(String paramString, sfv paramsfv)
  {
    try
    {
      paramString = (sfv)super.put(paramString, paramsfv);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public sfv remove(String paramString)
  {
    try
    {
      paramString = (sfv)super.remove(paramString);
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
    sft localsft = new sft();
    Object localObject2 = ((sft)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((sfu)localEntry.getValue()).equals(localsft.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localsft);
    this.mStyleConfigHelper = localsft;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */