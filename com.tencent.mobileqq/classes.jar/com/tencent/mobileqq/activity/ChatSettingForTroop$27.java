package com.tencent.mobileqq.activity;

import babl;
import com.tencent.mobileqq.app.QQAppInterface;

class ChatSettingForTroop$27
  implements Runnable
{
  ChatSettingForTroop$27(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    babl.a(this.this$0.app.getCurrentAccountUin(), "troop_game_feed", this.a, 0);
    babl.a(this.this$0.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.a, this.this$0.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.27
 * JD-Core Version:    0.7.0.1
 */