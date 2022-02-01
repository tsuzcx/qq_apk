package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopInviteStatusFragment$6
  extends TroopMngObserver
{
  TroopInviteStatusFragment$6(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onGetGroupInviteStatus success:");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(" group_members_num:");
      ((StringBuilder)???).append(paramInt2);
      ((StringBuilder)???).append(" group_friends_num:");
      ((StringBuilder)???).append(paramInt3);
      ((StringBuilder)???).append(" friends_uins:");
      ((StringBuilder)???).append(paramArrayList);
      ((StringBuilder)???).append(" status:");
      ((StringBuilder)???).append(paramInt4);
      QLog.d("TroopInviteStatusFragment", 2, ((StringBuilder)???).toString());
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramBoolean) {
      synchronized (this.a)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        this.a.jdField_b_of_type_Int = paramInt3;
        paramArrayList = this.a;
        paramArrayList.jdField_a_of_type_Int = paramInt2;
        paramArrayList.jdField_c_of_type_Int = paramInt4;
        paramInt1 = paramInt4;
        if (paramInt4 != 5) {
          break label430;
        }
        paramInt1 = paramInt4;
        if (!paramArrayList.jdField_b_of_type_Boolean) {
          break label430;
        }
        paramInt1 = paramInt4;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          break label430;
        }
        paramInt1 = paramInt4;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          break label430;
        }
        paramArrayList = this.a;
        paramArrayList.jdField_b_of_type_Boolean = false;
        paramArrayList.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
        paramInt1 = paramInt4;
      }
    }
    switch (paramInt1)
    {
    default: 
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, HardCodeUtil.a(2131715250), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight()).show();
      paramInt1 = paramInt4;
      break;
    case 1282: 
    case 1283: 
    case 1284: 
    case 1285: 
      synchronized (this.a)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        this.a.jdField_b_of_type_Int = paramInt3;
        paramArrayList = this.a;
        paramArrayList.jdField_a_of_type_Int = paramInt2;
        paramArrayList.jdField_c_of_type_Int = 6;
        paramInt1 = 6;
      }
    }
    label430:
    if (paramInt1 != 6)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        paramArrayList = "1";
      } else {
        paramArrayList = "2";
      }
      TroopReportor.a("Grp_AIO", "invite", "in_exp", 0, 0, new String[] { paramArrayList, String.valueOf(paramInt1) });
    }
    else
    {
      TroopReportor.a("Grp_AIO", "invite", "in_past", 0, 0, new String[0]);
    }
    TroopInviteStatusFragment.a(this.a);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, null, this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
      return;
    }
    if (paramInt > 0)
    {
      TroopNotifyHelper.a(this.a.getBaseActivity(), TroopInviteStatusFragment.a(this.a), new Object[0]);
      return;
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, null, this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.6
 * JD-Core Version:    0.7.0.1
 */