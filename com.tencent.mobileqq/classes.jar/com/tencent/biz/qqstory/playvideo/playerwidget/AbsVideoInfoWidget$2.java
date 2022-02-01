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
    if (this.this$0.j == null)
    {
      this.this$0.k = new AbsVideoInfoWidget.ProgressView(this.a);
      this.this$0.j = new ReportDialog(this.a);
      this.this$0.j.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.j.setCanceledOnTouchOutside(false);
      this.this$0.j.requestWindowFeature(1);
      this.this$0.j.setContentView(this.this$0.k);
    }
    else
    {
      this.this$0.j.dismiss();
    }
    this.this$0.j.setCancelable(this.b);
    this.this$0.k.setProgressText(this.c);
    this.this$0.j.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.2
 * JD-Core Version:    0.7.0.1
 */