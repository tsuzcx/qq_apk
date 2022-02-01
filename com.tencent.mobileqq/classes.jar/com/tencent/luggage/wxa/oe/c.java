package com.tencent.luggage.wxa.oe;

import com.tencent.luggage.util.g;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.iu.h;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private final b.a a;
  private final h b;
  private final int c;
  
  public c(h paramh)
  {
    this.b = paramh;
    this.c = -1;
    this.a = null;
  }
  
  public c(h paramh, int paramInt, b.a parama)
  {
    this.a = parama;
    this.b = paramh;
    this.c = paramInt;
  }
  
  private String a(String paramString)
  {
    b.a locala = this.a;
    if (locala == null) {
      return paramString;
    }
    locala.a(this.c, paramString);
    return null;
  }
  
  private static String b(Map<String, Object> paramMap)
  {
    g.a(paramMap);
    return new i(paramMap).toString();
  }
  
  public h a()
  {
    return this.b;
  }
  
  public String a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public String a(int paramInt, Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("ret", Integer.valueOf(paramInt));
    return a(b((Map)localObject));
  }
  
  public String a(Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("ret", Integer.valueOf(0));
    return a(b((Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oe.c
 * JD-Core Version:    0.7.0.1
 */