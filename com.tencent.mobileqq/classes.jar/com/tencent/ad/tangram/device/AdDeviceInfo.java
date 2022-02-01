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
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForIMEI;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForIMEI.Item;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForRelationTarget;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt;
import com.tencent.ad.tangram.protocol.qq_common.DeviceExt.AppStatus;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.settings.AdSettingsUtil.a;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Keep
public enum AdDeviceInfo
{
  INSTANCE;
  
  private static final int MUID_SOURCE_DEVICE_ID = 1;
  private static final int MUID_SOURCE_IMEI = 2;
  private static final int MUID_SOURCE_MAC_ADDRESS = 3;
  private static final int MUID_SOURCE_UNKNOWN = 0;
  private static final String TAG = "AdDeviceInfo";
  private volatile qq_common.DeviceExt.AppStatus appStatus;
  private volatile boolean initialized = false;
  private AdSettingsUtil.a listener = new AdDeviceInfo.2(this);
  
  private AdDeviceInfo() {}
  
  private static boolean canUseIMEI(Context paramContext)
  {
    Object localObject1 = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
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
  
  private static qq_common.DeviceExt.AppStatus getAppStatus(Context paramContext, String[] paramArrayOfString)
  {
    AdLog.i("AdDeviceInfo", "getAppStatus");
    qq_common.DeviceExt.AppStatus localAppStatus = new qq_common.DeviceExt.AppStatus();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramContext == null) || (paramArrayOfString == null))
    {
      AdLog.i("AdDeviceInfo", "getAppStatus error");
      return localAppStatus;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if (AdAppUtil.isInstalled(paramContext, str)) {
        localArrayList1.add(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(str);
      }
    }
    if (!localArrayList1.isEmpty()) {
      localAppStatus.installed = ((String[])localArrayList1.toArray(new String[0]));
    }
    if (!localArrayList2.isEmpty()) {
      localAppStatus.uninstalled = ((String[])localArrayList2.toArray(new String[0]));
    }
    return localAppStatus;
  }
  
  private String getDeviceExtString(Context paramContext)
  {
    Object localObject1 = null;
    paramContext = new qq_common.DeviceExt();
    paramContext.app_status = this.appStatus;
    try
    {
      Object localObject2 = AdJSON.fromObject(paramContext);
      paramContext = localObject1;
      if (localObject2 != null)
      {
        paramContext = localObject1;
        if (!JSONObject.NULL.equals(localObject2)) {
          paramContext = localObject2.toString();
        }
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdDeviceInfo", "getDeviceExt", paramContext);
    }
    return null;
  }
  
  private void setAppStatus(qq_common.DeviceExt.AppStatus paramAppStatus)
  {
    try
    {
      this.appStatus = paramAppStatus;
      return;
    }
    finally {}
  }
  
  private void updateAppStatus(WeakReference<Context> paramWeakReference)
  {
    AdLog.i("AdDeviceInfo", "updateAppStatus");
    Object localObject;
    if ((paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      localObject = ((Context)paramWeakReference.get()).getApplicationContext();
      localObject = new WeakReference(localObject);
      paramWeakReference = AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get());
      if (paramWeakReference != null) {
        break label62;
      }
    }
    label62:
    do
    {
      return;
      localObject = null;
      break;
      if ((paramWeakReference.settingsForRelationTarget.packageNameList == null) || (paramWeakReference.settingsForRelationTarget.packageNameList.length <= 0))
      {
        setAppStatus(null);
        return;
      }
    } while (this.appStatus != null);
    AdThreadManager.INSTANCE.post(new AdDeviceInfo.1(this, (WeakReference)localObject, paramWeakReference), 4);
  }
  
  public AdDeviceInfo.Result create(Context paramContext)
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
      label69:
      String str2;
      label120:
      String str3;
      label154:
      label182:
      label216:
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
          break label791;
        }
        i = 0;
        ((List)localObject1).add(AdReporterForAnalysis.createEventForGetImei(paramContext, i, System.currentTimeMillis() - l, k));
        if (TextUtils.isEmpty(c.getMacAddressCache(paramContext))) {
          break label796;
        }
        bool = true;
        l = System.currentTimeMillis();
        str3 = AdMacAddressMD5Digest.get(paramContext);
        localObject1 = localResult.eventsForAnalysis;
        if (TextUtils.isEmpty(str3)) {
          break label802;
        }
        i = 0;
        ((List)localObject1).add(AdReporterForAnalysis.createEventForMacAddress(paramContext, i, System.currentTimeMillis() - l, bool));
        if (TextUtils.isEmpty(b.getAndroidIdCache(paramContext))) {
          break label807;
        }
        bool = true;
        l = System.currentTimeMillis();
        str4 = a.get(paramContext);
        localObject1 = localResult.eventsForAnalysis;
        if (TextUtils.isEmpty(str4)) {
          break label813;
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
            break label840;
          }
          i = 0;
          ((List)localObject1).add(AdReporterForAnalysis.createEventForGetQADID(paramContext, i, System.currentTimeMillis() - l));
          localObject1 = com.tencent.ad.tangram.net.a.INSTANCE.getCache(paramContext);
          if (localObject1 == null) {
            break label845;
          }
          localObject1 = ((a.a)localObject1).ip;
          List localList = localResult.eventsForAnalysis;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label851;
          }
          i = 0;
          localList.add(AdReporterForAnalysis.createEventForIPV4(paramContext, i));
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            if (!str1.equals(str2)) {
              break label856;
            }
            localResult.eventsForAnalysis.add(AdReporterForAnalysis.createEventImeiConsistency(paramContext, 0, k));
          }
          bool = canUseIMEI(paramContext);
          if (TextUtils.isEmpty(str1)) {
            break label877;
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
          localResult.deviceInfo.origin_network_type = AdNet.getNetworkType(paramContext);
          if (!TextUtils.isEmpty(Build.BRAND)) {
            localResult.deviceInfo.brand = Build.BRAND;
          }
          localResult.deviceInfo.device_ext = getDeviceExtString(paramContext);
          return localResult;
          bool = false;
          continue;
          i = 1;
          break label69;
          label791:
          i = 1;
          break label120;
          label796:
          bool = false;
          break label154;
          label802:
          i = 1;
          break label182;
          label807:
          bool = false;
          break label216;
          label813:
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
          label840:
          i = 1;
          continue;
          label845:
          Object localObject2 = null;
          continue;
          label851:
          i = 1;
          continue;
          label856:
          localResult.eventsForAnalysis.add(AdReporterForAnalysis.createEventImeiConsistency(paramContext, 1, k));
          continue;
          label877:
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
    AdSettingsUtil.INSTANCE.addListener(new WeakReference(this.listener));
    updateAppStatus(new WeakReference(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo
 * JD-Core Version:    0.7.0.1
 */