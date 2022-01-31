package com.tencent.biz.qqstory.database;

import atmo;
import atoc;

public class FeedEntry
  extends atmo
{
  public String date;
  public byte[] extraInfo;
  @atoc
  public String feedId;
  public int feedSourceTagType;
  public String ownerId;
  public int type;
  
  public static String queryFeedByDate()
  {
    return "ownerId=?&date=?";
  }
  
  public static String queryFeedId()
  {
    return "feedId=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.FeedEntry
 * JD-Core Version:    0.7.0.1
 */