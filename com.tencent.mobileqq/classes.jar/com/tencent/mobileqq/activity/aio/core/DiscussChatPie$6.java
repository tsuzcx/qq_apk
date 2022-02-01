package com.tencent.mobileqq.activity.aio.core;

import android.text.Editable;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

class DiscussChatPie$6
  implements Runnable
{
  DiscussChatPie$6(DiscussChatPie paramDiscussChatPie, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().delete(i - 1, i);
    }
    SpannableString localSpannableString = AtTroopMemberSpan.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx, false);
    if (localSpannableString != null)
    {
      if (localSpannableString.length() == 0) {
        return;
      }
      int j = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, localSpannableString);
      this.this$0.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.6
 * JD-Core Version:    0.7.0.1
 */