package com.tencent.mobileqq.avatar.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class AvatarUtil
{
  public static byte a(byte paramByte)
  {
    byte b = paramByte;
    if (ThemeUtil.b(null, false, null))
    {
      b = paramByte;
      if (!a(paramByte)) {
        b = 1;
      }
    }
    return b;
  }
  
  public static Bitmap a(byte paramByte, Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    switch (paramByte)
    {
    case 5: 
    case 8: 
    case 2: 
    default: 
      return a(paramBitmap);
    case 1: 
      return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).genSquareFaceBmpByShape(paramBitmap);
    case 3: 
    case 4: 
      return a(paramBitmap, 50, 50);
    case 7: 
      return ApolloUtil.b(paramBitmap, paramString, paramInt);
    }
    return ApolloUtil.a(paramBitmap, paramString, paramInt);
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getRoundFaceBitmap(paramBitmap);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return a(paramBitmap, -1, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getShapeRoundFaceBitmap(paramBitmap, paramInt1, paramInt2, paramInt3);
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      if (paramInt1 == 32) {
        return "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
      }
      if (paramInt1 == 16) {
        return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
      }
      str = paramString;
    } while (paramInt1 != 116);
    return "apollo_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    String str = paramInt1 + "_" + paramString;
    if (paramInt1 == 32) {
      str = "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
    }
    do
    {
      return str;
      if (paramInt1 == 16) {
        return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
      }
    } while (paramInt1 != 116);
    return "apollo_" + String.valueOf(paramInt3) + "_" + paramString;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.PATH_HEAD_HD);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
  }
  
  private static boolean a(byte paramByte)
  {
    return (paramByte == 4) || (paramByte == 5) || (paramByte == 8) || (paramByte == 7) || (paramByte == 6);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("AvatarUtil", 1, "===isPstnDiscussionUin discussionUin is null ===");
      bool = false;
    }
    while (paramString.contains("_1001")) {
      return bool;
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("AvatarUtil", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int i = paramString.indexOf("_");
    if ((i < 0) || (i > paramString.length()))
    {
      QLog.i("AvatarUtil", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + paramString);
      return null;
    }
    return paramString.substring(0, i);
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("AvatarUtil", 1, "===getPstnDiscussionUin discussionUin is null ===");
      return null;
    }
    return paramString + "_" + 1001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.utils.AvatarUtil
 * JD-Core Version:    0.7.0.1
 */