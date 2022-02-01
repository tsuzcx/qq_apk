package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class DeviceMsgChatPie$2
  implements View.OnClickListener
{
  DeviceMsgChatPie$2(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(AppConstants.SMARTDEVICE_SEARCH_UIN))
    {
      if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        this.a.q();
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("nickname", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        ((Intent)localObject1).putExtra("bitmap", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2, false));
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("square_url_");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject2 = ((SharedPreferences)localObject2).getString(localStringBuilder.toString(), "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Intent)localObject1).putExtra("url", (String)localObject2);
        } else {
          ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
        }
        SmartDevicePluginLoader.a().a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
      }
    }
    else
    {
      localObject1 = (SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      localObject2 = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        if (DeviceMsgChatPie.a(this.a)) {
          ((SmartDeviceProxyMgr)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (DeviceInfo)localObject2, false);
        }
        this.a.q();
      }
      else
      {
        ((SmartDeviceProxyMgr)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (DeviceInfo)localObject2, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.2
 * JD-Core Version:    0.7.0.1
 */