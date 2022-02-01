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
  
  public static int a(int paramInt)
  {
    return paramInt >>> 4 & 0xF;
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
  
  public static long a(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarUtil", 2, "failed getLong, uin = " + paramString);
      }
    }
    return 0L;
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      return "";
    }
    String str2 = b(paramInt);
    paramInt = NetworkUtil.a(BaseApplication.getContext());
    String str1;
    if (paramInt == 1) {
      str1 = "WIFI";
    }
    for (;;)
    {
      return str2 + str1;
      if (paramInt == 2) {
        str1 = "2G";
      } else if (paramInt == 3) {
        str1 = "3G";
      } else if (paramInt == 4) {
        str1 = "4G";
      } else {
        str1 = "Unknown";
      }
    }
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
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.lastIndexOf('_');
    } while (i <= 0);
    return paramString.substring(i + 1);
  }
  
  public static <T> List<List<T>> a(List<T> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt < 1)) {
      return null;
    }
    int m = paramList.size();
    int i;
    ArrayList localArrayList;
    int j;
    if (m % paramInt == 0)
    {
      i = m / paramInt;
      localArrayList = new ArrayList();
      j = 0;
      label42:
      if (j >= i) {
        break label104;
      }
      if (j != i - 1) {
        break label94;
      }
    }
    label94:
    for (int k = m;; k = (j + 1) * paramInt)
    {
      localArrayList.add(paramList.subList(j * paramInt, k));
      j += 1;
      break label42;
      i = m / paramInt + 1;
      break;
    }
    label104:
    return localArrayList;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("save_qqhead_to_app_storage", paramBoolean).commit();
  }
  
  public static int b(int paramInt)
  {
    return paramInt & 0xF;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "actGetUserHead";
    case 4: 
    case 8: 
      return "actGetGroupHead";
    case 16: 
    case 32: 
      return "actGetNearbyHead";
    }
    return "actGetUserHead";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.utils.AvatarImplUtil
 * JD-Core Version:    0.7.0.1
 */