package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

public class StoryAlbumEntry
  extends Entity
{
  public String albumDesc;
  public long albumId;
  public String albumName;
  public int albumType;
  public String debugInfo;
  public long endTime;
  public byte[] extraInfo;
  public int geoHashLevel = -1;
  public String geoHashStr;
  public int minCount;
  public long picDbId;
  public long startTime;
  public int state;
  public int textId;
  public String transId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryAlbumEntry
 * JD-Core Version:    0.7.0.1
 */