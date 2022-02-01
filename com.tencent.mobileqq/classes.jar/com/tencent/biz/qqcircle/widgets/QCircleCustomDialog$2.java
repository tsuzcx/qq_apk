package com.tencent.biz.qqcircle.widgets;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleCustomDialog$2
  implements View.OnClickListener
{
  QCircleCustomDialog$2(QCircleCustomDialog paramQCircleCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.b, 0);
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNegativeButton click trigger dismiss error:");
      localStringBuilder.append(localException.toString());
      QLog.e("QCircleCustomDialog", 1, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */