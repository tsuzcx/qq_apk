package com.tencent.featuretoggle.hltxkg.common.a.b;

import android.os.Handler;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import java.util.Map;

public final class a
{
  private static Handler a = ;
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    a.post(new c(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = i.a(1);
    if (bool) {
      a.post(new b(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean, 1));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.b.a
 * JD-Core Version:    0.7.0.1
 */