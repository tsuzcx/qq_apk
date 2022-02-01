package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchBaseActivity$1
  implements View.OnClickListener
{
  SearchBaseActivity$1(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.K.getText()))
    {
      this.a.setResult(0);
      this.a.finish();
    }
    else
    {
      this.a.M.a(this.a.K.getText().toString(), false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */