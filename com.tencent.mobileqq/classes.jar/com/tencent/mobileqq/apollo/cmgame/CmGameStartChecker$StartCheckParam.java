package com.tencent.mobileqq.apollo.cmgame;

import com.tencent.mobileqq.data.ApolloGameData;
import java.io.Serializable;

public class CmGameStartChecker$StartCheckParam
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int aioType;
  public String apolloGameSt;
  public String apolloGameStkey;
  public int apolloStatus;
  public boolean enableMenu = true;
  public int enter;
  public String extInfoFromSvr;
  public String extendJson;
  public String from;
  public ApolloGameData game;
  public int gameId;
  public int gameMode;
  public int gender;
  public boolean isCreator;
  public boolean isPatch;
  public boolean isRunning;
  public boolean isWhiteUsr;
  public boolean launchNewGame;
  public String mExtraStr;
  public String mFriendUin;
  public int mGameType;
  public boolean mUpdated;
  public int msgGameStatus;
  public String openId;
  public long requestCode;
  public long retCode;
  public long roomId;
  public String sessionOpenId;
  public int sessionType;
  public String sessionUin;
  public boolean showAlertTips;
  public int src;
  public long startT;
  public String version;
  public String wordingV2;
  public String zipMD5;
  
  public CmGameStartChecker$StartCheckParam(int paramInt1, boolean paramBoolean, String paramString1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6)
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
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StartCheckParam{");
    localStringBuilder.append("game=").append(this.game);
    localStringBuilder.append(", isCreator=").append(this.isCreator);
    localStringBuilder.append(", from='").append(this.from).append('\'');
    localStringBuilder.append(", roomId=").append(this.roomId);
    localStringBuilder.append(", enter=").append(this.enter);
    localStringBuilder.append(", isRunning=").append(this.isRunning);
    localStringBuilder.append(", gameMode=").append(this.gameMode);
    localStringBuilder.append(", sessionType=").append(this.sessionType);
    localStringBuilder.append(", aioType=").append(this.aioType);
    localStringBuilder.append(", sessionUin='").append(this.sessionUin).append('\'');
    localStringBuilder.append(", src=").append(this.src);
    localStringBuilder.append(", requestCode=").append(this.requestCode);
    localStringBuilder.append(", extendJson='").append(this.extendJson).append('\'');
    localStringBuilder.append(", version='").append(this.version).append('\'');
    localStringBuilder.append(", isPatch=").append(this.isPatch);
    localStringBuilder.append(", zipMD5='").append(this.zipMD5).append('\'');
    localStringBuilder.append(", retCode=").append(this.retCode);
    localStringBuilder.append(", wordingV2='").append(this.wordingV2).append('\'');
    localStringBuilder.append(", apolloGameSt='").append(this.apolloGameSt).append('\'');
    localStringBuilder.append(", apolloGameStkey='").append(this.apolloGameStkey).append('\'');
    localStringBuilder.append(", openId='").append(this.openId).append('\'');
    localStringBuilder.append(", sessionOpenId='").append(this.sessionOpenId).append('\'');
    localStringBuilder.append(", extInfoFromSvr='").append(this.extInfoFromSvr).append('\'');
    localStringBuilder.append(", mExtraStr='").append(this.mExtraStr).append('\'');
    localStringBuilder.append(", mFriendUin='").append(this.mFriendUin).append('\'');
    localStringBuilder.append(", showAlertTips=").append(this.showAlertTips);
    localStringBuilder.append(", msgGameStatus=").append(this.msgGameStatus);
    localStringBuilder.append(", launchNewGame=").append(this.launchNewGame);
    localStringBuilder.append(", isWhiteUsr=").append(this.isWhiteUsr);
    localStringBuilder.append(", gender=").append(this.gender);
    localStringBuilder.append(", apolloStatus=").append(this.apolloStatus);
    localStringBuilder.append(", mGameType=").append(this.mGameType);
    localStringBuilder.append(", mUpdated=").append(this.mUpdated);
    localStringBuilder.append(", enableMenu=").append(this.enableMenu);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam
 * JD-Core Version:    0.7.0.1
 */