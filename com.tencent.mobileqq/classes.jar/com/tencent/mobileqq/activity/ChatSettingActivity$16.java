package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class ChatSettingActivity$16
  implements Runnable
{
  ChatSettingActivity$16(ChatSettingActivity paramChatSettingActivity, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((StringBuilder)localObject1).length() > 0)) {
      localObject1 = this.a.toString();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.this$0;
    if (ChatSettingActivity.a((ChatSettingActivity)localObject2, ChatSettingActivity.a((ChatSettingActivity)localObject2), ChatSettingActivity.n(this.this$0), this.a) > 0)
    {
      localObject2 = this.this$0.G.obtainMessage();
      ((Message)localObject2).what = 18;
      ((Message)localObject2).obj = localObject1;
      ((Message)localObject2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */