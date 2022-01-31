package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import axjq;
import bami;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class ChatSettingForTroop$42$1
  implements Runnable
{
  ChatSettingForTroop$42$1(ChatSettingForTroop.42 param42) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem;
    if (this.a.this$0.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      localFormSimpleItem = (FormSimpleItem)this.a.this$0.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if ((localFormSimpleItem != null) && (!TextUtils.equals(localFormSimpleItem.a().getText(), this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)))
      {
        if (!TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
          break label96;
        }
        localFormSimpleItem.setRightText(this.a.this$0.getString(2131632097));
      }
    }
    return;
    label96:
    SpannableString localSpannableString = new axjq(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
    localFormSimpleItem.setRightText(localSpannableString);
    bami.a(this.a.this$0.app, localFormSimpleItem.a(), localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.42.1
 * JD-Core Version:    0.7.0.1
 */