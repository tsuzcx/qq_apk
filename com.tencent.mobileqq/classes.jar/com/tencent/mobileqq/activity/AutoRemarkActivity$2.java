package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoRemarkActivity$2
  implements View.OnClickListener
{
  AutoRemarkActivity$2(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.k != null) && (this.a.k.isShowing()) && (this.a.k.getWindow() != null)) {}
    try
    {
      this.a.k.dismiss();
      label46:
      this.a.k = null;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity.2
 * JD-Core Version:    0.7.0.1
 */