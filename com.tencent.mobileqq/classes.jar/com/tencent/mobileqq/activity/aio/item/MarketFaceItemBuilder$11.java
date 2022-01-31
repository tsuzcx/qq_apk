package com.tencent.mobileqq.activity.aio.item;

import adje;
import adjt;
import anfj;
import anla;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder$11
  implements Runnable
{
  public MarketFaceItemBuilder$11(adje paramadje, adjt paramadjt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.a.a(this.jdField_a_of_type_Adjt.a.a, 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.11.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */