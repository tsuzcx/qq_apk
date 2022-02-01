package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;

class ChatPieApolloViewController$4
  implements Runnable
{
  ChatPieApolloViewController$4(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, SpriteScriptManagerImpl paramSpriteScriptManagerImpl) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie != null)
    {
      SpriteScriptManagerImpl localSpriteScriptManagerImpl = this.b;
      if (localSpriteScriptManagerImpl != null)
      {
        localSpriteScriptManagerImpl.updateSessionInfo(localBaseChatPie.ah);
        this.b.preloadSpriteData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController.4
 * JD-Core Version:    0.7.0.1
 */