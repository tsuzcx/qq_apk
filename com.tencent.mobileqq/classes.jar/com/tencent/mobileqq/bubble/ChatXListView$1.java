package com.tencent.mobileqq.bubble;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class ChatXListView$1
  implements Runnable
{
  ChatXListView$1(ChatXListView paramChatXListView, Context paramContext) {}
  
  public void run()
  {
    int i = ((Activity)this.a).getWindowManager().getDefaultDisplay().getHeight();
    if (i <= 0) {
      i = ChatXListView.a();
    }
    for (;;)
    {
      ChatXListView.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("ChatXListView", 2, "ChatXListView open_panel_threshold_value = " + ChatXListView.b());
      }
      return;
      i >>= 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView.1
 * JD-Core Version:    0.7.0.1
 */