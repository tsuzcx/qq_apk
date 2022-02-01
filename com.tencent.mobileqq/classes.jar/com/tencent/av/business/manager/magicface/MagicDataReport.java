package com.tencent.av.business.manager.magicface;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class MagicDataReport
{
  static long a = 0L;
  static String b = "";
  static String c = "";
  static String d = "";
  static String e = "";
  static int f;
  
  public static void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3) && (!TextUtils.isEmpty(b)))
    {
      long l = System.currentTimeMillis();
      a(b, (l - a) / 1000L, f);
      b = "";
      f = 0;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    g(paramString);
    if (!TextUtils.isEmpty(d)) {
      a("0X8008025", d);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if ((paramVideoAppInterface != null) && (paramString != null))
    {
      g(paramString);
      paramVideoAppInterface = (EffectSupportManager)paramVideoAppInterface.c(5);
      boolean bool = paramVideoAppInterface.a(3, "normal");
      if ((!paramVideoAppInterface.a(3, "interact")) && (!bool))
      {
        a("0X8008027", null);
        return;
      }
      a("0X8008026", null);
    }
  }
  
  public static void a(String paramString)
  {
    g(paramString);
    a("0X8008021", null);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3))
    {
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(b)) && (!paramString.equals(b)))
      {
        long l = System.currentTimeMillis();
        a(b, (l - a) / 1000L, f);
      }
      b = paramString;
      f = paramInt;
      a = System.currentTimeMillis();
      return;
    }
    a(paramString, 10L, paramInt);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    g(paramString2);
    d = paramString1;
  }
  
  public static void a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DOUBLE SCREEN DataReport onStateReport: |");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramLong);
    AVLog.printColorLog("MagicDataReport", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("activeName", paramString);
    ((Map)localObject).put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatFace", true, -1L, -1L, (Map)localObject, true);
    try
    {
      UserAction.flushObjectsToDB(true);
    }
    catch (Exception localException)
    {
      AVLog.printErrorLog("MagicDataReport", localException.getMessage());
    }
    int i = 0;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramInt = i;
        } else {
          paramInt = 5;
        }
      }
      else {
        paramInt = 4;
      }
    }
    else {
      paramInt = 3;
    }
    if (paramInt != 0) {
      c(paramInt, paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a("CliOper", paramString1, 0, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportClickEvent key = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", fromType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", value = ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(", mRoomId = ");
    localStringBuilder.append(e);
    AVLog.printColorLog("MagicDataReport", localStringBuilder.toString());
    ReportController.b(null, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", e, paramString3);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        paramInt = 0;
      } else {
        paramInt = 4;
      }
    }
    else {
      paramInt = 3;
    }
    if ((TextUtils.isEmpty(e)) || (e.equals("0")))
    {
      VideoController localVideoController = VideoController.f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localVideoController.p(localVideoController.k().s));
      localStringBuilder.append("");
      e = localStringBuilder.toString();
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString)) && (!paramString.equals(c)))
    {
      a("dc00898", "0X800BB5E", paramInt, paramString);
      c = paramString;
    }
  }
  
  public static void b(String paramString)
  {
    g(paramString);
    a("0X800812F", null);
  }
  
  public static void c(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WL_DEBUG reportChangeFace fromType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", id = ");
    ((StringBuilder)localObject).append(paramString);
    AVLog.printColorLog("MagicDataReport", ((StringBuilder)localObject).toString());
    if ((TextUtils.isEmpty(e)) || (e.equals("0")))
    {
      localObject = VideoController.f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((VideoController)localObject).p(((VideoController)localObject).k().s));
      localStringBuilder.append("");
      e = localStringBuilder.toString();
    }
    if (paramInt == 5)
    {
      a("dc00898", "0X800984E", paramInt, paramString);
      return;
    }
    a("dc00898", "0X80088B3", paramInt, paramString);
  }
  
  public static void c(String paramString)
  {
    g(paramString);
    a("0X8008130", null);
  }
  
  public static void d(String paramString)
  {
    g(paramString);
    a("0X800984D", null);
  }
  
  public static void e(String paramString)
  {
    g(paramString);
    a("0X8008131", null);
  }
  
  public static void f(String paramString)
  {
    g(paramString);
    a("0X8008022", null);
  }
  
  static void g(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0"))) {
      e = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicDataReport
 * JD-Core Version:    0.7.0.1
 */