package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.content.Context;
import bjxj;
import com.tencent.commonsdk.cache.QQHashMap;
import sgc;
import sgf;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, sgf>
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
    if (!bjxj.p()) {
      clear();
    }
  }
  
  public sgf get(String paramString)
  {
    try
    {
      paramString = (sgf)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public sgf getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = sgc.a(paramString);
    if (paramContext != null)
    {
      paramContext.b(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public sgf put(String paramString, sgf paramsgf)
  {
    try
    {
      paramString = (sgf)super.put(paramString, paramsgf);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public sgf remove(String paramString)
  {
    try
    {
      paramString = (sgf)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */