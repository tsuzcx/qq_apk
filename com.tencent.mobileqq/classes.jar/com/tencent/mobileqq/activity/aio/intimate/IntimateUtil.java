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
    return LayoutInflater.from(paramContext).inflate(2131559268, null);
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
    if (paramContext != null)
    {
      if (paramLong == 1L) {
        return paramContext.getString(2131693409);
      }
      if (paramLong == 2L) {
        return paramContext.getString(2131693407);
      }
      if (paramLong == 3L) {
        return paramContext.getString(2131693408);
      }
      if (paramLong == 26L) {
        return paramContext.getString(2131693410);
      }
    }
    return "";
  }
  
  public static boolean a(long paramLong)
  {
    long[] arrayOfLong = MutualMarkUtils.a;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateUtil
 * JD-Core Version:    0.7.0.1
 */