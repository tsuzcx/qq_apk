package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdIPV4;
import com.tencent.ad.tangram.net.AdIPV4.a;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForIMEI;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForIMEI.Item;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import java.util.List;

@Keep
public final class AdDeviceInfo
{
  private static final int MUID_SOURCE_DEVICE_ID = 1;
  private static final int MUID_SOURCE_IMEI = 2;
  private static final int MUID_SOURCE_MAC_ADDRESS = 3;
  private static final int MUID_SOURCE_UNKNOWN = 0;
  private static final String TAG = "AdDeviceInfo";
  
  public static boolean canUseIMEI(Context paramContext)
  {
    Object localObject1 = com.tencent.ad.tangram.settings.a.INSTANCE.getSettingsCache(paramContext);
    if ((localObject1 == null) || (((gdt_settings.Settings)localObject1).settingsForIMEI.items == null) || (((gdt_settings.Settings)localObject1).settingsForIMEI.items.length <= 0)) {
      return false;
    }
    localObject1 = ((gdt_settings.Settings)localObject1).settingsForIMEI.items;
    int k = localObject1.length;
    int j = 0;
    label55:
    Object localObject2;
    int i;
    if (j < k)
    {
      localObject2 = localObject1[j];
      if ((localObject2.androidSDK != 0) && (localObject2.phoneType != 0)) {
        if ((localObject2.androidSDK == Build.VERSION.SDK_INT) && (localObject2.phoneType == b.getPhoneType(paramContext))) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return true;
        i = 0;
        continue;
        if (localObject2.androidSDK != 0)
        {
          if (localObject2.androidSDK == Build.VERSION.SDK_INT)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
        }
        if (localObject2.phoneType != 0)
        {
          if (localObject2.phoneType == b.getPhoneType(paramContext))
          {
            i = 1;
            continue;
          }
          i = 0;
        }
      }
      else
      {
        j += 1;
        break label55;
        break;
      }
      i = 0;
    }
  }
  
