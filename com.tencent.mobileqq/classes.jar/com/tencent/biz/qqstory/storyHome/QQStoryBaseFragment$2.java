package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class QQStoryBaseFragment$2
  implements Runnable
{
  public void run()
  {
    if (this.this$0.f())
    {
      SLog.d("IphoneTitleBarFragment", "Activity has been destroy.");
      return;
    }
    if (this.this$0.n == null)
    {
      this.this$0.o = new QQStoryBaseFragment.ProgressView(this.a);
      this.this$0.n = new ReportDialog(this.a);
      this.this$0.n.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.n.setCanceledOnTouchOutside(false);
      this.this$0.n.requestWindowFeature(1);
      this.this$0.n.setContentView(this.this$0.o);
    }
    else
    {
      this.this$0.n.dismiss();
    }
    this.this$0.n.setCancelable(this.b);
    this.this$0.o.a(this.c);
    this.this$0.n.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */