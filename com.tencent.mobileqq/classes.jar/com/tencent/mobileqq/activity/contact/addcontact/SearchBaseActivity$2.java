package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchBaseActivity$2
  implements TextView.OnEditorActionListener
{
  SearchBaseActivity$2(SearchBaseActivity paramSearchBaseActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66)))
    {
      bool1 = false;
    }
    else
    {
      Object localObject = this.a.K.getText().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(((String)localObject).trim())))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          SearchUtils.a("add_page", "search", "clk_search_all", this.a.G + 1, 0, new String[] { "", "", localObject, "" });
          this.a.M.a((String)localObject, false);
          bool1 = bool2;
        }
      }
      else
      {
        localObject = this.a;
        ((SearchBaseActivity)localObject).a(true, ((SearchBaseActivity)localObject).K);
        QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131911076), 0).show();
        bool1 = bool2;
      }
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */