package com.tencent.gdtad.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Params;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForDeviceInfo;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForDeviceInfo.UUID;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.HevcCompatibilityInfo;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.IdInfo;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.video.AdVideo;
import com.tencent.ad.tangram.video.AdVideo.CodecCapability;
import com.tencent.common.config.AppSetting;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.tangram.TangramIDSetting;
import com.tencent.gathererga.tangram.TangramIDSetting.Params;
import com.tencent.gathererga.tangram.TangramResult;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Integer;Lcom.tencent.gathererga.tangram.TangramResult;>;
import java.util.Set;
import org.json.JSONObject;

public class GdtDeviceInfoHelper
{
  private static String a = "GdtDeviceInfoHelper";
  private static volatile boolean b = false;
  private static volatile Map<String, Long> c = new HashMap();
  
  private static int a(TangramResult paramTangramResult, int paramInt)
  {
    if (paramTangramResult == null) {
      return paramInt;
    }
    if ((paramTangramResult.c() instanceof Integer)) {
      return ((Integer)paramTangramResult.c()).intValue();
    }
    return paramInt;
  }
  
  public static AdAnalysisEvent a(Context paramContext, int paramInt, TangramResult paramTangramResult)
  {
    int j = -2147483648;
    int i;
    if (paramTangramResult == null) {
      i = -2147483648;
    } else {
      i = (int)paramTangramResult.b();
    }
    if (paramTangramResult != null) {
      j = (int)paramTangramResult.a();
    }
    int k;
    if (paramTangramResult == null) {
      k = 0;
    } else {
      k = paramTangramResult.e();
    }
    return AdAnalysisHelperForUtil.createEventForDeviceIdentifierV2(paramContext, paramInt, i, j, k);
  }
  
  public static AdDeviceInfo.Result a(Context paramContext, AdDeviceInfo.Params paramParams, gdt_settings.Settings paramSettings)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static TangramIDSetting a(boolean paramBoolean, ProviderMethodPriority paramProviderMethodPriority1, ProviderMethodPriority paramProviderMethodPriority2)
  {
    TangramIDSetting localTangramIDSetting = new TangramIDSetting();
    localTangramIDSetting.a(paramBoolean);
    localTangramIDSetting.b(paramProviderMethodPriority1);
    localTangramIDSetting.a(paramProviderMethodPriority2);
    paramProviderMethodPriority1 = new TangramIDSetting.Params();
    paramProviderMethodPriority1.a(true);
    paramProviderMethodPriority2 = AdSettingsManager.INSTANCE.getCache();
    gdt_settings.Settings.SettingsForDeviceInfo.UUID localUUID;
    if (paramProviderMethodPriority2 != null)
    {
      localUUID = paramProviderMethodPriority2.settingsForDeviceInfo.uuid;
      paramProviderMethodPriority2 = new JSONObject();
    }
    try
    {
      paramProviderMethodPriority2.put("version", localUUID.version);
      paramProviderMethodPriority2.put("maxLength", localUUID.maxLength);
      paramProviderMethodPriority2.put("salt", localUUID.salt);
      label100:
      paramProviderMethodPriority1.a(paramProviderMethodPriority2.toString());
      localTangramIDSetting.a(paramProviderMethodPriority1);
      return localTangramIDSetting;
    }
    catch (Exception localException)
    {
      break label100;
    }
  }
  
  @Deprecated
  public static GdtDeviceInfoHelper.Result a(Context paramContext, GdtDeviceInfoHelper.Params paramParams)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static String a(TangramResult paramTangramResult)
  {
    if (paramTangramResult == null) {
      return null;
    }
    if ((paramTangramResult.c() instanceof String)) {
      return (String)paramTangramResult.c();
    }
    return null;
  }
  
