package com.tencent.biz.qqcircle.widgets;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;

class QCircleFeedCommentWidget$10
  implements DialogInterface.OnClickListener
{
  QCircleFeedCommentWidget$10(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HostUIHelper.closeHostEnvironment();
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.10
 * JD-Core Version:    0.7.0.1
 */