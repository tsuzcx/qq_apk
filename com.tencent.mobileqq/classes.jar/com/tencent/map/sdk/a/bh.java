package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bh
{
  public int a;
  public String b;
  public int c;
  public byte[] d;
  private Map<String, String> e;
  
  public bh(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = 0;
  }
  
  public final String a(String paramString)
  {
    if ((this.e != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = (String)this.e.get(paramString.toLowerCase());
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.e = new HashMap();
    if (paramMap.size() > 0)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.e.put(str.toLowerCase(), paramMap.get(str));
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("errorCode:").append(this.a).append(",errorInfo:").append(this.b).append(",httpStatus:").append(this.c).append(",headers:").append(this.e).append(",body:");
    if (this.d != null) {}
    for (Object localObject = Integer.valueOf(this.d.length);; localObject = "null") {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bh
 * JD-Core Version:    0.7.0.1
 */