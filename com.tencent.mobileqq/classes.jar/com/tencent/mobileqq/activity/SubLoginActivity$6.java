package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.widget.ClearableEditText;

class SubLoginActivity$6
  implements View.OnFocusChangeListener
{
  SubLoginActivity$6(SubLoginActivity paramSubLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean) {
      SubLoginActivity.a(this.a).setSelection(SubLoginActivity.a(this.a).getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.6
 * JD-Core Version:    0.7.0.1
 */