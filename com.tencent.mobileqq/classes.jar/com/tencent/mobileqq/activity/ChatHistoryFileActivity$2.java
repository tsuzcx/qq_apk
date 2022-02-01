package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistoryFileActivity$2
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryFileActivity$2(ChatHistoryFileActivity paramChatHistoryFileActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.b;
    paramView.a(3, paramView.j, this.b.k, this.b.l, this.b.m);
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.2
 * JD-Core Version:    0.7.0.1
 */