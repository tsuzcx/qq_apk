package com.tencent.gdtad.util;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Params;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
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
  private static String jdField_a_of_type_JavaLangString = "GdtDeviceInfoHelper";
  private static volatile Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean = false;
  
  public static GdtDeviceInfoHelper.Result a(Context paramContext, GdtDeviceInfoHelper.Params paramParams)
  {
    if ((paramContext == null) || (paramParams == null) || (Looper.myLooper() == Looper.getMainLooper()))
    {
      localObject = jdField_a_of_type_JavaLangString;
      if (paramParams != null) {}
      for (paramContext = paramParams.jdField_a_of_type_JavaLangString;; paramContext = null)
      {
        GdtLog.d((String)localObject, String.format("create businessId:%s error", new Object[] { paramContext }));
        return null;
      }
    }
    GdtLog.b(jdField_a_of_type_JavaLangString, String.format("create businessId:%s", new Object[] { paramParams.jdField_a_of_type_JavaLangString }));
    long l = System.currentTimeMillis();
    GdtManager.a().a(paramContext, new GdtManager.Params());
    Object localObject = new GdtDeviceInfoHelper.Result();
    ((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    a(paramContext, paramParams, (GdtDeviceInfoHelper.Result)localObject);
    b(paramContext, paramParams, (GdtDeviceInfoHelper.Result)localObject);
    ((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_JavaUtilList.add(AdReporterForAnalysis.createEventForDeviceInfoEnd(paramContext, String.valueOf(paramParams.jdField_a_of_type_JavaLangString), System.currentTimeMillis() - l));
    c(paramContext, paramParams, (GdtDeviceInfoHelper.Result)localObject);
    return localObject;
  }
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      GdtLog.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    GdtManager.a().a(paramContext, new GdtManager.Params());
    Object localObject = AdDeviceInfo.INSTANCE.create(paramContext, null);
    if (localObject != null) {}
    for (localObject = ((AdDeviceInfo.Result)localObject).deviceInfo; localObject == null; localObject = null)
    {
      GdtLog.d(jdField_a_of_type_JavaLangString, "create error");
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
    if (!TextUtils.isEmpty(GdtVersionUtil.a())) {
      localDeviceInfo.qq_ver.set(GdtVersionUtil.a());
    }
    localDeviceInfo.app_version_id.set(AppSetting.a());
    paramContext = GdtLocationUtil.a(paramContext);
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
  
  static void a(Context paramContext)
  {
    GdtLog.b(jdField_a_of_type_JavaLangString, String.format("init %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean) }));
    if (jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_Boolean = true;
    AdDeviceInfo.INSTANCE.init(paramContext);
  }
  
  private static void a(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    Object localObject2 = null;
    Object localObject3 = new AdDeviceInfo.Params();
    Object localObject1;
    if (paramParams != null)
    {
      localObject1 = paramParams.jdField_a_of_type_JavaLangString;
      ((AdDeviceInfo.Params)localObject3).businessIdForAidTicketAndTaidTicket = ((String)localObject1);
      localObject3 = AdDeviceInfo.INSTANCE.create(paramContext, (AdDeviceInfo.Params)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((AdDeviceInfo.Result)localObject3).deviceInfo;
      }
      if ((paramContext != null) && (paramParams != null) && (paramResult != null) && (paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null) && (localObject1 != null)) {
        break label81;
      }
    }
    label81:
    do
    {
      return;
      localObject1 = null;
      break;
      paramResult.jdField_a_of_type_JavaUtilList.addAll(((AdDeviceInfo.Result)localObject3).eventsForAnalysis);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid);
      }
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type);
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn);
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver);
      }
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type);
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location != null)
      {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.coordinates_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type);
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.latitude.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.latitude);
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.location.longitude.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.longitude);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.manufacturer.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_brand_and_model.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_mac.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_android_id.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.client_ipv4.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.aid_ticket.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket);
      }
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.origin_network_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).origin_network_type);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.brand.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand);
      }
    } while (TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext));
    paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_ext.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext);
  }
  
  private static void b(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    if ((paramContext == null) || (paramParams == null) || (paramResult == null) || (paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null)) {
      return;
    }
    if (!TextUtils.isEmpty(GdtVersionUtil.a())) {
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qq_ver.set(GdtVersionUtil.a());
    }
    paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.app_version_id.set(AppSetting.a());
    paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.is_googleplay_version.set(false);
  }
  
  private static void c(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    if ((paramParams != null) && (!TextUtils.isEmpty(paramParams.jdField_a_of_type_JavaLangString))) {}
    for (String str = paramParams.jdField_a_of_type_JavaLangString; (paramParams == null) || (paramResult == null) || (paramResult.jdField_a_of_type_JavaUtilList == null) || (paramResult.jdField_a_of_type_JavaUtilList.isEmpty()); str = "null") {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      paramParams = (Long)jdField_a_of_type_JavaUtilMap.get(str);
      if ((paramParams != null) && (l - paramParams.longValue() < 60000L)) {
        return;
      }
    }
    finally {}
    jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
    GdtLog.b(jdField_a_of_type_JavaLangString, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramResult.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */