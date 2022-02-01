package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.IDbCacheService;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.LocalMultiProcConfig;

public class QCircleHostQzoneHelper
{
  public static int HARDWARE_HIGHLEVEL()
  {
    return QCircleServiceImpl.getQZoneService().HARDWARE_HIGHLEVEL();
  }
  
  public static int HARDWARE_LOWLEVEL()
  {
    return QCircleServiceImpl.getQZoneService().HARDWARE_LOWLEVEL();
  }
  
  public static String KEY_UPLOAD_KEEP_VIDEO_CACHE()
  {
    return QCircleServiceImpl.getQZoneService().KEY_UPLOAD_KEEP_VIDEO_CACHE();
  }
  
  public static String KEY_VIDEO_COMPRESS_SPEED()
  {
    return QCircleServiceImpl.getQZoneService().KEY_VIDEO_COMPRESS_SPEED();
  }
  
  public static String QZONE_SHARE_IMAGES()
  {
    return QCircleServiceImpl.getQZoneService().QZONE_SHARE_IMAGES();
  }
  
  public static String QZONE_SHARE_SUMMERY()
  {
    return QCircleServiceImpl.getQZoneService().QZONE_SHARE_SUMMERY();
  }
  
  public static void bindQzoneVideoService(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    QCircleServiceImpl.getQZoneService().bindQzoneVideoService(paramContext, paramString, paramServiceConnection);
  }
  
  public static void cleanQCirclePush()
  {
    QCircleServiceImpl.getQZoneService().cleanQCirclePush();
  }
  
  public static void closeDbCacheService()
  {
    ((IDbCacheService)QRoute.api(IDbCacheService.class)).close();
  }
  
  public static boolean getBool(String paramString, boolean paramBoolean)
  {
    return LocalMultiProcConfig.getBool(paramString, paramBoolean);
  }
  
  public static IDBManagerWrapper getCacheManager(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, String paramString)
  {
    return ((IDbCacheService)QRoute.api(IDbCacheService.class)).getCacheManager(paramClass, paramLong, paramString);
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt(paramString, paramInt);
  }
  
  public static int getInt4Uin(String paramString, int paramInt, long paramLong)
  {
    return LocalMultiProcConfig.getInt4Uin(paramString, paramInt, paramLong);
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    return LocalMultiProcConfig.getLong(paramString, paramLong);
  }
  
  public static String getSDCardCapabilityForDisplay()
  {
    return QCircleServiceImpl.getQZoneService().getSDCardCapabilityForDisplay();
  }
  
  public static String getSDCardRemainForDisplay()
  {
    return QCircleServiceImpl.getQZoneService().getSDCardRemainForDisplay();
  }
  
  public static int getVideoCanCompressLimitMs()
  {
    return QCircleServiceImpl.getQZoneService().getVideoCanCompressLimitMs();
  }
  
  public static String getVideoFileCacheDir()
  {
    return QCircleServiceImpl.getQZoneService().getVideoFileCacheDir();
  }
  
  public static boolean isExternalAvailable()
  {
    return QCircleServiceImpl.getQZoneService().isExternalAvailable();
  }
  
  public static void jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    QCircleServiceImpl.getQZoneService().jumpToQzoneShare(paramString, paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public static boolean meetHardwareRestriction(int paramInt1, int paramInt2)
  {
    return QCircleServiceImpl.getQZoneService().meetHardwareRestriction(paramInt1, paramInt2);
  }
  
  public static void putInt4Uin(String paramString, int paramInt, long paramLong)
  {
    LocalMultiProcConfig.putInt4Uin(paramString, paramInt, paramLong);
  }
  
  public static void putLong(String paramString, long paramLong)
  {
    LocalMultiProcConfig.putLong(paramString, paramLong);
  }
  
  public static void retentionReport(int paramInt)
  {
    QCircleServiceImpl.getQZoneService().retentionReport(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper
 * JD-Core Version:    0.7.0.1
 */