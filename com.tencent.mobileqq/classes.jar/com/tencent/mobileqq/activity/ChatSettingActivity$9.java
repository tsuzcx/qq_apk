package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class ChatSettingActivity$9
  implements Runnable
{
  ChatSettingActivity$9(ChatSettingActivity paramChatSettingActivity, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    Message localMessage = null;
    Object localObject = localMessage;
    if (this.a != null)
    {
      localObject = localMessage;
      if (this.a.length() > 0) {
        localObject = this.a.toString();
      }
    }
    if (ChatSettingActivity.a(this.this$0, ChatSettingActivity.a(this.this$0), ChatSettingActivity.a(this.this$0), this.a) > 0)
    {
      localMessage = this.this$0.a.obtainMessage();
      localMessage.what = 18;
      localMessage.obj = localObject;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.9
 * JD-Core Version:    0.7.0.1
 */