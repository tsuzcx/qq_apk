package com.tencent.av.redpacket;

import java.io.Serializable;

public class AVRedPacketManager$LocalHitInfo
  implements Serializable
{
  public int comboCnt;
  public int emojiId;
  public long hitStartTime;
  public int newAddScore;
  public int topWordTipType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalHitInfo:");
    localStringBuilder.append("emojiId=").append(this.emojiId);
    localStringBuilder.append(", topWordTipType=").append(this.topWordTipType);
    localStringBuilder.append(", comboCnt=").append(this.comboCnt);
    localStringBuilder.append(", newAddScore=").append(this.newAddScore);
    localStringBuilder.append(", hitStartTime=").append(this.hitStartTime);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo
 * JD-Core Version:    0.7.0.1
 */