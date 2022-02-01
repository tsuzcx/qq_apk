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
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.net.a.a;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo.Location;
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
    Object localObject1 = new h.a();
    Object localObject2 = h.INSTANCE.getCache();
    HashMap localHashMap = new HashMap();
    AdDeviceInfo.Result localResult = new AdDeviceInfo.Result();
    AdDeviceIdentifier localAdDeviceIdentifier1 = new AdDeviceIdBuilder().build(paramContext, false, ((h.a)localObject2).d_i_h);
    ((h.a)localObject1).d_i_h = localAdDeviceIdentifier1.idHash;
    localHashMap.put(Integer.valueOf(1), localAdDeviceIdentifier1);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier1.event);
    AdDeviceIdentifier localAdDeviceIdentifier2 = new d().build(paramContext, true, ((h.a)localObject2).d_i_0_h);
    ((h.a)localObject1).d_i_0_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(2), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new e().build(paramContext, true, ((h.a)localObject2).d_i_1_h);
    ((h.a)localObject1).d_i_1_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(4), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new k().build(paramContext, true, ((h.a)localObject2).i_h);
    ((h.a)localObject1).i_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(8), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new i().build(paramContext, false, ((h.a)localObject2).i_0_h);
    ((h.a)localObject1).i_0_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(16), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new j().build(paramContext, false, ((h.a)localObject2).i_1_h);
    ((h.a)localObject1).i_1_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(32), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new n().build(paramContext, false, ((h.a)localObject2).m_h);
    ((h.a)localObject1).m_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(64), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new l().build(paramContext, false, ((h.a)localObject2).m_0_h);
    ((h.a)localObject1).m_0_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(128), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new m().build(paramContext, false, ((h.a)localObject2).m_1_h);
    ((h.a)localObject1).m_1_h = localAdDeviceIdentifier2.idHash;
    localHashMap.put(Integer.valueOf(256), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    AdDeviceIdentifier localAdDeviceIdentifier3 = new a().build(paramContext, false, ((h.a)localObject2).a_i_h);
    ((h.a)localObject1).a_i_h = localAdDeviceIdentifier3.idHash;
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier3.event);
    localObject2 = new p().build(paramContext, true, ((h.a)localObject2).s_i_h);
    ((h.a)localObject1).s_i_h = ((AdDeviceIdentifier)localObject2).idHash;
    localHashMap.put(Integer.valueOf(512), localObject2);
    localResult.eventsForAnalysis.add(((AdDeviceIdentifier)localObject2).event);
    localAdDeviceIdentifier2 = new b().build(paramContext, true);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    h.INSTANCE.update(paramContext, (h.a)localObject1);
    r.a locala = r.getUUID(paramContext, true);
    localObject1 = localResult.eventsForAnalysis;
    int j = locala.error;
    long l1 = locala.duration;
    int i;
    label809:
    label837:
    label849:
    Object localObject4;
    if (locala.cached)
    {
      i = 1;
      ((List)localObject1).add(AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1124, j, l1, i));
      l1 = System.currentTimeMillis();
      localObject1 = AdTAID.getInstance();
      if (paramParams == null) {
        break label1660;
      }
      paramParams = paramParams.businessIdForAidTicketAndTaidTicket;
      localObject2 = ((AdTAID)localObject1).getEntity(paramContext, paramParams);
      l1 = System.currentTimeMillis() - l1;
      if (localObject2 == null) {
        break label1665;
      }
      paramParams = ((AdTAID.Entity)localObject2).aidTicket;
      if (localObject2 == null) {
        break label1670;
      }
      localObject1 = ((AdTAID.Entity)localObject2).taidTicket;
      localObject4 = localResult.eventsForAnalysis;
      if (localObject2 == null) {
        break label1676;
      }
      i = ((AdTAID.Entity)localObject2).errorCodeForAidTicket;
      label867:
      if (localObject2 == null) {
        break label1683;
      }
      j = ((AdTAID.Entity)localObject2).originErrorCode;
      label879:
      ((List)localObject4).add(AdReporterForAnalysis.createEventForAidTicket(paramContext, i, j, l1));
      localObject4 = localResult.eventsForAnalysis;
      if (localObject2 == null) {
        break label1691;
      }
      i = ((AdTAID.Entity)localObject2).errorCodeForTaidTicket;
      label914:
      if (localObject2 == null) {
        break label1698;
      }
      j = ((AdTAID.Entity)localObject2).originErrorCode;
      label926:
      ((List)localObject4).add(AdReporterForAnalysis.createEventForTaidTicket(paramContext, i, j, l1));
      l1 = System.currentTimeMillis();
      localObject2 = AdCarrier.getCode(paramContext);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1718;
      }
    }
    for (;;)
    {
      label1665:
      label1670:
      label1676:
      label1683:
      label1691:
      label1698:
      try
      {
        i = Integer.parseInt((String)localObject2);
        localObject2 = localResult.eventsForAnalysis;
        if (i != -2147483648)
        {
          j = 0;
          ((List)localObject2).add(AdReporterForAnalysis.createEventCarrier(paramContext, j, System.currentTimeMillis() - l1));
          localObject2 = com.tencent.ad.tangram.net.a.INSTANCE.getCache(paramContext);
          if (localObject2 == null) {
            break label1731;
          }
          localObject2 = ((a.a)localObject2).ip;
          localObject4 = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1737;
          }
          j = 0;
          ((List)localObject4).add(AdReporterForAnalysis.createEventForIPV4(paramContext, j));
          l1 = System.currentTimeMillis();
          localObject4 = AdNet.getUserAgent();
          Object localObject5 = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label1743;
          }
          j = 0;
          long l2 = System.currentTimeMillis();
          if (TextUtils.isEmpty(AdNet.getUserAgentCache())) {
            break label1749;
          }
          k = 1;
          ((List)localObject5).add(AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1125, j, l2 - l1, k));
          l2 = System.currentTimeMillis();
          localObject5 = AdLocationManager.INSTANCE.getLocationCache(paramContext);
          if ((localObject5 == null) || (!((AdLocation)localObject5).isValid())) {
            break label1755;
          }
          bool = true;
          List localList = localResult.eventsForAnalysis;
          long l3 = System.currentTimeMillis();
          if ((!bool) || (((AdLocation)localObject5).timeMillis == -2147483648L)) {
            break label1761;
          }
          l1 = System.currentTimeMillis() - ((AdLocation)localObject5).timeMillis;
          localList.add(AdReporterForAnalysis.createEventForLocation(paramContext, bool, l3 - l2, l1));
          if (TextUtils.isEmpty(localAdDeviceIdentifier1.idHash)) {
            break label1769;
          }
          localResult.deviceInfo.muid = localAdDeviceIdentifier1.idHash;
          localResult.deviceInfo.muid_type = 1;
          localResult.deviceInfo.conn = AdNet.getType(paramContext);
          if (i != -2147483648) {
            localResult.deviceInfo.carrier_code = i;
          }
          localResult.deviceInfo.os_ver = Build.VERSION.RELEASE;
          localResult.deviceInfo.os_type = 2;
          if ((localObject5 != null) && (((AdLocation)localObject5).isValid()))
          {
            localResult.deviceInfo.location = new qq_ad_get.QQAdGet.DeviceInfo.Location();
            localResult.deviceInfo.location.coordinates_type = 0;
            localResult.deviceInfo.location.latitude = Double.valueOf(((AdLocation)localObject5).latitude * 1000000.0D).intValue();
            localResult.deviceInfo.location.longitude = Double.valueOf(((AdLocation)localObject5).longitude * 1000000.0D).intValue();
          }
          if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            localResult.deviceInfo.manufacturer = Build.MANUFACTURER;
          }
          if (!TextUtils.isEmpty(Build.MODEL)) {
            localResult.deviceInfo.device_brand_and_model = Build.MODEL;
          }
          localResult.deviceInfo.md5_android_id = localAdDeviceIdentifier3.idHash;
          localResult.deviceInfo.client_ipv4 = ((String)localObject2);
          localResult.deviceInfo.aid_ticket = paramParams;
          localResult.deviceInfo.taid_ticket = ((String)localObject1);
          localResult.deviceInfo.origin_network_type = AdNet.getNetworkType(paramContext);
          if (!TextUtils.isEmpty(Build.BRAND)) {
            localResult.deviceInfo.brand = Build.BRAND;
          }
          localObject1 = new qq_common.DeviceExt();
          ((qq_common.DeviceExt)localObject1).attri_info.id_info = getIdInfoArray(localHashMap);
          localObject2 = ((qq_common.DeviceExt)localObject1).attri_info;
          if ((locala == null) || (locala.uuidInfo == null)) {
            break label1781;
          }
          paramParams = locala.uuidInfo.getInfo();
          ((qq_common.DeviceExt.AttriDeviceInfo)localObject2).uuid = paramParams;
          ((qq_common.DeviceExt)localObject1).attri_info.wm_h = localAdDeviceIdentifier2.idHash;
          ((qq_common.DeviceExt)localObject1).attri_info.ua = ((String)localObject4);
          ((qq_common.DeviceExt)localObject1).wechat_installed_info.api_ver = getWeChatAPIVer(paramContext);
          if (AdSettingsUtil.INSTANCE.getSettingsCache(paramContext) == null) {
            break label1786;
          }
          i = 1;
          ((qq_common.DeviceExt)localObject1).mqq_config_status = i;
        }
      }
      catch (Throwable localThrowable)
      {
        label1660:
        AdLog.e("AdDeviceInfo", "create", localThrowable);
      }
      try
      {
        paramContext = AdJSON.fromObject(localObject1);
        paramParams = localResult.deviceInfo;
        if ((paramContext == null) || (JSONObject.NULL.equals(paramContext))) {
          break label1791;
        }
        paramContext = paramContext.toString();
        paramParams.device_ext = paramContext;
      }
      catch (Throwable paramContext)
      {
        Object localObject3;
        AdLog.e("AdDeviceInfo", "create", paramContext);
        continue;
      }
      return localResult;
      i = 0;
      break;
      paramParams = null;
      break label809;
      paramParams = null;
      break label837;
      localObject1 = null;
      break label849;
      i = -2147483648;
      break label867;
      j = -2147483648;
      break label879;
      i = -2147483648;
      break label914;
      j = -2147483648;
      break label926;
      label1718:
      i = -2147483648;
      continue;
      j = 1;
      continue;
      label1731:
      localObject3 = null;
      continue;
      label1737:
      j = 1;
      continue;
      label1743:
      j = 1;
      continue;
      label1749:
      int k = 0;
      continue;
      label1755:
      boolean bool = false;
      continue;
      label1761:
      l1 = -2147483648L;
      continue;
      label1769:
      localResult.deviceInfo.muid_type = 0;
      continue;
      label1781:
      paramParams = null;
      continue;
      label1786:
      i = 2;
      continue;
      label1791:
      paramContext = null;
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
    AdLocationManager.INSTANCE.init(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo
 * JD-Core Version:    0.7.0.1
 */