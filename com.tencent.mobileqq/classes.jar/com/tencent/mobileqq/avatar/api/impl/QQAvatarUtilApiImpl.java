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
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get1080QQHeadDownLoadUrl.choosedIp=");
      localStringBuilder.append(str);
      QLog.i("InnerDns", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    } else {
      localStringBuilder.append("q.qlogo.cn");
    }
    int i = paramString.indexOf("/", 8);
    str = paramString;
    if (i > 8)
    {
      localStringBuilder.append(paramString.substring(i));
      str = localStringBuilder.toString();
    }
    if ((paramByte & 0x20) != 0) {
      paramByte = 0;
    } else if ((paramByte & 0x10) != 0) {
      paramByte = 640;
    } else if ((paramByte & 0x8) != 0) {
      paramByte = 140;
    } else if ((paramByte & 0x4) != 0) {
      paramByte = 100;
    } else {
      paramByte = 40;
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(paramByte);
    return paramString.toString();
  }
  
  public Bitmap getBitmapWithCache(String paramString, int paramInt)
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(paramString);
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = BitmapManager.b(BaseApplication.getContext().getResources(), paramInt);
    }
    if ((localBitmap2 != null) && (GlobalImageCache.a != null)) {
      GlobalImageCache.a.put(paramString, localBitmap2);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getBitmapWithCache, bitmap=");
      paramString.append(localBitmap2);
      QLog.d("QQAvatarUtilApiImpl", 2, paramString.toString());
    }
    return localBitmap2;
  }
  
  public Drawable getDefaultDiscusionFaceDrawable()
  {
    return BaseImageUtil.d();
  }
  
  public Drawable getDefaultFaceDrawable(boolean paramBoolean)
  {
    return BaseImageUtil.a(paramBoolean);
  }
  
  public Drawable getDefaultTroopFaceDrawable()
  {
    return BaseImageUtil.c();
  }
  
  public Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    return SkinUtils.a(paramDrawable);
  }
  
  public String getIp(String paramString, boolean paramBoolean)
  {
    boolean bool = HeadDpcCfg.a().a();
    int j = NetConnInfoCenter.getActiveNetIpFamily(true);
    int i = 28;
    Object localObject;
    if (j == 3)
    {
      localObject = BaseInnerDns.getInstance();
      if (bool) {
        j = 28;
      } else {
        j = 1;
      }
      localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1003, true, j);
      if ((localObject == null) || (((ArrayList)localObject).size() == 0) || (paramBoolean))
      {
        localObject = BaseInnerDns.getInstance();
        if (bool) {
          i = 1;
        }
        localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
      }
    }
    else
    {
      if (j == 2) {
        j = 1;
      } else {
        j = 0;
      }
      localObject = BaseInnerDns.getInstance();
      if (j == 0) {
        i = 1;
      }
      localObject = ((BaseInnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getQQHeandDownLoadUrl.choosedIp = ");
        paramString.append((String)((ArrayList)localObject).get(0));
        QLog.i("InnerDns", 2, paramString.toString());
      }
      return (String)((ArrayList)localObject).get(0);
    }
    QLog.d("InnerDns", 1, "getQQHeandDownLoadUrl() ipList is null");
    return null;
  }
  
  public Bitmap getRoundFaceBitmap(Bitmap paramBitmap)
  {
    return BaseImageUtil.c(paramBitmap, 50, 50);
  }
  
  public Bitmap getShapeRoundFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    float f2 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      float f3 = i;
      float f4 = paramInt2;
      f1 = f2;
      if (f3 < f2 * f4) {
        f1 = f3 / f4;
      }
    }
    paramInt2 = (int)(paramInt2 * f1);
    paramInt3 = (int)(paramInt3 * f1);
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      paramInt1 = paramInt2;
    }
    return BaseImageUtil.a(paramBitmap, paramInt1, bool, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */