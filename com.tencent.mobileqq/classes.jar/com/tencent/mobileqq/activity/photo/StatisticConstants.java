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
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.PhotoReportUtils;
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
  public static void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    int i = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_enter_times", i + 1).commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPhotoPreviewSelectRateStatistic (");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ,");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(")");
      QLog.d("StatisticConstants", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = ((SharedPreferences)localObject).getLong("PhotoConst.last_send_select_rate_time_preview", 0L);
      long l2 = System.currentTimeMillis();
      paramInt1 = ((SharedPreferences)localObject).getInt("PhotoConst.photopreviewactivity_send_pic_count", 0) + paramInt1;
      paramInt2 = ((SharedPreferences)localObject).getInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0) + paramInt2;
      if (l2 - l1 > 86400000L)
      {
        HashMap localHashMap = new HashMap();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("");
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_count", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt1 / paramInt2);
        localStringBuilder.append("");
        localHashMap.put("PhotoConst.photopreviewactivity_send_pic_rate", localStringBuilder.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PhotoConst.photopreviewactivity_send", false, 0L, 0L, localHashMap, "", false);
        ((SharedPreferences)localObject).edit().putLong("PhotoConst.last_send_select_rate_time_preview", l2).putInt("PhotoConst.photopreviewactivity_send_pic_count", 0).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", 0).commit();
        return;
      }
      ((SharedPreferences)localObject).edit().putInt("PhotoConst.photopreviewactivity_send_pic_count", paramInt1).putInt("PhotoConst.photopreviewactivity_send_pic_total_count", paramInt2).commit();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPhotoListSourceTypeStatistic (");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt6);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt7);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt8);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt9);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt10);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt11);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt12);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt13);
      ((StringBuilder)localObject).append("),age = ");
      ((StringBuilder)localObject).append(paramInt14);
      ((StringBuilder)localObject).append(",gender = ");
      ((StringBuilder)localObject).append(paramInt15);
      ((StringBuilder)localObject).append(",userType = ");
      ((StringBuilder)localObject).append(paramInt16);
      QLog.d("StatisticConstants", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = ((SharedPreferences)localObject).getLong("PhotoConst.last_send_pic_source_type", 0L);
    long l2 = System.currentTimeMillis();
    paramInt1 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_systemalbum_send_count", 0) + paramInt1;
    paramInt2 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0) + paramInt2;
    paramInt3 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0) + paramInt3;
    paramInt5 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_other_send_count", 0) + paramInt5;
    paramInt4 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_app_send_count", 0) + paramInt4;
    paramInt6 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_qq_collection_send_count", 0) + paramInt6;
    paramInt7 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_qq_image_send_count", 0) + paramInt7;
    paramInt8 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0) + paramInt8;
    paramInt9 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0) + paramInt9;
    paramInt10 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0) + paramInt10;
    paramInt11 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_weixin_send_count", 0) + paramInt11;
    paramInt12 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_sougou_send_count", 0) + paramInt12;
    paramInt13 = ((SharedPreferences)localObject).getInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0) + paramInt13;
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("");
      localHashMap.put("param_systemAlbumSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("");
      localHashMap.put("param_screnshotQQSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("");
      localHashMap.put("param_screnshotOtherSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("");
      localHashMap.put("param_otherSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("");
      localHashMap.put("param_appSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt6);
      localStringBuilder.append("");
      localHashMap.put("param_qq_collection_SendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt7);
      localStringBuilder.append("");
      localHashMap.put("param_qq_image_SendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt8);
      localStringBuilder.append("");
      localHashMap.put("param_qq_filerecv_SendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt9);
      localStringBuilder.append("");
      localHashMap.put("param_qq_zebra_SendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt10);
      localStringBuilder.append("");
      localHashMap.put("param_qq_favorite_SendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt11);
      localStringBuilder.append("");
      localHashMap.put("param_weixinSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt12);
      localStringBuilder.append("");
      localHashMap.put("param_sougouSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt13);
      localStringBuilder.append("");
      localHashMap.put("param_qqpinyinSendCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt14);
      localStringBuilder.append("");
      localHashMap.put("param_age", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt15);
      localStringBuilder.append("");
      localHashMap.put("param_gender", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt16);
      localStringBuilder.append("");
      localHashMap.put("param_userType", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actDaySendPicSourceType", false, 0L, 0L, localHashMap, "", false);
      ((SharedPreferences)localObject).edit().putLong("PhotoConst.last_send_pic_source_type", l2).putInt("PhotoConst.photolistactivity_systemalbum_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", 0).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", 0).putInt("PhotoConst.photolistactivity_other_send_count", 0).putInt("PhotoConst.photolistactivity_app_send_count", 0).putInt("PhotoConst.photolistactivity_qq_collection_send_count", 0).putInt("PhotoConst.photolistactivity_qq_image_send_count", 0).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", 0).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", 0).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", 0).putInt("PhotoConst.photolistactivity_weixin_send_count", 0).putInt("PhotoConst.photolistactivity_sougou_send_count", 0).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", 0).commit();
      return;
    }
    ((SharedPreferences)localObject).edit().putInt("PhotoConst.photolistactivity_systemalbum_send_count", paramInt1).putInt("PhotoConst.photolistactivity_screnshot_qq_send_count", paramInt2).putInt("PhotoConst.photolistactivity_screnshot_other_send_count", paramInt3).putInt("PhotoConst.photolistactivity_other_send_count", paramInt5).putInt("PhotoConst.photolistactivity_app_send_count", paramInt4).putInt("PhotoConst.photolistactivity_qq_collection_send_count", paramInt6).putInt("PhotoConst.photolistactivity_qq_image_send_count", paramInt7).putInt("PhotoConst.photolistactivity_qq_filerecv_send_count", paramInt8).putInt("PhotoConst.photolistactivity_qq_zebra_send_count", paramInt9).putInt("PhotoConst.photolistactivity_qq_favorite_send_count", paramInt10).putInt("PhotoConst.photolistactivity_weixin_send_count", paramInt11).putInt("PhotoConst.photolistactivity_sougou_send_count", paramInt12).putInt("PhotoConst.photolistactivity_qqpinyin_send_count", paramInt13).commit();
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportActPSdayWastedSize,size <= 0,return! size = ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("StatisticConstants", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = new HashMap();
    int i;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
      i = 1002;
    } else {
      i = 1001;
    }
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int k = DeviceInfoUtil.O();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_netType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_phone_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_userType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_WasteSize", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayWastedSize", false, 0L, 0L, (HashMap)localObject, "", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportActPSdayWastedSize,WastedSize =");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("StatisticConstants", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    Object localObject = new HashMap();
    int i;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
      i = 1002;
    } else {
      i = 1001;
    }
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int k = DeviceInfoUtil.O();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_netType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_phone_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_userType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_WasteSize", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((HashMap)localObject).put("param_cancelType", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSWaste", false, 0L, 0L, (HashMap)localObject, "", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportActPSWaste,size = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",cancelType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("StatisticConstants", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = new HashMap();
    if ((paramLong != 0L) && (paramInt != 0) && (paramLong <= 86400000L))
    {
      long l = paramLong / paramInt;
      int j = DeviceInfoUtil.O();
      int i;
      if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
        i = 1002;
      } else {
        i = 1001;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_userType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_phone_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_consumTime", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_selNum", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_showing_progress", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_averageTime", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdonecompressPic", false, 0L, 0L, (HashMap)localObject, "", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportActPSdonecompressPic,param_consumTime =");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(",param_selNum = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(",param_averageTime = ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(",isShowing = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("StatisticConstants", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "reportActPSdonecompressPic,invalid arg,return!");
    }
  }
  
  public static void a(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    long l1 = 0L;
    long l2 = paramIntent.getLongExtra("param_compressInitTime", 0L);
    if (l2 == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScompressPic,initTime == 0,return!");
      }
      return;
    }
    l2 = System.currentTimeMillis() - l2;
    if (l2 > 86400000L) {
      return;
    }
    int i = paramIntent.getIntExtra("param_selNum", 0);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScompressPic,param_selNum == 0,return!");
      }
      return;
    }
    if (i > 0) {
      l1 = l2 / i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l2);
    localStringBuilder.append("");
    localHashMap.put("param_consumTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localHashMap.put("param_selNum", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("");
    localHashMap.put("param_averageTime", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPScompressPic", false, 0L, 0L, localHashMap, "", false);
    paramIntent.removeExtra("param_compressInitTime");
    paramIntent.removeExtra("param_selNum");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("reportActPScompressPic,param_consumTime =");
      paramIntent.append(l2);
      paramIntent.append(",param_selNum = ");
      paramIntent.append(i);
      paramIntent.append(",param_averageTime = ");
      paramIntent.append(l1);
      QLog.d("StatisticConstants", 2, paramIntent.toString());
    }
  }
  
  public static void a(Intent paramIntent, int paramInt)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPhotoListSelectRateStatistic (");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(")");
      QLog.d("StatisticConstants", 4, ((StringBuilder)localObject).toString());
    }
    int i = paramIntent.getIntExtra("param_totalSelNum", 0);
    if ((paramInt > 0) && (i > 0))
    {
      paramIntent = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      long l1 = paramIntent.getLong("PhotoConst.last_send_select_rate_time", 0L);
      long l2 = System.currentTimeMillis();
      paramInt = paramIntent.getInt("PhotoConst.photolistactivity_pic_count", 0) + paramInt;
      i = paramIntent.getInt("PhotoConst.photolistactivity_pic_total_count", 0) + i;
      if (l2 - l1 > 86400000L)
      {
        localObject = new HashMap();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        ((HashMap)localObject).put("param_sendCount", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ((HashMap)localObject).put("param_selCount", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / i);
        localStringBuilder.append("");
        ((HashMap)localObject).put("param_sendPercent", localStringBuilder.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdaySelSend", false, 0L, 0L, (HashMap)localObject, "", false);
        paramIntent.edit().putLong("PhotoConst.last_send_select_rate_time", l2).putInt("PhotoConst.photolistactivity_pic_count", 0).putInt("PhotoConst.photolistactivity_pic_total_count", 0).commit();
        return;
      }
      paramIntent.edit().putInt("PhotoConst.photolistactivity_pic_count", paramInt).putInt("PhotoConst.photolistactivity_pic_total_count", i).commit();
    }
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    long l2 = paramIntent.getLongExtra("param_initTime", 0L);
    if (l2 == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPSselectSendPic,initTime == 0,return!");
      }
      return;
    }
    l2 = System.currentTimeMillis() - l2;
    if (l2 > 86400000L) {
      return;
    }
    if (paramInt1 > 0) {
      l1 = l2 / paramInt1;
    }
    int i = paramIntent.getIntExtra("param_cancelSelNum", 0);
    HashMap localHashMap = new HashMap();
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    localHashMap.put("param_netType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    localHashMap.put("param_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localHashMap.put("param_cancelSelNum", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l2);
    localStringBuilder.append("");
    localHashMap.put("param_consumTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localHashMap.put("param_selNum", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("");
    localHashMap.put("param_averageTime", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSselectSendPic", false, 0L, 0L, localHashMap, "", false);
    paramIntent.removeExtra("param_initTime");
    paramIntent.removeExtra("param_cancelSelNum");
    paramIntent.removeExtra("param_totalSelNum");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("reportActPSselectSendPic,param_type =");
      paramIntent.append(paramInt2);
      paramIntent.append(",param_cancelSelNum = ");
      paramIntent.append(i);
      paramIntent.append(",param_consumTime = ");
      paramIntent.append(l2);
      paramIntent.append(",param_selNum = ");
      paramIntent.append(paramInt1);
      paramIntent.append(",param_averageTime = ");
      paramIntent.append(l1);
      QLog.d("StatisticConstants", 2, paramIntent.toString());
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("incrementStatisticParam(");
      localStringBuilder.append(paramString);
      QLog.d("StatisticConstants", 4, localStringBuilder.toString());
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
    //   6: getstatic 359	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   9: invokevirtual 365	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12: checkcast 367	com/tencent/mobileqq/nearby/INearbyCardManager
    //   15: astore_2
    //   16: iconst_m1
    //   17: istore 4
    //   19: aload_2
    //   20: ifnull +21 -> 41
    //   23: aload_2
    //   24: invokeinterface 370 1 0
    //   29: istore 4
    //   31: aload_2
    //   32: invokeinterface 373 1 0
    //   37: istore_3
    //   38: goto +5 -> 43
    //   41: iconst_m1
    //   42: istore_3
    //   43: new 375	android/graphics/BitmapFactory$Options
    //   46: dup
    //   47: invokespecial 376	android/graphics/BitmapFactory$Options:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: iconst_1
    //   53: putfield 380	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   56: aload_0
    //   57: aload_2
    //   58: invokestatic 385	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: pop
    //   62: aload_2
    //   63: getfield 388	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 6
    //   68: aload_2
    //   69: getfield 391	android/graphics/BitmapFactory$Options:outHeight	I
    //   72: istore 7
    //   74: iload_1
    //   75: ifeq +20 -> 95
    //   78: iload_1
    //   79: iconst_1
    //   80: if_icmpeq +15 -> 95
    //   83: iload_1
    //   84: sipush 3000
    //   87: if_icmpeq +8 -> 95
    //   90: iconst_5
    //   91: istore_1
    //   92: goto +3 -> 95
    //   95: aconst_null
    //   96: astore 17
    //   98: aconst_null
    //   99: astore 18
    //   101: new 393	java/io/FileInputStream
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 395	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   109: astore 15
    //   111: aload 15
    //   113: new 397	java/io/File
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 398	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 401	java/io/File:length	()J
    //   124: invokestatic 407	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   127: astore_2
    //   128: goto +52 -> 180
    //   131: astore_0
    //   132: goto +82 -> 214
    //   135: goto +102 -> 237
    //   138: new 397	java/io/File
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 398	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual 410	java/io/File:exists	()Z
    //   151: istore 10
    //   153: iload 10
    //   155: ifeq +23 -> 178
    //   158: aload_2
    //   159: invokestatic 415	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +930 -> 1094
    //   167: goto +3 -> 170
    //   170: aload_2
    //   171: invokestatic 421	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   174: astore_2
    //   175: goto +5 -> 180
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_2
    //   181: invokestatic 425	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   184: astore 16
    //   186: aload 16
    //   188: astore_2
    //   189: aload 15
    //   191: invokevirtual 428	java/io/FileInputStream:close	()V
    //   194: aload 16
    //   196: astore_2
    //   197: goto +59 -> 256
    //   200: astore 15
    //   202: aload 15
    //   204: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   207: goto +49 -> 256
    //   210: astore_0
    //   211: aconst_null
    //   212: astore 15
    //   214: aload 15
    //   216: ifnull +16 -> 232
    //   219: aload 15
    //   221: invokevirtual 428	java/io/FileInputStream:close	()V
    //   224: goto +8 -> 232
    //   227: astore_2
    //   228: aload_2
    //   229: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: athrow
    //   234: aconst_null
    //   235: astore 15
    //   237: aload 17
    //   239: astore_2
    //   240: aload 15
    //   242: ifnull +14 -> 256
    //   245: aload 18
    //   247: astore_2
    //   248: aload 15
    //   250: invokevirtual 428	java/io/FileInputStream:close	()V
    //   253: aload 17
    //   255: astore_2
    //   256: aload_0
    //   257: invokestatic 437	com/tencent/mobileqq/utils/FileUtils:estimateFileType	(Ljava/lang/String;)Ljava/lang/String;
    //   260: astore 15
    //   262: aload 15
    //   264: invokevirtual 442	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   267: ldc_w 444
    //   270: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: iconst_1
    //   274: ixor
    //   275: istore 8
    //   277: invokestatic 453	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   280: bipush 11
    //   282: invokevirtual 457	java/util/Calendar:get	(I)I
    //   285: istore 9
    //   287: ldc 208
    //   289: invokestatic 214	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   292: checkcast 208	com/tencent/mobileqq/dpc/api/IDPCApi
    //   295: getstatic 220	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:picpredownload_whitelist	Lcom/tencent/mobileqq/dpc/enumname/DPCAccountNames;
    //   298: invokevirtual 223	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:name	()Ljava/lang/String;
    //   301: invokeinterface 227 2 0
    //   306: ifeq +11 -> 317
    //   309: sipush 1002
    //   312: istore 5
    //   314: goto +8 -> 322
    //   317: sipush 1001
    //   320: istore 5
    //   322: invokestatic 128	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   325: ifeq +223 -> 548
    //   328: new 52	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   335: astore 16
    //   337: aload 16
    //   339: ldc_w 459
    //   342: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 16
    //   348: aload_0
    //   349: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 16
    //   355: ldc_w 461
    //   358: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 16
    //   364: iload_1
    //   365: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 16
    //   371: ldc_w 463
    //   374: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 16
    //   380: iload 4
    //   382: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 16
    //   388: ldc 136
    //   390: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 16
    //   396: iload_3
    //   397: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 16
    //   403: ldc_w 465
    //   406: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 16
    //   412: iload 9
    //   414: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 16
    //   420: ldc_w 467
    //   423: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 16
    //   429: aload_2
    //   430: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 16
    //   436: ldc_w 469
    //   439: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 16
    //   445: iload 8
    //   447: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 16
    //   453: ldc_w 471
    //   456: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 16
    //   462: aload 15
    //   464: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 16
    //   470: ldc_w 473
    //   473: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 16
    //   479: aload_0
    //   480: invokestatic 476	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   483: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 16
    //   489: ldc_w 478
    //   492: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 16
    //   498: iload 6
    //   500: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 16
    //   506: ldc_w 480
    //   509: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 16
    //   515: iload 7
    //   517: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 16
    //   523: ldc 138
    //   525: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 16
    //   531: iload 5
    //   533: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: ldc 68
    //   539: iconst_4
    //   540: aload 16
    //   542: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: new 96	java/util/HashMap
    //   551: dup
    //   552: invokespecial 97	java/util/HashMap:<init>	()V
    //   555: astore_0
    //   556: new 52	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   563: astore 15
    //   565: aload 15
    //   567: iload_1
    //   568: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 15
    //   574: ldc 99
    //   576: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload_0
    //   581: ldc_w 482
    //   584: aload 15
    //   586: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: pop
    //   593: new 52	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   600: astore 15
    //   602: aload 15
    //   604: iload 4
    //   606: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 15
    //   612: ldc 99
    //   614: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload_0
    //   619: ldc 194
    //   621: aload 15
    //   623: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   629: pop
    //   630: new 52	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   637: astore 15
    //   639: aload 15
    //   641: iload_3
    //   642: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 15
    //   648: ldc 99
    //   650: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload_0
    //   655: ldc 196
    //   657: aload 15
    //   659: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   665: pop
    //   666: new 52	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   673: astore 15
    //   675: aload 15
    //   677: iload 5
    //   679: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 15
    //   685: ldc 99
    //   687: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload_0
    //   692: ldc 198
    //   694: aload 15
    //   696: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   702: pop
    //   703: aload_0
    //   704: ldc_w 484
    //   707: aload_2
    //   708: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   711: pop
    //   712: new 52	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   719: astore_2
    //   720: aload_2
    //   721: iload 8
    //   723: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload_2
    //   728: ldc 99
    //   730: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_0
    //   735: ldc_w 486
    //   738: aload_2
    //   739: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   745: pop
    //   746: new 52	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   753: astore_2
    //   754: aload_2
    //   755: iload 9
    //   757: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_2
    //   762: ldc 99
    //   764: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload_0
    //   769: ldc_w 488
    //   772: aload_2
    //   773: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   779: pop
    //   780: invokestatic 16	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   783: invokestatic 114	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   786: aconst_null
    //   787: ldc_w 490
    //   790: iconst_0
    //   791: lconst_0
    //   792: lconst_0
    //   793: aload_0
    //   794: ldc 99
    //   796: iconst_0
    //   797: invokevirtual 120	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   800: invokestatic 16	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   803: invokestatic 22	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   806: astore_0
    //   807: aload_0
    //   808: ldc_w 492
    //   811: lconst_0
    //   812: invokeinterface 82 4 0
    //   817: lstore 11
    //   819: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   822: lstore 13
    //   824: aload_0
    //   825: ldc_w 494
    //   828: iconst_0
    //   829: invokeinterface 30 3 0
    //   834: iconst_1
    //   835: iadd
    //   836: istore_1
    //   837: lload 13
    //   839: lload 11
    //   841: lsub
    //   842: ldc2_w 93
    //   845: lcmp
    //   846: ifle +210 -> 1056
    //   849: new 96	java/util/HashMap
    //   852: dup
    //   853: invokespecial 97	java/util/HashMap:<init>	()V
    //   856: astore_2
    //   857: new 52	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   864: astore 15
    //   866: aload 15
    //   868: iload 4
    //   870: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload 15
    //   876: ldc 99
    //   878: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload_2
    //   883: ldc 194
    //   885: aload 15
    //   887: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   893: pop
    //   894: new 52	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   901: astore 15
    //   903: aload 15
    //   905: iload_3
    //   906: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload 15
    //   912: ldc 99
    //   914: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload_2
    //   919: ldc 196
    //   921: aload 15
    //   923: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   929: pop
    //   930: new 52	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   937: astore 15
    //   939: aload 15
    //   941: iload 5
    //   943: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload 15
    //   949: ldc 99
    //   951: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload_2
    //   956: ldc 198
    //   958: aload 15
    //   960: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   963: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   966: pop
    //   967: new 52	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   974: astore 15
    //   976: aload 15
    //   978: iload_1
    //   979: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload 15
    //   985: ldc 99
    //   987: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: aload_2
    //   992: ldc_w 496
    //   995: aload 15
    //   997: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1000: invokevirtual 103	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1003: pop
    //   1004: invokestatic 16	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1007: invokestatic 114	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1010: aconst_null
    //   1011: ldc_w 498
    //   1014: iconst_0
    //   1015: lconst_0
    //   1016: lconst_0
    //   1017: aload_2
    //   1018: ldc 99
    //   1020: iconst_0
    //   1021: invokevirtual 120	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1024: aload_0
    //   1025: invokeinterface 34 1 0
    //   1030: ldc_w 492
    //   1033: lload 13
    //   1035: invokeinterface 124 4 0
    //   1040: ldc_w 494
    //   1043: iconst_0
    //   1044: invokeinterface 40 3 0
    //   1049: invokeinterface 44 1 0
    //   1054: pop
    //   1055: return
    //   1056: aload_0
    //   1057: invokeinterface 34 1 0
    //   1062: ldc_w 494
    //   1065: iload_1
    //   1066: invokeinterface 40 3 0
    //   1071: invokeinterface 44 1 0
    //   1076: pop
    //   1077: return
    //   1078: astore_2
    //   1079: goto -845 -> 234
    //   1082: astore_2
    //   1083: goto -945 -> 138
    //   1086: astore_2
    //   1087: goto -952 -> 135
    //   1090: astore_2
    //   1091: goto -913 -> 178
    //   1094: ldc 99
    //   1096: astore_2
    //   1097: goto -927 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1100	0	paramString	String
    //   0	1100	1	paramInt	int
    //   0	1100	2	paramQQAppInterface	QQAppInterface
    //   37	869	3	i	int
    //   17	852	4	j	int
    //   312	630	5	k	int
    //   66	433	6	m	int
    //   72	444	7	n	int
    //   275	447	8	i1	int
    //   285	471	9	i2	int
    //   151	3	10	bool	boolean
    //   817	23	11	l1	long
    //   822	212	13	l2	long
    //   109	81	15	localFileInputStream	java.io.FileInputStream
    //   200	3	15	localIOException	java.io.IOException
    //   212	784	15	localObject1	Object
    //   184	357	16	localObject2	Object
    //   96	158	17	localObject3	Object
    //   99	147	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   111	128	131	finally
    //   138	153	131	finally
    //   158	163	131	finally
    //   170	175	131	finally
    //   180	186	131	finally
    //   189	194	200	java/io/IOException
    //   248	253	200	java/io/IOException
    //   101	111	210	finally
    //   219	224	227	java/io/IOException
    //   101	111	1078	java/io/IOException
    //   111	128	1082	java/lang/UnsatisfiedLinkError
    //   111	128	1086	java/io/IOException
    //   138	153	1086	java/io/IOException
    //   180	186	1086	java/io/IOException
    //   158	163	1090	java/io/IOException
    //   170	175	1090	java/io/IOException
  }
  
  private static void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramString == null) {
      return;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    try
    {
      ImageUtil.a(paramString, (BitmapFactory.Options)localObject1);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        try
        {
          int n;
          int i;
          int j;
          localObject1 = Environment.getExternalStorageDirectory().toString();
          if ((localObject1 == null) || (!paramString.contains((CharSequence)localObject1))) {
            break;
          }
          localObject1 = paramString.replace((CharSequence)localObject1, "");
          paramInt2 = ((String)localObject1).lastIndexOf("/");
          paramInt1 = -1;
          localObject2 = localObject1;
          if (paramInt2 != -1) {
            localObject2 = ((String)localObject1).substring(0, paramInt2);
          }
          localObject2 = ((String)localObject2).replace("/", "//");
          i1 = Calendar.getInstance().get(11);
          localObject1 = new File(paramString);
          if ((!paramBoolean2) && (((File)localObject1).exists()))
          {
            paramInt2 = (int)((System.currentTimeMillis() - ((File)localObject1).lastModified()) / 60000L);
            paramInt1 = paramInt2;
            if (paramInt2 == 0) {
              paramInt1 = 1;
            }
          }
          bool = paramString.toLowerCase(Locale.US).contains("gif") ^ true;
          if (paramString.contains(AppConstants.SDCARD_AIO_FORWARD))
          {
            paramString = paramString.split("#");
            if (paramString.length >= 4)
            {
              n = Integer.parseInt(paramString[1]);
              k = Integer.parseInt(paramString[2]);
              if (Integer.parseInt(paramString[3]) == 3) {
                paramInt2 = 0;
              } else {
                paramInt2 = 1;
              }
              m = paramInt2;
              continue;
            }
          }
          paramInt2 = k;
          int k = paramInt2;
          paramInt2 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
          if (QLog.isDevelopLevel())
          {
            paramString = new StringBuilder();
            paramString.append("sendPhotoSourceDetailUrlStatistic url=");
            paramString.append((String)localObject2);
            paramString.append(",uinType = ");
            paramString.append(i);
            paramString.append(",batchCnt = ");
            paramString.append(paramInt7);
            paramString.append(",isRAW = ");
            paramString.append(paramBoolean1);
            paramString.append(",isForward = ");
            paramString.append(paramBoolean2);
            paramString.append(",age = ");
            paramString.append(paramInt3);
            paramString.append(",gender = ");
            paramString.append(paramInt4);
            paramString.append(",reprotHour = ");
            paramString.append(i1);
            paramString.append(",width = ");
            paramString.append(n);
            paramString.append(",height = ");
            paramString.append(k);
            paramString.append(",interval = ");
            paramString.append(paramInt1);
            paramString.append(",suffixType = ");
            paramString.append(m);
            paramString.append(",nettype = ");
            paramString.append(paramInt2);
            paramString.append(",forwardSourceUinType = ");
            paramString.append(j);
            paramString.append(",urlType = ");
            paramString.append(paramInt6);
            paramString.append(",userType = ");
            paramString.append(paramInt5);
            paramString.append(",fileName = ");
            paramString.append(((File)localObject1).getName());
            QLog.d("StatisticConstants", 4, paramString.toString());
          }
          paramString = new HashMap();
          paramString.put("param_sourceDetailUrl", localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_uinType", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_forwardSourceUinType", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramBoolean2);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_isForward", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt3);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_age", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt4);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_gender", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt5);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_userType", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_picReportHour", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_picInterval", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramBoolean1);
          ((StringBuilder)localObject2).append("");
          paramString.put("param_isRAWPic", ((StringBuilder)localObject2).toString());
          paramString.put("param_fileName", ((File)localObject1).getName());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(m);
          ((StringBuilder)localObject1).append("");
          paramString.put("param_picSuffixType", ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append("");
          paramString.put("param_netType", ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt6);
          ((StringBuilder)localObject1).append("");
          paramString.put("param_urlType", ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt7);
          ((StringBuilder)localObject1).append("");
          paramString.put("param_picBatchCount", ((StringBuilder)localObject1).toString());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPhotoSourceDetailUrl", false, 0L, 0L, paramString, "", false);
          return;
        }
        catch (Exception paramString)
        {
          return;
        }
        localOutOfMemoryError = localOutOfMemoryError;
      }
    }
    QLog.e("StatisticConstants", 4, "sendPhotoSourceDetailUrlStatistic OutOfMemoryError ");
    n = ((BitmapFactory.Options)localObject1).outWidth;
    k = ((BitmapFactory.Options)localObject1).outHeight;
    i = paramInt1;
    if (paramInt1 != 0)
    {
      i = paramInt1;
      if (paramInt1 != 1)
      {
        i = paramInt1;
        if (paramInt1 != 3000) {
          i = 5;
        }
      }
    }
    j = paramInt2;
    if (paramInt2 != 0)
    {
      j = paramInt2;
      if (paramInt2 != 1)
      {
        j = paramInt2;
        if (paramInt2 != 3000) {
          j = 5;
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      int i1;
      boolean bool;
      int m;
      localObject1 = paramString;
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfString == null) {
      return;
    }
    paramQQAppInterface = (INearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    int i16 = paramArrayOfString.length;
    int i10;
    int i11;
    if (paramQQAppInterface != null)
    {
      i10 = paramQQAppInterface.b();
      i11 = paramQQAppInterface.c();
    }
    else
    {
      i10 = -1;
      i11 = -1;
    }
    int i12;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
      i12 = 1002;
    } else {
      i12 = 1001;
    }
    int i17 = paramArrayOfString.length;
    int i8 = 0;
    int m = 0;
    int i7 = 0;
    int i13 = 0;
    int i6 = 0;
    int i4 = 0;
    int i5 = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (i13 < i17)
    {
      String str2 = paramArrayOfString[i13];
      String str1;
      String str3;
      if (str2 != null)
      {
        str1 = str2.toLowerCase(Locale.US);
        str3 = FileUtil.c(str1);
        paramQQAppInterface = null;
      }
      try
      {
        str1 = new File(str1).getParentFile().getName();
        paramQQAppInterface = str1;
      }
      catch (Exception localException)
      {
        label197:
        boolean bool;
        int i15;
        int i14;
        int i9;
        label574:
        label708:
        label985:
        break label197;
      }
      if (str3 != null)
      {
        if (paramQQAppInterface == null) {
          return;
        }
        bool = str3.contains("/tencent/");
        i15 = 1008;
        if (bool)
        {
          if (str3.contains("/qq_collection/"))
          {
            i5 += 1;
            i14 = i;
            i = 1001;
            i9 = m;
            m = i;
            i = k;
            k = i14;
          }
          else if ((!paramQQAppInterface.equals("qq_images")) && (!str3.contains("/mobileqq/photo")) && (!str3.contains("/mobileqq/diskcache")) && (!str3.contains("/AIO_FORWARD/")))
          {
            if (paramQQAppInterface.equals("qqfile_recv"))
            {
              i2 += 1;
              i14 = i;
              i = 1003;
              i9 = m;
              m = i;
              i = k;
              k = i14;
            }
            else if (paramQQAppInterface.equals("qq_favorite"))
            {
              n += 1;
              i14 = i;
              i = 1004;
              i9 = m;
              m = i;
              i = k;
              k = i14;
            }
            else if (str3.contains("/zebra/cache"))
            {
              i1 += 1;
              i14 = i;
              i = 1005;
              i9 = m;
              m = i;
              i = k;
              k = i14;
            }
            else if ((!paramQQAppInterface.equals("weixin")) && (!paramQQAppInterface.equals("wechat")) && (!paramQQAppInterface.equals("micromsg")))
            {
              if (str3.contains("/qqinput/exp/"))
              {
                i14 = i + 1;
                i = 1013;
                i9 = m;
                m = i;
                i = k;
                k = i14;
              }
              else if (PhotoReportUtils.a(str3))
              {
                i6 += 1;
                i14 = i;
                i = 1007;
                i9 = m;
                m = i;
                i = k;
                k = i14;
              }
              else
              {
                i4 += 1;
                i14 = i;
                i9 = m;
                m = i15;
                i = k;
                k = i14;
              }
            }
            else
            {
              i14 = k + 1;
              k = i;
              i = 1006;
              i9 = m;
              m = i;
              i = i14;
            }
          }
          else
          {
            i3 += 1;
            i14 = i;
            i = 1002;
            i9 = m;
            m = i;
            i = k;
            k = i14;
          }
        }
        else
        {
          if (!paramQQAppInterface.equals("qq_screenshot")) {
            break label708;
          }
          i9 = m + 1;
          m = k;
          i14 = 1009;
          k = i;
          i = m;
          m = i14;
        }
        for (;;)
        {
          break label985;
          if ((!str3.contains("screenshot")) && (!str3.contains(HardCodeUtil.a(2131911686))) && (!str3.contains(HardCodeUtil.a(2131911689))) && (!str3.equals("screen_cap")) && (!str3.equals("ScreenCapture")))
          {
            if ((!paramQQAppInterface.contains("camera")) && (!paramQQAppInterface.equals("dcim")) && (!paramQQAppInterface.equals("100MEDIA")) && (!paramQQAppInterface.equals("100ANDRO")) && (!paramQQAppInterface.contains(HardCodeUtil.a(2131911685))) && (!paramQQAppInterface.contains(HardCodeUtil.a(2131911688))) && (!paramQQAppInterface.contains(HardCodeUtil.a(2131911687))))
            {
              if (str3.contains("/sogou/.expression/"))
              {
                j += 1;
                i14 = i;
                i = 1012;
                i9 = m;
                m = i;
                i = k;
                k = i14;
                continue;
              }
              if (!PhotoReportUtils.a(str3)) {
                break label574;
              }
              break;
            }
            i8 += 1;
            i14 = i;
            i = 1011;
            i9 = m;
            m = i;
            i = k;
            k = i14;
            continue;
          }
          i7 += 1;
          i14 = i;
          i = 1010;
          i9 = m;
          m = i;
          i = k;
          k = i14;
        }
        a(str2, paramInt1, paramBoolean1, paramBoolean2, paramInt2, i10, i11, i12, m, i16);
        m = i;
        i = k;
        k = m;
        m = i9;
        i13 += 1;
      }
      else
      {
        return;
      }
    }
    a(i8, m, i7, i6, i4, i5, i3, i2, i1, n, k, j, i, i10, i11, i12);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      localHashMap.put("param_sendCount", localStringBuilder.toString());
      int j = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times", 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("");
      localHashMap.put("param_cameraCount", localStringBuilder.toString());
      if (j > 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i / j);
        localStringBuilder.append("");
        localHashMap.put("param_sendPercent", localStringBuilder.toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdayCameraSend", false, 0L, 0L, localHashMap, "", false);
      localSharedPreferences.edit().putLong("PhotoConst.last_send_camera_preview_rate", l2).putInt("PhotoConst.camerapreviewactivity_send_times", 0).putInt("PhotoConst.camerapreviewactivity_enter_times", 0).commit();
      return;
    }
    localSharedPreferences.edit().putInt("PhotoConst.camerapreviewactivity_send_times", i).commit();
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    if (!paramIntent.hasExtra("param_initTime")) {
      return;
    }
    long l = paramIntent.getLongExtra("param_initTime", 0L);
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatisticConstants", 2, "reportActPScancelSend,initTime == 0,return!");
      }
      return;
    }
    l = System.currentTimeMillis() - l;
    if (l > 86400000L) {
      return;
    }
    HashMap localHashMap = new HashMap();
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localHashMap.put("param_netType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("param_selNum", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("");
    localHashMap.put("param_residentTime", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPScancelSend", false, 0L, 0L, localHashMap, "", false);
    paramIntent.removeExtra("param_initTime");
    paramIntent.removeExtra("param_cancelSelNum");
    paramIntent.removeExtra("param_totalSelNum");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("reportActPScancelSend,param_residentTime =");
      paramIntent.append(l);
      paramIntent.append(",param_selNum = ");
      paramIntent.append(paramInt);
      QLog.d("StatisticConstants", 2, paramIntent.toString());
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      localHashMap.put("param_sendCount", localStringBuilder.toString());
      int j = localSharedPreferences.getInt("PhotoConst.camerapreviewactivity_enter_times_fast", 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("");
      localHashMap.put("param_browseCount", localStringBuilder.toString());
      if (j > 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i / j);
        localStringBuilder.append("");
        localHashMap.put("param_sendPercent", localStringBuilder.toString());
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
    int i;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
      i = 1002;
    } else {
      i = 1001;
    }
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int k = DeviceInfoUtil.O();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    localHashMap.put("param_netType", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("");
    localHashMap.put("param_phone_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    localHashMap.put("param_userType", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSCompressTimeOut", false, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticConstants", 2, "reportPresendCompressTimeOut");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.StatisticConstants
 * JD-Core Version:    0.7.0.1
 */