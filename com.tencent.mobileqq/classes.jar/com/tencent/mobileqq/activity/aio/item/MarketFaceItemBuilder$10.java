package com.tencent.mobileqq.activity.aio.item;

import adue;
import adus;
import anvx;
import aobp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder$10
  implements Runnable
{
  public MarketFaceItemBuilder$10(adue paramadue, adus paramadus, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.a.a(this.jdField_a_of_type_Adus.a.a, 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.10.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */