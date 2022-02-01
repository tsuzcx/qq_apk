package com.tencent.biz.troopgift;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

class TroopGiftPanel$GiftNumInputDialog$2
  implements TextView.OnEditorActionListener
{
  TroopGiftPanel$GiftNumInputDialog$2(TroopGiftPanel.GiftNumInputDialog paramGiftNumInputDialog, TroopGiftPanel paramTroopGiftPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.c();
      paramTextView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(paramTextView)) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(paramTextView);
      } else {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a("1");
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.b();
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      paramTextView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
      paramKeyEvent = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", paramInt, 0, paramTextView, "", paramKeyEvent, localStringBuilder.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.2
 * JD-Core Version:    0.7.0.1
 */