package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import wvn;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType")
public class MsgTabNodeRecommendActivityReadEntity
  extends Entity
{
  public static final int HAS_READ = 1;
  public static final String TABLE_NAME = MsgTabNodeRecommendActivityReadEntity.class.getSimpleName();
  public int hasRead;
  public int nodeType;
  public String unionId;
  
  public MsgTabNodeRecommendActivityReadEntity() {}
  
  public MsgTabNodeRecommendActivityReadEntity(wvn paramwvn, int paramInt)
  {
    this.nodeType = paramwvn.jdField_a_of_type_Int;
    this.unionId = paramwvn.jdField_a_of_type_JavaLangString;
    this.hasRead = paramInt;
  }
  
  public static String[] getArgs(wvn paramwvn)
  {
    int i = paramwvn.jdField_a_of_type_Int;
    if (paramwvn.jdField_a_of_type_JavaLangString == null) {}
    for (paramwvn = "";; paramwvn = paramwvn.jdField_a_of_type_JavaLangString) {
      return new String[] { String.valueOf(i), paramwvn };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity
 * JD-Core Version:    0.7.0.1
 */