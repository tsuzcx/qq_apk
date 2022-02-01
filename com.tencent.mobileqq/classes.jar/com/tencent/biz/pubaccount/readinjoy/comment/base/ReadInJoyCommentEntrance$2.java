package com.tencent.biz.pubaccount.readinjoy.comment.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ReadInJoyCommentEntrance$2
  implements DialogInterface.OnDismissListener
{
  ReadInJoyCommentEntrance$2(ReadInJoyCommentEntrance paramReadInJoyCommentEntrance, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance.2
 * JD-Core Version:    0.7.0.1
 */