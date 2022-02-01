package com.tencent.biz.pubaccount.subscript;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;

class SubscriptFeedsActivity$4
  implements View.OnFocusChangeListener
{
  SubscriptFeedsActivity$4(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      SubscriptFeedsActivity.a(this.a);
      long l = System.currentTimeMillis();
      if (l - SubscriptFeedsActivity.a(this.a) > 1500L)
      {
        SubscriptFeedsActivity.a(this.a, l);
        UniteSearchActivity.a(this.a, null, 12);
        if (QLog.isColorLevel()) {
          QLog.d("SubscriptFeedsActivity", 2, "Search Subscript Account...");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.4
 * JD-Core Version:    0.7.0.1
 */