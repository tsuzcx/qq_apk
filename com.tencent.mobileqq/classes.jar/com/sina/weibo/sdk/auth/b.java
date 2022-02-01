package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private Map<String, WbAuthListener> i = new HashMap();
  
  public static b f()
  {
    try
    {
      b localb = b.a.g();
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final WbAuthListener a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      paramString = (WbAuthListener)this.i.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public final void a(String paramString, WbAuthListener paramWbAuthListener)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramWbAuthListener != null))
      {
        this.i.put(paramString, paramWbAuthListener);
        return;
      }
      return;
    }
    finally {}
  }
  
  public final void b(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.i.remove(paramString);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.b
 * JD-Core Version:    0.7.0.1
 */