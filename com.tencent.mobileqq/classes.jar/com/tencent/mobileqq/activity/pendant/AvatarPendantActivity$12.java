package com.tencent.mobileqq.activity.pendant;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AvatarPendantActivity$12
  implements View.OnClickListener
{
  AvatarPendantActivity$12(AvatarPendantActivity paramAvatarPendantActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    VasH5PayUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, "mvip.gxh.android.faceaddon_nati_dft", this.jdField_a_of_type_Int, "1450000515", this.jdField_a_of_type_JavaLangString, this.b, "");
    String str = "0";
    if (!TextUtils.isEmpty(this.b)) {
      if (!"QQ会员".equals(this.b)) {
        break label91;
      }
    }
    label91:
    for (str = "0";; str = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8005FD2", "0X8005FD2", 0, 0, str, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.12
 * JD-Core Version:    0.7.0.1
 */