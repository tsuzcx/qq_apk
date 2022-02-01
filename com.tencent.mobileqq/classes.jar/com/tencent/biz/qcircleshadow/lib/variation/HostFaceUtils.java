package com.tencent.biz.qcircleshadow.lib.variation;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;

public class HostFaceUtils
{
  public static Bitmap getBitmapFromCache(String paramString)
  {
    return QCircleServiceImpl.getAvatarDataService().getBitmapFromCache(paramString);
  }
  
  public static String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return QCircleServiceImpl.getAvatarDataService().getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public static String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return QCircleServiceImpl.getAvatarDataService().getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, paramInt3, paramBoolean);
  }
  
  public static Drawable getFaceDrawable(int paramInt1, int paramInt2, String paramString)
  {
    if (QCircleServiceImpl.getAppInterface() != null) {
      return FaceDrawable.getFaceDrawable(QCircleServiceImpl.getAppInterface(), paramInt1, paramInt2, paramString);
    }
    return null;
  }
  
  public static void getFaceDrawable(int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, QCircleFaceBitmapListener paramQCircleFaceBitmapListener)
  {
    if (QCircleServiceImpl.getAppInterface() != null) {
      FaceDrawable.getFaceDrawable(QCircleServiceImpl.getAppInterface(), 1, String.valueOf(paramString), 4, paramDrawable1, paramDrawable2, new HostFaceUtils.1(paramString, paramQCircleFaceBitmapListener));
    }
  }
  
  public static String getQQAvatarDownLoadUrl(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    return AvatarDownloadUtil.getQQAvatarDownLoadUrl(paramString, paramByte1, paramByte2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils
 * JD-Core Version:    0.7.0.1
 */