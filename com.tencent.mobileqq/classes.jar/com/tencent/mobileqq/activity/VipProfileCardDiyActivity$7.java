package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import java.util.HashMap;

class VipProfileCardDiyActivity$7
  implements DialogInterface.OnClickListener
{
  VipProfileCardDiyActivity$7(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.l();
    if (VasUtil.a(this.a.app).getVipStatus().isSVip())
    {
      VipProfileCardDiyActivity localVipProfileCardDiyActivity;
      if (this.a.jdField_a_of_type_Long == 0L)
      {
        paramDialogInterface = (String)this.a.jdField_a_of_type_JavaUtilHashMap.get(this.a.d);
        if (!TextUtils.isEmpty(paramDialogInterface))
        {
          localVipProfileCardDiyActivity = this.a;
          localVipProfileCardDiyActivity.a(localVipProfileCardDiyActivity.d, paramDialogInterface, false);
        }
        else
        {
          paramDialogInterface = this.a;
          paramDialogInterface.a(paramDialogInterface.d, false);
        }
      }
      else if (((this.a.jdField_a_of_type_Long == 160L) || (this.a.jdField_a_of_type_Long == 1600L)) && (!TextUtils.isEmpty(this.a.b)))
      {
        paramDialogInterface = ProfileCardManager.a(this.a, ProfileCardTemplate.PROFILE_CARD_STYLE_DIY, this.a.jdField_a_of_type_Long);
        localVipProfileCardDiyActivity = this.a;
        localVipProfileCardDiyActivity.a(paramDialogInterface, localVipProfileCardDiyActivity.b, false);
      }
    }
    if ((this.a.jdField_a_of_type_Long != 0L) && (this.a.jdField_a_of_type_Long != 160L)) {
      paramDialogInterface = "4";
    } else {
      paramDialogInterface = "3";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramDialogInterface, "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.7
 * JD-Core Version:    0.7.0.1
 */