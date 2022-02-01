package com.tencent.biz.pubaccount.readinjoy.activity;

import android.text.Editable;
import android.text.TextWatcher;

class ReadInJoyBaseDeliverActivity$10
  implements TextWatcher
{
  ReadInJoyBaseDeliverActivity$10(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.b(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.10
 * JD-Core Version:    0.7.0.1
 */