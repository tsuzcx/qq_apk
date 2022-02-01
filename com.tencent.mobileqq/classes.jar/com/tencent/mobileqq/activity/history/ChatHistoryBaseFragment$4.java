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
      if (this.this$0.b == null)
      {
        ChatHistoryBaseFragment localChatHistoryBaseFragment = this.this$0;
        localChatHistoryBaseFragment.a = new ChatHistoryBaseFragment.ProgressView(localChatHistoryBaseFragment.getBaseActivity());
        localChatHistoryBaseFragment = this.this$0;
        localChatHistoryBaseFragment.b = new ReportDialog(localChatHistoryBaseFragment.getBaseActivity());
        this.this$0.b.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.this$0.b.setCanceledOnTouchOutside(false);
        this.this$0.b.requestWindowFeature(1);
        this.this$0.b.setContentView(this.this$0.a);
        this.this$0.b.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      }
      else
      {
        this.this$0.b.dismiss();
      }
      this.this$0.a.a(this.jdField_a_of_type_JavaLangCharSequence);
      this.this$0.b.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */