package com.tencent.map.sdk.a;

import java.util.Map;

public final class dd
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    ag.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
  }
  
  public static boolean a(String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (paramInt == ac.c())
    {
      if ((a) && (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString))))
      {
        a = false;
        return true;
      }
      if ((b) && ("HLHttpDirect".equals(paramString)))
      {
        paramString = (String)paramMap.get("B15");
        if ((!dg.a(paramString)) && (paramString.equals("app")))
        {
          b = false;
          return true;
        }
      }
    }
    return false;
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    ag.b(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.dd
 * JD-Core Version:    0.7.0.1
 */