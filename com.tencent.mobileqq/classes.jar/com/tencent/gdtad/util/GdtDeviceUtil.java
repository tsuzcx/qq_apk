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
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new qq_ad_get.QQAdGet.DeviceInfo();
      Object localObject = a(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localDeviceInfo.muid.set((String)localObject);
        localDeviceInfo.muid_type.set(1);
        localDeviceInfo.conn.set(GdtNetUtil.a(paramContext));
        localObject = b(paramContext);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      try
      {
        int i = Integer.parseInt((String)localObject);
        localDeviceInfo.carrier_code.set(i);
        localDeviceInfo.os_ver.set(Build.VERSION.RELEASE);
        localDeviceInfo.qq_ver.set(GdtVersionUtil.a());
        localDeviceInfo.os_type.set(2);
        localDeviceInfo.app_version_id.set(AppSetting.a());
        localObject = GdtLocationUtil.a(paramContext);
        paramContext = localDeviceInfo;
        if (localObject == null) {
          continue;
        }
        paramContext = localDeviceInfo;
        if (localObject.length != 2) {
          continue;
        }
        paramContext = new qq_ad_get.QQAdGet.DeviceInfo.Location();
        paramContext.coordinates_type.set(0);
        paramContext.latitude.set(localObject[0]);
        paramContext.longitude.set(localObject[1]);
        localDeviceInfo.location.set(paramContext);
        return localDeviceInfo;
        localDeviceInfo.muid_type.set(0);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          GdtLog.d(a, "initDeviceInfo", localThrowable);
        }
      }
    }
  }
  
  @Deprecated
  public static final String b(Context paramContext)
  {
    return AdCarrier.getCode(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceUtil
 * JD-Core Version:    0.7.0.1
 */