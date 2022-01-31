package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import bhvy;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rpr;
import rpu;
import rpv;
import rpw;
import rqj;

public class TemplateFactoryCache
  extends QQHashMap<String, rpw>
{
  private volatile rpu mStyleConfigHelper = new rpu();
  
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
    if (!bhvy.o()) {
      clear();
    }
  }
  
  public rpw get(String paramString)
  {
    try
    {
      paramString = (rpw)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rpr getAutoCreate(Context paramContext, String paramString)
  {
    rpw localrpw = get(paramString);
    if ((localrpw != null) && (localrpw.a != null))
    {
      paramContext = rqj.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
      if ((paramContext != null) && (localrpw.a.a().equals(paramContext.a())) && (localrpw.a.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localrpw.a;
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
  
  public rpw put(String paramString, rpw paramrpw)
  {
    try
    {
      paramString = (rpw)super.put(paramString, paramrpw);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rpw remove(String paramString)
  {
    try
    {
      paramString = (rpw)super.remove(paramString);
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
    rpu localrpu = new rpu();
    Object localObject2 = ((rpu)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((rpv)localEntry.getValue()).equals(localrpu.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localrpu);
    this.mStyleConfigHelper = localrpu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */