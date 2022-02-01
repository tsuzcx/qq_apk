package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.widget.QQToast;

class SearchBaseActivity$2
  implements TextView.OnEditorActionListener
{
  SearchBaseActivity$2(SearchBaseActivity paramSearchBaseActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!TextUtils.isEmpty(paramTextView)) && (!TextUtils.isEmpty(paramTextView.trim())))
    {
      if (!TextUtils.isEmpty(paramTextView))
      {
        SearchUtils.a("add_page", "search", "clk_search_all", this.a.h + 1, 0, new String[] { "", "", paramTextView, "" });
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramTextView, false);
      }
      return true;
    }
    paramTextView = this.a;
    paramTextView.a(true, paramTextView.jdField_a_of_type_AndroidWidgetEditText);
    QQToast.a(this.a.getApplicationContext(), HardCodeUtil.a(2131713530), 0).a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */