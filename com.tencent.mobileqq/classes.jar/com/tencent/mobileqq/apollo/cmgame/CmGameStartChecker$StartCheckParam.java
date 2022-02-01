package com.tencent.mobileqq.apollo.cmgame;

import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.data.ApolloGameData;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class CmGameStartChecker$StartCheckParam
  implements Serializable
{
  public static final int COMMON_FLAG_BIT_SHOW_QUIT_TIPS = 1;
  public static final int COMMON_FLAG_BIT_SHOW_RED_PACKET_BTN = 2;
  public static final int COMMON_FLAG_BIT_SHOW_RED_PACKET_FLOAT_VIEW = 4;
  public static final int START_MODE_FROM_TIPBAR = 1;
  public static final int START_MODE_IN_GAME = 2;
  public static final int START_MODE_MAIN_LOADING = 3;
  public static final int START_MODE_NORMAL = 0;
  private static final long serialVersionUID = 1L;
  public long adDevUin;
  public String adForbidPosId;
  public int adShareRate;
  public int aioType;
  public String apolloGameSt;
  public String apolloGameStkey;
  public int apolloStatus;
  public int appIdSrc;
  public int commFlag;
  public int delayMs;
  public boolean disableMinGame;
  public boolean enableMenu = true;
  public int enter;
  public String extInfoFromSvr;
  public String extendJson;
  public String from;
  public ApolloGameData game;
  public int gameId;
  public int gameMode;
  public String gameName;
  public int gameTypeForRedPacket;
  public int gender;
  public boolean isCreator;
  public boolean isEnableMSAA;
  public boolean isGameRscExist;
  public boolean isNeedConfInfo;
  public boolean isPatch;
  public boolean isRequestConf;
  public boolean isRunning;
  public boolean isWhiteUsr;
  public boolean launchNewGame;
  public long mCreateTs;
  public String mExtraStr;
  public String mFriendUin;
  public int mGameType;
  public boolean mIsTransGame;
  public boolean mLoadingOnMainProcess;
  public boolean mOpenTempAIOOnFinish;
  public String mRobotOpenId;
  public String mSSORule;
  public String mSendMsgUin;
  public int mStartType = 0;
  public String mTempAIONickName;
  public String mTempAIOUin;
  public boolean mUpdated;
  public int msgGameStatus;
  public boolean notFullScreen;
  public String openId;
  public CmGamePushItem pushItem;
  public String redUrl;
  public long requestCode;
  public long retCode;
  public long roomId;
  public String rpIconUrl;
  public String rpUrl;
  public String sessionOpenId;
  public int sessionType;
  public String sessionUin;
  public boolean showAlertTips;
  public int src;
  public long startCallEngine;
  public long startCheckGame;
  public long startT;
  public ConcurrentHashMap<String, Long> statMap = new ConcurrentHashMap();
  public String styleString;
  public String transInfo;
  public String version;
  public int viewMode;
  public String wordingV2;
  public String zipMD5;
  
  public CmGameStartChecker$StartCheckParam(int paramInt1, boolean paramBoolean, String paramString1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, String paramString3)
  {
    this.gameId = paramInt1;
    this.isCreator = paramBoolean;
    this.from = paramString1;
    this.enter = paramInt2;
    this.gameMode = paramInt3;
    this.sessionType = paramInt5;
    this.sessionUin = paramString2;
    this.src = paramInt6;
    this.aioType = paramInt4;
    this.roomId = paramLong;
    this.gameName = paramString3;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("StartCheckParam{");
    localStringBuffer.append("game=").append(this.game);
    localStringBuffer.append(", pushItem=").append(this.pushItem);
    localStringBuffer.append(", mSendMsgUin='").append(this.mSendMsgUin).append('\'');
    localStringBuffer.append(", gameId=").append(this.gameId);
    localStringBuffer.append(", gameName='").append(this.gameName).append('\'');
    localStringBuffer.append(", isCreator=").append(this.isCreator);
    localStringBuffer.append(", from='").append(this.from).append('\'');
    localStringBuffer.append(", roomId=").append(this.roomId);
    localStringBuffer.append(", enter=").append(this.enter);
    localStringBuffer.append(", isRunning=").append(this.isRunning);
    localStringBuffer.append(", gameMode=").append(this.gameMode);
    localStringBuffer.append(", viewMode=").append(this.viewMode);
    localStringBuffer.append(", sessionType=").append(this.sessionType);
    localStringBuffer.append(", aioType=").append(this.aioType);
    localStringBuffer.append(", sessionUin='").append(this.sessionUin).append('\'');
    localStringBuffer.append(", src=").append(this.src);
    localStringBuffer.append(", requestCode=").append(this.requestCode);
    localStringBuffer.append(", extendJson='").append(this.extendJson).append('\'');
    localStringBuffer.append(", version='").append(this.version).append('\'');
    localStringBuffer.append(", isPatch=").append(this.isPatch);
    localStringBuffer.append(", zipMD5='").append(this.zipMD5).append('\'');
    localStringBuffer.append(", retCode=").append(this.retCode);
    localStringBuffer.append(", wordingV2='").append(this.wordingV2).append('\'');
    localStringBuffer.append(", apolloGameSt='").append(this.apolloGameSt).append('\'');
    localStringBuffer.append(", apolloGameStkey='").append(this.apolloGameStkey).append('\'');
    localStringBuffer.append(", openId='").append(this.openId).append('\'');
    localStringBuffer.append(", sessionOpenId='").append(this.sessionOpenId).append('\'');
    localStringBuffer.append(", extInfoFromSvr='").append(this.extInfoFromSvr).append('\'');
    localStringBuffer.append(", mExtraStr='").append(this.mExtraStr).append('\'');
    localStringBuffer.append(", mFriendUin='").append(this.mFriendUin).append('\'');
    localStringBuffer.append(", showAlertTips=").append(this.showAlertTips);
    localStringBuffer.append(", msgGameStatus=").append(this.msgGameStatus);
    localStringBuffer.append(", launchNewGame=").append(this.launchNewGame);
    localStringBuffer.append(", isWhiteUsr=").append(this.isWhiteUsr);
    localStringBuffer.append(", gender=").append(this.gender);
    localStringBuffer.append(", apolloStatus=").append(this.apolloStatus);
    localStringBuffer.append(", mGameType=").append(this.mGameType);
    localStringBuffer.append(", mUpdated=").append(this.mUpdated);
    localStringBuffer.append(", gameTypeForRedPacket=").append(this.gameTypeForRedPacket);
    localStringBuffer.append(", redUrl='").append(this.redUrl).append('\'');
    localStringBuffer.append(", startT=").append(this.startT);
    localStringBuffer.append(", startCheckGame=").append(this.startCheckGame);
    localStringBuffer.append(", startCallEngine=").append(this.startCallEngine);
    localStringBuffer.append(", appIdSrc=").append(this.appIdSrc);
    localStringBuffer.append(", commFlag=").append(this.commFlag);
    localStringBuffer.append(", enableMenu=").append(this.enableMenu);
    localStringBuffer.append(", disableMinGame=").append(this.disableMinGame);
    localStringBuffer.append(", mStartType=").append(this.mStartType);
    localStringBuffer.append(", mOpenTempAIOOnFinish=").append(this.mOpenTempAIOOnFinish);
    localStringBuffer.append(", mTempAIOUin='").append(this.mTempAIOUin).append('\'');
    localStringBuffer.append(", mTempAIONickName='").append(this.mTempAIONickName).append('\'');
    localStringBuffer.append(", adDevUin=").append(this.adDevUin);
    localStringBuffer.append(", adShareRate=").append(this.adShareRate);
    localStringBuffer.append(", adForbidPosId='").append(this.adForbidPosId).append('\'');
    localStringBuffer.append(", rpUrl='").append(this.rpUrl).append('\'');
    localStringBuffer.append(", rpIconUrl='").append(this.rpIconUrl).append('\'');
    localStringBuffer.append(", isNeedConfInfo=").append(this.isNeedConfInfo);
    localStringBuffer.append(", isRequestConf=").append(this.isRequestConf);
    localStringBuffer.append(", mRobotOpenId='").append(this.mRobotOpenId).append('\'');
    localStringBuffer.append(", isEnableMSAA=").append(this.isEnableMSAA);
    localStringBuffer.append(", mCreateTs=").append(this.mCreateTs);
    localStringBuffer.append(", mLoadingOnMainProcess=").append(this.mLoadingOnMainProcess);
    localStringBuffer.append(", mSSORule='").append(this.mSSORule).append('\'');
    localStringBuffer.append(", statMap=").append(this.statMap);
    localStringBuffer.append(", mIsTransGame=").append(this.mIsTransGame);
    localStringBuffer.append(", transInfo=").append(this.transInfo);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam
 * JD-Core Version:    0.7.0.1
 */