package com.tencent.biz.widgets;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareAioResultDialog$1
  implements View.OnClickListener
{
  ShareAioResultDialog$1(ShareAioResultDialog paramShareAioResultDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog, 0);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog.1
 * JD-Core Version:    0.7.0.1
 */