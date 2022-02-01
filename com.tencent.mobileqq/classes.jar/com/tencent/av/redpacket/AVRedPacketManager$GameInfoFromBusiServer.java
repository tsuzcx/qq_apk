package com.tencent.av.redpacket;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AVRedPacketManager$GameInfoFromBusiServer
  implements Serializable
{
  public String authKey;
  public int currScores;
  public List<Integer> emojiIds = Collections.emptyList();
  public int gameRestTime;
  public int gameStartTime;
  public int gameStatus = -1;
  public String key;
  public int maxScore;
  public String receiveRedPacketUin;
  public String sendRedPacketUin;
  public int winMoney;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.GameInfoFromBusiServer
 * JD-Core Version:    0.7.0.1
 */