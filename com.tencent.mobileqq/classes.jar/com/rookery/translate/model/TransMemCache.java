package com.rookery.translate.model;

import android.support.v4.util.LruCache;

public class TransMemCache
  implements ICache<String>
{
  LruCache<String, String> a;
  private int b;
  
  public TransMemCache(int paramInt)
  {
    this.b = paramInt;
    a();
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.a.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a()
  {
    this.a = new TransMemCache.1(this, this.b);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (this.a.get(paramString1) == null)
      {
        this.a.put(paramString1, paramString2);
      }
      else
      {
        this.a.remove(paramString1);
        this.a.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("tween");
    a(localStringBuilder.toString(), paramBoolean.toString());
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("tween");
    paramString1 = a(localStringBuilder.toString());
    if (paramString1 == null) {
      return false;
    }
    return Boolean.valueOf(paramString1).booleanValue();
  }
  
  public void b(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("HasChangeToOriginalText");
    a(localStringBuilder.toString(), paramBoolean.toString());
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("HasChangeToOriginalText");
    paramString1 = a(localStringBuilder.toString());
    if (paramString1 == null) {
      return false;
    }
    return Boolean.valueOf(paramString1).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.TransMemCache
 * JD-Core Version:    0.7.0.1
 */