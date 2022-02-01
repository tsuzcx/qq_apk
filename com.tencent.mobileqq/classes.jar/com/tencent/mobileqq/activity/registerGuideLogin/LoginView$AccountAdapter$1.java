package com.tencent.mobileqq.activity.registerGuideLogin;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.List;

class LoginView$AccountAdapter$1
  extends Filter
{
  LoginView$AccountAdapter$1(LoginView.AccountAdapter paramAccountAdapter) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.values = this.a.a.a;
    paramCharSequence.count = this.a.a.a.size();
    return paramCharSequence;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.count > 0)
    {
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.AccountAdapter.1
 * JD-Core Version:    0.7.0.1
 */