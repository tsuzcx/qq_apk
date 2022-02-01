package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class VipProfileCardDiyActivity$10
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$10(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n();
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.e();
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
      this.a.f();
    }
    if (!TextUtils.isEmpty(this.a.a())) {}
    for (paramDialogInterface = "1";; paramDialogInterface = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "1");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.10
 * JD-Core Version:    0.7.0.1
 */