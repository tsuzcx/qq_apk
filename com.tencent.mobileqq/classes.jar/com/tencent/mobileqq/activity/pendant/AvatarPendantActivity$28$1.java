package com.tencent.mobileqq.activity.pendant;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AvatarPendantActivity$28$1
  implements Runnable
{
  AvatarPendantActivity$28$1(AvatarPendantActivity.28 param28, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity).setEnabled(true);
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity).setVisibility(8);
    if (this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 2, 2131720405, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.getTitleBarHeight());
      int i = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app.getCurrentUin());
      ApolloDtReportUtil.a("avatarQQPage", "successSet", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app)).c(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqApolloApiModelCmAvatarFaceInfo.getActionId())).f(i).a());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 2131719065, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.getTitleBarHeight());
    QLog.e("AvatarPendantActivity", 1, "OnProcessFinishListener avatar video process error! actionId: " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.28.1
 * JD-Core Version:    0.7.0.1
 */