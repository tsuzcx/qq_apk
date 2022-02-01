package com.tencent.mobileqq.activity.recent.gamemsgbox.api;

import android.content.SharedPreferences;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.IGameMsgCallback;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameTabData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGameMsgBoxManager
  extends IRuntimeService
{
  public abstract void asyncFindGameBoxRecentUserInfo(String paramString, ILoadGameListener<GameBoxRecentUser> paramILoadGameListener);
  
  public abstract void fetchRecentGameContacts(boolean paramBoolean, IGameContactFetchListener paramIGameContactFetchListener);
  
  public abstract GameBoxRecentUser findGameBoxRecentUserInfo(String paramString);
  
  public abstract GameDetailInfo findGameDetailInfoByConvertUin(String paramString);
  
  public abstract List<RecentUser> getAllOpenSyncRecentUserList();
  
  public abstract ArrayList<String> getAppidsInGameBox();
  
  public abstract IGameMsgCallback getCallback();
  
  public abstract List<RecentGameTabData> getGameBoxTabDataList();
  
  public abstract List<RecentUser> getGameMsgBoxRecentUsers();
  
  public abstract SharedPreferences getGameMsgBoxSp();
  
  public abstract List<RecentUser> getNotOpenSyncRecentUserList(String paramString);
  
  public abstract List<RecentGameTabData> getTitles();
  
  public abstract int getUnreadCount(String paramString);
  
  public abstract boolean isGameInGameBox(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract boolean isGameInGameBox(String paramString);
  
  public abstract boolean isShowGameBoxTips();
  
  public abstract boolean isShowGameMsgUpgradingToast();
  
  public abstract boolean shouldShowRedPoint(GameSwitchConfig paramGameSwitchConfig);
  
  public abstract RecentUser syncGetLastRecentUser(String paramString);
  
  public abstract List<RecentUser> syncGetRecentUserList(String paramString);
  
  public abstract void tryUpdateGameMsgInfoFromRecentUser();
  
  public abstract void updateGameMsgBoxRecentUsers();
  
  public abstract void updateIsTop(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void updateRedPointShowState(boolean paramBoolean, String paramString);
  
  public abstract void updateShowGameBoxTips(boolean paramBoolean);
  
  public abstract void updateShowGameMsgUpgradingToast(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager
 * JD-Core Version:    0.7.0.1
 */