package com.tencent.map.sdk.a;

import android.os.Handler;
import java.util.Map;

public final class ag
{
  private static Handler a = ;
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    boolean bool = as.a(1);
    if (bool) {
      a.post(new ah(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
    }
    return bool;
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    a.post(new ai(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ag
 * JD-Core Version:    0.7.0.1
 */