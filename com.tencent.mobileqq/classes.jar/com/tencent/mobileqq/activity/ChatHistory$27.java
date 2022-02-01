package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistory$27
  implements ActionSheet.OnButtonClickListener
{
  ChatHistory$27(ChatHistory paramChatHistory, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramView = this.c.W.obtainMessage(1);
      this.c.W.sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new ChatHistory.27.1(this), new MessageRecord[] { this.a });
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.27
 * JD-Core Version:    0.7.0.1
 */