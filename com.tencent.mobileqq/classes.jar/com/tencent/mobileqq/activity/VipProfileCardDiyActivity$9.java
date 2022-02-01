package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class VipProfileCardDiyActivity$9
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$9(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n();
    if (!TextUtils.isEmpty(this.a.a())) {
      paramDialogInterface = "1";
    } else {
      paramDialogInterface = "0";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "0");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.9
 * JD-Core Version:    0.7.0.1
 */