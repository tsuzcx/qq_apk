package com.tencent.biz.qqstory.database;

import awge;
import awhs;

public class UnionIdMapEntity
  extends awge
{
  public String qq;
  @awhs
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.UnionIdMapEntity
 * JD-Core Version:    0.7.0.1
 */