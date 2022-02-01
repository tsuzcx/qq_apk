package com.tencent.mobileqq.activity;

import bhdf;
import com.tencent.mobileqq.app.QQAppInterface;

class ChatSettingForTroop$32
  implements Runnable
{
  ChatSettingForTroop$32(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    bhdf.a(this.this$0.app.getCurrentAccountUin(), "troop_game_feed", this.a, 0);
    bhdf.a(this.this$0.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.a, this.this$0.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.32
 * JD-Core Version:    0.7.0.1
 */