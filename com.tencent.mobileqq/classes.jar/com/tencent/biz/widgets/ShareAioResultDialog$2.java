package com.tencent.biz.widgets;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareAioResultDialog$2
  implements View.OnClickListener
{
  ShareAioResultDialog$2(ShareAioResultDialog paramShareAioResultDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog, 1);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog.2
 * JD-Core Version:    0.7.0.1
 */