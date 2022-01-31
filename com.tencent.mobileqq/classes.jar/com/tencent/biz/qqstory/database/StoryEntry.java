package com.tencent.biz.qqstory.database;

import awge;
import awhs;

public class StoryEntry
  extends awge
{
  public String coverUrl;
  public long dbTime = System.currentTimeMillis();
  public String extra1;
  public String extra2;
  public String extra3;
  public int hasUnWatchVideo;
  @awhs
  public String key;
  public String mDoodleText;
  public int seq;
  public String storyTitle;
  public long totalTime;
  public int type;
  public String unionId;
  public long updateTime;
  public int videoCount;
  
  public static String getTypeOrSelection(int paramInt1, int paramInt2)
  {
    return "type IN (" + paramInt1 + "," + paramInt2 + ")";
  }
  
  public static String getTypeSelection(int paramInt)
  {
    return "type=" + paramInt + "";
  }
  
  public static String getUidSelectionNoArg()
  {
    return "unionId=? AND type=?";
  }
  
  public static String getUnionIdSelectionNoArg()
  {
    return "unionId=? AND type=?";
  }
  
  public String toString()
  {
    return "StoryEntry{key='" + this.key + '\'' + ", type=" + this.type + ", unionId=" + this.unionId + ", updateTime=" + this.updateTime + ", coverUrl='" + this.coverUrl + '\'' + ", totalTime=" + this.totalTime + ", dbTime=" + this.dbTime + ", hasUnWatchVideo=" + this.hasUnWatchVideo + ", videoCount=" + this.videoCount + ", extra1='" + this.extra1 + '\'' + ", extra2='" + this.extra2 + '\'' + ", extra3='" + this.extra3 + '\'' + ", storyTitle='" + this.storyTitle + '\'' + ", mDoodleText='" + this.mDoodleText + '\'' + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryEntry
 * JD-Core Version:    0.7.0.1
 */