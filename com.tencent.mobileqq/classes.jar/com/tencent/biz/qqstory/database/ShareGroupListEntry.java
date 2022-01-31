package com.tencent.biz.qqstory.database;

import awbv;

public class ShareGroupListEntry
  extends awbv
{
  public static final int LIST_TYPE_PICKER = 0;
  public int listType = 0;
  public String shareGroupId;
  public String unionId;
  
  public static String getSelectionSql(int paramInt)
  {
    return "unionId=? AND listType=" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.ShareGroupListEntry
 * JD-Core Version:    0.7.0.1
 */