package com.tencent.mobileqq.apollo.store;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.ShortcutCreateListener;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloGameActivity$15
  implements DialogInterface.OnClickListener
{
  ApolloGameActivity$15(ApolloGameActivity paramApolloGameActivity, ApolloGameUtil.ShortcutCreateListener paramShortcutCreateListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$ShortcutCreateListener.a(1);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, 1, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.15
 * JD-Core Version:    0.7.0.1
 */