package com.tencent.gdtad.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.device.AdCarrier;
import com.tencent.ad.tangram.device.AdDeviceIdBuilder;
import com.tencent.ad.tangram.device.AdDeviceIdentifier;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtNetUtil;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class GdtDeviceUtil
{
  private static String a = "GdtDeviceUtil";
  
  @Deprecated
  public static final int a(Context paramContext)
  {
    return AdCarrier.getType(paramContext);
  }
  
  @Deprecated
  public static String a(Context paramContext)
  {
    return new AdDeviceIdBuilder().build(paramContext, false, null).idHash;
  }
  
  @Deprecated
  public static qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      GdtLog.d(a, "getDeviceInfo error");
      return null;
    }
    qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new qq_ad_get.QQAdGet.DeviceInfo();
    String str = a(paramContext);
    if (!TextUtils.isEmpty(str))
    {
      localDeviceInfo.muid.set(str);
      localDeviceInfo.muid_type.set(1);
    }
    else
    {
      localDeviceInfo.muid_type.set(0);
    }
    int i = GdtNetUtil.a(paramContext);
    if (i >= 0) {
      localDeviceInfo.conn.set(i);
    }
    str = b(paramContext);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        i = Integer.parseInt(str);
        if (i >= 0) {
          localDeviceInfo.carrier_code.set(i);
        }
      }
      catch (Throwable localThrowable)
      {
        GdtLog.d(a, "initDeviceInfo", localThrowable);
      }
    }
    localDeviceInfo.os_ver.set(Build.VERSION.RELEASE);
    localDeviceInfo.qq_ver.set(GdtVersionUtil.a());
    localDeviceInfo.os_type.set(2);
    if (AppSetting.a() >= 0) {
      localDeviceInfo.app_version_id.set(AppSetting.a());
    }
    paramContext = GdtLocationUtil.a(paramContext);
    if ((paramContext != null) && (paramContext.length == 2))
    {
      qq_ad_get.QQAdGet.DeviceInfo.Location localLocation = new qq_ad_get.QQAdGet.DeviceInfo.Location();
      localLocation.coordinates_type.set(0);
      localLocation.latitude.set(paramContext[0]);
      localLocation.longitude.set(paramContext[1]);
      localDeviceInfo.location.set(localLocation);
    }
    return localDeviceInfo;
  }
  
  @Deprecated
  public static final String b(Context paramContext)
  {
    return AdCarrier.getCode(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceUtil
 * JD-Core Version:    0.7.0.1
 */