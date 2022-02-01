package com.tencent.biz.qqstory.troop.forward;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;

class TroopStoryForwardTask$2$1
  implements Runnable
{
  TroopStoryForwardTask$2$1(TroopStoryForwardTask.2 param2, String paramString) {}
  
  public void run()
  {
    this.b.d.d.storyId = this.a;
    this.b.d.d.serial();
    this.b.d.c.getMessageFacade().a(this.b.d.d.frienduin, this.b.d.d.istroop, this.b.d.d.uniseq, this.b.d.d.msgData);
    this.b.d.b.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.2.1
 * JD-Core Version:    0.7.0.1
 */