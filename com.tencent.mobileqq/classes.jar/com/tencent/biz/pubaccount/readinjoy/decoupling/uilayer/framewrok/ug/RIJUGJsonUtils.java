package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ug;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class RIJUGJsonUtils
{
  public static String a = "";
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = (QQAppInterface)RIJQQAppInterfaceUtil.a();
      localJSONObject.put("pos_id", 100402);
      localJSONObject.put("uin", ((QQAppInterface)localObject).getAccount());
      localJSONObject.put("imei", MobileInfoUtil.c());
      localJSONObject.put("Qom", UserAction.getQIMEI());
      localJSONObject.put("platform", "A");
      localJSONObject.put("qqver", "8.5.5");
      localJSONObject.put("net_type", HttpUtil.getNetWorkType() + "");
      localJSONObject.put("sUserKey", ((QQAppInterface)localObject).getAccount());
      localJSONObject.put("iUserKeyType", 6);
      localJSONObject.put("req_ext", URLEncoder.encode(URLEncoder.encode(b())));
      localObject = new JSONArray();
      if (!PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
        ((JSONArray)localObject).put("1");
      }
      if (!PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.weishi").equals("0")) {
        ((JSONArray)localObject).put("3");
      }
      localJSONObject.put("app_list", localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("RIJUGJsonUtils", 1, localException.getMessage());
      }
    }
    return localJSONObject.toString();
  }
  
  public static String b()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localObject = RIJQQAppInterfaceUtil.b();
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localJSONObject.put("guid", localObject);
        }
        localJSONObject.put("qua", c());
        localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).a = "ce2d9f";
        localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
        if (localObject == null) {
          continue;
        }
        localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
        if (localObject != null) {
          localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get());
        }
        localObject = Build.BRAND;
        localJSONObject.put("machine", Build.MODEL);
        localJSONObject.put("brand", localObject);
        localJSONObject.put("qimei", UserAction.getQIMEI());
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.d("RIJUGJsonUtils", 1, localException.getMessage());
        continue;
      }
      return localJSONObject.toString();
      localObject = null;
    }
  }
  
  public static String c()
  {
    if (!a.isEmpty()) {
      return a;
    }
    int i = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int k;
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2)
    {
      k = j;
      j = i;
    }
    for (;;)
    {
      String str = "" + k + "*" + j;
      a = "PR=QQ&PP=com.tencent.mobileqq&PPVN=8.5.5.5105&CO=SYS&PL=ADR&LCID=" + AppSetting.d() + "&RL=" + str + "&DE=" + Build.BRAND + "&MO=" + Build.MODEL + "&REF=NA_0";
      return a;
      k = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ug.RIJUGJsonUtils
 * JD-Core Version:    0.7.0.1
 */