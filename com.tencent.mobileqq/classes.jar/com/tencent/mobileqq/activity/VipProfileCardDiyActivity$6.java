package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class VipProfileCardDiyActivity$6
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$6(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.l();
    this.a.a(ProfileCardTemplate.g, this.a.a, false);
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "2", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.6
 * JD-Core Version:    0.7.0.1
 */