package com.tencent.mobileqq.apollo.lightGame;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
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
    CmGameAudioManager.a(((ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[onQueryAudioRoomId] friUin:" + paramString + ",roomID:" + paramInt1);
    super.b(paramString, paramInt1, paramInt2);
    ((ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().a(paramString, String.valueOf(paramInt1), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager.GameMsgListener
 * JD-Core Version:    0.7.0.1
 */