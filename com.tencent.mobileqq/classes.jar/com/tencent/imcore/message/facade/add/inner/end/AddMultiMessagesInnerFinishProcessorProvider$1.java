package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class AddMultiMessagesInnerFinishProcessorProvider$1
  extends ArrayList<IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>>
{
  AddMultiMessagesInnerFinishProcessorProvider$1(AddMultiMessagesInnerFinishProcessorProvider paramAddMultiMessagesInnerFinishProcessorProvider)
  {
    add(new EcShopProcessor());
    add(new InComingMsgProcessor());
    add(new UpdateUnreadProcessor());
    add(new TroopAssistantProcessor());
    add(new HotChatCenterProcessor());
    add(new DecodeMsgProcessor());
    add(new TroopBarAssistantProcessor());
    add(new ServiceAccountFolderProcessor());
    add(new ForwardOrderProcessor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.AddMultiMessagesInnerFinishProcessorProvider.1
 * JD-Core Version:    0.7.0.1
 */