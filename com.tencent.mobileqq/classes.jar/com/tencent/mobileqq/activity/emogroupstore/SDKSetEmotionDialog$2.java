package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SDKSetEmotionDialog$2
  implements View.OnClickListener
{
  SDKSetEmotionDialog$2(SDKSetEmotionDialog paramSDKSetEmotionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKSetEmotionDialog.2
 * JD-Core Version:    0.7.0.1
 */