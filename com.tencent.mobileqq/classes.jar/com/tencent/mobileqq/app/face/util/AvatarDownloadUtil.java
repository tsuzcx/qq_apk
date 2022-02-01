package com.tencent.mobileqq.app.face.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

public class AvatarDownloadUtil
{
  public static String get1080QQHeadDownLoadUrl(String paramString, byte paramByte)
  {
    return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).get1080QQHeadDownLoadUrl(paramString, paramByte);
  }
  
  public static int getFaceImageSize()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i = Math.min(localBaseApplication.getResources().getDisplayMetrics().widthPixels, localBaseApplication.getResources().getDisplayMetrics().heightPixels);
    if (i > 720) {}
    while (i >= 640) {
      return 140;
    }
    return 40;
  }
  
  private static byte getImageIndex(int paramInt)
  {
    switch (paramInt)
    {
    case 140: 
    default: 
      return 3;
    case 100: 
      return 2;
    }
    return 0;
  }
  
  public static String getIp(String paramString, boolean paramBoolean)
  {
    return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getIp(paramString, paramBoolean);
  }
  
  public static String getQQAvatarDownLoadUrl(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    return getQQAvatarDownLoadUrl(paramString, paramByte1, paramByte2, paramInt, false);
  }
  
  public static String getQQAvatarDownLoadUrl(String paramString, byte paramByte1, byte paramByte2, int paramInt, boolean paramBoolean)
  {
    String str1 = "q.qlogo.cn";
    StringBuilder localStringBuilder;
    if (paramByte2 == 32) {
      if (paramInt == 1)
      {
        str1 = "q.qlogo.cn";
        String str2 = getIp(str1, paramBoolean);
        localStringBuilder = new StringBuilder("https://");
        if (TextUtils.isEmpty(str2)) {
          break label181;
        }
        localStringBuilder.append(str2);
        label55:
        int i = paramString.indexOf("/", 8);
        str1 = paramString;
        if (i > 8)
        {
          localStringBuilder.append(paramString.substring(i));
          str1 = localStringBuilder.toString();
        }
        if (paramByte2 != 32) {
          break label199;
        }
        if (paramInt != 1) {
          break label192;
        }
        paramByte2 = getQQHeadImageSize(paramByte1);
      }
    }
    for (;;)
    {
      return str1 + paramByte2;
      if (paramInt != 32) {
        break;
      }
      str1 = "p.qlogo.cn";
      break;
      if (paramByte2 == 16)
      {
        str1 = "p.qlogo.cn";
        break;
      }
      if ((paramByte2 == 4) || (paramByte2 == 8))
      {
        str1 = "p.qlogo.cn";
        break;
      }
      str1 = "q.qlogo.cn";
      break;
      label181:
      localStringBuilder.append(str1);
      break label55;
      label192:
      paramByte2 = 140;
      continue;
      label199:
      if (paramByte2 == 16) {
        paramByte2 = 224;
      } else {
        paramByte2 = getQQHeadImageSize(paramByte1);
      }
    }
  }
  
  public static int getQQHeadImageSize(byte paramByte)
  {
    byte b4 = 1;
    byte b1 = getFaceImageSize();
    int i = getImageIndex(b1);
    byte b3 = paramByte;
    if (paramByte == 0) {
      b3 = 1;
    }
    paramByte = 1 << i;
    if ((paramByte & b3) == paramByte) {
      return b1;
    }
    byte b2 = 0;
    paramByte = i - 1;
    b1 = b2;
    if (paramByte >= 0)
    {
      b1 = (byte)(1 << paramByte);
      if ((b1 & b3) == b1) {
        b1 = 1;
      }
    }
    else
    {
      b2 = paramByte;
      if (b1 != 0) {
        break label168;
      }
      paramByte = i + 1;
      b2 = paramByte;
      if (paramByte >= 8) {
        break label168;
      }
      b2 = (byte)(1 << paramByte);
      if ((b2 & b3) != b2) {
        break label147;
      }
      b1 = b4;
    }
    for (;;)
    {
      if (b1 != 0) {}
      switch (paramByte)
      {
      case 1: 
      default: 
        return 140;
        paramByte -= 1;
        break;
        paramByte += 1;
        break;
      case 0: 
        return 40;
      case 2: 
        return 100;
      case 3: 
        return 140;
      case 4: 
        label147:
        return 640;
        label168:
        paramByte = b2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.util.AvatarDownloadUtil
 * JD-Core Version:    0.7.0.1
 */