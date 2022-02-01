package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.mobileqq.persistence.Entity;

public class TroopStoryEntry
  extends Entity
{
  public static final int ITEM_TYPE_DAY = 1;
  public static final int ITEM_TYPE_VIDEO = 2;
  public static final int ITEM_TYPE_YEAR = 0;
  public String feedId;
  public int itemType = 2;
  public int publishCount;
  public long publishTime;
  public String storyId;
  public long troopId;
  public String uin;
  public String unionId;
  public int unionIdRole;
  public String vid;
  
  public static String getQueryByPageSql(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(TroopStoryEntry.class.getSimpleName());
    localStringBuilder.append(" where troopId = ");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public void from(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.troopId = paramTroopStoryItemInfo.troopId;
    this.itemType = paramTroopStoryItemInfo.itemType;
    this.publishTime = paramTroopStoryItemInfo.publishTime;
    this.publishCount = paramTroopStoryItemInfo.publishCount;
    this.vid = paramTroopStoryItemInfo.vid;
    this.storyId = paramTroopStoryItemInfo.storyId;
    this.feedId = paramTroopStoryItemInfo.feedId;
    this.unionId = paramTroopStoryItemInfo.unionId;
    this.unionIdRole = paramTroopStoryItemInfo.unionIdRole;
    this.uin = paramTroopStoryItemInfo.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.TroopStoryEntry
 * JD-Core Version:    0.7.0.1
 */