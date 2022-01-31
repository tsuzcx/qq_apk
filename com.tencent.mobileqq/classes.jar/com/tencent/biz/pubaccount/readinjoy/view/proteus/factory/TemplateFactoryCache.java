package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import bhvh;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rpu;
import rpx;
import rpy;
import rpz;
import rqm;

public class TemplateFactoryCache
  extends QQHashMap<String, rpz>
{
  private volatile rpx mStyleConfigHelper = new rpx();
  
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
    if (!bhvh.o()) {
      clear();
    }
  }
  
  public rpz get(String paramString)
  {
    try
    {
      paramString = (rpz)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rpu getAutoCreate(Context paramContext, String paramString)
  {
    rpz localrpz = get(paramString);
    if ((localrpz != null) && (localrpz.a != null))
    {
      paramContext = rqm.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
      if ((paramContext != null) && (localrpz.a.a().equals(paramContext.a())) && (localrpz.a.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localrpz.a;
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
  
  public rpz put(String paramString, rpz paramrpz)
  {
    try
    {
      paramString = (rpz)super.put(paramString, paramrpz);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rpz remove(String paramString)
  {
    try
    {
      paramString = (rpz)super.remove(paramString);
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
    rpx localrpx = new rpx();
    Object localObject2 = ((rpx)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((rpy)localEntry.getValue()).equals(localrpx.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localrpx);
    this.mStyleConfigHelper = localrpx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */