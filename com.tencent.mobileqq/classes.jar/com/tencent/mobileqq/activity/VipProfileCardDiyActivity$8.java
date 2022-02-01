package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;

class VipProfileCardDiyActivity$8
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$8(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.l();
    paramDialogInterface = this.a;
    paramDialogInterface.b(paramDialogInterface.n);
    if (VasUtil.a(this.a.app).getVipStatus().isSVip()) {
      paramDialogInterface = "4";
    } else {
      paramDialogInterface = "3";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.8
 * JD-Core Version:    0.7.0.1
 */