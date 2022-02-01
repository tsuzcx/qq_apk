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
      i = ChatXListView.c();
    } else {
      i >>= 2;
    }
    ChatXListView.a(i);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChatXListView open_panel_threshold_value = ");
      localStringBuilder.append(ChatXListView.d());
      QLog.d("ChatXListView", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView.1
 * JD-Core Version:    0.7.0.1
 */