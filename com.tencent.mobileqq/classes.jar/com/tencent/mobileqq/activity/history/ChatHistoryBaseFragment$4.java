package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class ChatHistoryBaseFragment$4
  implements Runnable
{
  ChatHistoryBaseFragment$4(ChatHistoryBaseFragment paramChatHistoryBaseFragment, DialogInterface.OnCancelListener paramOnCancelListener, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()))
    {
      if (this.this$0.b != null) {
        break label175;
      }
      this.this$0.a = new ChatHistoryBaseFragment.ProgressView(this.this$0.getActivity());
      this.this$0.b = new ReportDialog(this.this$0.getActivity());
      this.this$0.b.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.b.setCanceledOnTouchOutside(false);
      this.this$0.b.requestWindowFeature(1);
      this.this$0.b.setContentView(this.this$0.a);
      this.this$0.b.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    }
    for (;;)
    {
      this.this$0.a.a(this.jdField_a_of_type_JavaLangCharSequence);
      this.this$0.b.show();
      return;
      label175:
      this.this$0.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */