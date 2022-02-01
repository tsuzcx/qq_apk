package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameContactFetchListener;

class GameMsgBoxManagerImpl$1
  implements Runnable
{
  GameMsgBoxManagerImpl$1(GameMsgBoxManagerImpl paramGameMsgBoxManagerImpl, boolean paramBoolean, IGameContactFetchListener paramIGameContactFetchListener) {}
  
  public void run()
  {
    this.this$0.syncLoadRecentGameContacts(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */