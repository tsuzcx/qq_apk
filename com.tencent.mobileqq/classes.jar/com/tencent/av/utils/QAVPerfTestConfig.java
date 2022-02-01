package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QAVPerfTestConfig
{
  private static Integer a;
  
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" parseAndSave parse json = ");
      localStringBuilder.append(paramString1);
      QLog.i("QAVPerfTestConfig", 2, localStringBuilder.toString());
    }
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = j;
        if (paramString1.has("is_perf_test_open")) {
          i = paramString1.getInt("is_perf_test_open");
        }
      }
      catch (Exception paramString1)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" parse json: ");
          localStringBuilder.append(QLog.getStackTraceString(paramString1));
          QLog.i("handleGetQAVGeneralConfig", 2, localStringBuilder.toString());
          i = j;
        }
      }
    }
    paramString1 = QAVConfigUtils.a(735, paramString2).edit();
    paramString1.putInt("is_perf_test_open", i);
    paramString1.commit();
  }
  
  public static boolean a(String paramString)
  {
    if (a == null)
    {
      a = Integer.valueOf(QAVConfigUtils.a(735, paramString).getInt("is_perf_test_open", 0));
      paramString = new StringBuilder();
      paramString.append("isPerfTestOpen, {");
      paramString.append(a);
      paramString.append("}");
      QLog.i("QAVPerfTestConfig", 1, paramString.toString());
    }
    return a.intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVPerfTestConfig
 * JD-Core Version:    0.7.0.1
 */