package com.tencent.mobileqq.activity.messagesearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class MessageSearchDialog$1
  implements TextWatcher
{
  MessageSearchDialog$1(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.d.getText().toString().trim();
    if (this.a.q) {
      this.a.o.a(paramEditable);
    }
    this.a.q = true;
    if (paramEditable.length() == 0)
    {
      this.a.findViewById(2131435215).setVisibility(8);
      return;
    }
    this.a.findViewById(2131435215).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */