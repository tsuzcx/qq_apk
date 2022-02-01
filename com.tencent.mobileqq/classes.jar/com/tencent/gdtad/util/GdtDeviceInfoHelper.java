package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Params;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GdtDeviceInfoHelper
{
  private static String jdField_a_of_type_JavaLangString = "GdtDeviceInfoHelper";
  private static volatile Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean = false;
  
  @Deprecated
  public static GdtDeviceInfoHelper.Result a(Context paramContext, GdtDeviceInfoHelper.Params paramParams)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      GdtLog.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    Object localObject = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
    if (localObject == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "gdtAdAPI == null");
      return null;
    }
    ((IGdtAdAPI)localObject).initGdtContext(paramContext, new InitGdtContextParams());
    localObject = AdDeviceInfo.INSTANCE.create(paramContext, null);
    if (localObject != null) {
      localObject = ((AdDeviceInfo.Result)localObject).deviceInfo;
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      GdtLog.d(jdField_a_of_type_JavaLangString, "create error");
      return null;
    }
    tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo();
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid)) {
      localDeviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid);
    }
    if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid_type >= 0) {
      localDeviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).muid_type);
    }
    if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).conn > 0) {
      localDeviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).conn);
    }
    if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).carrier_code >= 0) {
      localDeviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).carrier_code);
    }
    if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver)) {
      localDeviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_ver);
    }
    if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_type >= 0) {
      localDeviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject).os_type);
    }
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
    if (AppSetting.a() >= 0) {
      localDeviceInfo.app_version_id.set(AppSetting.a());
    }
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
      jdField_a_of_type_Boolean = true;
      AdDeviceInfo.INSTANCE.init(paramContext);
      return;
    }
    finally {}
  }
  
  private static void a(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    Object localObject3 = new AdDeviceInfo.Params();
    Object localObject2 = null;
    if (paramParams != null) {
      localObject1 = paramParams.jdField_a_of_type_JavaLangString;
    } else {
      localObject1 = null;
    }
    ((AdDeviceInfo.Params)localObject3).businessIdForAidTicketAndTaidTicket = ((String)localObject1);
    localObject3 = AdDeviceInfo.INSTANCE.create(paramContext, (AdDeviceInfo.Params)localObject3);
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((AdDeviceInfo.Result)localObject3).deviceInfo;
    }
    if ((paramContext != null) && (paramParams != null) && (paramResult != null) && (paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null))
    {
      if (localObject1 == null) {
        return;
      }
      paramResult.jdField_a_of_type_JavaUtilList.addAll(((AdDeviceInfo.Result)localObject3).eventsForAnalysis);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type >= 0) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn >= 0) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code >= 0) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type >= 0) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type);
      }
      if ((((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location != null) && (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type >= 0))
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
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).origin_network_type >= 0) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.origin_network_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).origin_network_type);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.brand.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext)) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.device_ext.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext);
      }
    }
  }
  
  private static void b(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    if ((paramContext != null) && (paramParams != null) && (paramResult != null))
    {
      if (paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo == null) {
        return;
      }
      if (!TextUtils.isEmpty(GdtVersionUtil.a())) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.qq_ver.set(GdtVersionUtil.a());
      }
      if (AppSetting.a() >= 0) {
        paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.app_version_id.set(AppSetting.a());
      }
      paramResult.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.is_googleplay_version.set(false);
    }
  }
  
  private static void c(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    String str;
    if ((paramParams != null) && (!TextUtils.isEmpty(paramParams.jdField_a_of_type_JavaLangString))) {
      str = paramParams.jdField_a_of_type_JavaLangString;
    } else {
      str = "null";
    }
    if ((paramParams != null) && (paramResult != null) && (paramResult.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramResult.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      long l = System.currentTimeMillis();
      try
      {
        paramParams = (Long)jdField_a_of_type_JavaUtilMap.get(str);
        if ((paramParams != null) && (l - paramParams.longValue() < 60000L)) {
          return;
        }
        jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
        GdtLog.b(jdField_a_of_type_JavaLangString, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
        AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramResult.jdField_a_of_type_JavaUtilList);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */