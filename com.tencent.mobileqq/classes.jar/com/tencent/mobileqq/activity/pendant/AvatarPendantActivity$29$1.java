package com.tencent.mobileqq.activity.pendant;

import android.view.View;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AvatarPendantActivity$29$1
  implements Runnable
{
  AvatarPendantActivity$29$1(AvatarPendantActivity.29 param29, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity).setVisibility(8);
    if (this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 2, 2131720144, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.getTitleBarHeight());
      AvatarPendantActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity);
      int i = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app.getCurrentUin());
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "successSet", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app)).c(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqApolloModelCmAvatarFaceInfo.getActionId())).f(i).a());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, 1, 2131718781, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$29.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.getTitleBarHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnProcessFinishListener avatar video process error! actionId: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.e("AvatarPendantActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.29.1
 * JD-Core Version:    0.7.0.1
 */