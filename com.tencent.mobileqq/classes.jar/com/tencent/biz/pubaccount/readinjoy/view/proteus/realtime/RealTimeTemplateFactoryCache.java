package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.content.Context;
import bmhv;
import com.tencent.commonsdk.cache.QQHashMap;
import tmt;
import tmw;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, tmw>
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
    if (!bmhv.s()) {
      clear();
    }
  }
  
  public tmw get(String paramString)
  {
    try
    {
      paramString = (tmw)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public tmw getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = tmt.a(paramString);
    if (paramContext != null)
    {
      paramContext.b(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public tmw put(String paramString, tmw paramtmw)
  {
    try
    {
      paramString = (tmw)super.put(paramString, paramtmw);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public tmw remove(String paramString)
  {
    try
    {
      paramString = (tmw)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */