package com.tencent.avgame.business.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

@Service(needUin=false, process={""})
public abstract interface IAvGameManager
  extends IRuntimeService, Manager
{
  public static final int GROUP_GAME_ROOM_LIST_REQ_FROM_AIO_BANNER = 1;
  public static final int GROUP_GAME_ROOM_LIST_REQ_FROM_LIST_FRAGMENT = 2;
  
  public abstract void createAvGameRoom(Activity paramActivity, int paramInt1, String paramString, int paramInt2);
  
  public abstract void createAvGameRoom(Activity paramActivity, int paramInt1, String paramString, int paramInt2, Bundle paramBundle);
  
  public abstract boolean destroyAllGameRoom(String paramString);
  
  public abstract String getAvGameRoomId();
  
  public abstract GameResultUploadMgrForRemote getGameResultShareMgr();
  
  public abstract boolean isAVGameOpen(String paramString);
  
  public abstract boolean isAvGameRoomExist();
  
  public abstract boolean isAvGameRoomExistReEnterDialog(Activity paramActivity);
  
  public abstract boolean isCurrentPkSurvivalEmptyRoom();
  
  public abstract boolean isLobbyEntryStatus();
  
  public abstract boolean isOnlyAllowManagerCreateAVGame(String paramString);
  
  public abstract void joinAvGameRoom(Activity paramActivity, int paramInt, String paramString1, String paramString2);
  
  public abstract void notifySendMsg(int paramInt, String paramString1, String paramString2);
  
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
  
  public abstract void onPermisionDenied(Activity paramActivity);
  
  public abstract boolean requestGameRoomListForGroup(String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean requestGetShareLink(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3);
  
  public abstract boolean requestShareInviteBackflowInfo(String paramString, long paramLong);
  
  public abstract void setCurrentAvGameRoomInfo(int paramInt, String paramString);
  
  public abstract void setLobbyEntryStatus(boolean paramBoolean);
  
  public abstract void startStrangerMatch(Activity paramActivity, int paramInt);
  
  public abstract void startStrangerMatchNotCheck(int paramInt);
  
  public abstract void startStrangerMatchV2(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void startSurvivalGame(Activity paramActivity, int paramInt, boolean paramBoolean);
  
  public abstract void startSurvivalGame(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void startSurvivalGame(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.IAvGameManager
 * JD-Core Version:    0.7.0.1
 */