package com.tencent.biz.pubaccount.readinjoySearch;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class ReadInJoyNewSearchActivity$EditTextKeyListener
  implements View.OnKeyListener
{
  private ReadInJoyNewSearchActivity$EditTextKeyListener(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = ReadInJoyNewSearchActivity.a(this.a).getText().toString().trim();
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0) && (!TextUtils.isEmpty(paramView)))
    {
      paramKeyEvent = (InputMethodManager)this.a.getSystemService("input_method");
      if (paramKeyEvent != null) {
        paramKeyEvent.hideSoftInputFromWindow(ReadInJoyNewSearchActivity.a(this.a).getWindowToken(), 2);
      }
      ReadInJoyNewSearchActivity.a(this.a, paramView);
      this.a.a(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.EditTextKeyListener
 * JD-Core Version:    0.7.0.1
 */