package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class UnionIdMapEntity
  extends Entity
{
  public String qq;
  @unique
  public String unionId;
  
  public static String selectionQQ()
  {
    return "qq=?";
  }
  
  public static String selectionUnionId()
  {
    return "unionId=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.UnionIdMapEntity
 * JD-Core Version:    0.7.0.1
 */