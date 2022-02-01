package com.tencent.ad.tangram.device;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.net.a.a;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.AttriDeviceInfo;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.IdInfo;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@Keep
public enum AdDeviceInfo
{
  INSTANCE;
  
  private static final String TAG = "AdDeviceInfo";
  private static final String WX_OPENSDK_VERSION = "com.tencent.mm.BuildInfo.OPEN_SDK_VERSION";
  private static final String WX_PACKAGE_NAME = "com.tencent.mm";
  private volatile boolean initialized = false;
  
  private AdDeviceInfo() {}
  
  private static qq_common.DeviceExt.IdInfo[] getIdInfoArray(Map<Integer, AdDeviceIdentifier> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    label174:
    do
    {
      return null;
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      qq_common.DeviceExt.IdInfo localIdInfo;
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        Integer localInteger = (Integer)paramMap.getKey();
        if ((localInteger != null) && (localInteger.intValue() != 0))
        {
          if (paramMap.getValue() != null) {}
          for (paramMap = ((AdDeviceIdentifier)paramMap.getValue()).idHash;; paramMap = null)
          {
            if (TextUtils.isEmpty(paramMap)) {
              break label174;
            }
            localIdInfo = (qq_common.DeviceExt.IdInfo)localHashMap.get(paramMap);
            localObject = localIdInfo;
            if (localIdInfo == null)
            {
              localObject = new qq_common.DeviceExt.IdInfo();
              ((qq_common.DeviceExt.IdInfo)localObject).id_h = paramMap;
            }
            int i = ((qq_common.DeviceExt.IdInfo)localObject).bitmap;
            ((qq_common.DeviceExt.IdInfo)localObject).bitmap = (localInteger.intValue() | i);
            localHashMap.put(paramMap, localObject);
            break;
          }
        }
      }
      paramMap = new ArrayList();
      Object localObject = localHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localIdInfo = (qq_common.DeviceExt.IdInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localIdInfo != null) && (!TextUtils.isEmpty(localIdInfo.id_h)) && (localIdInfo.bitmap != 0)) {
          paramMap.add(localIdInfo);
        }
      }
    } while (paramMap.isEmpty());
    return (qq_common.DeviceExt.IdInfo[])paramMap.toArray(new qq_common.DeviceExt.IdInfo[paramMap.size()]);
  }
  
  private static int getWeChatAPIVer(Context paramContext)
  {
    if (paramContext == null) {
      AdLog.e("AdDeviceInfo", "getWXAppSupportAPI: context is null");
    }
    do
    {
      return 0;
      try
      {
        if (paramContext.getPackageManager() == null)
        {
          AdLog.e("AdDeviceInfo", "getWXAppSupportAPI: getPackageManager is null");
          return 0;
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdDeviceInfo", "getWXAppSupportAPI: error " + paramContext);
        return 0;
      }
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128);
    } while ((paramContext == null) || (paramContext.metaData == null));
    int i = paramContext.metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
    return i;
  }
  
  public AdDeviceInfo.Result create(Context paramContext, AdDeviceInfo.Params paramParams)
  {
    if (paramContext == null)
    {
      AdLog.e("AdDeviceInfo", "create error");
      return null;
    }
    Object localObject4 = new h.a();
    Object localObject3 = h.INSTANCE.getCache();
    Object localObject1 = new HashMap();
    AdDeviceInfo.Result localResult = new AdDeviceInfo.Result();
    Object localObject2 = new AdDeviceIdBuilder().build(paramContext, false, ((h.a)localObject3).d_i_h);
    ((h.a)localObject4).d_i_h = ((AdDeviceIdentifier)localObject2).idHash;
    ((Map)localObject1).put(Integer.valueOf(1), localObject2);
    localResult.eventsForAnalysis.add(((AdDeviceIdentifier)localObject2).event);
    AdDeviceIdentifier localAdDeviceIdentifier = new d().build(paramContext, true, ((h.a)localObject3).d_i_0_h);
    ((h.a)localObject4).d_i_0_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(2), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new e().build(paramContext, true, ((h.a)localObject3).d_i_1_h);
    ((h.a)localObject4).d_i_1_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(4), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new k().build(paramContext, true, ((h.a)localObject3).i_h);
    ((h.a)localObject4).i_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(8), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new i().build(paramContext, false, ((h.a)localObject3).i_0_h);
    ((h.a)localObject4).i_0_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(16), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new j().build(paramContext, false, ((h.a)localObject3).i_1_h);
    ((h.a)localObject4).i_1_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(32), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new n().build(paramContext, false, ((h.a)localObject3).m_h);
    ((h.a)localObject4).m_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(64), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new l().build(paramContext, false, ((h.a)localObject3).m_0_h);
    ((h.a)localObject4).m_0_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(128), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new m().build(paramContext, false, ((h.a)localObject3).m_1_h);
    ((h.a)localObject4).m_1_h = localAdDeviceIdentifier.idHash;
    ((Map)localObject1).put(Integer.valueOf(256), localAdDeviceIdentifier);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localAdDeviceIdentifier = new a().build(paramContext, false, ((h.a)localObject3).a_i_h);
    ((h.a)localObject4).a_i_h = localAdDeviceIdentifier.idHash;
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier.event);
    localObject3 = new p().build(paramContext, true, ((h.a)localObject3).s_i_h);
    ((h.a)localObject4).s_i_h = ((AdDeviceIdentifier)localObject3).idHash;
    ((Map)localObject1).put(Integer.valueOf(512), localObject3);
    localResult.eventsForAnalysis.add(((AdDeviceIdentifier)localObject3).event);
    localObject3 = new b().build(paramContext, true);
    localResult.eventsForAnalysis.add(((AdDeviceIdentifier)localObject3).event);
    h.INSTANCE.update(paramContext, (h.a)localObject4);
    localObject4 = r.getUUID(paramContext, true);
    Object localObject5 = localResult.eventsForAnalysis;
    int j = ((r.a)localObject4).error;
    long l1 = ((r.a)localObject4).duration;
    int i;
    if (((r.a)localObject4).cached) {
      i = 1;
    }
    for (;;)
    {
      ((List)localObject5).add(AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1124, j, l1, i));
      l1 = System.currentTimeMillis();
      localObject5 = AdTAID.getInstance();
      label809:
      String str;
      Object localObject6;
      if (paramParams != null)
      {
        paramParams = paramParams.businessIdForAidTicketAndTaidTicket;
        paramParams = ((AdTAID)localObject5).getEntity(paramContext, paramParams);
        l1 = System.currentTimeMillis() - l1;
        localObject5 = paramParams.aidTicket;
        str = paramParams.taidTicket;
        localObject6 = localResult.eventsForAnalysis;
        if (paramParams == null) {
          break label1525;
        }
        i = paramParams.errorCodeForAidTicket;
        label853:
        if (paramParams == null) {
          break label1532;
        }
        j = paramParams.originErrorCode;
        label863:
        ((List)localObject6).add(AdReporterForAnalysis.createEventForAidTicket(paramContext, i, j, l1));
        localObject6 = localResult.eventsForAnalysis;
        if (paramParams == null) {
          break label1540;
        }
        i = paramParams.errorCodeForTaidTicket;
        label896:
        if (paramParams == null) {
          break label1547;
        }
        j = paramParams.originErrorCode;
        ((List)localObject6).add(AdReporterForAnalysis.createEventForTaidTicket(paramContext, i, j, l1));
        j = -2147483648;
        l1 = System.currentTimeMillis();
        paramParams = AdCarrier.getCode(paramContext);
        i = j;
        if (TextUtils.isEmpty(paramParams)) {}
      }
      try
      {
        i = Integer.parseInt(paramParams);
        paramParams = localResult.eventsForAnalysis;
        if (i != -2147483648)
        {
          j = 0;
          paramParams.add(AdReporterForAnalysis.createEventCarrier(paramContext, j, System.currentTimeMillis() - l1));
          l1 = System.currentTimeMillis();
          localObject6 = com.qq.gdt.action.qadid.a.createQADID(paramContext);
          paramParams = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject6)) {
            break label1577;
          }
          j = 0;
          paramParams.add(AdReporterForAnalysis.createEventForGetQADID(paramContext, j, System.currentTimeMillis() - l1));
          paramParams = com.tencent.ad.tangram.net.a.INSTANCE.getCache(paramContext);
          if (paramParams == null) {
            break label1583;
          }
          paramParams = paramParams.ip;
          Object localObject7 = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty(paramParams)) {
            break label1588;
          }
          j = 0;
          ((List)localObject7).add(AdReporterForAnalysis.createEventForIPV4(paramContext, j));
          l1 = System.currentTimeMillis();
          localObject7 = AdNet.getUserAgent();
          List localList = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject7)) {
            break label1594;
          }
          j = 0;
          long l2 = System.currentTimeMillis();
          if (TextUtils.isEmpty(AdNet.getUserAgentCache())) {
            break label1600;
          }
          k = 1;
          localList.add(AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1125, j, l2 - l1, k));
          if (TextUtils.isEmpty(((AdDeviceIdentifier)localObject2).idHash)) {
            break label1606;
          }
          localResult.deviceInfo.muid = ((AdDeviceIdentifier)localObject2).idHash;
          localResult.deviceInfo.muid_type = 1;
          localResult.deviceInfo.conn = AdNet.getType(paramContext);
          if (i != -2147483648) {
            localResult.deviceInfo.carrier_code = i;
          }
          localResult.deviceInfo.os_ver = Build.VERSION.RELEASE;
          localResult.deviceInfo.os_type = 2;
          if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            localResult.deviceInfo.manufacturer = Build.MANUFACTURER;
          }
          if (!TextUtils.isEmpty(Build.MODEL)) {
            localResult.deviceInfo.device_brand_and_model = Build.MODEL;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {
            localResult.deviceInfo.qadid = ((String)localObject6);
          }
          localResult.deviceInfo.md5_android_id = localAdDeviceIdentifier.idHash;
          localResult.deviceInfo.client_ipv4 = paramParams;
          localResult.deviceInfo.aid_ticket = ((String)localObject5);
          localResult.deviceInfo.taid_ticket = str;
          localResult.deviceInfo.origin_network_type = AdNet.getNetworkType(paramContext);
          if (!TextUtils.isEmpty(Build.BRAND)) {
            localResult.deviceInfo.brand = Build.BRAND;
          }
          localObject2 = new qq_common.DeviceExt();
          ((qq_common.DeviceExt)localObject2).attri_info.id_info = getIdInfoArray((Map)localObject1);
          localObject1 = ((qq_common.DeviceExt)localObject2).attri_info;
          if ((localObject4 == null) || (((r.a)localObject4).uuidInfo == null)) {
            break label1618;
          }
          paramParams = ((r.a)localObject4).uuidInfo.getInfo();
          ((qq_common.DeviceExt.AttriDeviceInfo)localObject1).uuid = paramParams;
          ((qq_common.DeviceExt)localObject2).attri_info.wm_h = ((AdDeviceIdentifier)localObject3).idHash;
          ((qq_common.DeviceExt)localObject2).attri_info.ua = ((String)localObject7);
          ((qq_common.DeviceExt)localObject2).wechat_installed_info.api_ver = getWeChatAPIVer(paramContext);
          if (AdSettingsUtil.INSTANCE.getSettingsCache(paramContext) == null) {
            break label1623;
          }
          i = 1;
          ((qq_common.DeviceExt)localObject2).mqq_config_status = i;
        }
        try
        {
          paramContext = AdJSON.fromObject(localObject2);
          paramParams = localResult.deviceInfo;
          if ((paramContext == null) || (JSONObject.NULL.equals(paramContext))) {
            break label1628;
          }
          paramContext = paramContext.toString();
          paramParams.device_ext = paramContext;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            AdLog.e("AdDeviceInfo", "create", paramContext);
          }
        }
        return localResult;
        i = 0;
        continue;
        paramParams = null;
        break label809;
        label1525:
        i = -2147483648;
        break label853;
        label1532:
        j = -2147483648;
        break label863;
        label1540:
        i = -2147483648;
        break label896;
        label1547:
        j = -2147483648;
      }
      catch (Throwable paramParams)
      {
        for (;;)
        {
          AdLog.e("AdDeviceInfo", "create", paramParams);
          i = j;
          continue;
          j = 1;
          continue;
          label1577:
          j = 1;
          continue;
          label1583:
          paramParams = null;
          continue;
          label1588:
          j = 1;
          continue;
          label1594:
          j = 1;
          continue;
          label1600:
          int k = 0;
          continue;
          label1606:
          localResult.deviceInfo.muid_type = 0;
          continue;
          label1618:
          paramParams = null;
          continue;
          label1623:
          i = 2;
          continue;
          label1628:
          paramContext = null;
        }
      }
    }
  }
  
  public void init(Context paramContext)
  {
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    com.tencent.ad.tangram.net.a.INSTANCE.init(paramContext);
    h.INSTANCE.init(paramContext);
    AdTAID.getInstance().init(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo
 * JD-Core Version:    0.7.0.1
 */