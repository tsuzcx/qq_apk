package com.tencent.av.redpacket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AVRedPacketManager$LocalFrameSyncInfo
  implements Serializable
{
  public int curScore;
  public int frameSyncGameState;
  public List<Integer> hasHitedEmojiIds = new ArrayList();
  public List<AVRedPacketManager.LocalEmojiInfo> localEmojiInfos = new ArrayList();
  public AVRedPacketManager.LocalFocusInfo localFocusInfo = new AVRedPacketManager.LocalFocusInfo();
  public AVRedPacketManager.LocalHitInfo localHitInfo = new AVRedPacketManager.LocalHitInfo();
  public int seq;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("LocalFrameSyncInfo:");
      localStringBuilder.append("frameSyncGameState=").append(this.frameSyncGameState);
      localStringBuilder.append(",emojiInfos=").append(this.localEmojiInfos);
      localStringBuilder.append(",localFocusInfo=").append(this.localFocusInfo);
      localStringBuilder.append(",localHitInfo=").append(this.localHitInfo);
      localStringBuilder.append(",curScore=").append(this.curScore);
      localStringBuilder.append(",hasHitedEmojiIds=").append(this.hasHitedEmojiIds);
      localStringBuilder.append(",seq=").append(this.seq);
      label113:
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo
 * JD-Core Version:    0.7.0.1
 */