package com.tencent.beacon.core.info;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.qimei.QimeiSDK;

public class BeaconPubParams
{
  private static BeaconPubParams sParamsHolder;
  private String all_ssid;
  private String android_id;
  private String app_first_install_time;
  private String app_last_updated_time;
  private String app_version;
  private String beacon_id;
  private String boundle_id;
  private String brand;
  private String cid;
  private String dpi;
  private String dt_imei2;
  private String dt_meid;
  private String dt_mf;
  private String fingerprint;
  private String gpu;
  private String hardware_os;
  private String host_app_version;
  private String imei;
  private String imsi;
  private String is_rooted;
  private String language;
  private String mac;
  private String model;
  private String model_apn;
  private String network_type;
  private String os_version;
  private String platform;
  private String product_id;
  private String qimei;
  private String resolution;
  private String sdk_id;
  private String sdk_version;
  private String wifi_mac;
  private String wifi_ssid;
  
  private BeaconPubParams(String paramString)
  {
    init(paramString);
  }
  
  /* Error */
  public static BeaconPubParams getPubParams(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   6: ifnonnull +26 -> 32
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 54	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   15: ifnonnull +14 -> 29
    //   18: new 2	com/tencent/beacon/core/info/BeaconPubParams
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 56	com/tencent/beacon/core/info/BeaconPubParams:<init>	(Ljava/lang/String;)V
    //   26: putstatic 54	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   29: ldc 2
    //   31: monitorexit
    //   32: getstatic 54	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   35: invokespecial 59	com/tencent/beacon/core/info/BeaconPubParams:refresh	()V
    //   38: getstatic 54	com/tencent/beacon/core/info/BeaconPubParams:sParamsHolder	Lcom/tencent/beacon/core/info/BeaconPubParams;
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   12	29	47	finally
    //   29	32	47	finally
    //   48	51	47	finally
    //   3	12	53	finally
    //   32	42	53	finally
    //   51	53	53	finally
  }
  
  private void init(String paramString)
  {
    Context localContext = UserAction.mContext;
    g localg = g.b(localContext);
    e locale = e.d(localContext);
    c localc = c.a(localContext);
    this.app_version = localg.a(paramString);
    this.boundle_id = localg.b();
    this.host_app_version = a.a(localContext);
    this.sdk_id = localg.h();
    this.sdk_version = b.i();
    this.product_id = paramString;
    this.beacon_id = QimeiSDK.getInstance().getBeaconIdInfo(localContext);
    this.app_first_install_time = com.tencent.beacon.core.e.b.b(localContext);
    this.app_last_updated_time = locale.c(localContext);
    this.platform = String.valueOf(localg.g());
    this.dt_mf = locale.k();
    this.os_version = locale.n();
    this.hardware_os = (locale.f() + "_" + locale.e());
    this.brand = locale.d();
    this.model = localg.e();
    this.language = locale.j();
    this.resolution = locale.m(localContext);
    this.dpi = String.valueOf(locale.n(localContext));
    this.gpu = "";
    if (locale.i()) {}
    for (paramString = "1";; paramString = "0")
    {
      this.is_rooted = paramString;
      this.fingerprint = locale.p();
      this.qimei = QimeiSDK.getInstance().getQimeiInternal(localContext);
      this.mac = locale.i(localContext);
      this.wifi_mac = locale.p(localContext);
      this.wifi_ssid = locale.q(localContext);
      this.all_ssid = locale.a(localContext);
      this.cid = localc.b();
      return;
    }
  }
  
  private void refresh()
  {
    Context localContext = UserAction.mContext;
    e locale = e.d(localContext);
    c localc = c.a(localContext);
    this.network_type = locale.k(localContext);
    this.model_apn = com.tencent.beacon.core.e.e.b(localContext);
    if (TextUtils.isEmpty(this.imei)) {
      this.imei = localc.c();
    }
    if (TextUtils.isEmpty(this.dt_imei2)) {
      this.dt_imei2 = locale.g(localContext);
    }
    if (TextUtils.isEmpty(this.dt_meid)) {
      this.dt_meid = locale.j(localContext);
    }
    if (TextUtils.isEmpty(this.imsi)) {
      this.imsi = locale.h(localContext);
    }
    if (TextUtils.isEmpty(this.android_id)) {
      this.android_id = locale.b(localContext);
    }
  }
  
  public String getAll_ssid()
  {
    return this.all_ssid;
  }
  
  public String getAndroid_id()
  {
    return this.android_id;
  }
  
  public String getApp_first_install_time()
  {
    return this.app_first_install_time;
  }
  
  public String getApp_last_updated_time()
  {
    return this.app_last_updated_time;
  }
  
  public String getApp_version()
  {
    return this.app_version;
  }
  
  public String getBeacon_id()
  {
    return this.beacon_id;
  }
  
  public String getBoundle_id()
  {
    return this.boundle_id;
  }
  
  public String getBrand()
  {
    return this.brand;
  }
  
  public String getCid()
  {
    return this.cid;
  }
  
  public String getDpi()
  {
    return this.dpi;
  }
  
  public String getDt_imei2()
  {
    return this.dt_imei2;
  }
  
  public String getDt_meid()
  {
    return this.dt_meid;
  }
  
  public String getDt_mf()
  {
    return this.dt_mf;
  }
  
  public String getFingerprint()
  {
    return this.fingerprint;
  }
  
  public String getHardware_os()
  {
    return this.hardware_os;
  }
  
  public String getHost_app_version()
  {
    return this.host_app_version;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getIs_rooted()
  {
    return this.is_rooted;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getModel_apn()
  {
    return this.model_apn;
  }
  
  public String getNetwork_type()
  {
    return this.network_type;
  }
  
  public String getOs_version()
  {
    return this.os_version;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public String getProduct_id()
  {
    return this.product_id;
  }
  
  public String getQimei()
  {
    return this.qimei;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public String getSdk_id()
  {
    return this.sdk_id;
  }
  
  public String getSdk_version()
  {
    return this.sdk_version;
  }
  
  public String getWifi_mac()
  {
    return this.wifi_mac;
  }
  
  public String getWifi_ssid()
  {
    return this.wifi_ssid;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.BeaconPubParams
 * JD-Core Version:    0.7.0.1
 */