package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

public class StoryAlbumPicEntry
  extends Entity
{
  public static final int PIC_STATE_BLACK_POI = 4;
  public static final int PIC_STATE_DEFAULT = 1;
  public static final int PIC_STATE_EXCULSIVE = 2;
  public long createTime;
  public String geohashString;
  public double gpsLat;
  public double gpsLng;
  public int height;
  public String mime;
  public int orientation;
  public String path;
  public long size;
  public int state;
  public String thumbPath;
  public int width;
  
  public static String getTimeSelection(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" createTime >= ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" AND  createTime <= ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" AND  state <>");
    localStringBuilder.append(4);
    localStringBuilder.append(" AND  state <>");
    localStringBuilder.append(2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryAlbumPicEntry
 * JD-Core Version:    0.7.0.1
 */