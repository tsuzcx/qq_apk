package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.content.Context;
import bgmq;
import com.tencent.commonsdk.cache.QQHashMap;
import rdt;
import rdw;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, rdw>
{
  public RealTimeTemplateFactoryCache()
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
  
  public rdw get(String paramString)
  {
    try
    {
      paramString = (rdw)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rdw getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = rdt.a(paramString);
    if (paramContext != null)
    {
      paramContext.b(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public rdw put(String paramString, rdw paramrdw)
  {
    try
    {
      paramString = (rdw)super.put(paramString, paramrdw);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rdw remove(String paramString)
  {
    try
    {
      paramString = (rdw)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */