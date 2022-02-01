package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.content.Context;
import bnrf;
import com.tencent.commonsdk.cache.QQHashMap;
import svl;
import svo;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, svo>
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
    if (!bnrf.o()) {
      clear();
    }
  }
  
  public svo get(String paramString)
  {
    try
    {
      paramString = (svo)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public svo getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = svl.a(paramString);
    if (paramContext != null)
    {
      paramContext.b(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public svo put(String paramString, svo paramsvo)
  {
    try
    {
      paramString = (svo)super.put(paramString, paramsvo);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public svo remove(String paramString)
  {
    try
    {
      paramString = (svo)super.remove(paramString);
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