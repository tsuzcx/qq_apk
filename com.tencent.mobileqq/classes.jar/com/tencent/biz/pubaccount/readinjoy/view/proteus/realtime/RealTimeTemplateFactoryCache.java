package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.content.Context;
import bhvy;
import com.tencent.commonsdk.cache.QQHashMap;
import rqd;
import rqg;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, rqg>
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
    if (!bhvy.o()) {
      clear();
    }
  }
  
  public rqg get(String paramString)
  {
    try
    {
      paramString = (rqg)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rqg getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = rqd.a(paramString);
    if (paramContext != null)
    {
      paramContext.b(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public rqg put(String paramString, rqg paramrqg)
  {
    try
    {
      paramString = (rqg)super.put(paramString, paramrqg);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public rqg remove(String paramString)
  {
    try
    {
      paramString = (rqg)super.remove(paramString);
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