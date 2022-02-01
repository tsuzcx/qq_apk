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
    if (i > 720) {
      return 140;
    }
    if (i >= 640) {
      return 140;
    }
    return 40;
  }
  
  private static byte getImageIndex(int paramInt)
  {
    if (paramInt != 40)
    {
      if (paramInt != 100) {
        return 3;
      }
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
    Object localObject2 = "p.qlogo.cn";
    if (paramByte2 == 32) {
      if ((paramInt != 1) && (paramInt == 32))
      {
        localObject1 = localObject2;
        break label70;
      }
    }
    do
    {
      localObject1 = "q.qlogo.cn";
      break;
      if (paramByte2 == 16)
      {
        localObject1 = localObject2;
        break;
      }
      localObject1 = localObject2;
      if (paramByte2 == 4) {
        break;
      }
    } while (paramByte2 != 8);
    Object localObject1 = localObject2;
    label70:
    String str = getIp((String)localObject1, paramBoolean);
    localObject2 = new StringBuilder("https://");
    if (!TextUtils.isEmpty(str)) {
      ((StringBuilder)localObject2).append(str);
    } else {
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    int i = paramString.indexOf("/", 8);
    localObject1 = paramString;
    if (i > 8)
    {
      ((StringBuilder)localObject2).append(paramString.substring(i));
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    if (paramByte2 == 32)
    {
      if (paramInt == 1) {
        paramByte2 = getQQHeadImageSize(paramByte1);
      } else {
        paramByte2 = 140;
      }
    }
    else if (paramByte2 == 16) {
      paramByte2 = 224;
    } else {
      paramByte2 = getQQHeadImageSize(paramByte1);
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject1);
    paramString.append(paramByte2);
    return paramString.toString();
  }
  
  public static int getQQHeadImageSize(byte paramByte)
  {
    int i = getFaceImageSize();
    int k = getImageIndex(i);
    byte b1 = paramByte;
    if (paramByte == 0) {
      b1 = 1;
    }
    paramByte = 1 << k;
    if ((paramByte & b1) == paramByte) {
      return i;
    }
    byte b2 = 0;
    i = k - 1;
    for (;;)
    {
      paramByte = b2;
      if (i < 0) {
        break;
      }
      paramByte = (byte)(1 << i);
      if ((paramByte & b1) == paramByte)
      {
        paramByte = 1;
        break;
      }
      i -= 1;
    }
    b2 = paramByte;
    int j = i;
    if (paramByte == 0)
    {
      i = k + 1;
      for (;;)
      {
        b2 = paramByte;
        j = i;
        if (i >= 8) {
          break;
        }
        b2 = (byte)(1 << i);
        if ((b2 & b1) == b2)
        {
          b2 = 1;
          j = i;
          break;
        }
        i += 1;
      }
    }
    paramByte = 140;
    i = paramByte;
    if (b2 != 0)
    {
      if (j != 0)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4) {
              return 140;
            }
            paramByte = 640;
          }
          return paramByte;
        }
        return 100;
      }
      i = 40;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.util.AvatarDownloadUtil
 * JD-Core Version:    0.7.0.1
 */