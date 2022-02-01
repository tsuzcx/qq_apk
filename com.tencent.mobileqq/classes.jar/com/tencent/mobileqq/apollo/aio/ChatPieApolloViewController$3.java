package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;

class ChatPieApolloViewController$3
  implements Runnable
{
  ChatPieApolloViewController$3(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, SpriteScriptManagerImpl paramSpriteScriptManagerImpl) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null)
    {
      SpriteScriptManagerImpl localSpriteScriptManagerImpl = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl;
      if (localSpriteScriptManagerImpl != null)
      {
        localSpriteScriptManagerImpl.updateSessionInfo(localBaseChatPie.a);
        this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl.preloadSpriteData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */