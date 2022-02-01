package com.tencent.mobileqq.activity.selectmember;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectMemberActivity$5
  implements View.OnClickListener
{
  SelectMemberActivity$5(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d == 27)
    {
      this.a.a.putParcelableArrayListExtra("result_set", this.a.e);
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
      this.a.setResult(-1, this.a.a);
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.5
 * JD-Core Version:    0.7.0.1
 */