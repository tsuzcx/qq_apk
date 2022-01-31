package com.tencent.mobileqq.activity.aio.item;

import afvg;
import afvu;
import apro;
import apxv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder$10
  implements Runnable
{
  public MarketFaceItemBuilder$10(afvg paramafvg, afvu paramafvu, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.a.a(this.jdField_a_of_type_Afvu.a.a, 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.10.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */