package com.tencent.mobileqq.activity;

import acjm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatPie$83
  implements Runnable
{
  BaseChatPie$83(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    acjm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a, false);
    Object localObject = EmojiStickerManager.a(this.a);
    if (localObject != null)
    {
      EmojiStickerManager.a().jdField_b_of_type_Int = 0;
      EmojiStickerManager.a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localObject, Boolean.valueOf(true));
      localObject = EmojiStickerManager.a().a(this.a);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localLong.longValue());
        }
      }
    }
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.83.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.83
 * JD-Core Version:    0.7.0.1
 */