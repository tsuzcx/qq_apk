package com.tencent.gdtad.util;

import acho;
import achr;
import achs;
import acim;
import acin;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Params;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GdtDeviceInfoHelper
{
  private static final long ANALYSIS_INTERVAL = 60000L;
  private static String TAG = "GdtDeviceInfoHelper";
  private static volatile boolean initialized;
  private static volatile Map<String, Long> mapTimeMillis = new HashMap();
  
  public static GdtDeviceInfoHelper.Result create(Context paramContext, GdtDeviceInfoHelper.Params paramParams)
  {
    if ((paramContext == null) || (paramParams == null) || (Looper.myLooper() == Looper.getMainLooper()))
    {
      localObject = TAG;
      if (paramParams != null) {}
      for (paramContext = paramParams.businessIdForAidTicketAndTaidTicket;; paramContext = null)
      {
        acho.d((String)localObject, String.format("create businessId:%s error", new Object[] { paramContext }));
        return null;
      }
    }
    acho.b(TAG, String.format("create businessId:%s", new Object[] { paramParams.businessIdForAidTicketAndTaidTicket }));
    long l = System.currentTimeMillis();
    acim.a().a(paramContext, new acin());
    Object localObject = new GdtDeviceInfoHelper.Result();
    ((GdtDeviceInfoHelper.Result)localObject).deviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    fillDeviceInfo(paramContext, paramParams, (GdtDeviceInfoHelper.Result)localObject);
    fillDeviceInfoWithOthers(paramContext, paramParams, (GdtDeviceInfoHelper.Result)localObject);
    ((GdtDeviceInfoHelper.Result)localObject).eventsForAnalysis.add(AdReporterForAnalysis.createEventForDeviceInfoEnd(paramContext, String.valueOf(paramParams.businessIdForAidTicketAndTaidTicket), System.currentTimeMillis() - l));
    reportForAnalysis(paramContext, paramParams, (GdtDeviceInfoHelper.Result)localObject);
    return localObject;
  }
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo create(Context paramContext)
  {
    if (paramContext == null)
    {
      acho.d(TAG, "create error");
      return null;
    }
    acim.a().a(paramContext, new acin());
    Object localObject = AdDeviceInfo.INSTANCE.create(paramContext, null);
    if (localObject != null) {}
    for (localObject = ((AdDeviceInfo.Result)localObject).deviceInfo; localObject == null; localObject = null)
    {
      acho.d(TAG, "create error");
      return null;
    }
    tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid)) {
      localDeviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid);
    }
    localDeviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid_type);
    localDeviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).conn);
    localDeviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).carrier_code);
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver)) {
      localDeviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver);
    }
    localDeviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_type);
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).manufacturer)) {
      localDeviceInfo.manufacturer.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).manufacturer);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model)) {
      localDeviceInfo.device_brand_and_model.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).device_brand_and_model);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac)) {
      localDeviceInfo.md5_mac.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id)) {
      localDeviceInfo.md5_android_id.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4)) {
      localDeviceInfo.client_ipv4.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4);
    }
    if (!TextUtils.isEmpty(achs.a())) {
      localDeviceInfo.qq_ver.set(achs.a());
    }
    localDeviceInfo.app_version_id.set(AppSetting.a());
    paramContext = achr.a(paramContext);
    if ((paramContext != null) && (paramContext.length == 2))
    {
      localObject = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location();
      ((tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).coordinates_type.set(0);
      ((tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).latitude.set(paramContext[0]);
      ((tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location)localObject).longitude.set(paramContext[1]);
      localDeviceInfo.location.set((MessageMicro)localObject);
    }
    localDeviceInfo.is_googleplay_version.set(false);
    return localDeviceInfo;
  }
  
  private static void fillDeviceInfo(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    Object localObject2 = null;
    Object localObject3 = new AdDeviceInfo.Params();
    Object localObject1;
    if (paramParams != null)
    {
      localObject1 = paramParams.businessIdForAidTicketAndTaidTicket;
      ((AdDeviceInfo.Params)localObject3).businessIdForAidTicketAndTaidTicket = ((String)localObject1);
      localObject3 = AdDeviceInfo.INSTANCE.create(paramContext, (AdDeviceInfo.Params)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((AdDeviceInfo.Result)localObject3).deviceInfo;
      }
      if ((paramContext != null) && (paramParams != null) && (paramResult != null) && (paramResult.deviceInfo != null) && (localObject1 != null)) {
        break label81;
      }
    }
    label81:
    do
    {
      return;
      localObject1 = null;
      break;
      paramResult.eventsForAnalysis.addAll(((AdDeviceInfo.Result)localObject3).eventsForAnalysis);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid)) {
        paramResult.deviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid);
      }
      paramResult.deviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type);
      paramResult.deviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn);
      paramResult.deviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver)) {
        paramResult.deviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver);
      }
      paramResult.deviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type);
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location != null)
      {
        paramResult.deviceInfo.location.coordinates_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type);
        paramResult.deviceInfo.location.latitude.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.latitude);
        paramResult.deviceInfo.location.longitude.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.longitude);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer)) {
        paramResult.deviceInfo.manufacturer.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model)) {
        paramResult.deviceInfo.device_brand_and_model.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac)) {
        paramResult.deviceInfo.md5_mac.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id)) {
        paramResult.deviceInfo.md5_android_id.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4)) {
        paramResult.deviceInfo.client_ipv4.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket)) {
        paramResult.deviceInfo.aid_ticket.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket)) {
        paramResult.deviceInfo.taid_ticket.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket);
      }
      paramResult.deviceInfo.origin_network_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).origin_network_type);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand)) {
        paramResult.deviceInfo.brand.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand);
      }
    } while (TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext));
    paramResult.deviceInfo.device_ext.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext);
  }
  
  private static void fillDeviceInfoWithOthers(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    if ((paramContext == null) || (paramParams == null) || (paramResult == null) || (paramResult.deviceInfo == null)) {
      return;
    }
    if (!TextUtils.isEmpty(achs.a())) {
      paramResult.deviceInfo.qq_ver.set(achs.a());
    }
    paramResult.deviceInfo.app_version_id.set(AppSetting.a());
    paramResult.deviceInfo.is_googleplay_version.set(false);
  }
  
  public static void init(Context paramContext)
  {
    acho.b(TAG, String.format("init %b", new Object[] { Boolean.valueOf(initialized) }));
    if (initialized) {
      return;
    }
    try
    {
      if (initialized) {
        return;
      }
    }
    finally {}
    initialized = true;
    AdDeviceInfo.INSTANCE.init(paramContext);
  }
  
  private static void reportForAnalysis(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    if ((paramParams != null) && (!TextUtils.isEmpty(paramParams.businessIdForAidTicketAndTaidTicket))) {}
    for (String str = paramParams.businessIdForAidTicketAndTaidTicket; (paramParams == null) || (paramResult == null) || (paramResult.eventsForAnalysis == null) || (paramResult.eventsForAnalysis.isEmpty()); str = "null") {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      paramParams = (Long)mapTimeMillis.get(str);
      if ((paramParams != null) && (l - paramParams.longValue() < 60000L)) {
        return;
      }
    }
    finally {}
    mapTimeMillis.put(str, Long.valueOf(l));
    acho.b(TAG, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramResult.eventsForAnalysis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */