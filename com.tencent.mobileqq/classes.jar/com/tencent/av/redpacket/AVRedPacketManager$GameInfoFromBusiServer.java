package com.tencent.av.redpacket;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AVRedPacketManager$GameInfoFromBusiServer
  implements Serializable
{
  String authKey;
  int currScores;
  List emojiIds = Collections.emptyList();
  int gameRestTime;
  int gameStartTime;
  int gameStatus = -1;
  String key;
  int maxScore;
  String receiveRedPacketUin;
  String sendRedPacketUin;
  int winMoney;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameInfoFromBusiServer:");
    localStringBuilder.append("gameStatus=").append(this.gameStatus);
    localStringBuilder.append(",sendRedPacketUin=").append(this.sendRedPacketUin);
    localStringBuilder.append(",receiveRedPacketUin=").append(this.receiveRedPacketUin);
    localStringBuilder.append(",maxScore=").append(this.maxScore);
    localStringBuilder.append(",winMoney=").append(this.winMoney);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.GameInfoFromBusiServer
 * JD-Core Version:    0.7.0.1
 */