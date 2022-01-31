package com.qq.im.poi;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class LbsPackPoiListActivity$SearchTextWatcher
  implements TextWatcher
{
  protected LbsPackPoiListActivity$SearchTextWatcher(LbsPackPoiListActivity paramLbsPackPoiListActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = LbsPackPoiListActivity.a(this.a).getText().toString().trim();
    LbsPackPoiListActivity.a(this.a, paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackPoiListActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */