package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;

public class AdDeviceInfoUtil
{
  public static int a()
  {
    int i = 0;
    switch (AppNetConnInfo.getConnInfo())
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AdDeviceInfoUtil", 2, "getNetType " + i);
      }
      return i;
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        break;
      case 1: 
        i = 2;
        break;
      case 2: 
        i = 3;
        break;
      case 3: 
      case 4: 
        i = 4;
        continue;
        i = 1;
      }
    }
  }
  
  public static String a()
  {
    Object localObject = "";
    try
    {
      String str = QQDeviceInfo.getIMEI("d059d4");
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdDeviceInfoUtil", 2, "getIMEI: exception" + localException.getMessage());
    }
    return localObject;
    return "";
  }
  
  public static String a(Context paramContext)
  {
    return a(paramContext, "com.tencent.mm");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = "";
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 1);
      paramContext = str;
      if (paramString != null) {
        paramContext = paramString.versionName;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static oidb_0x6cf.PhoneInfo a()
  {
    oidb_0x6cf.PhoneInfo localPhoneInfo = new oidb_0x6cf.PhoneInfo();
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).a = "ce2d9f";
    Object localObject2 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = ((GdtDeviceInfoHelper.Result)localObject2).a;; localObject1 = null)
    {
      if ((localObject2 != null) && (((GdtDeviceInfoHelper.Result)localObject2).a != null) && (((GdtDeviceInfoHelper.Result)localObject2).a.muid != null) && (((GdtDeviceInfoHelper.Result)localObject2).a.muid_type != null))
      {
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(((GdtDeviceInfoHelper.Result)localObject2).a.muid.get()));
        localPhoneInfo.uint32_muid_type.set(((GdtDeviceInfoHelper.Result)localObject2).a.muid_type.get());
      }
      localObject2 = b();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localPhoneInfo.string_imei.set((String)localObject2);
      }
      int i = PublicAccountAdUtil.a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.f();
        i = j;
      }
      catch (Exception localException)
      {
        label158:
        break label158;
      }
      localPhoneInfo.uint32_carrier.set(i);
      localObject2 = DeviceInfoUtil.e();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = DeviceInfoUtil.c();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = DatalineMathUtil.a(DatalineMathUtil.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      localPhoneInfo.bytes_ads_context.set(ByteStringMicro.copyFromUtf8(NativeAdUtils.a()));
      localPhoneInfo.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
      localPhoneInfo.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
      if (localObject1 != null)
      {
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
          localPhoneInfo.string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
          localPhoneInfo.string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
          localPhoneInfo.string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
          localPhoneInfo.string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
          localPhoneInfo.string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
          localPhoneInfo.string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
        }
        if (QLog.isColorLevel()) {
          QLog.i("AdDeviceInfoUtil", 2, "makePhoneInfo0x6cf: deviceInfo: ma=" + localPhoneInfo.string_androidid.get() + ", mm=" + localPhoneInfo.string_mac.get() + ", oa=" + localPhoneInfo.string_oaid.get() + ", ta=" + localPhoneInfo.string_taid.get());
        }
      }
      localPhoneInfo.bytes_wx_ver.set(ByteStringMicro.copyFrom(a(BaseApplication.getContext()).getBytes()));
      return localPhoneInfo;
    }
  }
  
  public static int b()
  {
    try
    {
      Object localObject = new GdtDeviceInfoHelper.Params();
      ((GdtDeviceInfoHelper.Params)localObject).a = "ce2d9f";
      localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
      if (localObject != null)
      {
        if (((GdtDeviceInfoHelper.Result)localObject).a == null) {
          return 0;
        }
        int i = ((GdtDeviceInfoHelper.Result)localObject).a.carrier_code.get();
        return i;
      }
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static String b()
  {
    for (Object localObject1 = "";; localObject1 = "")
    {
      try
      {
        Object localObject2 = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT > 28) {
          continue;
        }
        localObject2 = ((TelephonyManager)localObject2).getDeviceId();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AdDeviceInfoUtil", 2, "getGdtIMEI: exception" + localException.getMessage());
        return "";
      }
      return localObject1;
    }
  }
  
  public static String c()
  {
    Object localObject = "";
    try
    {
      String str = QQDeviceInfo.getMAC("d059d4");
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdDeviceInfoUtil", 2, "getIMEI: exception" + localException.getMessage());
    }
    return localObject;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */