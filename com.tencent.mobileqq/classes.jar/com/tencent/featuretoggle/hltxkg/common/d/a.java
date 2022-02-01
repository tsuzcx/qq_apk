package com.tencent.featuretoggle.hltxkg.common.d;

import com.tencent.featuretoggle.hltxkg.common.e.c;
import java.util.Map;

public final class a
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    com.tencent.featuretoggle.hltxkg.common.a.b.a.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean, 1);
  }
  
  public static boolean a(String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (paramInt == com.tencent.featuretoggle.hltxkg.common.a.c())
    {
      if ((a) && (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString))))
      {
        a = false;
        return true;
      }
      if ((b) && ("HLHttpDirect".equals(paramString)))
      {
        paramString = (String)paramMap.get("B15");
        if ((!c.a(paramString)) && (paramString.equals("app")))
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
    com.tencent.featuretoggle.hltxkg.common.a.b.a.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.d.a
 * JD-Core Version:    0.7.0.1
 */