package com.tencent.mobileqq.activity.aio.core;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatPie$27
  implements Runnable
{
  BaseChatPie$27(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.this$0.d, this.this$0.ah);
    this.this$0.d.getMessageFacade().a(this.a, false);
    Object localObject = EmojiStickerManager.f(this.a);
    if (localObject != null)
    {
      EmojiStickerManager.a().i = 0;
      EmojiStickerManager.a().D.put(localObject, Boolean.valueOf(true));
      localObject = EmojiStickerManager.a().c(this.a);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          this.this$0.d.getMessageFacade().h(this.this$0.ah.b, this.this$0.ah.a, localLong.longValue());
        }
      }
    }
    this.this$0.m.post(new BaseChatPie.27.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.27
 * JD-Core Version:    0.7.0.1
 */