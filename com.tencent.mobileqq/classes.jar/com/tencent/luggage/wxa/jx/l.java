package com.tencent.luggage.wxa.jx;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;

public class l
{
  private volatile d a;
  
  public l(d paramd)
  {
    this.a = paramd;
  }
  
  private int[] a(String paramString)
  {
    int i = 0;
    localObject2 = new int[0];
    Object localObject1 = localObject2;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      localObject1 = localObject2;
      paramString = new int[localJSONArray.length()];
      for (;;)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        paramString[i] = localJSONArray.getInt(i);
        i += 1;
      }
      return localObject2;
    }
    catch (Exception paramString)
    {
      o.b("MicroMsg.AppBrandJSInterface", paramString.getMessage());
      localObject2 = localObject1;
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      d locald = this.a;
      if (locald == null) {
        return "";
      }
      paramString1 = locald.b(paramString1, paramString2, paramInt);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      o.a("MicroMsg.AppBrandJSInterface", paramString1, "invokeHandler", new Object[0]);
      throw paramString1;
    }
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      d locald = this.a;
      if (locald == null) {
        return;
      }
      locald.a(paramString1, paramString2, a(paramString3));
      return;
    }
    catch (Exception paramString1)
    {
      o.a("MicroMsg.AppBrandJSInterface", paramString1, "publishHandler", new Object[0]);
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.l
 * JD-Core Version:    0.7.0.1
 */