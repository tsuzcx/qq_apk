package com.tencent.mobileqq.activity.aio.item;

import awav;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import java.util.Iterator;
import java.util.List;

class LightVideoItemBuilder$2
  implements Runnable
{
  LightVideoItemBuilder$2(LightVideoItemBuilder paramLightVideoItemBuilder, MessageForLightVideo paramMessageForLightVideo) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (((localChatMessage instanceof MessageForLightVideo)) && (localChatMessage.uniseq == this.a.uniseq)) {
          localChatMessage.saveExtInfoToExtStr(awav.u, "1");
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extLong", Integer.valueOf(this.a.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */