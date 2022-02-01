package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import cooperation.qwallet.QwUtils;

class HbSkinLogic$3$2
  implements DialogInterface.OnClickListener
{
  HbSkinLogic$3$2(HbSkinLogic.3 param3, HbSkinInfo paramHbSkinInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinInfo.a.pop_dialog.right_url;
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      QwUtils.a(HbSkinLogic.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicHbSkinLogic$3.a), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinLogic.3.2
 * JD-Core Version:    0.7.0.1
 */