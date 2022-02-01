package com.tencent.mobileqq.avatar.api.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQAvatarUtilApiImpl
  implements IQQAvatarUtilApi
{
  public static final String TAG = "QQAvatarUtilApiImpl";
  
  public Bitmap genSquareFaceBmpByShape(Bitmap paramBitmap)
  {
    return getShapeRoundFaceBitmap(paramBitmap, BaseImageUtil.a(paramBitmap.getWidth()), 50, 50);
  }
  
  public String get1080QQHeadDownLoadUrl(String paramString, byte paramByte)
  {
    String str = BaseInnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 2, "get1080QQHeadDownLoadUrl.choosedIp=" + str);
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(str);
      int i = paramString.indexOf("/", 8);
      str = paramString;
      if (i > 8)
      {
        localStringBuilder.append(paramString.substring(i));
        str = localStringBuilder.toString();
      }
      if ((paramByte & 0x20) == 0) {
        break label148;
      }
      paramByte = 0;
    }
    for (;;)
    {
      return str + paramByte;
      localStringBuilder.append("q.qlogo.cn");
      break;
      label148:
      if ((paramByte & 0x10) != 0) {
        paramByte = 640;
      } else if ((paramByte & 0x8) != 0) {
        paramByte = 140;
      } else if ((paramByte & 0x4) != 0) {
        paramByte = 100;
      } else {
        paramByte = 40;
      }
    }
  }
  
  public Bitmap getBitmapWithCache(String paramString, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(paramString);
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = BitmapManager.b(BaseApplication.getContext().getResources(), paramInt);
    }
    if ((localBitmap2 != null) && (GlobalImageCache.a != null)) {
      GlobalImageCache.a.put(paramString, localBitmap2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAvatarUtilApiImpl", 2, "getBitmapWithCache, bitmap=" + localBitmap2);
    }
    return localBitmap2;
  }
  
  public Drawable getDefaultDiscusionFaceDrawable()
  {
    return BaseImageUtil.b();
  }
  
  public Drawable getDefaultFaceDrawable(boolean paramBoolean)
  {
    return BaseImageUtil.a(paramBoolean);
  }
  
  public Drawable getDefaultTroopFaceDrawable()
  {
    return BaseImageUtil.a();
  }
  
  public Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    return SkinUtils.a(paramDrawable);
  }
  
  public String getIp(String paramString, boolean paramBoolean)
  {
    int i = 28;
    boolean bool = HeadDpcCfg.a().a();
    int j = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject;
    if (j == 3)
    {
      localObject = BaseInnerDns.getInstance();
      if (bool)
      {
        j = 28;
        localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1003, true, j);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0) && (!paramBoolean)) {
          break label211;
        }
        localObject = BaseInnerDns.getInstance();
        if (bool) {
          i = 1;
        }
        paramString = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("InnerDns", 2, "getQQHeandDownLoadUrl.choosedIp = " + (String)paramString.get(0));
        }
        return (String)paramString.get(0);
        j = 1;
        break;
        if (j == 2)
        {
          j = 1;
          label165:
          localObject = BaseInnerDns.getInstance();
          if (j == 0) {
            break label196;
          }
        }
        for (;;)
        {
          paramString = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
          break;
          j = 0;
          break label165;
          label196:
          i = 1;
        }
      }
      QLog.d("InnerDns", 1, "getQQHeandDownLoadUrl() ipList is null");
      return null;
      label211:
      paramString = (String)localObject;
    }
  }
  
  public Bitmap getRoundFaceBitmap(Bitmap paramBitmap)
  {
    return BaseImageUtil.c(paramBitmap, 50, 50);
  }
  
  public Bitmap getShapeRoundFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    float f = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    if ((i > 0) && (i < paramInt2 * f)) {
      f = i / paramInt2;
    }
    for (;;)
    {
      paramInt2 = (int)(paramInt2 * f);
      paramInt3 = (int)(f * paramInt3);
      if (paramInt1 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (!bool) {
          paramInt1 = paramInt2;
        }
        return BaseImageUtil.a(paramBitmap, paramInt1, bool, paramInt2, paramInt3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */