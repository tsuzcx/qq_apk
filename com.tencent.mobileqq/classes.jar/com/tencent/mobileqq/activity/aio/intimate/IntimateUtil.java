package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;

public class IntimateUtil
{
  public static View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559393, null);
  }
  
  public static MutualMarkForDisplayInfo a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo)
  {
    long[] arrayOfLong = MutualMarkUtils.a;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = MutualMarkDataCenter.a(paramQQAppInterface, paramString, paramExtensionInfo, arrayOfLong[i]);
      if (localMutualMarkForDisplayInfo != null) {
        return localMutualMarkForDisplayInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
    {
      if (paramLong != 1L) {
        break label26;
      }
      str1 = paramContext.getString(2131693454);
    }
    label26:
    do
    {
      return str1;
      if (paramLong == 2L) {
        return paramContext.getString(2131693452);
      }
      if (paramLong == 3L) {
        return paramContext.getString(2131693453);
      }
      str1 = str2;
    } while (paramLong != 26L);
    return paramContext.getString(2131693455);
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool2 = false;
    long[] arrayOfLong = MutualMarkUtils.a;
    int j = arrayOfLong.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateUtil
 * JD-Core Version:    0.7.0.1
 */