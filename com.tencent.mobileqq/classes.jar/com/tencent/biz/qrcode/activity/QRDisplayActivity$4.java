package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.utils.TroopInfoActivityConstant;
import com.tencent.mobileqq.utils.TroopReportor;

class QRDisplayActivity$4
  extends ClickableSpan
{
  QRDisplayActivity$4(QRDisplayActivity paramQRDisplayActivity, TroopInfo paramTroopInfo) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = TroopInfoUIUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 5, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLat, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLon, 0, "");
    paramView.putString("leftViewText", this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.getString(2131719940));
    paramView.putInt("PARAM_EXIT_ANIMATION", 1);
    paramView.putBoolean(TroopInfoActivityConstant.a, true);
    ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, paramView);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.overridePendingTransition(2130771993, 2130771994);
    TroopReportor.a("Grp_QR", "search_upgrade", "search_upgrade_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin });
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-11692801);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.4
 * JD-Core Version:    0.7.0.1
 */