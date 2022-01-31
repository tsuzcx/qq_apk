package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import ved;

class QQStoryBaseActivity$2
  implements Runnable
{
  QQStoryBaseActivity$2(QQStoryBaseActivity paramQQStoryBaseActivity, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.isFinishing())
    {
      ved.d("Q.qqstory.QQStoryBaseActivity", "Activity has been destroy.");
      return;
    }
    if (this.this$0.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity$ProgressView = new QQStoryBaseActivity.ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.this$0.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setContentView(this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity$ProgressView);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCancelable(this.jdField_a_of_type_Boolean);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity$ProgressView.a(this.jdField_a_of_type_JavaLangCharSequence);
      this.this$0.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.this$0.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */