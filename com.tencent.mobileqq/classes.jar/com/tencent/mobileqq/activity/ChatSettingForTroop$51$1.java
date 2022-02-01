package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import begq;
import bhmb;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class ChatSettingForTroop$51$1
  implements Runnable
{
  ChatSettingForTroop$51$1(ChatSettingForTroop.51 param51) {}
  
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
        localFormSimpleItem.setRightText(this.a.this$0.getString(2131697320));
      }
    }
    return;
    label96:
    SpannableString localSpannableString = new begq(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
    localFormSimpleItem.setRightText(localSpannableString);
    bhmb.a(this.a.this$0.app, localFormSimpleItem.a(), localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51.1
 * JD-Core Version:    0.7.0.1
 */