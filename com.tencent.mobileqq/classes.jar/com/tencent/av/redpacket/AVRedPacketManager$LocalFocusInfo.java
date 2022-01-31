package com.tencent.av.redpacket;

import java.io.Serializable;

public class AVRedPacketManager$LocalFocusInfo
  implements Serializable
{
  public int emojiId;
  public AVRedPacketManager.LocalEmojiInfo mLocalEmojiInfo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalFocusInfo:");
    localStringBuilder.append("emojiId=").append(this.emojiId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.LocalFocusInfo
 * JD-Core Version:    0.7.0.1
 */