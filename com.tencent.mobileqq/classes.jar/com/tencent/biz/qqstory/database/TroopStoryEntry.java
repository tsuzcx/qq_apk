package com.tencent.biz.qqstory.database;

import aukm;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;

public class TroopStoryEntry
  extends aukm
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
    return "select * from " + TroopStoryEntry.class.getSimpleName() + " where troopId = " + paramLong;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.TroopStoryEntry
 * JD-Core Version:    0.7.0.1
 */