  public static AdDeviceInfo.Result create(Context paramContext)
  {
    if (paramContext == null)
    {
      AdLog.e("AdDeviceInfo", "create error");
      return null;
    }
    AdDeviceInfo.Result localResult = new AdDeviceInfo.Result();
    int k = b.getPhoneType(paramContext);
    boolean bool;
    if (!TextUtils.isEmpty(b.getDeviceIdCache(paramContext))) {
      bool = true;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      String str1 = AdDeviceIdMD5Digest.get(paramContext);
      Object localObject1 = localResult.eventsForAnalysis;
      int i;
      label68:
      String str2;
      label118:
      String str3;
      label151:
      label179:
      label213:
      String str4;
      int j;
      if (!TextUtils.isEmpty(str1))
      {
        i = 0;
        ((List)localObject1).add(AdReporterForAnalysis.createEventForDeviceId(paramContext, i, System.currentTimeMillis() - l, bool, k));
        l = System.currentTimeMillis();
        str2 = AdIMEIMD5Digest.get(paramContext);
        localObject1 = localResult.eventsForAnalysis;
        if (TextUtils.isEmpty(str2)) {
          break label733;
        }
        i = 0;
        ((List)localObject1).add(AdReporterForAnalysis.createEventForGetImei(paramContext, i, System.currentTimeMillis() - l, k));
        if (TextUtils.isEmpty(c.getMacAddressCache(paramContext))) {
          break label738;
        }
        bool = true;
        l = System.currentTimeMillis();
        str3 = AdMacAddressMD5Digest.get(paramContext);
        localObject1 = localResult.eventsForAnalysis;
        if (TextUtils.isEmpty(str3)) {
          break label744;
        }
        i = 0;
        ((List)localObject1).add(AdReporterForAnalysis.createEventForMacAddress(paramContext, i, System.currentTimeMillis() - l, bool));
        if (TextUtils.isEmpty(b.getAndroidIdCache(paramContext))) {
          break label749;
        }
        bool = true;
        l = System.currentTimeMillis();
        str4 = a.get(paramContext);
        localObject1 = localResult.eventsForAnalysis;
        if (TextUtils.isEmpty(str4)) {
          break label755;
        }
        i = 0;
        ((List)localObject1).add(AdReporterForAnalysis.createEventForAndroidId(paramContext, i, System.currentTimeMillis() - l, bool));
        i = -2147483648;
        l = System.currentTimeMillis();
        localObject1 = AdCarrier.getCode(paramContext);
        j = i;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      try
      {
        j = Integer.parseInt((String)localObject1);
        localObject1 = localResult.eventsForAnalysis;
        if (j != -2147483648)
        {
          i = 0;
          ((List)localObject1).add(AdReporterForAnalysis.createEventCarrier(paramContext, i, System.currentTimeMillis() - l));
          l = System.currentTimeMillis();
          String str5 = com.qq.gdt.action.qadid.a.createQADID(paramContext);
          localObject1 = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty(str5)) {
            break label782;
          }
          i = 0;
          ((List)localObject1).add(AdReporterForAnalysis.createEventForGetQADID(paramContext, i, System.currentTimeMillis() - l));
          localObject1 = AdIPV4.INSTANCE.getCache();
          if (localObject1 == null) {
            break label787;
          }
          localObject1 = ((AdIPV4.a)localObject1).ip;
          List localList = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label793;
          }
          i = 0;
          localList.add(AdReporterForAnalysis.createEventForIPV4(paramContext, i));
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            if (!str1.equals(str2)) {
              break label798;
            }
            localResult.eventsForAnalysis.add(AdReporterForAnalysis.createEventImeiConsistency(paramContext, 0, k));
          }
          bool = canUseIMEI(paramContext);
          if (TextUtils.isEmpty(str1)) {
            break label818;
          }
          localResult.deviceInfo.muid = str1;
          localResult.deviceInfo.muid_type = 1;
          i = 1;
          AdLog.i("AdDeviceInfo", "create muid:" + localResult.deviceInfo.muid + " muid_type:" + localResult.deviceInfo.muid_type + " muidSourceType:" + i + " canUseIMEI:" + bool);
          localResult.eventsForAnalysis.add(AdReporterForAnalysis.createEventImeiSource(paramContext, i, k));
          localResult.deviceInfo.conn = AdNet.getType(paramContext);
          if (j != -2147483648) {
            localResult.deviceInfo.carrier_code = j;
          }
          localResult.deviceInfo.os_ver = Build.VERSION.RELEASE;
          localResult.deviceInfo.os_type = 2;
          if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            localResult.deviceInfo.manufacturer = Build.MANUFACTURER;
          }
          if (!TextUtils.isEmpty(Build.MODEL)) {
            localResult.deviceInfo.device_brand_and_model = Build.MODEL;
          }
          if (!TextUtils.isEmpty(str5)) {
            localResult.deviceInfo.qadid = str5;
          }
          localResult.deviceInfo.md5_mac = str3;
          localResult.deviceInfo.md5_android_id = str4;
          localResult.deviceInfo.client_ipv4 = ((String)localObject1);
          return localResult;
          bool = false;
          continue;
          i = 1;
          break label68;
          label733:
          i = 1;
          break label118;
          label738:
          bool = false;
          break label151;
          label744:
          i = 1;
          break label179;
          label749:
          bool = false;
          break label213;
          label755:
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          AdLog.e("AdDeviceInfo", "create", localThrowable);
          j = i;
          continue;
          i = 1;
          continue;
          label782:
          i = 1;
          continue;
          label787:
          Object localObject2 = null;
          continue;
          label793:
          i = 1;
          continue;
          label798:
          localResult.eventsForAnalysis.add(AdReporterForAnalysis.createEventImeiConsistency(paramContext, 1, k));
          continue;
          label818:
          if ((!TextUtils.isEmpty(str2)) && (bool))
          {
            localResult.deviceInfo.muid = str2;
            localResult.deviceInfo.muid_type = 1;
            i = 2;
          }
          else if (!TextUtils.isEmpty(str3))
          {
            localResult.deviceInfo.muid = str3;
            localResult.deviceInfo.muid_type = 3;
            i = 3;
          }
          else
          {
            localResult.deviceInfo.muid_type = 0;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo
 * JD-Core Version:    0.7.0.1
 */