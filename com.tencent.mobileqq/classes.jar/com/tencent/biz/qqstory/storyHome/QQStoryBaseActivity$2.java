package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class QQStoryBaseActivity$2
  implements Runnable
{
  QQStoryBaseActivity$2(QQStoryBaseActivity paramQQStoryBaseActivity, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.isFinishing())
    {
      SLog.d("Q.qqstory.QQStoryBaseActivity", "Activity has been destroy.");
      return;
    }
    if (this.this$0.mLoadingDialog == null)
    {
      this.this$0.mLoadingView = new QQStoryBaseActivity.ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.mLoadingDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.mLoadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.mLoadingDialog.setCanceledOnTouchOutside(false);
      this.this$0.mLoadingDialog.requestWindowFeature(1);
      this.this$0.mLoadingDialog.setContentView(this.this$0.mLoadingView);
      this.this$0.mLoadingDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    else
    {
      this.this$0.mLoadingDialog.dismiss();
    }
    this.this$0.mLoadingDialog.setCancelable(this.jdField_a_of_type_Boolean);
    this.this$0.mLoadingView.a(this.jdField_a_of_type_JavaLangCharSequence);
    this.this$0.mLoadingDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */