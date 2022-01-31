package com.tencent.av.redpacket;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

public class AVRedPacketManager$GameStateInfo
  implements Serializable
{
  String authKey;
  public List configEmojiInfos;
  public int count_OnFrameDataSend = 0;
  int curCommCnt;
  int curScore;
  public AVRedPacketManager.LocalFrameSyncInfo currLocalFrameSyncInfo = new AVRedPacketManager.LocalFrameSyncInfo();
  public int enterType;
  public int gameMode = 0;
  long gameStartTime;
  public int gameState = 0;
  boolean hasEmojiTip;
  public int hasScreenShotCnt;
  boolean isDestroy = false;
  int kazhenTipCnt;
  public String key;
  public long mRedPacketComeStartTime;
  String money;
  String receiveRedPacketUin;
  String sendRedPacketUin;
  HashSet syncSuccEmojiId = new HashSet();
  
  AVRedPacketManager$GameStateInfo(GameStateInfo paramGameStateInfo)
  {
    this.key = paramGameStateInfo.key;
    this.gameMode = paramGameStateInfo.gameMode;
    this.sendRedPacketUin = paramGameStateInfo.sendRedPacketUin;
    this.receiveRedPacketUin = paramGameStateInfo.receiveRedPacketUin;
  }
  
  AVRedPacketManager$GameStateInfo(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.key = paramString1;
    this.gameMode = paramInt;
    this.sendRedPacketUin = paramString2;
    this.receiveRedPacketUin = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameStateInfo:");
    localStringBuilder.append("key=").append(this.key);
    localStringBuilder.append(", gameMode=").append(this.gameMode);
    localStringBuilder.append(", gameState=").append(this.gameState);
    localStringBuilder.append(", isDestroy=").append(this.isDestroy);
    localStringBuilder.append(", sendRedPacketUin=").append(this.sendRedPacketUin);
    localStringBuilder.append(", receiveRedPacketUin=").append(this.receiveRedPacketUin);
    localStringBuilder.append(", curCommCnt=").append(this.curCommCnt);
    localStringBuilder.append(", curScore=").append(this.curScore);
    localStringBuilder.append(", currFrameSyncInfo=").append(this.currLocalFrameSyncInfo);
    return localStringBuilder.toString();
  }
  
  public void updateGameState(int paramInt)
  {
    this.gameState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.GameStateInfo
 * JD-Core Version:    0.7.0.1
 */