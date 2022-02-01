package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class StoryEntry
  extends Entity
{
  public String coverUrl;
  public long dbTime = System.currentTimeMillis();
  public String extra1;
  public String extra2;
  public String extra3;
  public int hasUnWatchVideo;
  @unique
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type IN (");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String getTypeSelection(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryEntry{key='");
    localStringBuilder.append(this.key);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", unionId=");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append(", updateTime=");
    localStringBuilder.append(this.updateTime);
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", totalTime=");
    localStringBuilder.append(this.totalTime);
    localStringBuilder.append(", dbTime=");
    localStringBuilder.append(this.dbTime);
    localStringBuilder.append(", hasUnWatchVideo=");
    localStringBuilder.append(this.hasUnWatchVideo);
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.videoCount);
    localStringBuilder.append(", extra1='");
    localStringBuilder.append(this.extra1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extra2='");
    localStringBuilder.append(this.extra2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extra3='");
    localStringBuilder.append(this.extra3);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyTitle='");
    localStringBuilder.append(this.storyTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDoodleText='");
    localStringBuilder.append(this.mDoodleText);
    localStringBuilder.append('\'');
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryEntry
 * JD-Core Version:    0.7.0.1
 */