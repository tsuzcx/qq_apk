package c.t.m.g;

import android.os.Handler;
import java.util.Map;

public final class q
{
  private static Handler a = ;
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    boolean bool = x.a.a(1);
    if (bool) {
      a.post(new r(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
    }
    return bool;
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    a.post(new s(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.q
 * JD-Core Version:    0.7.0.1
 */