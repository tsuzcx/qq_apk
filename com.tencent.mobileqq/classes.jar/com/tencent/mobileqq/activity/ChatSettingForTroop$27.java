package com.tencent.mobileqq.activity;

import bdgg;
import com.tencent.mobileqq.app.QQAppInterface;

class ChatSettingForTroop$27
  implements Runnable
{
  ChatSettingForTroop$27(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    bdgg.a(this.this$0.app.getCurrentAccountUin(), "troop_game_feed", this.a, 0);
    bdgg.a(this.this$0.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.a, this.this$0.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.27
 * JD-Core Version:    0.7.0.1
 */