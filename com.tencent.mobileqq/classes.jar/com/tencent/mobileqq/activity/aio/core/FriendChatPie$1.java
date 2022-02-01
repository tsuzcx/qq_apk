package com.tencent.mobileqq.activity.aio.core;

import afiw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$1
  implements Runnable
{
  public FriendChatPie$1(afiw paramafiw) {}
  
  public void run()
  {
    this.this$0.app.getMessageFacade().sendSpecialMessage("babyq_set_avator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.1
 * JD-Core Version:    0.7.0.1
 */