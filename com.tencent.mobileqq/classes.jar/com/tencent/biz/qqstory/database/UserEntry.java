package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class UserEntry
  extends Entity
{
  public long dbCacheTime = -1L;
  public int fansCount;
  public int fansCountExtra;
  public int followCount;
  public int gradeSpeed = -2147483648;
  public long groupIdInGroup;
  public String headUrl;
  public String iconJumpUrl;
  public String iconUrl;
  public int isSubscribe = -1;
  public boolean isVip;
  public int medalLevel = -2147483648;
  public String nickName;
  public String nickPostfix;
  public String qq;
  public int relationType = -1;
  public String remark;
  public int shareGroupCount;
  public int sourceTagType = -2147483648;
  public String symbolUrl;
  @unique
  public String unionId;
  public int videoCount;
  public String wsSchema;
  
  public static String getUserSelectionByQQ()
  {
    return "qq=?";
  }
  
  public static String getUserSelectionNoArg()
  {
    return "unionId=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.UserEntry
 * JD-Core Version:    0.7.0.1
 */