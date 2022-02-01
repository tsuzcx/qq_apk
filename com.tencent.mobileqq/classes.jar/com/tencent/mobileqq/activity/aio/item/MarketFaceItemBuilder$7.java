package com.tencent.mobileqq.activity.aio.item;

import ahch;
import ahcu;
import arup;
import asbq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder$7
  implements Runnable
{
  public MarketFaceItemBuilder$7(ahch paramahch, ahcu paramahcu, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.a.a(this.jdField_a_of_type_Ahcu.a.a, 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.7.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */