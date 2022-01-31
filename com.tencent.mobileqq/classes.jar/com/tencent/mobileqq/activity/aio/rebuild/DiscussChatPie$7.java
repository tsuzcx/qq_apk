package com.tencent.mobileqq.activity.aio.rebuild;

import aeoc;
import android.text.Editable;
import android.text.SpannableString;
import bafv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class DiscussChatPie$7
  implements Runnable
{
  public DiscussChatPie$7(aeoc paramaeoc, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().delete(j - 1, j);
    }
    SpannableString localSpannableString = bafv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx, false);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {
      return;
    }
    int j = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, localSpannableString);
      aeoc.a(this.this$0).a(1);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.7
 * JD-Core Version:    0.7.0.1
 */