  static void a(Context paramContext)
  {
    GdtLog.b(a, String.format("init %b", new Object[] { Boolean.valueOf(b) }));
    if (b) {
      return;
    }
    try
    {
      if (b) {
        return;
      }
      b = true;
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
      localObject1 = paramParams.a;
    } else {
      localObject1 = null;
    }
    ((AdDeviceInfo.Params)localObject3).businessIdForAidTicketAndTaidTicket = ((String)localObject1);
    localObject3 = AdDeviceInfo.INSTANCE.create(paramContext, (AdDeviceInfo.Params)localObject3);
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((AdDeviceInfo.Result)localObject3).deviceInfo;
    }
    if ((paramContext != null) && (paramParams != null) && (paramResult != null) && (paramResult.a != null))
    {
      if (localObject1 == null) {
        return;
      }
      paramResult.b.addAll(((AdDeviceInfo.Result)localObject3).eventsForAnalysis);
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid)) {
        paramResult.a.muid.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type >= 0) {
        paramResult.a.muid_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn >= 0) {
        paramResult.a.conn.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code >= 0) {
        paramResult.a.carrier_code.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).carrier_code);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver)) {
        paramResult.a.os_ver.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type >= 0) {
        paramResult.a.os_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_type);
      }
      if ((((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location != null) && (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type >= 0))
      {
        paramResult.a.location.coordinates_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.coordinates_type);
        paramResult.a.location.latitude.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.latitude);
        paramResult.a.location.longitude.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.longitude);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer)) {
        paramResult.a.manufacturer.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model)) {
        paramResult.a.device_brand_and_model.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac)) {
        paramResult.a.md5_mac.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id)) {
        paramResult.a.md5_android_id.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4)) {
        paramResult.a.client_ipv4.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket)) {
        paramResult.a.aid_ticket.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket)) {
        paramResult.a.taid_ticket.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket);
      }
      if (((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).origin_network_type >= 0) {
        paramResult.a.origin_network_type.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).origin_network_type);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand)) {
        paramResult.a.brand.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).brand);
      }
      if (!TextUtils.isEmpty(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext)) {
        paramResult.a.device_ext.set(((com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext);
      }
    }
  }
  
  private static boolean a(TangramResult paramTangramResult, boolean paramBoolean)
  {
    if (paramTangramResult == null) {
      return paramBoolean;
    }
    if ((paramTangramResult.c() instanceof Boolean)) {
      return ((Boolean)paramTangramResult.c()).booleanValue();
    }
    return paramBoolean;
  }
  
  private static qq_common.DeviceExt.HevcCompatibilityInfo[] a()
  {
    Object localObject = AdVideo.INSTANCE.getHEVCMaxCapability(1);
    if (localObject == null) {
      return null;
    }
    qq_common.DeviceExt.HevcCompatibilityInfo localHevcCompatibilityInfo = new qq_common.DeviceExt.HevcCompatibilityInfo();
    localHevcCompatibilityInfo.video_player_type = 1;
    localHevcCompatibilityInfo.max_luma_samples = ((AdVideo.CodecCapability)localObject).lumaSamples;
    localHevcCompatibilityInfo.max_fps = ((AdVideo.CodecCapability)localObject).framerateForLumaSamples;
    localObject = new ArrayList();
    ((ArrayList)localObject).add(localHevcCompatibilityInfo);
    return (qq_common.DeviceExt.HevcCompatibilityInfo[])((ArrayList)localObject).toArray(new qq_common.DeviceExt.HevcCompatibilityInfo[((ArrayList)localObject).size()]);
  }
  
  private static qq_common.DeviceExt.IdInfo[] a(Map<Integer, TangramResult> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return null;
      }
      Object localObject2 = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        Integer localInteger = (Integer)paramMap.getKey();
        if ((localInteger != null) && (localInteger.intValue() != 0))
        {
          String str = b((TangramResult)paramMap.getValue());
          if (!TextUtils.isEmpty(str))
          {
            localObject1 = (qq_common.DeviceExt.IdInfo)((Map)localObject2).get(str);
            paramMap = (Map<Integer, TangramResult>)localObject1;
            if (localObject1 == null)
            {
              paramMap = new qq_common.DeviceExt.IdInfo();
              paramMap.id_h = str;
            }
            int i = paramMap.bitmap;
            paramMap.bitmap = (localInteger.intValue() | i);
            ((Map)localObject2).put(str, paramMap);
          }
        }
      }
      paramMap = new ArrayList();
      Object localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (qq_common.DeviceExt.IdInfo)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((qq_common.DeviceExt.IdInfo)localObject2).id_h)) && (((qq_common.DeviceExt.IdInfo)localObject2).bitmap != 0)) {
          paramMap.add(localObject2);
        }
      }
      if (paramMap.isEmpty()) {
        return null;
      }
      return (qq_common.DeviceExt.IdInfo[])paramMap.toArray(new qq_common.DeviceExt.IdInfo[paramMap.size()]);
    }
    return null;
  }
  
  private static String b(TangramResult paramTangramResult)
  {
    if (paramTangramResult == null) {
      return null;
    }
    return paramTangramResult.d();
  }
  
  @Deprecated
  public static tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo b(Context paramContext)
  {
    if (paramContext == null)
    {
      GdtLog.d(a, "create error");
      return null;
    }
    Object localObject = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
    if (localObject == null)
    {
      QLog.i(a, 1, "gdtAdAPI == null");
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
      GdtLog.d(a, "create error");
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
    if (AppSetting.d() >= 0) {
      localDeviceInfo.app_version_id.set(AppSetting.d());
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
  
  private static void b(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    if ((paramContext != null) && (paramParams != null) && (paramResult != null))
    {
      if (paramResult.a == null) {
        return;
      }
      if (!TextUtils.isEmpty(GdtVersionUtil.a())) {
        paramResult.a.qq_ver.set(GdtVersionUtil.a());
      }
      if (AppSetting.d() >= 0) {
        paramResult.a.app_version_id.set(AppSetting.d());
      }
      paramResult.a.is_googleplay_version.set(false);
    }
  }
  
  private static int c(Context paramContext)
  {
    if (paramContext == null)
    {
      AdLog.e(a, "getWXAppSupportAPI: context is null");
      return 0;
    }
    try
    {
      if (paramContext.getPackageManager() == null)
      {
        AdLog.e(a, "getWXAppSupportAPI: getPackageManager is null");
        return 0;
      }
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        int i = paramContext.metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
        return i;
      }
    }
    catch (Throwable paramContext)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWXAppSupportAPI: error ");
      localStringBuilder.append(paramContext);
      AdLog.e(str, localStringBuilder.toString());
    }
    return 0;
  }
  
  private static void c(Context paramContext, GdtDeviceInfoHelper.Params paramParams, GdtDeviceInfoHelper.Result paramResult)
  {
    String str;
    if ((paramParams != null) && (!TextUtils.isEmpty(paramParams.a))) {
      str = paramParams.a;
    } else {
      str = "null";
    }
    if ((paramParams != null) && (paramResult != null) && (paramResult.b != null))
    {
      if (paramResult.b.isEmpty()) {
        return;
      }
      long l = System.currentTimeMillis();
      try
      {
        paramParams = (Long)c.get(str);
        if ((paramParams != null) && (l - paramParams.longValue() < 60000L)) {
          return;
        }
        c.put(str, Long.valueOf(l));
        GdtLog.b(a, String.format("reportForAnalysis businessId:%s", new Object[] { str }));
        AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), paramResult.b);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */