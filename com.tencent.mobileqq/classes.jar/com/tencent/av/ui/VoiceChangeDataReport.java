package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.app.SessionInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class VoiceChangeDataReport
{
  static int jdField_a_of_type_Int = 0;
  static long jdField_a_of_type_Long = 0L;
  public static String a = "VoiceChangeDataReport";
  static boolean jdField_a_of_type_Boolean = false;
  static int jdField_b_of_type_Int = 0;
  static String jdField_b_of_type_JavaLangString = "0";
  static boolean jdField_b_of_type_Boolean = false;
  static int jdField_c_of_type_Int = 0;
  static String jdField_c_of_type_JavaLangString = "actAVFunChatVoiceChange";
  static boolean jdField_c_of_type_Boolean = false;
  static boolean d = false;
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("typeid", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localHashMap.put("duration", localStringBuilder.toString());
    UserAction.onUserAction(jdField_c_of_type_JavaLangString, true, -1L, -1L, localHashMap, true);
    AVLog.printDebugLog(jdField_a_of_type_JavaLangString, String.format("reportVoiceChange voiceType = %s, duration = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  public static void a(int paramInt, String paramString)
  {
    AVLog.printDebugLog(jdField_a_of_type_JavaLangString, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    d = true;
    jdField_b_of_type_JavaLangString = paramString;
    if ((paramInt != 1) && (paramInt != 3))
    {
      if ((paramInt == 2) || (paramInt == 4))
      {
        paramInt = jdField_a_of_type_Int;
        if (paramInt != 0) {
          jdField_c_of_type_Int = paramInt;
        }
        jdField_b_of_type_Boolean = true;
      }
    }
    else
    {
      paramInt = jdField_a_of_type_Int;
      if (paramInt != 0) {
        jdField_b_of_type_Int = paramInt;
      }
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public static void a(SessionInfo paramSessionInfo)
  {
    if (jdField_c_of_type_Boolean)
    {
      if (!d) {
        return;
      }
      StringBuilder localStringBuilder;
      if ((paramSessionInfo.d != 1) && (paramSessionInfo.d != 2))
      {
        if ((paramSessionInfo.d == 3) || (paramSessionInfo.d == 4)) {
          if (paramSessionInfo.j == 1)
          {
            if (jdField_a_of_type_Boolean) {
              if (jdField_b_of_type_Int == 0)
              {
                a("0X8007E67", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(jdField_b_of_type_Int);
                localStringBuilder.append("");
                a("0X8007E68", localStringBuilder.toString());
              }
            }
            if (jdField_b_of_type_Boolean) {
              if (jdField_c_of_type_Int == 0)
              {
                a("0X8007E69", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(jdField_c_of_type_Int);
                localStringBuilder.append("");
                a("0X8007E6A", localStringBuilder.toString());
              }
            }
          }
          else if (paramSessionInfo.j == 10)
          {
            if (jdField_a_of_type_Boolean) {
              if (jdField_b_of_type_Int == 0)
              {
                a("0X8007E63", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(jdField_b_of_type_Int);
                localStringBuilder.append("");
                a("0X8007E64", localStringBuilder.toString());
              }
            }
            if (jdField_b_of_type_Boolean) {
              if (jdField_c_of_type_Int == 0)
              {
                a("0X8007E65", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(jdField_c_of_type_Int);
                localStringBuilder.append("");
                a("0X8007E66", localStringBuilder.toString());
              }
            }
          }
        }
      }
      else
      {
        if (jdField_a_of_type_Boolean) {
          if (jdField_b_of_type_Int == 0)
          {
            a("0X8007DC3", "");
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(jdField_b_of_type_Int);
            localStringBuilder.append("");
            a("0X8007DC2", localStringBuilder.toString());
          }
        }
        if (jdField_b_of_type_Boolean) {
          if (jdField_c_of_type_Int == 0)
          {
            a("0X8007DC5", "");
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(jdField_c_of_type_Int);
            localStringBuilder.append("");
            a("0X8007DC4", localStringBuilder.toString());
          }
        }
      }
      a(paramSessionInfo, 0);
      jdField_c_of_type_Boolean = false;
      d = false;
      jdField_b_of_type_JavaLangString = "0";
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, int paramInt)
  {
    AVLog.printDebugLog(jdField_a_of_type_JavaLangString, String.format("updateReportData sessionType = %d, voiceType = %d", new Object[] { Integer.valueOf(paramSessionInfo.d), Integer.valueOf(paramInt) }));
    long l = System.currentTimeMillis();
    int i = jdField_a_of_type_Int;
    if (i != 0) {
      a(i, (l - jdField_a_of_type_Long) / 1000L);
    }
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_Long = l;
    if ((paramSessionInfo.d != 1) && (paramSessionInfo.d != 3))
    {
      if ((paramSessionInfo.d == 2) || (paramSessionInfo.d == 4))
      {
        paramInt = jdField_a_of_type_Int;
        if (paramInt != 0) {
          jdField_c_of_type_Int = paramInt;
        }
        jdField_b_of_type_Boolean = true;
      }
    }
    else
    {
      paramInt = jdField_a_of_type_Int;
      if (paramInt != 0) {
        jdField_b_of_type_Int = paramInt;
      }
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AVLog.printDebugLog(jdField_a_of_type_JavaLangString, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, jdField_b_of_type_JavaLangString }));
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", jdField_b_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeDataReport
 * JD-Core Version:    0.7.0.1
 */