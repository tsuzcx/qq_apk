package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Locale;

public class SqliteExcuteMonitor
{
  private static int jdField_a_of_type_Int = 0;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int;
  private static Field jdField_b_of_type_JavaLangReflectField;
  private static int jdField_c_of_type_Int;
  private static Field jdField_c_of_type_JavaLangReflectField;
  private static int d;
  private static int e;
  private static int f;
  
  public static int a(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() < 3) {
      return 99;
    }
    paramString = paramString.substring(0, 3).toUpperCase(Locale.US);
    if (paramString.equals("SEL")) {
      return 1;
    }
    if ((!paramString.equals("INS")) && (!paramString.equals("UPD")) && (!paramString.equals("REP")) && (!paramString.equals("DEL")))
    {
      if (paramString.equals("ATT")) {
        return 3;
      }
      if (paramString.equals("COM")) {
        return 5;
      }
      if (paramString.equals("END")) {
        return 5;
      }
      if (paramString.equals("ROL")) {
        return 6;
      }
      if (paramString.equals("BEG")) {
        return 4;
      }
      if (paramString.equals("PRA")) {
        return 7;
      }
      if ((!paramString.equals("CRE")) && (!paramString.equals("DRO")) && (!paramString.equals("ALT")))
      {
        if ((!paramString.equals("ANA")) && (!paramString.equals("DET"))) {
          return 99;
        }
        return 9;
      }
      return 8;
    }
    return 2;
  }
  
  private static boolean a()
  {
    return (jdField_a_of_type_Int > 0) && (jdField_b_of_type_Int > 0) && (jdField_c_of_type_Int > 0) && (d > 0) && (e > 0) && (f > 0);
  }
  
  private static void b(AppInterface paramAppInterface, String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    String str2 = paramString.replaceAll("(([=|>|<|>=|<=|!=|]|LIKE)\\s*)[\\w\\.']+", "$1?");
    int i = a(str2);
    if (i == 1) {
      paramString = "SELECT";
    }
    for (;;)
    {
      break;
      if (i == 2) {
        paramString = "UPDATE";
      } else if (i == 5) {
        paramString = "TRANSACTION";
      } else {
        paramString = "";
      }
    }
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    String str3 = String.valueOf(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sql=");
      localStringBuilder.append(str2);
      localStringBuilder.append(",bizId=");
      localStringBuilder.append(str3);
      localStringBuilder.append(",operType=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",costTime=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("isMainThread");
      localStringBuilder.append(paramBoolean);
      QLog.i("SqliteExcuteMonitor", 2, localStringBuilder.toString());
    }
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDCSqliteProfile(paramAppInterface, str3, "", paramString, str2, String.valueOf(paramLong), str1, new String[0]);
  }
  
  private static boolean b(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a()))
    {
      int m = a(paramString);
      int i;
      if (paramBoolean) {
        i = jdField_a_of_type_Int;
      } else {
        i = jdField_b_of_type_Int;
      }
      int j;
      if (paramBoolean) {
        j = jdField_c_of_type_Int;
      } else {
        j = d;
      }
      int k;
      if (paramBoolean) {
        k = e;
      } else {
        k = f;
      }
      if (m != 1)
      {
        if (m != 2)
        {
          if ((m == 5) && (paramLong > k)) {
            return true;
          }
        }
        else if (paramLong > j) {
          return true;
        }
      }
      else if (paramLong > i) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SqliteExcuteMonitor
 * JD-Core Version:    0.7.0.1
 */