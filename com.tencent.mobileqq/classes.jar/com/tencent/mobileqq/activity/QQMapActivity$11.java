package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQMapActivity$11
  implements View.OnClickListener
{
  QQMapActivity$11(QQMapActivity paramQQMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.b.runOnUiThread(new QQMapActivity.11.1(this));
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.11
 * JD-Core Version:    0.7.0.1
 */