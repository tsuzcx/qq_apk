package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

class TroopFileItemBuilder$5
  implements Runnable
{
  public void run()
  {
    this.this$0.d.getMessageFacade().h(this.a.frienduin, this.a.istroop, this.a.uniseq);
    this.this$0.a.post(new TroopFileItemBuilder.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */