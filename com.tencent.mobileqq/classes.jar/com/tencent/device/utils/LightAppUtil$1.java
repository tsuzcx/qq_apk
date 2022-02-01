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
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (!paramBoolean)
    {
      ToastUtil.a().a(2131691545);
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(2131691545);
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
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
          ToastUtil.a().a(2131691545);
          if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
            this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          }
        }
        else
        {
          try
          {
            paramBundle = paramBundle.getJSONArray("list");
            if (((paramBundle != null) && (paramBundle.length() != 0)) || (!this.a.b)) {
              break label927;
            }
            ToastUtil.a().a(2131691545);
            if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            }
            if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
              this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(true);
            }
            SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
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
            ToastUtil.a().a(2131691545);
            if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
              continue;
            }
            this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          }
          if (paramInt < paramBundle.length())
          {
            localObject1 = paramBundle.getJSONObject(paramInt);
            localLightAppSettingInfo = new LightAppSettingInfo();
            localLightAppSettingInfo.jdField_c_of_type_Int = ((JSONObject)localObject1).optInt("pid");
            localLightAppSettingInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("template_type");
            localLightAppSettingInfo.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("has_own_app");
            localLightAppSettingInfo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("h5_url");
            localLightAppSettingInfo.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("public_url");
            localLightAppSettingInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_appid");
            localLightAppSettingInfo.jdField_d_of_type_Int = ((JSONObject)localObject1).optInt("device_type");
            localLightAppSettingInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_pkgname");
            localLightAppSettingInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("openid");
            localLightAppSettingInfo.f = ((JSONObject)localObject1).optString("openkey");
            localLightAppSettingInfo.g = ((JSONObject)localObject1).optString("appname");
            localLightAppSettingInfo.jdField_e_of_type_Int = ((JSONObject)localObject1).optInt("bindtype", 1);
            localObject2 = ((JSONObject)localObject1).optString("pub_propertyids");
            localJSONArray = ((JSONObject)localObject1).getJSONArray("config_list");
            localLightAppSettingInfo.jdField_a_of_type_JavaUtilHashMap = this.a.a(localJSONArray);
            localLightAppSettingInfo.h = ((JSONObject)localObject1).optString("comment");
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
              localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
            }
            else
            {
              LogUtility.e("LightAppUtil", "no ids!");
            }
            if (!LightAppUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int)))
            {
              LightAppUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int), localLightAppSettingInfo);
              LightAppUtil.jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
            }
            if ((this.a.b) && (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId == localLightAppSettingInfo.jdField_c_of_type_Int))
            {
              this.a.a(this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, this.a.jdField_a_of_type_AndroidOsBundle, this.a.d);
              break label936;
            }
            if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
              break label936;
            }
            this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
            break label936;
          }
          if ((!this.a.c) && (LightAppUtil.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramBundle = BaseApplicationImpl.getApplication().getRuntime();
            if ((paramBundle instanceof QQAppInterface)) {
              ((SmartDeviceProxyMgr)((QQAppInterface)paramBundle).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(LightAppUtil.jdField_a_of_type_JavaUtilArrayList);
            }
          }
        }
        if (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null) {
          paramInt = this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
        } else {
          paramInt = 0;
        }
        if (this.a.c)
        {
          SmartDeviceReport.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "Net_Get_LiteappSetting", 0, j, paramInt);
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
      label927:
      if (paramBundle != null)
      {
        paramInt = 0;
        continue;
        label936:
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil.1
 * JD-Core Version:    0.7.0.1
 */