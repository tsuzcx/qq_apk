package com.tencent.comic.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VersionUtils
{
  public static int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return -2;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 1;
    }
    paramString1 = paramString1.trim();
    paramString2 = paramString2.trim();
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    if (paramString1.length > 0)
    {
      if (paramString2.length <= 0) {
        return -2;
      }
      paramString1 = new ArrayList(Arrays.asList(paramString1));
      paramString2 = new ArrayList(Arrays.asList(paramString2));
    }
    for (;;)
    {
      int k;
      int j;
      try
      {
        i = paramString1.size() - 1;
        if ((i >= 0) && (Integer.parseInt((String)paramString1.get(i)) == 0))
        {
          paramString1.remove(i);
          i -= 1;
          continue;
        }
        i = paramString2.size() - 1;
        if ((i < 0) || (Integer.parseInt((String)paramString2.get(i)) != 0)) {
          break label332;
        }
        paramString2.remove(i);
        i -= 1;
        continue;
        if (i < paramString1.size())
        {
          k = Integer.parseInt((String)paramString1.get(i));
          int m = paramString2.size();
          j = i + 1;
          if (m < j) {
            return 1;
          }
          i = Integer.parseInt((String)paramString2.get(i));
          if (k <= i) {
            break label337;
          }
          return 1;
        }
        i = paramString2.size();
        j = paramString1.size();
        if (i > j) {
          return -1;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("compareVersion fail e:");
        paramString2.append(paramString1.toString());
        QLog.e("VersionUtils", 1, paramString2.toString());
      }
      return -2;
      label332:
      int i = 0;
      continue;
      label337:
      if ((k != i) && (k < i)) {
        return -1;
      }
      i = j;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      try
      {
        if ((a(paramString1, paramString2) >= 0) && (a(paramString1, paramString3) <= 0))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("localversion target. min=");
            localStringBuilder.append(paramString2);
            localStringBuilder.append(",local =");
            localStringBuilder.append(paramString1);
            localStringBuilder.append(",max=");
            localStringBuilder.append(paramString3);
            QLog.d("VersionUtils", 2, localStringBuilder.toString());
          }
          return true;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VersionUtils", 2, paramString1.toString());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.utils.VersionUtils
 * JD-Core Version:    0.7.0.1
 */