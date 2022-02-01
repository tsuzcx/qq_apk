package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;

class ChatPieApolloViewController$7
  implements Runnable
{
  ChatPieApolloViewController$7(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, SpriteScriptManagerImpl paramSpriteScriptManagerImpl) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl.updateSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl.preloadSpriteData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.7
 * JD-Core Version:    0.7.0.1
 */