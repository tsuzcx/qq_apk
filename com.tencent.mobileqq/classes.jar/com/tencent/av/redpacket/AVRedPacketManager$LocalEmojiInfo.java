package com.tencent.av.redpacket;

import java.io.Serializable;

public class AVRedPacketManager$LocalEmojiInfo
  implements Serializable
{
  public int emojiId;
  public int emojiType;
  public int eventType;
  public int fallDownDuration;
  public boolean isBigEmoji;
  public long startTime;
  public int trackNum;
  
  public boolean equals(Object paramObject)
  {
    return this.emojiId == ((LocalEmojiInfo)paramObject).emojiId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalEmojiInfo:");
    localStringBuilder.append("emojiId=").append(this.emojiId);
    localStringBuilder.append(", emojiType=").append(this.emojiType);
    localStringBuilder.append(", startTime=").append(this.startTime);
    localStringBuilder.append(", trackNum=").append(this.trackNum);
    localStringBuilder.append(", isBigEmoji=").append(this.isBigEmoji);
    localStringBuilder.append(", fallDownDuration=").append(this.fallDownDuration);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo
 * JD-Core Version:    0.7.0.1
 */