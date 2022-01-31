package com.tencent.gdtad.aditem;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtNetUtil;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.gdtad.util.GdtDeviceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import qiu;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class GdtAdLoader
{
  private static Set a = new HashSet();
  
  public static void a(Context paramContext, GdtAdLoader.Session paramSession, WeakReference paramWeakReference)
  {
    qiu.a(new qiu(paramSession, paramWeakReference), paramContext);
  }
  
  public static void a(Context paramContext, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    if (paramDeviceInfo == null)
    {
      GdtLog.d("GdtAdLoader", "initDeviceInfo error");
      return;
    }
    String str1 = GdtDeviceUtil.a(paramContext);
    String str2 = GdtDeviceUtil.b(paramContext);
    if (!TextUtils.isEmpty(str1))
    {
      paramDeviceInfo.muid.set(str1);
      paramDeviceInfo.muid_type.set(1);
    }
    for (;;)
    {
      paramDeviceInfo.conn.set(GdtNetUtil.a(paramContext));
      paramDeviceInfo.carrier_code.set(GdtDeviceUtil.a(paramContext));
      paramDeviceInfo.os_ver.set(Build.VERSION.RELEASE);
      paramDeviceInfo.qq_ver.set(GdtVersionUtil.a());
      paramDeviceInfo.os_type.set(2);
      paramContext = GdtLocationUtil.INSTANCE.getLocation();
      if ((paramContext == null) || (paramContext.length != 2)) {
        break;
      }
      paramDeviceInfo.location.latitude.set(paramContext[0]);
      paramDeviceInfo.location.longitude.set(paramContext[1]);
      return;
      if (!TextUtils.isEmpty(str2))
      {
        paramDeviceInfo.muid.set(str2);
        paramDeviceInfo.muid_type.set(3);
      }
      else
      {
        paramDeviceInfo.muid_type.set(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader
 * JD-Core Version:    0.7.0.1
 */