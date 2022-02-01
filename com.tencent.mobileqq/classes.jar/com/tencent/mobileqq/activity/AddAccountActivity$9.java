package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddAccountActivity$9
  implements View.OnClickListener
{
  AddAccountActivity$9(AddAccountActivity paramAddAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mDelIcon != null) && (this.a.mDelIcon.isShown())) {
      this.a.mDelIcon.setVisibility(8);
    }
    this.a.mAutoTextAccount.setText("");
    this.a.mPwdEdit.setText("");
    libsafeedit.clearPassBuffer();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.9
 * JD-Core Version:    0.7.0.1
 */