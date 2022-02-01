package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class VipProfileCardDiyActivity$8
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$8(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.l();
    this.a.b(this.a.n);
    if (VipUtils.b(this.a.app)) {}
    for (paramDialogInterface = "4";; paramDialogInterface = "3")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "1");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.8
 * JD-Core Version:    0.7.0.1
 */