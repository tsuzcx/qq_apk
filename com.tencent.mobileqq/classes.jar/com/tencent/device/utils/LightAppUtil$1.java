package com.tencent.device.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LightAppUtil$1
  implements BusinessObserver
{
  LightAppUtil$1(LightAppUtil paramLightAppUtil) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.f != null) && (!this.a.d.isFinishing())) {
      this.a.f.dismiss();
    }
    if (!paramBoolean)
    {
      ToastUtil.a().a(2131888507);
      if (this.a.e != null) {
        this.a.e.a(false);
      }
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(2131888507);
      if (this.a.e != null) {
        this.a.e.a(false);
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        int j = paramBundle.optInt("ret", -1);
        if (j != 0)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("GETLightAppSettingCallBack failed,resultCode=");
          paramBundle.append(j);
          LogUtility.a("LightAppUtil", paramBundle.toString());
          ToastUtil.a().a(2131888507);
          if (this.a.e != null) {
            this.a.e.a(false);
          }
        }
        else
        {
          try
          {
            paramBundle = paramBundle.getJSONArray("list");
            if (((paramBundle != null) && (paramBundle.length() != 0)) || (!this.a.i)) {
              break label928;
            }
            ToastUtil.a().a(2131888507);
            if ((this.a.f != null) && (this.a.f.isShowing()) && (this.a.d != null) && (!this.a.d.isFinishing())) {
              this.a.f.dismiss();
            }
            if (this.a.e != null) {
              this.a.e.a(true);
            }
            SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, this.a.l.productId);
            return;
          }
          catch (Exception paramBundle)
          {
            Object localObject1;
            LightAppSettingInfo localLightAppSettingInfo;
            Object localObject2;
            JSONArray localJSONArray;
            int k;
            int i;
            paramBundle.printStackTrace();
            ToastUtil.a().a(2131888507);
            if (this.a.e == null) {
              continue;
            }
            this.a.e.a(false);
          }
          if (paramInt < paramBundle.length())
          {
            localObject1 = paramBundle.getJSONObject(paramInt);
            localLightAppSettingInfo = new LightAppSettingInfo();
            localLightAppSettingInfo.c = ((JSONObject)localObject1).optInt("pid");
            localLightAppSettingInfo.a = ((JSONObject)localObject1).optInt("template_type");
            localLightAppSettingInfo.b = ((JSONObject)localObject1).optInt("has_own_app");
            localLightAppSettingInfo.j = ((JSONObject)localObject1).optString("h5_url");
            localLightAppSettingInfo.i = ((JSONObject)localObject1).optString("public_url");
            localLightAppSettingInfo.f = ((JSONObject)localObject1).optString("own_appid");
            localLightAppSettingInfo.h = ((JSONObject)localObject1).optInt("device_type");
            localLightAppSettingInfo.g = ((JSONObject)localObject1).optString("own_pkgname");
            localLightAppSettingInfo.k = ((JSONObject)localObject1).optString("openid");
            localLightAppSettingInfo.l = ((JSONObject)localObject1).optString("openkey");
            localLightAppSettingInfo.m = ((JSONObject)localObject1).optString("appname");
            localLightAppSettingInfo.n = ((JSONObject)localObject1).optInt("bindtype", 1);
            localObject2 = ((JSONObject)localObject1).optString("pub_propertyids");
            localJSONArray = ((JSONObject)localObject1).getJSONArray("config_list");
            localLightAppSettingInfo.o = this.a.a(localJSONArray);
            localLightAppSettingInfo.p = ((JSONObject)localObject1).optString("comment");
            localObject1 = ((String)localObject2).split(",");
            if (localObject1 != null)
            {
              localObject2 = new ArrayList();
              k = localObject1.length;
              i = 0;
              if (i < k)
              {
                ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i]));
                i += 1;
                continue;
              }
              localLightAppSettingInfo.e = ((ArrayList)localObject2);
            }
            else
            {
              LogUtility.e("LightAppUtil", "no ids!");
            }
            if (!LightAppUtil.a.containsKey(Integer.valueOf(localLightAppSettingInfo.c)))
            {
              LightAppUtil.a.put(Integer.valueOf(localLightAppSettingInfo.c), localLightAppSettingInfo);
              LightAppUtil.b.add(localLightAppSettingInfo);
            }
            if ((this.a.i) && (this.a.l.productId == localLightAppSettingInfo.c))
            {
              this.a.a(this.a.l, this.a.m, this.a.n);
              break label937;
            }
            if (this.a.e == null) {
              break label937;
            }
            this.a.e.a(false);
            break label937;
          }
          if ((!this.a.j) && (LightAppUtil.b.size() > 0))
          {
            paramBundle = BaseApplicationImpl.getApplication().getRuntime();
            if ((paramBundle instanceof QQAppInterface)) {
              ((SmartDeviceProxyMgr)((QQAppInterface)paramBundle).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(LightAppUtil.b);
            }
          }
        }
        if (this.a.l != null) {
          paramInt = this.a.l.productId;
        } else {
          paramInt = 0;
        }
        if (this.a.j)
        {
          SmartDeviceReport.a(this.a.g, "Net_Get_LiteappSetting", 0, j, paramInt);
          return;
        }
        SmartDeviceReport.a(null, "Net_Get_LiteappSetting", 0, j, paramInt);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      label928:
      if (paramBundle != null)
      {
        paramInt = 0;
        continue;
        label937:
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil.1
 * JD-Core Version:    0.7.0.1
 */