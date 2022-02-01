package com.tencent.mobileqq.activity.aio.core;

import acvv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatPie$76
  implements Runnable
{
  BaseChatPie$76(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    acvv.a(this.this$0.app, this.this$0.sessionInfo);
    this.this$0.app.getMessageFacade().removeMsgByMessageRecord(this.val$cm, false);
    Object localObject = EmojiStickerManager.a(this.val$cm);
    if (localObject != null)
    {
      EmojiStickerManager.a().jdField_b_of_type_Int = 0;
      EmojiStickerManager.a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localObject, Boolean.valueOf(true));
      localObject = EmojiStickerManager.a().a(this.val$cm);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          this.this$0.app.getMessageFacade().removeMsgByUniseq(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, localLong.longValue());
        }
      }
    }
    this.this$0.uiHandler.post(new BaseChatPie.76.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.76
 * JD-Core Version:    0.7.0.1
 */