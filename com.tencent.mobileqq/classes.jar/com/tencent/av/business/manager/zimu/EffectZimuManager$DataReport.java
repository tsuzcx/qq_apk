package com.tencent.av.business.manager.zimu;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class EffectZimuManager$DataReport
{
  static long jdField_a_of_type_Long = 0L;
  static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean = false;
  
  static long a(String paramString)
  {
    boolean bool = Utils.a(paramString, jdField_a_of_type_JavaLangString);
    long l1 = 0L;
    long l2 = l1;
    if (!bool)
    {
      long l3 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DataReport calTime zimu:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append(jdField_a_of_type_Long);
      AVLog.printColorLog("EffectZimuManager", localStringBuilder.toString());
      l2 = l1;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        l2 = jdField_a_of_type_Long;
        if (l2 != 0L)
        {
          l1 = l3 - l2;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataReport zimu:");
          localStringBuilder.append(l1);
          AVLog.printColorLog("EffectZimuManager", localStringBuilder.toString());
          jdField_a_of_type_Boolean = true;
          l1 /= 1000L;
          a(jdField_a_of_type_JavaLangString, l1);
          ReportController.b(null, "CliOper", "", "", "0X800888D", "0X800888D", 0, 0, String.valueOf(l1), "", jdField_a_of_type_JavaLangString, "");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DataReport zimu 33:");
        localStringBuilder.append(l1);
        AVLog.printColorLog("EffectZimuManager", localStringBuilder.toString());
        l2 = l1;
      }
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Long = l3;
    }
    return l2;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(0))
    {
      paramVideoAppInterface = (ZimuItem)((EffectZimuManager)paramVideoAppInterface.a(0)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
        a(null);
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataReport zimu:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramLong);
    AVLog.printColorLog("EffectZimuManager", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("zimuName", paramString);
    ((Map)localObject).put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatZimu", true, -1L, -1L, (Map)localObject, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      return;
    }
    catch (Exception paramString)
    {
      AVLog.printErrorLog("EffectZimuManager", paramString.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReport onUsedZimu reportClickEvent:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    AVLog.printColorLog("EffectZimuManager", localStringBuilder.toString());
    ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport
 * JD-Core Version:    0.7.0.1
 */