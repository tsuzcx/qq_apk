package com.tencent.mobileqq.app.parser;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QwalletModifyPassAction$2
  implements View.OnClickListener
{
  QwalletModifyPassAction$2(QwalletModifyPassAction paramQwalletModifyPassAction) {}
  
  public void onClick(View paramView)
  {
    if ((QwalletModifyPassAction.a(this.a) != null) && (QwalletModifyPassAction.a(this.a).isShowing())) {
      QwalletModifyPassAction.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletModifyPassAction.2
 * JD-Core Version:    0.7.0.1
 */