package com.tencent.biz.qqstory.database;

import awbv;

public class StoryAlbumPicEntry
  extends awbv
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
    return " createTime >= " + paramLong1 + " AND  createTime <= " + paramLong2 + " AND  state <>" + 4 + " AND  state <>" + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryAlbumPicEntry
 * JD-Core Version:    0.7.0.1
 */