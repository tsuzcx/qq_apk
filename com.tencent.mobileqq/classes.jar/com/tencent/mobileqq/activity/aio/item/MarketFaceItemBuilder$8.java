package com.tencent.mobileqq.activity.aio.item;

import ahaw;
import ahbj;
import asih;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder$8
  implements Runnable
{
  public MarketFaceItemBuilder$8(ahaw paramahaw, ahbj paramahbj, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.a.a(this.jdField_a_of_type_Ahbj.a.emoticon, 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.8.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */