package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.net.a.a;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.AttriDeviceInfo;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.IdInfo;
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
  
  public AdDeviceInfo.Result create(Context paramContext)
  {
    if (paramContext == null)
    {
      AdLog.e("AdDeviceInfo", "create error");
      return null;
    }
    Object localObject1 = new h.a();
    Object localObject4 = h.INSTANCE.getCache();
    Object localObject3 = new HashMap();
    AdDeviceInfo.Result localResult = new AdDeviceInfo.Result();
    AdDeviceIdentifier localAdDeviceIdentifier1 = new AdDeviceIdBuilder().build(paramContext, false, ((h.a)localObject4).d_i_h);
    ((h.a)localObject1).d_i_h = localAdDeviceIdentifier1.idHash;
    ((Map)localObject3).put(Integer.valueOf(1), localAdDeviceIdentifier1);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier1.event);
    AdDeviceIdentifier localAdDeviceIdentifier2 = new d().build(paramContext, true, ((h.a)localObject4).d_i_0_h);
    ((h.a)localObject1).d_i_0_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(2), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new e().build(paramContext, true, ((h.a)localObject4).d_i_1_h);
    ((h.a)localObject1).d_i_1_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(4), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new k().build(paramContext, true, ((h.a)localObject4).i_h);
    ((h.a)localObject1).i_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(8), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new i().build(paramContext, false, ((h.a)localObject4).i_0_h);
    ((h.a)localObject1).i_0_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(16), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new j().build(paramContext, false, ((h.a)localObject4).i_1_h);
    ((h.a)localObject1).i_1_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(32), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new o().build(paramContext, false, ((h.a)localObject4).m_h);
    ((h.a)localObject1).m_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(64), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new m().build(paramContext, false, ((h.a)localObject4).m_0_h);
    ((h.a)localObject1).m_0_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(128), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new n().build(paramContext, false, ((h.a)localObject4).m_1_h);
    ((h.a)localObject1).m_1_h = localAdDeviceIdentifier2.idHash;
    ((Map)localObject3).put(Integer.valueOf(256), localAdDeviceIdentifier2);
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    localAdDeviceIdentifier2 = new AdMacAddressBuilder().build(paramContext, false, ((h.a)localObject4).m_a_h);
    ((h.a)localObject1).m_a_h = localAdDeviceIdentifier2.idHash;
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier2.event);
    AdDeviceIdentifier localAdDeviceIdentifier3 = new a().build(paramContext, false, ((h.a)localObject4).a_i_h);
    ((h.a)localObject1).a_i_h = localAdDeviceIdentifier3.idHash;
    localResult.eventsForAnalysis.add(localAdDeviceIdentifier3.event);
    localObject4 = new q().build(paramContext, true, ((h.a)localObject4).s_i_h);
    ((h.a)localObject1).s_i_h = ((AdDeviceIdentifier)localObject4).idHash;
    ((Map)localObject3).put(Integer.valueOf(512), localObject4);
    localResult.eventsForAnalysis.add(((AdDeviceIdentifier)localObject4).event);
    localObject4 = new b().build(paramContext, true);
    localResult.eventsForAnalysis.add(((AdDeviceIdentifier)localObject4).event);
    h.INSTANCE.update(paramContext, (h.a)localObject1);
    s.a locala = s.getUUID(paramContext, true);
    localObject1 = localResult.eventsForAnalysis;
    int j = locala.error;
    long l1 = locala.duration;
    int i;
    if (locala.cached) {
      i = 1;
    }
    for (;;)
    {
      ((List)localObject1).add(AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1124, j, l1, i));
      j = -2147483648;
      l1 = System.currentTimeMillis();
      localObject1 = AdCarrier.getCode(paramContext);
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        i = Integer.parseInt((String)localObject1);
        localObject1 = localResult.eventsForAnalysis;
        if (i != -2147483648)
        {
          j = 0;
          ((List)localObject1).add(AdReporterForAnalysis.createEventCarrier(paramContext, j, System.currentTimeMillis() - l1));
          l1 = System.currentTimeMillis();
          String str = com.qq.gdt.action.qadid.a.createQADID(paramContext);
          localObject1 = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty(str)) {
            break label1419;
          }
          j = 0;
          ((List)localObject1).add(AdReporterForAnalysis.createEventForGetQADID(paramContext, j, System.currentTimeMillis() - l1));
          localObject1 = com.tencent.ad.tangram.net.a.INSTANCE.getCache(paramContext);
          if (localObject1 == null) {
            break label1424;
          }
          localObject1 = ((a.a)localObject1).ip;
          Object localObject5 = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1430;
          }
          j = 0;
          ((List)localObject5).add(AdReporterForAnalysis.createEventForIPV4(paramContext, j));
          l1 = System.currentTimeMillis();
          localObject5 = AdNet.getUserAgent();
          List localList = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break label1435;
          }
          j = 0;
          long l2 = System.currentTimeMillis();
          if (TextUtils.isEmpty(AdNet.getUserAgentCache())) {
            break label1440;
          }
          k = 1;
          localList.add(AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1125, j, l2 - l1, k));
          if (TextUtils.isEmpty(localAdDeviceIdentifier1.idHash)) {
            break label1446;
          }
          localResult.deviceInfo.muid = localAdDeviceIdentifier1.idHash;
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
          if (!TextUtils.isEmpty(str)) {
            localResult.deviceInfo.qadid = str;
          }
          localResult.deviceInfo.md5_mac = localAdDeviceIdentifier2.idHash;
          localResult.deviceInfo.md5_android_id = localAdDeviceIdentifier3.idHash;
          localResult.deviceInfo.client_ipv4 = ((String)localObject1);
          localResult.deviceInfo.origin_network_type = AdNet.getNetworkType(paramContext);
          if (!TextUtils.isEmpty(Build.BRAND)) {
            localResult.deviceInfo.brand = Build.BRAND;
          }
          localObject1 = new qq_common.DeviceExt();
          ((qq_common.DeviceExt)localObject1).attri_info.id_info = getIdInfoArray((Map)localObject3);
          localObject3 = ((qq_common.DeviceExt)localObject1).attri_info;
          if ((locala == null) || (locala.uuidInfo == null)) {
            break label1494;
          }
          paramContext = locala.uuidInfo.getInfo();
          ((qq_common.DeviceExt.AttriDeviceInfo)localObject3).uuid = paramContext;
          ((qq_common.DeviceExt)localObject1).attri_info.wm_h = ((AdDeviceIdentifier)localObject4).idHash;
          ((qq_common.DeviceExt)localObject1).attri_info.ua = ((String)localObject5);
        }
        try
        {
          paramContext = AdJSON.fromObject(localObject1);
          localObject1 = localResult.deviceInfo;
          if ((paramContext == null) || (JSONObject.NULL.equals(paramContext))) {
            break label1499;
          }
          paramContext = paramContext.toString();
          ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_ext = paramContext;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            Object localObject2;
            AdLog.e("AdDeviceInfo", "create", paramContext);
          }
        }
        return localResult;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          AdLog.e("AdDeviceInfo", "create", localThrowable);
          i = j;
          continue;
          j = 1;
          continue;
          label1419:
          j = 1;
          continue;
          label1424:
          localObject2 = null;
          continue;
          label1430:
          j = 1;
          continue;
          label1435:
          j = 1;
          continue;
          label1440:
          int k = 0;
          continue;
          label1446:
          if (!TextUtils.isEmpty(localAdDeviceIdentifier2.idHash))
          {
            localResult.deviceInfo.muid = localAdDeviceIdentifier2.idHash;
            localResult.deviceInfo.muid_type = 3;
          }
          else
          {
            localResult.deviceInfo.muid_type = 0;
            continue;
            label1494:
            paramContext = null;
            continue;
            label1499:
            paramContext = null;
          }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo
 * JD-Core Version:    0.7.0.1
 */