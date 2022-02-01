package com.tencent.mobileqq.avatar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AvatarImplUtil
{
  public static byte a(int paramInt)
  {
    if (paramInt == 32) {
      return 1;
    }
    return 2;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 2) && (paramInt1 == 1)) {
      return 8;
    }
    if (paramInt1 == 1) {
      return 7;
    }
    return 6;
  }
  
  public static String a(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.lastIndexOf('_');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  public static <T> List<List<T>> a(List<T> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt >= 1))
    {
      int m = paramList.size();
      int i;
      if (m % paramInt == 0) {
        i = m / paramInt;
      } else {
        i = 1 + m / paramInt;
      }
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while (j < i)
      {
        int k;
        if (j == i - 1) {
          k = m;
        } else {
          k = (j + 1) * paramInt;
        }
        localArrayList.add(paramList.subList(j * paramInt, k));
        j += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("save_qqhead_to_app_storage", paramBoolean).commit();
  }
  
  public static int b(int paramInt)
  {
    return paramInt >>> 4 & 0xF;
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      label14:
      StringBuilder localStringBuilder;
      break label14;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed getLong, uin = ");
      localStringBuilder.append(paramString);
      QLog.e("AvatarUtil", 2, localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static int c(int paramInt)
  {
    return paramInt & 0xF;
  }
  
  public static String d(int paramInt)
  {
    if ((paramInt != 4) && (paramInt != 8))
    {
      String str2 = e(paramInt);
      paramInt = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      String str1;
      if (paramInt == 1) {
        str1 = "WIFI";
      } else if (paramInt == 2) {
        str1 = "2G";
      } else if (paramInt == 3) {
        str1 = "3G";
      } else if (paramInt == 4) {
        str1 = "4G";
      } else {
        str1 = "Unknown";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String e(int paramInt)
  {
    String str2 = "actGetUserHead";
    String str1 = str2;
    if (paramInt != 1) {
      if ((paramInt != 4) && (paramInt != 8))
      {
        str1 = str2;
        if (paramInt != 11)
        {
          if ((paramInt != 16) && (paramInt != 32)) {
            return "actGetUserHead";
          }
          return "actGetNearbyHead";
        }
      }
      else
      {
        str1 = "actGetGroupHead";
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.utils.AvatarImplUtil
 * JD-Core Version:    0.7.0.1
 */