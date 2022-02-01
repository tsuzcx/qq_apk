package com.tencent.avgame.ui;

import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;

public abstract interface IAVGameRootContainer
{
  public abstract boolean checkDestroyed();
  
  public abstract boolean getGameExitStatus();
  
  public abstract String getRoomId();
  
  public abstract boolean isExitByFinish();
  
  public abstract boolean isNewEnter();
  
  public abstract void notifyExitGamed();
  
  public abstract void refreshActivityCenter(GameActivityCenterEntry paramGameActivityCenterEntry);
  
  public abstract void showResult();
  
  public abstract void showRoom();
  
  public abstract void updateRoomInfo(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.IAVGameRootContainer
 * JD-Core Version:    0.7.0.1
 */