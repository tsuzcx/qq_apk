package com.tencent.mobileqq.activity.messagesearch;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.qphone.base.util.QLog;

class TenDocMessageSearchDialog$3
  implements TextWatcher
{
  private String jdField_a_of_type_JavaLangString = "";
  
  TenDocMessageSearchDialog$3(TenDocMessageSearchDialog paramTenDocMessageSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString().trim();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.jdField_a_of_type_JavaLangString = "";
      TenDocMessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTenDocMessageSearchDialog).a();
      TenDocMessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTenDocMessageSearchDialog).setVisibility(8);
      TenDocMessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTenDocMessageSearchDialog).setVisibility(8);
      TenDocMessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTenDocMessageSearchDialog).setVisibility(8);
      return;
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramEditable))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("afterTextChanged, mLastKeyword = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",lastKeyWord:");
        localStringBuilder.append(paramEditable);
        QLog.i("TenDocMessageSearchDialog", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaLangString = paramEditable;
      TenDocMessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTenDocMessageSearchDialog).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTenDocMessageSearchDialog.a();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */