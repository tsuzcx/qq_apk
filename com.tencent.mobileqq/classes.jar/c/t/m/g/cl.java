package c.t.m.g;

import java.util.Map;

public final class cl
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    q.a(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
  }
  
  public static boolean a(String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (paramInt == m.c())
    {
      if ((a) && (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString))))
      {
        a = false;
        return true;
      }
      if ((b) && ("HLHttpDirect".equals(paramString)))
      {
        paramString = (String)paramMap.get("B15");
        if ((!cn.a(paramString)) && (paramString.equals("app")))
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
    q.b(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cl
 * JD-Core Version:    0.7.0.1
 */