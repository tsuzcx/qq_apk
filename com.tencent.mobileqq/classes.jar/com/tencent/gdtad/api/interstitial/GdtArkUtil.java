package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;

final class GdtArkUtil
{
  private static volatile boolean a = false;
  
  public static int a(int paramInt)
  {
    if (paramInt != -8)
    {
      if (paramInt != -7)
      {
        if (paramInt != -6)
        {
          if ((paramInt != -4) && (paramInt != -3))
          {
            if (paramInt != -2)
            {
              if (paramInt != -1) {
                if (paramInt != 0)
                {
                  if (paramInt != 5) {
                    return 1;
                  }
                }
                else {
                  return 0;
                }
              }
              return 1;
            }
            return 3;
          }
          return 1;
        }
        return 6;
      }
      return 13;
    }
    return 207;
  }
  
  public static void a()
  {
    GdtLog.b("GdtArkUtil", String.format("init %b", new Object[] { Boolean.valueOf(a) }));
    if (a) {
      return;
    }
    try
    {
      if (a) {
        return;
      }
      a = true;
      ArkMultiProcUtil.a(true);
      ArkMultiProcUtil.a();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkUtil
 * JD-Core Version:    0.7.0.1
 */