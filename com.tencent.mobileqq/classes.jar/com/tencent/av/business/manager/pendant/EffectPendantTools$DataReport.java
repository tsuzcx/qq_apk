package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class EffectPendantTools$DataReport
{
  static long a = 0L;
  static String b;
  private static String c = "actAVFunChatDecorate";
  
  public static void a(String paramString, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.d(2))
    {
      paramVideoAppInterface = (PendantItem)((EffectPendantTools)paramVideoAppInterface.c(2)).c();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
        a(paramString, null);
      }
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    if (!Utils.a(paramString2, b))
    {
      if (!TextUtils.isEmpty(b))
      {
        long l2 = a;
        if (l2 != 0L) {
          a(paramString1, b, (l1 - l2) / 1000L);
        }
      }
      b = paramString2;
      a = l1;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      long l = (System.currentTimeMillis() - paramLong) / 1000L;
      Object localObject = new HashMap();
      ((Map)localObject).put("tempID", paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("");
      ((Map)localObject).put("duration", localStringBuilder.toString());
      UserAction.onUserAction(c, true, -1L, -1L, (Map)localObject, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateReport, ID: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("  pendant time: ");
      ((StringBuilder)localObject).append(paramLong);
      AVLog.printColorLog(paramString1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport
 * JD-Core Version:    0.7.0.1
 */