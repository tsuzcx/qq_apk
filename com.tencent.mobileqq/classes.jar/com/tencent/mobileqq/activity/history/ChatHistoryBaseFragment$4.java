package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class ChatHistoryBaseFragment$4
  implements Runnable
{
  ChatHistoryBaseFragment$4(ChatHistoryBaseFragment paramChatHistoryBaseFragment, DialogInterface.OnCancelListener paramOnCancelListener, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if ((this.this$0.getBaseActivity() != null) && (!this.this$0.getBaseActivity().isFinishing()))
    {
      if (this.this$0.q == null)
      {
        ChatHistoryBaseFragment localChatHistoryBaseFragment = this.this$0;
        localChatHistoryBaseFragment.r = new ChatHistoryBaseFragment.ProgressView(localChatHistoryBaseFragment.getBaseActivity());
        localChatHistoryBaseFragment = this.this$0;
        localChatHistoryBaseFragment.q = new ReportDialog(localChatHistoryBaseFragment.getBaseActivity());
        this.this$0.q.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.this$0.q.setCanceledOnTouchOutside(false);
        this.this$0.q.requestWindowFeature(1);
        this.this$0.q.setContentView(this.this$0.r);
        this.this$0.q.setOnCancelListener(this.a);
      }
      else
      {
        this.this$0.q.dismiss();
      }
      this.this$0.r.a(this.b);
      this.this$0.q.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */