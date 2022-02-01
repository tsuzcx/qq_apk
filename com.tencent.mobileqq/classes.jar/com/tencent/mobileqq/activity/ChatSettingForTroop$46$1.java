package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class ChatSettingForTroop$46$1
  implements Runnable
{
  ChatSettingForTroop$46$1(ChatSettingForTroop.46 param46) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem;
    if (this.a.this$0.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      localFormSimpleItem = (FormSimpleItem)this.a.this$0.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localFormSimpleItem != null) {
        if (!TextUtils.equals(localFormSimpleItem.a().getText(), this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
        {
          if (!TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
            break label115;
          }
          localFormSimpleItem.setRightText(this.a.this$0.getString(2131697574));
        }
      }
    }
    for (;;)
    {
      if (localFormSimpleItem.a() != null) {
        localFormSimpleItem.a().setCompoundDrawablePadding(ViewUtils.b(9.0F));
      }
      return;
      label115:
      SpannableString localSpannableString = new ColorNickText(this.a.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
      localFormSimpleItem.setRightText(localSpannableString);
      ColorNickManager.a(this.a.this$0.app, localFormSimpleItem.a(), localSpannableString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.46.1
 * JD-Core Version:    0.7.0.1
 */