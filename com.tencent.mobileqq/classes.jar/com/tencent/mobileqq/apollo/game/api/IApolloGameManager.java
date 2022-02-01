package com.tencent.mobileqq.apollo.game.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Deprecated;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(needUin=true, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/game/api/IApolloGameManager;", "Lmqq/app/api/IRuntimeService;", "onGetGameStatus", "", "from", "", "aioType", "friendUin", "", "gameStatusObj", "Ljava/lang/Object;", "reqUsrGameList", "resetReqUsrGameList", "Constant", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloGameManager
  extends IRuntimeService
{
  public static final IApolloGameManager.Constant Constant = IApolloGameManager.Constant.a;
  public static final int GAME_STATUS_UPDATE_FROM_PULL = 1;
  public static final int GAME_STATUS_UPDATE_FROM_PUSH = 0;
  public static final int GET_GAME_STATUS_FROM_FIRST_OPEN_AIO = 1;
  public static final int GET_GAME_STATUS_FROM_MSG_PULL_BACK = 3;
  public static final int GET_GAME_STATUS_FROM_ON_STOP_SCROLL = 2;
  @NotNull
  public static final String REQ_FROM_TYPE_PLAYGAME = "android.playgame";
  @NotNull
  public static final String REQ_FROM_TYPE_WEB = "android.web";
  @NotNull
  public static final String REQ_FROM_TYPE_WECHAT = "android.wechat";
  @NotNull
  public static final String TAG = "ApolloGameManager";
  
  @Deprecated(message="轻游下架")
  public abstract void onGetGameStatus(int paramInt1, int paramInt2, @Nullable String paramString, @Nullable Object paramObject);
  
  public abstract void reqUsrGameList();
  
  public abstract void resetReqUsrGameList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.api.IApolloGameManager
 * JD-Core Version:    0.7.0.1
 */