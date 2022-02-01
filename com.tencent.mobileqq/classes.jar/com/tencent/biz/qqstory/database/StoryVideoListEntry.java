package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

public class StoryVideoListEntry
  extends Entity
{
  public static final int LIST_TYPE_COLLECTION = 5;
  public static final int LIST_TYPE_EXPIRE_USER = 6;
  public static final int LIST_TYPE_HOT_TOPIC = 2;
  public static final int LIST_TYPE_LABEL = 1;
  public static final int LIST_TYPE_LABEL_CONFIG = 4;
  public static final int LIST_TYPE_RECENT = 3;
  public static final int LIST_TYPE_RECOMMEND_BIG_V = 7;
  public static final int LIST_TYPE_SQUARE_VIDEO = 8;
  public static final int LIST_TYPE_USER = 0;
  public String collectionKey;
  public String label;
  public int listType;
  public String unionId;
  public String vid;
  
  public static String getCollectionSelectionNoArg()
  {
    return "listType=? AND collectionKey=?";
  }
  
  public static String getLabelSelectionNoArg()
  {
    return "listType=? AND label=?";
  }
  
  public static String getRecentUidSelectionNoArg()
  {
    return "listType=3 AND unionId=?";
  }
  
  public static String getRecommendBigVSelectionNoArg()
  {
    return "listType=7 AND unionId=?";
  }
  
  public static String getSelectionNoArg()
  {
    return "listType=? AND unionId=?";
  }
  
  public static String getTopicIdSelectionNoArg()
  {
    return "listType=2 AND unionId=?";
  }
  
  public static String getUserUidSelectionNoArg()
  {
    return "listType=0 AND unionId=?";
  }
  
  public static String getVidSelectionNoArg()
  {
    return "vid=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryVideoListEntry
 * JD-Core Version:    0.7.0.1
 */