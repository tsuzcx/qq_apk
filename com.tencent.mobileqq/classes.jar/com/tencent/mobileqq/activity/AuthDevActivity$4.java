package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class AuthDevActivity$4
  implements ActionSheet.OnButtonClickListener
{
  AuthDevActivity$4(AuthDevActivity paramAuthDevActivity, String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        break label368;
      }
      if (!AuthDevActivity.access$1000(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity)) {}
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label431;
        }
        paramView = "0X800AC56";
        ReportController.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        AuthDevActivity.access$1100(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.c, this.jdField_a_of_type_Long);
      }
      catch (Throwable paramView)
      {
        QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "showDelDevActionSheet error : ", paramView.getMessage() });
      }
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
        QQToast.a(paramView, paramView.getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getTitleBarHeight());
      }
      else
      {
        QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick.begin to del recent dev");
        if (AuthDevActivity.access$1300(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).delHistoryDev(AuthDevActivity.access$1200(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int))
        {
          AuthDevActivity.access$1400(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
        }
        else
        {
          QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick del recent dev fail");
          break label368;
          paramView = new Intent();
          paramView.putExtra("appname", this.jdField_a_of_type_JavaLangString);
          paramView.putExtra("appid", this.jdField_a_of_type_Long);
          paramView.putExtra("sub_appid", AppSetting.a());
          paramView.putExtra("device_guid", NetConnInfoCenter.GUID);
          paramView.putExtra("target_name", this.jdField_b_of_type_JavaLangString);
          paramView.putExtra("target_type_info", ((SvcDevLoginInfo)AuthDevActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).get(this.jdField_a_of_type_Int)).strDeviceTypeInfo);
          paramView.putExtra("target_desc", ((SvcDevLoginInfo)AuthDevActivity.access$900(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).get(this.jdField_a_of_type_Int)).stDeviceItemDes.vecItemDes);
          paramView.putExtra("index", this.jdField_a_of_type_Int);
          RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, paramView, "/base/safe/authDevOpenActivity");
        }
      }
      label368:
      if ((AuthDevActivity.access$1500(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity) != null) && (AuthDevActivity.access$1500(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.isFinishing()))
      {
        AuthDevActivity.access$1500(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).dismiss();
        AuthDevActivity.access$1500(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).cancel();
        AuthDevActivity.access$1502(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, null);
      }
      return;
      label431:
      paramView = "0X800AC58";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.4
 * JD-Core Version:    0.7.0.1
 */