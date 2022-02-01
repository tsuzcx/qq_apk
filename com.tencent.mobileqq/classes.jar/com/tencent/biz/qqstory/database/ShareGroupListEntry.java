package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

public class ShareGroupListEntry
  extends Entity
{
  public static final int LIST_TYPE_PICKER = 0;
  public int listType = 0;
  public String shareGroupId;
  public String unionId;
  
  public static String getSelectionSql(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unionId=? AND listType=");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.ShareGroupListEntry
 * JD-Core Version:    0.7.0.1
 */