package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class VipProfileCardDiyActivity$10
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$10(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n();
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = this.a;
      paramDialogInterface.jdField_a_of_type_Boolean = false;
      paramDialogInterface.e();
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
      this.a.f();
    }
    if (!TextUtils.isEmpty(this.a.a())) {
      paramDialogInterface = "1";
    } else {
      paramDialogInterface = "0";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.10
 * JD-Core Version:    0.7.0.1
 */