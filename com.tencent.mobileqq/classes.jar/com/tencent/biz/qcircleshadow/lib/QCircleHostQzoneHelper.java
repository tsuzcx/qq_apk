package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qcircle.api.IDbCacheService;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.retention.RetentionReport;

public class QCircleHostQzoneHelper
{
  public static final String QCIRCLE_UNREADCOUND = "qzone_unreadcount";
  private static final String TAG = "QCircleHostQzoneHelper";
  
  public static int HARDWARE_HIGHLEVEL()
  {
    return 2;
  }
  
  public static int HARDWARE_LOWLEVEL()
  {
    return 0;
  }
  
  public static String KEY_UPLOAD_KEEP_VIDEO_CACHE()
  {
    return "ServerKeepVideoCache";
  }
  
  public static String KEY_VIDEO_COMPRESS_SPEED()
  {
    return "key_video_compress_speed";
  }
  
  public static String QZONE_SHARE_IMAGES()
  {
    return "images";
  }
  
  public static String QZONE_SHARE_SUMMERY()
  {
    return "summary";
  }
  
  public static void bindQzoneVideoService(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    QZoneHelper.bindQzoneVideoService(paramContext, paramString, paramServiceConnection);
  }
  
  public static void cleanQCirclePush()
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null)
    {
      localQQNotificationManager.cancel("QCircleHostQzoneHelper", 3000532);
      localQQNotificationManager.cancel("QCircleHostQzoneHelper", 3000533);
      localQQNotificationManager.cancel("QCircleHostQzoneHelper", 3000534);
      localQQNotificationManager.cancel("QCircleHostQzoneHelper", 3000535);
      localQQNotificationManager.cancel("QCircleHostQzoneHelper", 3000536);
    }
    clearQCircleUnreadCount();
  }
  
  public static void clearQCircleUnreadCount()
  {
    LocalMultiProcConfig.putInt("qzone_unreadcount3000532", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000533", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000534", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000535", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000536", 0);
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
    return CacheManager.getSDCardCapabilityForDisplay();
  }
  
  public static String getSDCardRemainForDisplay()
  {
    return CacheManager.getSDCardRemainForDisplay();
  }
  
  public static int getVideoCanCompressLimitMs()
  {
    return QZoneHelper.getVideoCanCompressLimitMs();
  }
  
  public static String getVideoFileCacheDir()
  {
    return CacheManager.getVideoFileCacheDir();
  }
  
  public static boolean isExternalAvailable()
  {
    return CacheManager.isExternalAvailable();
  }
  
  public static void jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(paramString, paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public static boolean meetHardwareRestriction(int paramInt1, int paramInt2)
  {
    return ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(paramInt1, paramInt2);
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
    RetentionReport.report(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper
 * JD-Core Version:    0.7.0.1
 */