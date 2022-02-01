package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$6
  implements View.OnClickListener
{
  ForwardRecentActivity$6(ForwardRecentActivity paramForwardRecentActivity, DeviceInfo paramDeviceInfo, ForwardRecentItemView paramForwardRecentItemView, ResultRecord paramResultRecord, Resources paramResources, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.access$400(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      if (ForwardRecentActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din), 9501))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(false);
        ForwardRecentActivity.access$600(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din), 9501);
      }
      else if (ForwardRecentActivity.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, this.jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord))
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(true);
      }
    }
    else if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, HardCodeUtil.a(2131704878), 1000).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din));
      localBundle.putInt("uintype", 9501);
      localBundle.putString("uinname", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.mForwardOption.a(ForwardAbility.ForwardAbilityType.j.intValue(), localBundle);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.6
 * JD-Core Version:    0.7.0.1
 */