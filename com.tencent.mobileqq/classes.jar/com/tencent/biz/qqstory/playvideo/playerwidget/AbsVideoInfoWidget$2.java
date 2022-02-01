package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AbsVideoInfoWidget$2
  implements Runnable
{
  AbsVideoInfoWidget$2(AbsVideoInfoWidget paramAbsVideoInfoWidget, Context paramContext, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$ProgressView = new AbsVideoInfoWidget.ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.this$0.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setContentView(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$ProgressView);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCancelable(this.jdField_a_of_type_Boolean);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$ProgressView.setProgressText(this.jdField_a_of_type_JavaLangCharSequence);
      this.this$0.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.this$0.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.2
 * JD-Core Version:    0.7.0.1
 */