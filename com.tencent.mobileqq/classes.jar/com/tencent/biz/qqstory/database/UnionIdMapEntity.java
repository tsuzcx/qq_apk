package com.tencent.biz.qqstory.database;

import aukm;
import auma;

public class UnionIdMapEntity
  extends aukm
{
  public String qq;
  @auma
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.UnionIdMapEntity
 * JD-Core Version:    0.7.0.1
 */