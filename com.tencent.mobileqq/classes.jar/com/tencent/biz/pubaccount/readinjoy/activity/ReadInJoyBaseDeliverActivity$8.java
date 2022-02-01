package com.tencent.biz.pubaccount.readinjoy.activity;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.model.QueryCallback;

final class ReadInJoyBaseDeliverActivity$8
  implements QueryCallback<char[]>
{
  ReadInJoyBaseDeliverActivity$8(EditText paramEditText) {}
  
  public void a(char[] paramArrayOfChar)
  {
    int i = this.a.getSelectionStart();
    int j = this.a.getSelectionEnd();
    this.a.getEditableText().replace(i, j, String.valueOf(paramArrayOfChar));
    this.a.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.8
 * JD-Core Version:    0.7.0.1
 */