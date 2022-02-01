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
  static int jdField_a_of_type_Int = 0;
  static long jdField_a_of_type_Long = 0L;
  static String jdField_a_of_type_JavaLangString = "";
  static String b = "";
  static String c = "";
  static String d = "";
  
  public static void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)))
    {
      long l = System.currentTimeMillis();
      a(jdField_a_of_type_JavaLangString, (l - jdField_a_of_type_Long) / 1000L, jdField_a_of_type_Int);
      jdField_a_of_type_JavaLangString = "";
      jdField_a_of_type_Int = 0;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    g(paramString);
    if (!TextUtils.isEmpty(c)) {
      a("0X8008025", c);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if ((paramVideoAppInterface != null) && (paramString != null))
    {
      g(paramString);
      paramVideoAppInterface = (EffectSupportManager)paramVideoAppInterface.a(5);
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
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!paramString.equals(jdField_a_of_type_JavaLangString)))
      {
        long l = System.currentTimeMillis();
        a(jdField_a_of_type_JavaLangString, (l - jdField_a_of_type_Long) / 1000L, jdField_a_of_type_Int);
      }
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Int = paramInt;
      jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(paramString, 10L, paramInt);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    g(paramString2);
    c = paramString1;
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
    localStringBuilder.append(d);
    AVLog.printColorLog("MagicDataReport", localStringBuilder.toString());
    ReportController.b(null, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", d, paramString3);
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
    if ((TextUtils.isEmpty(d)) || (d.equals("0")))
    {
      VideoController localVideoController = VideoController.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localVideoController.a(localVideoController.a().c));
      localStringBuilder.append("");
      d = localStringBuilder.toString();
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramString)) && (!paramString.equals(b)))
    {
      a("dc00898", "0X800BB5E", paramInt, paramString);
      b = paramString;
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
    if ((TextUtils.isEmpty(d)) || (d.equals("0")))
    {
      localObject = VideoController.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((VideoController)localObject).a(((VideoController)localObject).a().c));
      localStringBuilder.append("");
      d = localStringBuilder.toString();
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
      d = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicDataReport
 * JD-Core Version:    0.7.0.1
 */