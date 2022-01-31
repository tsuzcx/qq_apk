package c.t.m.g;

import android.os.Handler;
import java.util.Map;

public final class cd
{
  private static Handler a = ;
  private static boolean b = true;
  private static boolean c = true;
  
  private static int a(String paramString, int paramInt)
  {
    int j = 1;
    if (paramString.equals("HLDisconnEvent")) {
      return 0;
    }
    int i;
    if (paramInt != 0)
    {
      if ((paramInt == -4) || (paramInt == -3) || (paramInt == -288))
      {
        i = 1;
        if (i == 0) {
          break label95;
        }
      }
    }
    else
    {
      paramString = "self_report_succ_denominator_value";
      label45:
      if (paramInt != 0)
      {
        i = j;
        if (paramInt != -4)
        {
          i = j;
          if (paramInt != -3)
          {
            if (paramInt != -288) {
              break label101;
            }
            i = j;
          }
        }
        label74:
        if (i == 0) {
          break label106;
        }
      }
    }
    label95:
    label101:
    label106:
    for (paramInt = 100;; paramInt = 2)
    {
      return v.a(paramString, 0, 2147483647, paramInt);
      i = 0;
      break;
      paramString = "self_report_fail_denominator_value";
      break label45;
      i = 0;
      break label74;
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    a.post(new ce(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
  {
    a.post(new cf(paramString1, paramInt1, paramInt2, paramString2, paramMap1, paramMap2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cd
 * JD-Core Version:    0.7.0.1
 */