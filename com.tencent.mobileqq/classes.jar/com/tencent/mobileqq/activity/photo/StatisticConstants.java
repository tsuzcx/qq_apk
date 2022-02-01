package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class StatisticConstants
{
  public static int a()
  {
    int j = 1;
    int i;
    if ((DeviceInfoUtil.a() >>> 20 < 600L) || (DeviceInfoUtil.b() == 1)) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "getDeviceType,DeviceInfoUtil.getSystemTotalMemory() =" + (DeviceInfoUtil.a() >>> 20) + ",DeviceInfoUtil.getCpuNumber() = " + DeviceInfoUtil.b() + ",phoneType = " + i);
      }
      return i;
      i = j;
      if (DeviceInfoUtil.a() >>> 20 >= 1536.0D)
      {
        i = j;
        if (DeviceInfoUtil.b() >= 4) {
          i = 2;
        }
      }
    }
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times", i + 1).commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "sendPhotoPreviewSelectRateStatistic (" + paramInt1 + " ," + paramInt2 + ")");
    }
    SharedPreferences localSharedPreferences;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = localSharedPreferences.getLong("PhotoConst.last_send_select_rate_time_preview", 0L);
      long l2 = System.currentTimeMillis();
      paramInt1 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_count", 0) + paramInt1;
      paramInt2 = localSharedPreferences.getInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0) + paramInt2;
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_count", paramInt1 + "");
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_rate", paramInt1 / paramInt2 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PhotoConst.photopreviewactivity_send", false, 0L, 0L, localHashMap, "", false);
        localSharedPreferences.edit().putLong("PhotoConst.last_send_select_rate_time_preview", l2).putInt("PhotoConst.photopreviewactivity_send_pic_count", 0).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photopreviewactivity_send_pic_count", paramInt1).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", paramInt2).commit();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "userAlbumSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + ")");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_album_source_type", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumCount", paramInt1 + "");
      localHashMap.put("param_screnshot_qq_cnt", paramInt2 + "");
      localHashMap.put("param_screnshot_other_cnt", paramInt3 + "");
      localHashMap.put("param_appCount", paramInt4 + "");
      localHashMap.put("param_otherCount", paramInt5 + "");
      localHashMap.put("param_qq_collection_cnt", paramInt6 + "");
      localHashMap.put("param_qq_filerecv_cnt", paramInt8 + "");
      localHashMap.put("param_qq_image_cnt", paramInt7 + "");
      localHashMap.put("param_qq_zebra_cnt", paramInt9 + "");
      localHashMap.put("param_qq_favorite_cnt", paramInt10 + "");
      localHashMap.put("param_weixinCnt", paramInt11 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actAlbumPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_album_source_type", l2).commit();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSourceTypeStatistic (" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramInt5 + "," + paramInt6 + "," + paramInt7 + "," + paramInt8 + "," + paramInt9 + "," + paramInt10 + "," + paramInt11 + "," + paramInt12 + "," + paramInt13 + "),age = " + paramInt14 + ",gender = " + paramInt15 + ",userType = " + paramInt16);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_pic_source_type", 0L);
    long l2 = System.currentTimeMillis();
    paramInt1 = localSharedPreferences.getInt("PhotoConst.photolistactivity_systemalbum_send_count", 0) + paramInt1;
    paramInt2 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0) + paramInt2;
    paramInt3 = localSharedPreferences.getInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0) + paramInt3;
    paramInt5 = localSharedPreferences.getInt("PhotoConst.photolistactivity_other_send_count", 0) + paramInt5;
    paramInt4 = localSharedPreferences.getInt("PhotoConst.photolistactivity_app_send_count", 0) + paramInt4;
    paramInt6 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_collection_send_count", 0) + paramInt6;
    paramInt7 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_image_send_count", 0) + paramInt7;
    paramInt8 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0) + paramInt8;
    paramInt9 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0) + paramInt9;
    paramInt10 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0) + paramInt10;
    paramInt11 = localSharedPreferences.getInt("PhotoConst.photolistactivity_weixin_send_count", 0) + paramInt11;
    paramInt12 = localSharedPreferences.getInt("PhotoConst.photolistactivity_sougou_send_count", 0) + paramInt12;
    paramInt13 = localSharedPreferences.getInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0) + paramInt13;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_systemAlbumSendCount", paramInt1 + "");
      localHashMap.put("param_screnshotQQSendCount", paramInt2 + "");
      localHashMap.put("param_screnshotOtherSendCount", paramInt3 + "");
      localHashMap.put("param_otherSendCount", paramInt5 + "");
      localHashMap.put("param_appSendCount", paramInt4 + "");
      localHashMap.put("param_qq_collection_SendCount", paramInt6 + "");
      localHashMap.put("param_qq_image_SendCount", paramInt7 + "");
      localHashMap.put("param_qq_filerecv_SendCount", paramInt8 + "");
      localHashMap.put("param_qq_zebra_SendCount", paramInt9 + "");
      localHashMap.put("param_qq_favorite_SendCount", paramInt10 + "");
      localHashMap.put("param_weixinSendCount", paramInt11 + "");
      localHashMap.put("param_sougouSendCount", paramInt12 + "");
      localHashMap.put("param_qqpinyinSendCount", paramInt13 + "");
      localHashMap.put("param_age", paramInt14 + "");
      localHashMap.put("param_gender", paramInt15 + "");
      localHashMap.put("param_userType", paramInt16 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actDaySendPicSourceType", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_pic_source_type", l2).putInt("PhotoConst.photolistactivity_systemalbum_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0).putInt("PhotoConst.photolistactivity_other_send_count", 0).putInt("PhotoConst.photolistactivity_app_send_count", 0).putInt("PhotoConst.photolistactivity_qq_collection_send_count", 0).putInt("PhotoConst.photolistactivity_qq_image_send_count", 0).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0).putInt("PhotoConst.photolistactivity_weixin_send_count", 0).putInt("PhotoConst.photolistactivity_sougou_send_count", 0).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.photolistactivity_systemalbum_send_count", paramInt1).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", paramInt2).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", paramInt3).putInt("PhotoConst.photolistactivity_other_send_count", paramInt5).putInt("PhotoConst.photolistactivity_app_send_count", paramInt4).putInt("PhotoConst.photolistactivity_qq_collection_send_count", paramInt6).putInt("PhotoConst.photolistactivity_qq_image_send_count", paramInt7).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", paramInt8).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", paramInt9).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", paramInt10).putInt("PhotoConst.photolistactivity_weixin_send_count", paramInt11).putInt("PhotoConst.photolistactivity_sougou_send_count", paramInt12).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", paramInt13).commit();
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,size <= 0,return! size = " + paramLong);
      }
      return;
    }
    HashMap localHashMap = new HashMap();
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      int j = NetworkUtil.a(BaseApplication.getContext());
      int k = a();
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_WasteSize", paramLong + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayWastedSize", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdayWastedSize,WastedSize =" + paramLong);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      int j = NetworkUtil.a(BaseApplication.getContext());
      int k = a();
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_WasteSize", paramLong + "");
      localHashMap.put("param_cancelType", paramInt + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSWaste", false, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSWaste,size = " + paramLong + ",cancelType = " + paramInt);
      }
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong == 0L) || (paramInt == 0) || (paramLong > 86400000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,invalid arg,return!");
      }
      return;
    }
    long l = paramLong / paramInt;
    int j = a();
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_phone_type", j + "");
      localHashMap.put("param_consumTime", paramLong + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_showing_progress", paramBoolean + "");
      localHashMap.put("param_averageTime", l + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdonecompressPic", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,param_consumTime =" + paramLong + ",param_selNum = " + paramInt + ",param_averageTime = " + l + ",isShowing = " + paramBoolean);
      return;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong1 > 86400000L) || (paramDouble < 0.0D) || (paramDouble > 1.0D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,invalid arg,return!");
      }
      return;
    }
    int j = NetworkUtil.a(BaseApplication.getContext());
    int k = a();
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      localHashMap.put("param_userType", i + "");
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_aio_duration", paramLong1 + "");
      localHashMap.put("param_second_trans", paramBoolean + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_pic_filesize", paramLong2 + "");
      localHashMap.put("param_optimizePercent", paramDouble + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdoneaioduration", false, 0L, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSdoneAioDuration,aioduration =" + paramLong1 + ",filesize = " + paramLong2 + ",isSecondTrans = " + paramBoolean + ",phoneType = " + k + ",percent = " + paramDouble);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    long l1 = paramIntent.getLongExtra("param_compressInitTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScompressPic,initTime == 0,return!");
      }
    }
    long l2;
    int i;
    do
    {
      do
      {
        return;
        l2 = System.currentTimeMillis() - l1;
      } while (l2 > 86400000L);
      i = paramIntent.getIntExtra("param_selNum", 0);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_selNum == 0,return!");
    return;
    if (i > 0) {}
    for (l1 = l2 / i;; l1 = 0L)
    {
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", i + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPScompressPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_compressInitTime");
      paramIntent.removeExtra("param_selNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_consumTime =" + l2 + ",param_selNum = " + i + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendPhotoListSelectRateStatistic (" + paramInt + ")");
    }
    int i = paramIntent.getIntExtra("param_totalSelNum", 0);
    if ((paramInt > 0) && (i > 0))
    {
      paramIntent = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = paramIntent.getLong("PhotoConst.last_send_select_rate_time", 0L);
      long l2 = System.currentTimeMillis();
      paramInt = paramIntent.getInt("PhotoConst.photolistactivity_pic_count", 0) + paramInt;
      i += paramIntent.getInt("PhotoConst.photolistactivity_pic_total_count", 0);
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_sendCount", paramInt + "");
        localHashMap.put("param_selCount", i + "");
        localHashMap.put("param_sendPercent", paramInt / i + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdaySelSend", false, 0L, 0L, localHashMap, "", false);
        paramIntent.edit().putLong("PhotoConst.last_send_select_rate_time", l2).putInt("PhotoConst.photolistactivity_pic_count", 0).putInt("PhotoConst.photolistactivity_pic_total_count", 0).commit();
      }
    }
    else
    {
      return;
    }
    paramIntent.edit().putInt("PhotoConst.photolistactivity_pic_count", paramInt).putInt("PhotoConst.photolistactivity_pic_total_count", i).commit();
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    long l1 = paramIntent.getLongExtra("param_initTime", 0L);
    if (l1 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,initTime == 0,return!");
      }
    }
    long l2;
    do
    {
      return;
      l2 = System.currentTimeMillis() - l1;
    } while (l2 > 86400000L);
    if (paramInt1 > 0) {}
    for (l1 = l2 / paramInt1;; l1 = 0L)
    {
      int i = paramIntent.getIntExtra("param_cancelSelNum", 0);
      HashMap localHashMap = new HashMap();
      int j = NetworkUtil.a(BaseApplication.getContext());
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_type", paramInt2 + "");
      localHashMap.put("param_cancelSelNum", i + "");
      localHashMap.put("param_consumTime", l2 + "");
      localHashMap.put("param_selNum", paramInt1 + "");
      localHashMap.put("param_averageTime", l1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSselectSendPic", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,param_type =" + paramInt2 + ",param_cancelSelNum = " + i + ",param_consumTime = " + l2 + ",param_selNum = " + paramInt1 + ",param_averageTime = " + l1);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "incrementStatisticParam(" + paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra(paramString, paramIntent.getIntExtra(paramString, 0) + 1);
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: getstatic 425	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   9: invokevirtual 431	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12: checkcast 433	com/tencent/mobileqq/nearby/NearbyCardManager
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +959 -> 976
    //   20: aload_2
    //   21: invokevirtual 434	com/tencent/mobileqq/nearby/NearbyCardManager:a	()I
    //   24: istore 4
    //   26: aload_2
    //   27: invokevirtual 435	com/tencent/mobileqq/nearby/NearbyCardManager:b	()I
    //   30: istore_3
    //   31: new 437	android/graphics/BitmapFactory$Options
    //   34: dup
    //   35: invokespecial 438	android/graphics/BitmapFactory$Options:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: iconst_1
    //   41: putfield 442	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: aload_0
    //   45: aload_2
    //   46: invokestatic 447	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload_2
    //   51: getfield 450	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: istore 7
    //   56: aload_2
    //   57: getfield 453	android/graphics/BitmapFactory$Options:outHeight	I
    //   60: istore 8
    //   62: iload 7
    //   64: i2l
    //   65: iload 8
    //   67: i2l
    //   68: invokestatic 458	com/tencent/mobileqq/richmedia/dc/PhotoUtils:a	(JJ)I
    //   71: istore 9
    //   73: iload_1
    //   74: istore 5
    //   76: iload_1
    //   77: ifeq +24 -> 101
    //   80: iload_1
    //   81: istore 5
    //   83: iload_1
    //   84: iconst_1
    //   85: if_icmpeq +16 -> 101
    //   88: iload_1
    //   89: istore 5
    //   91: iload_1
    //   92: sipush 3000
    //   95: if_icmpeq +6 -> 101
    //   98: iconst_5
    //   99: istore 5
    //   101: new 460	java/io/FileInputStream
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 462	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   109: astore 16
    //   111: aload 16
    //   113: new 464	java/io/File
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 465	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 468	java/io/File:length	()J
    //   124: invokestatic 474	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   127: astore_2
    //   128: aload_2
    //   129: invokestatic 480	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   132: astore_2
    //   133: aload 16
    //   135: ifnull +833 -> 968
    //   138: aload 16
    //   140: invokevirtual 483	java/io/FileInputStream:close	()V
    //   143: aload_0
    //   144: invokestatic 488	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 16
    //   149: aload 16
    //   151: invokevirtual 493	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   154: ldc_w 495
    //   157: invokevirtual 499	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +760 -> 920
    //   163: iconst_0
    //   164: istore_1
    //   165: invokestatic 504	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   168: bipush 11
    //   170: invokevirtual 508	java/util/Calendar:get	(I)I
    //   173: istore 10
    //   175: ldc 255
    //   177: invokestatic 261	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   180: checkcast 255	com/tencent/mobileqq/dpc/api/IDPCApi
    //   183: getstatic 267	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:picpredownload_whitelist	Lcom/tencent/mobileqq/dpc/enumname/DPCAccountNames;
    //   186: invokevirtual 270	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:name	()Ljava/lang/String;
    //   189: invokeinterface 274 2 0
    //   194: ifeq +731 -> 925
    //   197: sipush 1002
    //   200: istore 6
    //   202: invokestatic 149	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   205: ifeq +158 -> 363
    //   208: ldc 29
    //   210: iconst_4
    //   211: new 31	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 510
    //   221: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 512
    //   231: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload 5
    //   236: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: ldc_w 514
    //   242: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload 9
    //   247: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc_w 516
    //   253: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iload 4
    //   258: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc 186
    //   263: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: iload_3
    //   267: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc_w 518
    //   273: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: iload 10
    //   278: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 520
    //   284: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_2
    //   288: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 522
    //   294: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: iload_1
    //   298: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: ldc_w 524
    //   304: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 16
    //   309: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 526
    //   315: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: invokestatic 529	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 531
    //   328: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload 7
    //   333: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: ldc_w 533
    //   339: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: iload 8
    //   344: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: ldc 188
    //   349: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: iload 6
    //   354: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: new 117	java/util/HashMap
    //   366: dup
    //   367: invokespecial 118	java/util/HashMap:<init>	()V
    //   370: astore_0
    //   371: aload_0
    //   372: ldc_w 535
    //   375: new 31	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   382: iload 5
    //   384: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: ldc 120
    //   389: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: pop
    //   399: aload_0
    //   400: ldc_w 537
    //   403: new 31	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   410: iload 9
    //   412: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: ldc 120
    //   417: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   426: pop
    //   427: aload_0
    //   428: ldc 244
    //   430: new 31	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   437: iload 4
    //   439: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: ldc 120
    //   444: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: aload_0
    //   455: ldc 246
    //   457: new 31	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   464: iload_3
    //   465: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: ldc 120
    //   470: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   479: pop
    //   480: aload_0
    //   481: ldc 248
    //   483: new 31	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   490: iload 6
    //   492: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc 120
    //   497: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_0
    //   508: ldc_w 539
    //   511: aload_2
    //   512: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: pop
    //   516: aload_0
    //   517: ldc_w 541
    //   520: new 31	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   527: iload_1
    //   528: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: ldc 120
    //   533: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   542: pop
    //   543: aload_0
    //   544: ldc_w 543
    //   547: new 31	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   554: iload 10
    //   556: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: ldc 120
    //   561: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   570: pop
    //   571: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   574: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   577: aconst_null
    //   578: ldc_w 545
    //   581: iconst_0
    //   582: lconst_0
    //   583: lconst_0
    //   584: aload_0
    //   585: ldc 120
    //   587: iconst_0
    //   588: invokevirtual 141	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   591: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   594: invokestatic 70	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   597: astore_0
    //   598: aload_0
    //   599: ldc_w 547
    //   602: lconst_0
    //   603: invokeinterface 104 4 0
    //   608: lstore 11
    //   610: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   613: lstore 13
    //   615: aload_0
    //   616: ldc_w 549
    //   619: iconst_0
    //   620: invokeinterface 78 3 0
    //   625: iconst_1
    //   626: iadd
    //   627: istore_1
    //   628: lload 13
    //   630: lload 11
    //   632: lsub
    //   633: ldc2_w 114
    //   636: lcmp
    //   637: ifle +296 -> 933
    //   640: new 117	java/util/HashMap
    //   643: dup
    //   644: invokespecial 118	java/util/HashMap:<init>	()V
    //   647: astore_2
    //   648: aload_2
    //   649: ldc 244
    //   651: new 31	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   658: iload 4
    //   660: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: ldc 120
    //   665: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   674: pop
    //   675: aload_2
    //   676: ldc 246
    //   678: new 31	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   685: iload_3
    //   686: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: ldc 120
    //   691: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   700: pop
    //   701: aload_2
    //   702: ldc 248
    //   704: new 31	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   711: iload 6
    //   713: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: ldc 120
    //   718: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   727: pop
    //   728: aload_2
    //   729: ldc_w 551
    //   732: new 31	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   739: iload_1
    //   740: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc 120
    //   745: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   754: pop
    //   755: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   758: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   761: aconst_null
    //   762: ldc_w 553
    //   765: iconst_0
    //   766: lconst_0
    //   767: lconst_0
    //   768: aload_2
    //   769: ldc 120
    //   771: iconst_0
    //   772: invokevirtual 141	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   775: aload_0
    //   776: invokeinterface 82 1 0
    //   781: ldc_w 547
    //   784: lload 13
    //   786: invokeinterface 145 4 0
    //   791: ldc_w 549
    //   794: iconst_0
    //   795: invokeinterface 88 3 0
    //   800: invokeinterface 91 1 0
    //   805: pop
    //   806: return
    //   807: astore_2
    //   808: new 464	java/io/File
    //   811: dup
    //   812: aload_0
    //   813: invokespecial 465	java/io/File:<init>	(Ljava/lang/String;)V
    //   816: astore_2
    //   817: aload_2
    //   818: invokevirtual 556	java/io/File:exists	()Z
    //   821: istore 15
    //   823: iload 15
    //   825: ifeq +146 -> 971
    //   828: aload_2
    //   829: invokestatic 561	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   832: astore_2
    //   833: aload_2
    //   834: ifnull +11 -> 845
    //   837: aload_2
    //   838: invokestatic 565	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   841: astore_2
    //   842: goto -714 -> 128
    //   845: ldc 120
    //   847: astore_2
    //   848: goto -11 -> 837
    //   851: astore_2
    //   852: aconst_null
    //   853: astore_2
    //   854: goto -726 -> 128
    //   857: astore 16
    //   859: aload 16
    //   861: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   864: goto -721 -> 143
    //   867: astore_2
    //   868: aconst_null
    //   869: astore 16
    //   871: aload 16
    //   873: ifnull +90 -> 963
    //   876: aload 16
    //   878: invokevirtual 483	java/io/FileInputStream:close	()V
    //   881: aconst_null
    //   882: astore_2
    //   883: goto -740 -> 143
    //   886: astore_2
    //   887: aload_2
    //   888: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   891: aconst_null
    //   892: astore_2
    //   893: goto -750 -> 143
    //   896: astore_0
    //   897: aconst_null
    //   898: astore 16
    //   900: aload 16
    //   902: ifnull +8 -> 910
    //   905: aload 16
    //   907: invokevirtual 483	java/io/FileInputStream:close	()V
    //   910: aload_0
    //   911: athrow
    //   912: astore_2
    //   913: aload_2
    //   914: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   917: goto -7 -> 910
    //   920: iconst_1
    //   921: istore_1
    //   922: goto -757 -> 165
    //   925: sipush 1001
    //   928: istore 6
    //   930: goto -728 -> 202
    //   933: aload_0
    //   934: invokeinterface 82 1 0
    //   939: ldc_w 549
    //   942: iload_1
    //   943: invokeinterface 88 3 0
    //   948: invokeinterface 91 1 0
    //   953: pop
    //   954: return
    //   955: astore_0
    //   956: goto -56 -> 900
    //   959: astore_2
    //   960: goto -89 -> 871
    //   963: aconst_null
    //   964: astore_2
    //   965: goto -822 -> 143
    //   968: goto -825 -> 143
    //   971: aconst_null
    //   972: astore_2
    //   973: goto -845 -> 128
    //   976: iconst_m1
    //   977: istore_3
    //   978: iconst_m1
    //   979: istore 4
    //   981: goto -950 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	paramString	String
    //   0	984	1	paramInt	int
    //   0	984	2	paramQQAppInterface	QQAppInterface
    //   30	948	3	i	int
    //   24	956	4	j	int
    //   74	309	5	k	int
    //   200	729	6	m	int
    //   54	278	7	n	int
    //   60	283	8	i1	int
    //   71	340	9	i2	int
    //   173	382	10	i3	int
    //   608	23	11	l1	long
    //   613	172	13	l2	long
    //   821	3	15	bool	boolean
    //   109	199	16	localObject1	Object
    //   857	3	16	localIOException	java.io.IOException
    //   869	37	16	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   111	128	807	java/lang/UnsatisfiedLinkError
    //   828	833	851	java/io/IOException
    //   837	842	851	java/io/IOException
    //   138	143	857	java/io/IOException
    //   101	111	867	java/io/IOException
    //   876	881	886	java/io/IOException
    //   101	111	896	finally
    //   905	910	912	java/io/IOException
    //   111	128	955	finally
    //   128	133	955	finally
    //   808	823	955	finally
    //   828	833	955	finally
    //   837	842	955	finally
    //   111	128	959	java/io/IOException
    //   128	133	959	java/io/IOException
    //   808	823	959	java/io/IOException
  }
  
  private static void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    for (;;)
    {
      try
      {
        ImageUtil.a(paramString, (BitmapFactory.Options)localObject1);
        i1 = ((BitmapFactory.Options)localObject1).outWidth;
        i2 = ((BitmapFactory.Options)localObject1).outHeight;
        j = paramInt1;
        if (paramInt1 != 0)
        {
          j = paramInt1;
          if (paramInt1 != 1)
          {
            j = paramInt1;
            if (paramInt1 != 3000) {
              j = 5;
            }
          }
        }
        k = paramInt2;
        if (paramInt2 != 0)
        {
          k = paramInt2;
          if (paramInt2 != 1)
          {
            k = paramInt2;
            if (paramInt2 != 3000) {
              k = 5;
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          int i1;
          int i2;
          int j;
          int k;
          localObject1 = Environment.getExternalStorageDirectory().toString();
          if ((localObject1 != null) && (paramString.contains((CharSequence)localObject1)))
          {
            localObject1 = paramString.replace((CharSequence)localObject1, "");
            paramInt1 = ((String)localObject1).lastIndexOf("/");
            Object localObject2 = localObject1;
            if (paramInt1 != -1) {
              localObject2 = ((String)localObject1).substring(0, paramInt1);
            }
            localObject1 = ((String)localObject2).replace("/", "//");
            int i3 = Calendar.getInstance().get(11);
            paramInt2 = -1;
            localObject2 = new File(paramString);
            paramInt1 = paramInt2;
            if (!paramBoolean2)
            {
              paramInt1 = paramInt2;
              if (((File)localObject2).exists())
              {
                paramInt2 = (int)((System.currentTimeMillis() - ((File)localObject2).lastModified()) / 60000L);
                paramInt1 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt1 = 1;
                }
              }
            }
            int i;
            if (paramString.toLowerCase(Locale.US).contains("gif"))
            {
              i = 0;
              paramInt2 = i;
              int m = i2;
              int n = i1;
              if (paramString.contains(AppConstants.SDCARD_AIO_FORWARD))
              {
                paramString = paramString.split("#");
                paramInt2 = i;
                m = i2;
                n = i1;
                if (paramString.length >= 4)
                {
                  n = Integer.parseInt(paramString[1]);
                  m = Integer.parseInt(paramString[2]);
                  if (Integer.parseInt(paramString[3]) != 3) {
                    continue;
                  }
                  paramInt2 = 0;
                }
              }
              i = PhotoUtils.a(n, m);
              i1 = NetworkUtil.a(BaseApplication.getContext());
              if (QLog.isDevelopLevel()) {
                QLog.d("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic url=" + (String)localObject1 + ",uinType = " + j + ",batchCnt = " + paramInt7 + ",sizeType = " + i + ",isRAW = " + paramBoolean1 + ",isForward = " + paramBoolean2 + ",age = " + paramInt3 + ",gender = " + paramInt4 + ",reprotHour = " + i3 + ",width = " + n + ",height = " + m + ",interval = " + paramInt1 + ",suffixType = " + paramInt2 + ",nettype = " + i1 + ",forwardSourceUinType = " + k + ",urlType = " + paramInt6 + ",userType = " + paramInt5 + ",fileName = " + ((File)localObject2).getName());
              }
              paramString = new HashMap();
              paramString.put("param_sourceDetailUrl", localObject1);
              paramString.put("param_uinType", j + "");
              paramString.put("param_forwardSourceUinType", k + "");
              paramString.put("param_picSizeType", i + "");
              paramString.put("param_isForward", paramBoolean2 + "");
              paramString.put("param_age", paramInt3 + "");
              paramString.put("param_gender", paramInt4 + "");
              paramString.put("param_userType", paramInt5 + "");
              paramString.put("param_picReportHour", i3 + "");
              paramString.put("param_picInterval", paramInt1 + "");
              paramString.put("param_isRAWPic", paramBoolean1 + "");
              paramString.put("param_fileName", ((File)localObject2).getName());
              paramString.put("param_picSuffixType", paramInt2 + "");
              paramString.put("param_netType", i1 + "");
              paramString.put("param_urlType", paramInt6 + "");
              paramString.put("param_picBatchCount", paramInt7 + "");
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPhotoSourceDetailUrl", false, 0L, 0L, paramString, "", false);
              return;
              localOutOfMemoryError = localOutOfMemoryError;
              QLog.e("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic OutOfMemoryError ");
            }
            else
            {
              i = 1;
              continue;
            }
            paramInt2 = 1;
          }
          else
          {
            localObject1 = paramString;
          }
        }
        catch (Exception paramString)
        {
          return;
        }
      }
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfString == null) {}
    label196:
    do
    {
      return;
      paramQQAppInterface = (NearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      int i15 = paramArrayOfString.length;
      int i10 = -1;
      int i11 = -1;
      if (paramQQAppInterface != null)
      {
        i10 = paramQQAppInterface.a();
        i11 = paramQQAppInterface.b();
      }
      if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {}
      int i;
      int j;
      int i1;
      int m;
      int n;
      int i9;
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int i8;
      String str2;
      for (int i12 = 1002;; i12 = 1001)
      {
        i = 0;
        j = 0;
        i1 = 0;
        m = 0;
        n = 0;
        i9 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        int i16 = paramArrayOfString.length;
        int i13 = 0;
        for (;;)
        {
          if (i13 >= i16) {
            break label952;
          }
          str2 = paramArrayOfString[i13];
          if (str2 != null) {
            break;
          }
          i13 += 1;
        }
      }
      String str1 = str2.toLowerCase(Locale.US);
      String str3 = FileUtil.c(str1);
      paramQQAppInterface = null;
      try
      {
        str1 = new File(str1).getParentFile().getName();
        paramQQAppInterface = str1;
      }
      catch (Exception localException)
      {
        int k;
        int i14;
        break label196;
      }
    } while ((str3 == null) || (paramQQAppInterface == null));
    if (str3.contains("/tencent/")) {
      if (str3.contains("/qq_collection/"))
      {
        i9 += 1;
        k = j;
        i14 = 1001;
        j = i;
        i = k;
        k = i14;
      }
    }
    for (;;)
    {
      a(str2, paramInt1, paramBoolean1, paramBoolean2, paramInt2, i10, i11, i12, k, i15);
      k = j;
      j = i;
      i = k;
      break;
      if ((paramQQAppInterface.equals("qq_images")) || (str3.contains("/mobileqq/photo")) || (str3.contains("/mobileqq/diskcache")) || (str3.contains("/AIO_FORWARD/")))
      {
        i2 += 1;
        i14 = i;
        k = 1002;
        i = j;
        j = i14;
      }
      else if (paramQQAppInterface.equals("qqfile_recv"))
      {
        i3 += 1;
        i14 = i;
        k = 1003;
        i = j;
        j = i14;
      }
      else if (paramQQAppInterface.equals("qq_favorite"))
      {
        i5 += 1;
        i14 = i;
        k = 1004;
        i = j;
        j = i14;
      }
      else if (str3.contains("/zebra/cache"))
      {
        i4 += 1;
        i14 = i;
        k = 1005;
        i = j;
        j = i14;
      }
      else if ((paramQQAppInterface.equals("weixin")) || (paramQQAppInterface.equals("wechat")) || (paramQQAppInterface.equals("micromsg")))
      {
        i6 += 1;
        i14 = i;
        k = 1006;
        i = j;
        j = i14;
      }
      else if (str3.contains("/qqinput/exp/"))
      {
        i8 += 1;
        i14 = i;
        k = 1013;
        i = j;
        j = i14;
      }
      else if (a(str3))
      {
        m += 1;
        i14 = i;
        k = 1007;
        i = j;
        j = i14;
      }
      else
      {
        n += 1;
        i14 = i;
        k = 1008;
        i = j;
        j = i14;
        continue;
        if (paramQQAppInterface.equals("qq_screenshot"))
        {
          i14 = j + 1;
          j = i;
          k = 1009;
          i = i14;
        }
        else if ((str3.contains("screenshot")) || (str3.contains(HardCodeUtil.a(2131714229))) || (str3.contains(HardCodeUtil.a(2131714232))) || (str3.equals("screen_cap")) || (str3.equals("ScreenCapture")))
        {
          i1 += 1;
          i14 = i;
          k = 1010;
          i = j;
          j = i14;
        }
        else if ((paramQQAppInterface.contains("camera")) || (paramQQAppInterface.equals("dcim")) || (paramQQAppInterface.equals("100MEDIA")) || (paramQQAppInterface.equals("100ANDRO")) || (paramQQAppInterface.contains(HardCodeUtil.a(2131714228))) || (paramQQAppInterface.contains(HardCodeUtil.a(2131714231))) || (paramQQAppInterface.contains(HardCodeUtil.a(2131714230))))
        {
          k = 1011;
          i14 = i + 1;
          i = j;
          j = i14;
        }
        else if (str3.contains("/sogou/.expression/"))
        {
          i7 += 1;
          i14 = i;
          k = 1012;
          i = j;
          j = i14;
        }
        else if (a(str3))
        {
          m += 1;
          i14 = i;
          k = 1007;
          i = j;
          j = i14;
        }
        else
        {
          n += 1;
          i14 = i;
          k = 1008;
          i = j;
          j = i14;
        }
      }
    }
    label952:
    a(i, j, i1, m, n, i9, i2, i3, i4, i5, i6, i7, i8, i10, i11, i12);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "/weibo";
      arrayOfString[1] = "/sina/news/save/";
      arrayOfString[2] = "/faceq/";
      arrayOfString[3] = "/newsreader/";
      arrayOfString[4] = "/tieba";
      arrayOfString[5] = "/baidu";
      arrayOfString[6] = "/UCDownloads";
      arrayOfString[7] = "/taobao";
      arrayOfString[8] = "/news_article/";
      arrayOfString[9] = "/sohunewsdown/";
      arrayOfString[10] = "/pitu/";
      arrayOfString[11] = "/pins/";
      arrayOfString[12] = "/tumblr/";
      arrayOfString[13] = "/download";
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (paramString.contains(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendNomalCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate", 0L);
    long l2 = System.currentTimeMillis();
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i + "");
      int j = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
      localHashMap.put("param_cameraCount", j + "");
      if (j > 0) {
        localHashMap.put("param_sendPercent", i / j + "");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayCameraSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate", l2).putInt("PhotoConst.camerapreviewactivity_send_times", 0).putInt("PhotoConst.camerapreviewactivity_enter_times", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times", i).commit();
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    if (!paramIntent.hasExtra("param_initTime")) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          l = paramIntent.getLongExtra("param_initTime", 0L);
          if (l != 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("StatisticConstants", 2, "reportActPScancelSend,initTime == 0,return!");
        return;
        l = System.currentTimeMillis() - l;
      } while (l > 86400000L);
      HashMap localHashMap = new HashMap();
      int i = NetworkUtil.a(BaseApplication.getContext());
      localHashMap.put("param_netType", i + "");
      localHashMap.put("param_selNum", paramInt + "");
      localHashMap.put("param_residentTime", l + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPScancelSend", false, 0L, 0L, localHashMap, "", false);
      paramIntent.removeExtra("param_initTime");
      paramIntent.removeExtra("param_cancelSelNum");
      paramIntent.removeExtra("param_totalSelNum");
    } while (!QLog.isColorLevel());
    QLog.d("StatisticConstants", 2, "reportActPScancelSend,param_residentTime =" + l + ",param_selNum = " + paramInt);
  }
  
  public static void c()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times_fast", i + 1).commit();
  }
  
  public static void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StatisticConstants", 4, "sendFastImageCameraPreviewStatistic ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = localSharedPreferences.getLong("PhotoConst.last_send_camera_preview_rate_fast", 0L);
    long l2 = System.currentTimeMillis();
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_send_times_fast", 0) + 1;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_sendCount", i + "");
      int j = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
      localHashMap.put("param_browseCount", j + "");
      if (j > 0) {
        localHashMap.put("param_sendPercent", i / j + "");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayQuickSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate_fast", l2).putInt("PhotoConst.camerapreviewactivity_send_times_fast", 0).putInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times_fast", i).commit();
  }
  
  public static void e()
  {
    HashMap localHashMap = new HashMap();
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {}
    for (int i = 1002;; i = 1001)
    {
      int j = NetworkUtil.a(BaseApplication.getContext());
      int k = a();
      localHashMap.put("param_netType", j + "");
      localHashMap.put("param_phone_type", k + "");
      localHashMap.put("param_userType", i + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSCompressTimeOut", false, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportPresendCompressTimeOut");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.StatisticConstants
 * JD-Core Version:    0.7.0.1
 */