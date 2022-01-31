package com.tencent.biz.qqstory.msgTabNode.model;

import auko;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import tff;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType")
public class MsgTabNodeRecommendActivityReadEntity
  extends auko
{
  public static final int HAS_READ = 1;
  public static final String TABLE_NAME = MsgTabNodeRecommendActivityReadEntity.class.getSimpleName();
  public int hasRead;
  public int nodeType;
  public String unionId;
  
  public MsgTabNodeRecommendActivityReadEntity() {}
  
  public MsgTabNodeRecommendActivityReadEntity(tff paramtff, int paramInt)
  {
    this.nodeType = paramtff.jdField_a_of_type_Int;
    this.unionId = paramtff.jdField_a_of_type_JavaLangString;
    this.hasRead = paramInt;
  }
  
  public static String[] getArgs(tff paramtff)
  {
    int i = paramtff.jdField_a_of_type_Int;
    if (paramtff.jdField_a_of_type_JavaLangString == null) {}
    for (paramtff = "";; paramtff = paramtff.jdField_a_of_type_JavaLangString) {
      return new String[] { String.valueOf(i), paramtff };
    }
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=?";
  }
  
  public String toString()
  {
    return "MsgTabNodeEntity{nodeType=" + this.nodeType + ", unionId='" + this.unionId + '\'' + ", hasRead='" + this.hasRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity
 * JD-Core Version:    0.7.0.1
 */