package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import mqq.os.MqqHandler;

class MarketFaceItemBuilder$8
  implements Runnable
{
  MarketFaceItemBuilder$8(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.D.downloadAIOEmoticon(this.a.a.getEmoticon(), 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.8.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */