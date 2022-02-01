package com.tencent.beacon.core.info;

import android.content.Context;
import android.os.Build;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.c.d;
import com.tencent.beacon.qimei.QimeiSDK;

public class BeaconPubParams
{
  private static BeaconPubParams sParamsHolder;
  private String allSsid;
  private String androidId;
  private String appFirstInstallTime;
  private String appLastUpdatedTime;
  private String appVersion;
  private String beaconId;
  private String boundleId;
  private String brand;
  private String cid;
  private Context context;
  private String dpi;
  private String dtImei2;
  private String dtMeid;
  private String dtMf;
  private String fingerprint;
  private String gpu;
  private String hardwareOs;
  private String imei;
  private String imsi;
  private String isRooted;
  private String language;
  private String mac;
  private String model;
  private String modelApn;
  private String networkType;
  private String osVersion;
  private String platform;
  private String productId;
  private String qimei;
  private String resolution;
  private String sdkId;
  private String sdkVersion;
  private String wifiMac;
  private String wifiSsid;
  
  private BeaconPubParams(Context paramContext)
  {
    this.context = paramContext;
    init(paramContext);
  }
  
  public static BeaconPubParams getPubParams(Context paramContext)
  {
    try
    {
      if (sParamsHolder == null) {
        try
        {
          if (sParamsHolder == null) {
            sParamsHolder = new BeaconPubParams(paramContext);
          }
        }
        finally {}
      }
      sParamsHolder.refresh();
      paramContext = sParamsHolder;
      return paramContext;
    }
    finally {}
  }
  
  private void init(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext != paramContext.getApplicationContext()) {
      localContext = paramContext.getApplicationContext();
    }
    paramContext = c.d();
    paramContext.a(localContext);
    this.appVersion = b.a();
    this.boundleId = b.b();
    this.sdkId = paramContext.h();
    this.sdkVersion = paramContext.i();
    this.productId = paramContext.f();
    this.beaconId = QimeiSDK.getInstance().getBeaconIdInfo();
    this.appFirstInstallTime = b.a(localContext);
    f localf = f.p();
    this.appLastUpdatedTime = localf.a(localContext);
    this.platform = String.valueOf(paramContext.g());
    this.dtMf = localf.t();
    this.osVersion = localf.z();
    paramContext = new StringBuilder();
    paramContext.append(localf.g());
    paramContext.append("_");
    paramContext.append(localf.f());
    this.hardwareOs = paramContext.toString();
    this.brand = Build.BRAND;
    this.model = Build.MODEL;
    this.language = localf.r();
    this.resolution = localf.B();
    this.dpi = String.valueOf(localf.F());
    this.gpu = "";
    if (localf.q()) {
      paramContext = "1";
    } else {
      paramContext = "0";
    }
    this.isRooted = paramContext;
    this.fingerprint = localf.C();
    this.qimei = QimeiSDK.getInstance().getQimeiInternal();
    this.mac = localf.s();
    this.wifiMac = localf.I();
    this.wifiSsid = localf.J();
    this.allSsid = localf.d();
    this.cid = localf.v();
  }
  
  private void refresh()
  {
    f localf = f.p();
    this.networkType = localf.w();
    this.modelApn = d.c();
    this.imei = localf.m();
    this.dtImei2 = localf.n();
    this.dtMeid = localf.u();
    this.imsi = localf.o();
    this.androidId = localf.e();
    this.mac = localf.s();
    this.wifiMac = localf.I();
    this.wifiSsid = localf.J();
    this.allSsid = localf.d();
  }
  
  public String getAllSsid()
  {
    return this.allSsid;
  }
  
  public String getAndroidId()
  {
    return this.androidId;
  }
  
  public String getAppFirstInstallTime()
  {
    return this.appFirstInstallTime;
  }
  
  public String getAppLastUpdatedTime()
  {
    return this.appLastUpdatedTime;
  }
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getBeaconId()
  {
    return this.beaconId;
  }
  
  public String getBoundleId()
  {
    return this.boundleId;
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
  
  public String getDtImei2()
  {
    return this.dtImei2;
  }
  
  public String getDtMeid()
  {
    return this.dtMeid;
  }
  
  public String getDtMf()
  {
    return this.dtMf;
  }
  
  public String getFingerprint()
  {
    return this.fingerprint;
  }
  
  public String getHardwareOs()
  {
    return this.hardwareOs;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getIsRooted()
  {
    return this.isRooted;
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
  
  public String getModelApn()
  {
    return this.modelApn;
  }
  
  public String getNetworkType()
  {
    return this.networkType;
  }
  
  public String getOsVersion()
  {
    return this.osVersion;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getQimei()
  {
    return this.qimei;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public String getSdkId()
  {
    return this.sdkId;
  }
  
  public String getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  public String getWifiMac()
  {
    return this.wifiMac;
  }
  
  public String getWifiSsid()
  {
    return this.wifiSsid;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.core.info.BeaconPubParams
 * JD-Core Version:    0.7.0.1
 */