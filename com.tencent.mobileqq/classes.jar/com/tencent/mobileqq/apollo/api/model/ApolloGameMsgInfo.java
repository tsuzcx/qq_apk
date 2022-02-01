package com.tencent.mobileqq.apollo.api.model;

import com.tencent.qphone.base.util.QLog;

public class ApolloGameMsgInfo
{
  public int actionId;
  public String actionName;
  public String gameExtendJson;
  public int gameId;
  public int gameMode;
  public String gameName;
  public int gameStatus;
  public int msgType = 3;
  public long roomId;
  
  public void init()
  {
    this.gameId = 0;
    this.roomId = 0L;
    this.gameMode = 0;
    this.gameName = "";
    this.actionName = "";
    this.gameExtendJson = "";
    this.msgType = 3;
  }
  
  public void print()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gameId:").append(this.gameId).append(",roomId:").append(this.roomId).append(",actionId:").append(this.actionId).append(",gameName:").append(this.gameName).append(",wording:").append(",imgType:");
      QLog.d("ApolloPanel", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo
 * JD-Core Version:    0.7.0.1
 */