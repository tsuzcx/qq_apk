package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.ContactUtils;

class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  ChatHistory$ChatHistoryAdapter$1(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString, ChatHistory.Holder paramHolder, TextView paramTextView) {}
  
  public void run()
  {
    String str = ContactUtils.a(this.e.f.app, this.e.f.K, MessageRecordInfo.b(this.a), this.b);
    if (this.c.d.equals(this.b)) {
      this.c.c = str;
    }
    this.e.f.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */