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
    if (ThemeUtil.isNowThemeIsSimple(null, false, null))
    {
      b = paramByte;
      if (!b(paramByte)) {
        b = 3;
      }
    }
    return b;
  }
  
  public static Bitmap a(byte paramByte, Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    Bitmap localBitmap = paramBitmap;
    switch (paramByte)
    {
    case 2: 
    default: 
      return a(paramBitmap);
    case 7: 
      return ApolloUtil.b(paramBitmap, paramString, paramInt);
    case 6: 
      return ApolloUtil.a(paramBitmap, paramString, paramInt);
    case 3: 
    case 4: 
      return a(paramBitmap, 50, 50);
    case 1: 
      localBitmap = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).genSquareFaceBmpByShape(paramBitmap);
    }
    return localBitmap;
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
    if (paramInt1 == 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troop_");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 32)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stranger_");
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 16)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qcall_");
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = paramString;
    if (paramInt1 == 116)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_");
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    if (paramInt1 == 32)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stranger_");
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 16)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qcall_");
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 116)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_");
      ((StringBuilder)localObject).append(String.valueOf(paramInt3));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    if (SystemUtil.a()) {
      localStringBuilder1.append(AppConstants.PATH_HEAD_HD);
    } else {
      localStringBuilder1.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
    String str = MD5.toMD5(paramString);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramString);
    str = MD5.toMD5(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramString);
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(".png");
    return localStringBuilder1.toString();
  }
  
  private static boolean b(byte paramByte)
  {
    return (paramByte == 4) || (paramByte == 5) || (paramByte == 8) || (paramByte == 7) || (paramByte == 6);
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return paramString.contains("_1001");
    }
    QLog.i("AvatarUtil", 1, "===isPstnDiscussionUin discussionUin is null ===");
    return false;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("AvatarUtil", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int i = paramString.indexOf("_");
    if ((i >= 0) && (i <= paramString.length())) {
      return paramString.substring(0, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | ");
    localStringBuilder.append(paramString);
    QLog.i("AvatarUtil", 1, localStringBuilder.toString());
    return null;
  }
  
  public static String d(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(1001);
      return localStringBuilder.toString();
    }
    QLog.i("AvatarUtil", 1, "===getPstnDiscussionUin discussionUin is null ===");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.utils.AvatarUtil
 * JD-Core Version:    0.7.0.1
 */