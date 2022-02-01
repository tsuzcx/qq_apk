package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.inputmethod.InputMethodManager;

class TroopGiftPanel$GiftNumInputDialog$4
  implements DialogInterface.OnShowListener
{
  TroopGiftPanel$GiftNumInputDialog$4(TroopGiftPanel.GiftNumInputDialog paramGiftNumInputDialog) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ((InputMethodManager)this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method")).showSoftInput(this.a.jdField_a_of_type_AndroidWidgetEditText, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.4
 * JD-Core Version:    0.7.0.1
 */