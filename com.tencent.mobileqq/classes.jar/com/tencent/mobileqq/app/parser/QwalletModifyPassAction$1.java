package com.tencent.mobileqq.app.parser;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QwalletModifyPassAction$1
  implements View.OnClickListener
{
  QwalletModifyPassAction$1(QwalletModifyPassAction paramQwalletModifyPassAction) {}
  
  public void onClick(View paramView)
  {
    if ((QwalletModifyPassAction.a(this.a) != null) && (QwalletModifyPassAction.a(this.a).isShowing())) {
      QwalletModifyPassAction.a(this.a).dismiss();
    }
    QwalletModifyPassAction.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletModifyPassAction.1
 * JD-Core Version:    0.7.0.1
 */