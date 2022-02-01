package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.Toast;

class ChatHistory$ChatHistoryAdapter$5$1
  implements Runnable
{
  ChatHistory$ChatHistoryAdapter$5$1(ChatHistory.ChatHistoryAdapter.5 param5, Object paramObject, View paramView) {}
  
  public void run()
  {
    if ((this.c.a == 0) && ((this.c.c.f.al == null) || (!this.c.c.f.al.a(0, this.a))))
    {
      Toast.makeText(this.c.c.c, this.c.c.f.getString(2131916085), 0).show();
      return;
    }
    if (this.c.c.f.al == null) {
      this.c.c.f.al = new ChatHistory.PlayingPttHistoryInfo(this.c.c.f);
    }
    this.c.c.f.al.a(0, this.b, this.a, this.c.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */