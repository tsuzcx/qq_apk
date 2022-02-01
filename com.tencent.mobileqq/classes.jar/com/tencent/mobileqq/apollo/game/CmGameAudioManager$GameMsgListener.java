package com.tencent.mobileqq.apollo.game;

import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class CmGameAudioManager$GameMsgListener
  extends CmGameTempSessionHandler.DefaultMsgUIHandler
{
  public QQAppInterface a;
  
  CmGameAudioManager$GameMsgListener(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    CmGameAudioManager.a(((ApolloGameManagerImpl)this.a.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameAudioManager.GameMsgListener
 * JD-Core Version:    0.7.0.1
 */