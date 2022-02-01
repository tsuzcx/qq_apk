package com.tencent.ilivesdk.qualityreportservice_interface;

import android.os.Bundle;

public abstract interface AudQualityServiceInterface
{
  public abstract void reportEnterOver();
  
  public abstract void reportEnterRoom();
  
  public abstract void reportEnterRoomFail(int paramInt);
  
  public abstract void reportEnterRoomSuc();
  
  public abstract void reportExitRoom(long paramLong);
  
  public abstract void reportFirstFrame();
  
  public abstract void reportFistPreloadFrame();
  
  public abstract void reportLoginFail(int paramInt);
  
  public abstract void reportLoginSuc();
  
  public abstract void reportPlayFail(int paramInt);
  
  public abstract void reportSendGiftFail(long paramLong, int paramInt);
  
  public abstract void reportSendGiftStart(long paramLong);
  
  public abstract void reportSendGiftSuc(long paramLong);
  
  public abstract void reportStartEnter(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle);
  
  public abstract void reportStartPlay();
  
  public abstract void reportSwitchEnterRoom();
  
  public abstract void reportSwitchEnterRoomFail(int paramInt);
  
  public abstract void reportSwitchEnterRoomSuc();
  
  public abstract void reportSwitchFirstFrame();
  
  public abstract void reportSwitchFistPreloadFrame();
  
  public abstract void reportSwitchOver();
  
  public abstract void reportSwitchPlayFail(int paramInt);
  
  public abstract void reportSwitchRoom(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void reportSwitchStartPlay();
  
  public abstract void setEnterRoomCode(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface
 * JD-Core Version:    0.7.0.1
 */