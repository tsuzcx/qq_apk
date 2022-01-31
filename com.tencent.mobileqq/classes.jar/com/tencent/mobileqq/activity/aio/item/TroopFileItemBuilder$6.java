package com.tencent.mobileqq.activity.aio.item;

import afzs;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class TroopFileItemBuilder$6
  implements Runnable
{
  public TroopFileItemBuilder$6(afzs paramafzs, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    this.this$0.a.a().b(this.a.frienduin, this.a.istroop, this.a.uniseq);
    this.this$0.b.post(new TroopFileItemBuilder.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */