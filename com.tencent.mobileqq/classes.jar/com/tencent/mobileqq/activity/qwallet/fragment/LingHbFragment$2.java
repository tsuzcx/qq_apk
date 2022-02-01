package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LingHbFragment$2
  implements View.OnClickListener
{
  LingHbFragment$2(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      String str = ((TextView)paramView).getText().toString();
      QLog.i("LingHbFragment", 2, "choice: " + str);
      this.a.c.setText(str);
      this.a.a.post(new LingHbFragment.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment.2
 * JD-Core Version:    0.7.0.1
 */