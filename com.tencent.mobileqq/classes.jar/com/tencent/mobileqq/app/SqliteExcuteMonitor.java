package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.lang.reflect.Field;
import java.util.Locale;

public class SqliteExcuteMonitor
{
  private static int jdField_a_of_type_Int;
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
    if (paramString.length() < 3) {}
    do
    {
      return 99;
      paramString = paramString.substring(0, 3).toUpperCase(Locale.US);
      if (paramString.equals("SEL")) {
        return 1;
      }
      if ((paramString.equals("INS")) || (paramString.equals("UPD")) || (paramString.equals("REP")) || (paramString.equals("DEL"))) {
        return 2;
      }
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
      if ((paramString.equals("CRE")) || (paramString.equals("DRO")) || (paramString.equals("ALT"))) {
        return 8;
      }
    } while ((!paramString.equals("ANA")) && (!paramString.equals("DET")));
    return 9;
  }
  
  private static boolean a()
  {
    return (jdField_a_of_type_Int > 0) && (jdField_b_of_type_Int > 0) && (jdField_c_of_type_Int > 0) && (d > 0) && (e > 0) && (f > 0);
  }
  
  private static void b(AppInterface paramAppInterface, String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    String str2 = paramString.replaceAll("(([=|>|<|>=|<=|!=|]|LIKE)\\s*)[\\w\\.']+", "$1?");
    int i = a(str2);
    paramString = "";
    if (i == 1)
    {
      paramString = "SELECT";
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (String str1 = "1";; str1 = "0")
    {
      String str3 = String.valueOf(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sql=").append(str2).append(",bizId=").append(str3).append(",operType=").append(paramString).append(",costTime=").append(paramLong).append("isMainThread").append(paramBoolean);
        QLog.i("SqliteExcuteMonitor", 2, localStringBuilder.toString());
      }
      VipComicReportUtils.a(paramAppInterface, str3, "", paramString, str2, String.valueOf(paramLong), str1, new String[0]);
      return;
      if (i == 2)
      {
        paramString = "UPDATE";
        break;
      }
      if (i != 5) {
        break;
      }
      paramString = "TRANSACTION";
      break;
    }
  }
  
  private static boolean b(String paramString, long paramLong, boolean paramBoolean)
  {
    int i;
    int j;
    label37:
    int k;
    if ((!TextUtils.isEmpty(paramString)) && (a()))
    {
      int m = a(paramString);
      if (!paramBoolean) {
        break label86;
      }
      i = jdField_a_of_type_Int;
      if (!paramBoolean) {
        break label94;
      }
      j = jdField_c_of_type_Int;
      if (!paramBoolean) {
        break label102;
      }
      k = e;
      label46:
      switch (m)
      {
      }
    }
    label86:
    label94:
    label102:
    do
    {
      do
      {
        do
        {
          return false;
          i = jdField_b_of_type_Int;
          break;
          j = d;
          break label37;
          k = f;
          break label46;
        } while (paramLong <= i);
        return true;
      } while (paramLong <= j);
      return true;
    } while (paramLong <= k);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SqliteExcuteMonitor
 * JD-Core Version:    0.7.0.1
 */