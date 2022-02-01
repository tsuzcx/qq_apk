package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.BusinessObserver;

final class Utils$1
  implements DialogInterface.OnClickListener
{
  Utils$1(int paramInt, BusinessObserver paramBusinessObserver, Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(17, false, null);
        paramDialogInterface.dismiss();
        return;
      }
      Utils.sendPluginSetMessage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Long, false);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      Utils.sendPluginSetMessage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Long, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(17, false, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils.1
 * JD-Core Version:    0.7.0.1
 */